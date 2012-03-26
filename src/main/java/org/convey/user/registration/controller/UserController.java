package org.convey.user.registration.controller;

import org.convey.user.registration.dao.UserDao;
import org.convey.user.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET , value = "register")
    public ModelAndView displayUserRegistrationView(){

        logger.debug("request to display user registration page");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("userRegister");
        modelAndView.addObject("user",new User());

        return modelAndView;

    }//displayUserRegistrationView


}//class
