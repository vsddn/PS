package com.ques3.jsp;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("display")
	public  String display(ModelMap model) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    Student stu = context.getBean("stu", Student.class);
	    Map<String,String> mp = stu.getMp();
	    System.out.println(mp);

		model.addAttribute("id" , Integer.parseInt(mp.get("id")));
		model.addAttribute("maths" , Integer.parseInt(mp.get("maths")));
		model.addAttribute("science" , Integer.parseInt(mp.get("science")));
		model.addAttribute("english" ,Integer.parseInt (mp.get("english")));
		model.addAttribute("hindi" , Integer.parseInt(mp.get("hindi")));
		return "display";
	}
	
}
