package com.example.hrmproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

import com.example.hrmproject.exports.UserExcelExporter;
import com.example.hrmproject.model.DemoEmployee;
import com.example.hrmproject.services.DemoEmployeeService;

@Controller
public class DemoEmployeeController {
    @Autowired
    private DemoEmployeeService demoEmployeeService;

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employee_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<DemoEmployee> list = demoEmployeeService.listAll();
         
        UserExcelExporter excelExporter = new UserExcelExporter(list);
         
        excelExporter.export(response);  
    }
}
