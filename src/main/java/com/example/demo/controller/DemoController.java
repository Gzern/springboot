package com.example.demo.controller;


import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @Autowired
    private PersonService personService;



    @RequestMapping("/get/{id}")
    @ResponseBody
    public Map<String,Object> getResult(@PathVariable(name = "id",required = false) String id){
        System.out.println("xxxxxxxxx");
        Map<String,Object> map=new HashMap<>();
        map.put("id",5);
        return map;
    }


    @RequestMapping("/person/{id}")
    @ResponseBody
    public Person getT(@PathVariable(name = "id") int id){
        return personService.getPersion(id);
    }

}
