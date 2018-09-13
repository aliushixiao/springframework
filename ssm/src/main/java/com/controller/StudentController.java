package com.controller;

/*
*@ClassName:StudentController
 @Description:TODO
 @Author:
 @Date:2018/9/11 9:14 
 @Version:v1.0
*/


//@Component spring会放入容器  通用注解
//@service  spring会放入容器 主要用来标识service层
//@Repository spring会放入容器 主要用来表示dao
//@Controller  spring会放入容器 主要用来表示controller
import com.entity.Student;
import com.google.gson.Gson;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @ResponseBody
    @RequestMapping("/get.do")
    public String getStudent(int id){
        Student student = studentService.findById(id);
        Gson gson = new Gson();
        String json = gson.toJson(student);
        return json;
    }
    @RequestMapping("/hello.do")
    public ModelAndView hello(ModelAndView mav){
            mav.addObject("name","tom");
            mav.addObject("age",18);
            mav.setViewName("hello");
            return mav;
    }

}
