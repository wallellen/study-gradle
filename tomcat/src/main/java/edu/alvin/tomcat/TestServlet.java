package edu.alvin.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test-servlet.do")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"cn\">\n" +
                "   <meta charset=\"UTF-8\">\n" +
                "   <title>测试Servlet执行</title>\n" +
                "   <link rel=\"stylesheet\" href=\"/assets/css/common.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"page-main\">" +
                "   <div class=\"title\">Servlet测试成功</div>\n" +
                "   <div class=\"back-link\">\n" +
                "       <a href=\"index.html\">返回主页</a>\n" +
                "   </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        response.flushBuffer();
    }
}
