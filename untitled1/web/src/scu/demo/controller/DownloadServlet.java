package scu.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = "D:\\IDEAProjects\\untitled1\\out\\artifacts\\web_war_exploded\\static\\img\\avatar3.png";
        File file = new File(realPath);
        String fileName = java.net.URLEncoder.encode("头像.png","utf-8");

        resp.setContentType(getServletContext().getMimeType(realPath));
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream out = resp.getOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while( (len = bis.read(buf)) != -1)
            out.write(buf, 0, len);
        out.flush();
        bis.close();
        out.close();
    }
}
