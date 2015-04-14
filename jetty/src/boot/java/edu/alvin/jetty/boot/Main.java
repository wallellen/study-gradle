package edu.alvin.jetty.boot;

import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Arrays;


/**
 * The Java main class to start jetty embedded.
 * This program dose not work in the new version of jetty web-app support, and I don't know why.
 */
public class Main {
    private static final String ACCESS_LOG_FILE = "jetty.access.log";
    private static final String PORT = "jetty.port";

    private Main() {
    }

    public static void main(final String[] args) throws Exception {
        new Main().run(args);
    }

    private void run(final String[] args) throws Exception {
        if (args.length > 0) {
            invokeMain(args);
        } else {
            startJetty();
        }
    }

    private void invokeMain(final String[] args) throws Exception {
        WebAppContext context = createWebContext();
        configClassLoader(context);

        String mainClass = args[0];
        Object[] mainArgs = Arrays.copyOfRange(args, 1, args.length);

        Class<?> cls = context.getClassLoader().loadClass(mainClass);
        Method method = cls.getMethod("main", String[].class);
        try {
            method.invoke(null, new Object[] {mainArgs});
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    private void configClassLoader(final WebAppContext context) throws Exception {
        context.preConfigure();
        context.configure();
    }

    private void startJetty() throws Exception {
        Server server = new Server();
        server.addConnector(createConnector(server));
        server.setHandler(createWebContext());
        server.start();
        server.join();
    }

    private ServerConnector createConnector(final Server server) {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(Integer.parseInt(getProperty(PORT, "8080")));
        return connector;
    }

    private WebAppContext createWebContext() throws URISyntaxException {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar(getWarLocation());
        context.setHandler(createLogHandler());
        return context;
    }

    private RequestLogHandler createLogHandler() {
        NCSARequestLog log = new NCSARequestLog(getProperty(ACCESS_LOG_FILE, "logs/jetty-log.log"));
        log.setPreferProxiedForAddress(true);
        RequestLogHandler requestLog = new RequestLogHandler();
        requestLog.setRequestLog(log);
        return requestLog;
    }

    private String getWarLocation() {
        ProtectionDomain domain = Main.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        return location.toExternalForm();
    }

    private String getProperty(final String prop, final String defaultValue) {
        String value = System.getProperty(prop);
        return value == null ? defaultValue : value;
    }
}
