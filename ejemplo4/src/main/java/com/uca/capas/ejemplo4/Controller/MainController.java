package com.uca.capas.ejemplo4.Controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.ejemplo4.Domain.Student;


@Controller
public class MainController {
	
	private List<Student> students = new ArrayList<Student>();
	
	@GetMapping(path="/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos \n"+"Programacion NCAPAS";
	}
	
	@GetMapping("/ejemplo2")
	@ResponseBody public List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("Nombre1","Apellido","10/10/1998","Informatica",true),
				new Student("Nombre2","Apellido","10/10/1996","Informatica",false));
	}
	
	
	@GetMapping("/inicio")
	public String inicio(Student student) {
		return "index";
	}
	
	@PostMapping("/FormData")
	public ModelAndView proc(Student student) {

		ModelAndView mav = new ModelAndView();
		students.add(student);		
		mav.setViewName("index");
		mav.addObject("student", new Student());
		
		return mav;
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList",this.students);
		
		return mav;
	}
	
}