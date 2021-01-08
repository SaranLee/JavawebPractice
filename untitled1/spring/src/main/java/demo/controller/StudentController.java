package demo.controller;

import demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }
}
