//package com.michaelcgood.dao;
//
//import com.michaelcgood.model.Login;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.Query;
//
//import java.util.List;
//
//@Repository
//@Transactional
//@Component
//public abstract class  LoginDaoImplement implements LoginDao {
//
//    @Autowired
//    //@Qualifier("sessionFactory")
//    private SessionFactory sessionFactory;
//
//    @Override
//    public Login validate(String username, String password) {
//
//        Session session = sessionFactory.getCurrentSession();
//        String hql ="from login l where l.username =: username and l.password =: password";
//        org.hibernate.query.Query  query= session.createQuery(hql);
//        query.setParameter("username",username);
//        query.setParameter("password",password);
//        List results = query.list();
//        Login login = null;
//
//        if(results.size()>0){
//            login=(Login) results.get(0);
//
//            return login;
//        }else {
//
//            return login;
//        }
//
//
//
//    }
//}
