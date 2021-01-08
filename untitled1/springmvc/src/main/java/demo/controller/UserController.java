package demo.controller;

import demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/roles")
    @ResponseBody
    public List<String> roles(){
        User user = new User();
        return user.getRoles();
    }

    @RequestMapping("/uploadAvatar")
    public String uploadAvatar(MultipartFile uploadFile){
        String filename = uploadFile.getOriginalFilename();
        System.out.println(filename);
        try {
            uploadFile.transferTo(new File("d:/avatarXXX.png"));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
