package org.convey.user.registration.controller;

import net.sf.jasperreports.engine.JRDataSource;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){

        logger.debug("--------------generate XLS report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){

        logger.debug("--------------generate CSV report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){

        logger.debug("--------------generate HTML report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


}//ReportController
