package org.convey.user.registration.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.convey.user.registration.dao.UserDao;
import org.convey.user.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 3/23/12
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/report/")
public class ReportController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){

        logger.debug("--------------generate PDF report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        modelAndView = new ModelAndView("pdfReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


}//ReportController
