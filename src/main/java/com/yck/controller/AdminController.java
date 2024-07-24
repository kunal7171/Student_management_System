package com.yck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yck.sma.model.Student;
import com.yck.sma.service.ServiceI;

@Controller
public class AdminController {
	
	@Autowired
	private ServiceI ssi;

	@RequestMapping("/")
	public String prelogin() {
		System.out.println("In Pre login");
		return "login";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,Model m) {
		System.out.println("Inlogin");
		if (username.equals("admin") && password.equals("admin")) {
			List<Student>list = ssi.getAllStudents();
			m.addAttribute("data",list);
		//	return "adminscreen";
			return this.paging(0, m);
		} else {
			Student s = ssi.loginStudent(username,password);
			
			if (s!= null) {
				m.addAttribute("stu",s);
				return "studentview";
			} else {
				m.addAttribute("login_fail","Enter Valid Credentials ");
				return "login";
			}
			 
		}	 
	}
	
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		 
		try {
			ssi.saveStudent(s);
		} catch (Exception e) {
			m.addAttribute("msg","Email Id already exist");
		}
		
		
		List<Student>students = ssi.getAllStudents();
		m.addAttribute("data",students);
		return "adminscreen";
	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam int pageNo,Model m) {
		List<Student> list = ssi.paging(pageNo, 3);
	    m.addAttribute("data",list);
	    return "adminscreen";

	}
	
	@RequestMapping("/search")
	public String searchbatch(@RequestParam String batchNumber,Model m) {
		List<Student>result = ssi.searchStudentsbyBatch(batchNumber);
		if (result.size()>0) {
			m.addAttribute("data",result);
		} else {
			List<Student>list = ssi.getAllStudents();
			m.addAttribute("data",list);
			m.addAttribute("message","No records are avaliable for the batch "+batchNumber+"!!!!!!!!!!!!!!!!!!!");	
		}
		return "adminscreen";
	}
	
	@RequestMapping("/delete")
	public String deletedata(@RequestParam int studentId,Model m) {
		ssi.deletedata(studentId);
		List<Student>list = ssi.getAllStudents();
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
	@RequestMapping("/fees")
	public String onFees(@RequestParam int studentId,Model m) {
		
		Student s=ssi.getStudentData(studentId);
		m.addAttribute("st", s);
		return "fees";
	}
	

	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid,@RequestParam double ammount,Model m ) {
		
		    ssi.updateStudentFess(studentid,ammount);
		List<Student> students=ssi.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	
	@RequestMapping("/batch")
	public String onbatch(@RequestParam int studentId,  Model m) {	
		Student s=ssi.getStudentData(studentId);
		m.addAttribute("st", s);
		return "batch";
	}
	

	@RequestMapping("/updatebatch")
	public String payFees(@RequestParam int studentid,@RequestParam String batchNo,Model m ) {
		
		    ssi.updateStudentbatch(studentid,batchNo);
		List<Student> students=ssi.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	
}
