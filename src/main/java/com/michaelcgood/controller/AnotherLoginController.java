//package com.michaelcgood.Controller;
//
//
//import com.michaelcgood.Service.UserService;
//import com.michaelcgood.model.Login;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/loginAnotherUser")
//public class AnotherLoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//
//    public Login isValid(@RequestBody Login login){
//
//        Login login1 = userService.isValidUser(login.getUsername(),login.getPassword());
//        System.out.println(login1.getUsername()+" "+login1.getPassword());
//
//        return login1;
//    }
//
//
//}
