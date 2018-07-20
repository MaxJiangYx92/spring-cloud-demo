import org.springframework.security.core.userdetails.UserDetailsService;

//package com.test.demo.config.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/7/20 14:01
// * @Update -
// * @Description
// */
//@Component
//public class MyUserDetailsService implements UserDetailsService {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("用户的用户名: {}", username);
//        // TODO 根据用户名，查找到对应的密码，与权限
//
//        String pwd = new BCryptPasswordEncoder().encode("123456");
//        logger.info("user password: {}", pwd);
//
//        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
//        User user = new User(username, pwd,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return user;
//    }
//}
