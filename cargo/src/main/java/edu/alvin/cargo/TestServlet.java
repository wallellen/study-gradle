package edu.alvin.cargo;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test-servlet.do")
public class TestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"cn\">\n" +
                "   <meta charset=\"UTF-8\">\n" +
                "   <title>测试Servlet执行</title>\n" +
                "   <link rel=\"stylesheet\" href=\"common/css/common.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"page-main\">" +
                "   <div class=\"content-title\">Servlet测试成功</div>\n" +
                "   <div class=\"back-link\">\n" +
                "       <a href=\"index.html\">返回主页</a>\n" +
                "   </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        response.flushBuffer();
    }
}
