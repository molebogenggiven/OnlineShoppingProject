//package com.michaelcgood.Service;
//
//
//import com.michaelcgood.dao.LoginDao;
//import com.michaelcgood.dao.LoginRepository;
//import com.michaelcgood.model.Login;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service("UserService")
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private LoginDao loginDao;
//
//    public void setLoginDao(LoginDao loginDao){
//
//        this.loginDao = loginDao;
//    }
//
//    @Override
//    public Login isValidUser(String username, String password) {
//
//        return loginDao.validate(username,password);
//    }
//
//
//}
