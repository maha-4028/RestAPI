package com.web.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.RestWebModel.Student;
import com.web.RestWebRepository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	public void addStudent(Student student) {
		repo.save(student);
	}
public List<Student> getAllStudent(){
	 return repo.findAll();
	
}
public Student getStudentById(int id) {
	return repo.findById(id).orElse(new Student());
	
}
public void updateStudent(Student s) {
	
	repo.save(s);
	
}
public void deleteStudentById(int id) {
	repo.deleteById(id);
	
}
}
