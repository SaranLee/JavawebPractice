package scu.demo.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录。
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 500);
        File tempDirectory = new File("d:\\tempDirectory");
        factory.setRepository(tempDirectory);
        //2、使用DiskFileItemFactory 对象创建ServletFileUpload对象，并设置上传文件的大小限制。
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 5);
        try {
            //3、调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
            List<FileItem> items = upload.parseRequest(req);
            //4、对list进行迭代，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件：
            for (FileItem item : items) {
                //4.1、 为普通表单字段，则调用getFieldName、getString方法得到字段名和字段值。
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name + ": " + value);
                }
                //4.2、为上传文件，则调用getInputStream方法得到数据输入流，从而读取上传数据。
                else {
                    String fileName = item.getName();
                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    String dir = getServletContext().getRealPath("static/img");
                    File file = new File(dir);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    fileName = dir + "\\" + item.getName();
                    System.out.println(fileName);
                    OutputStream out = new FileOutputStream(fileName);
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    out.close();
                    in.close();
                }
            }
            PrintWriter out = resp.getWriter();
            out.write("ok");
            out.flush();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
