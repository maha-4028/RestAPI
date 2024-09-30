package com.web.RestWebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.RestWebModel.Student;
import com.web.RestWebService.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/addStudent")
	public String addStudent(Student student) {
		service.addStudent(student);
		return "added successfully";
	}
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		 return service.getAllStudent();
		
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
		
	}
	@PutMapping("updateStudent/{id}")
	public String updateStudent(@PathVariable int id,@RequestBody Student student) {
		Student s = service.getStudentById(id);
		if(s.getId()==id) {
			s.setName(student.getName());
		 service.updateStudent(s);
		 return "updated successfully";
		}
		else {
			return "no such student";
		}
		
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return "deleted successfully";
	}

}
