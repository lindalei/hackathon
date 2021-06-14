package com.demo.hackthon.controller;

import com.demo.hackthon.dto.ActivityDTO;
import com.demo.hackthon.entity.User;
import com.demo.hackthon.service.ActivityService;
import com.demo.hackthon.service.SendMailService;
import com.demo.hackthon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hackathon")
public class HackathonController {
    @Autowired
    private UserService userService;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    ActivityService activityService;

    @GetMapping("/mails")
    void sendEmail() throws Exception {
        sendMailService.sendSimpleMail();
    }


    @PostMapping(value="/doRegister",produces="text/html;charset=UTF-8")
    //Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported if use @RequestBody
    public String register(@RequestParam("username") String userName, @RequestParam("password") String userPass) {
        User user=new User(userName,userPass);
        userService.addUser(user);
        return user == null ? "注册失败" : "注册成功";
    }



    @PostMapping("/createActivity")
    public ActivityDTO createActivity(@RequestBody ActivityDTO activityDTO) throws Exception {
        return activityService.createActivity(activityDTO);
    }

}
