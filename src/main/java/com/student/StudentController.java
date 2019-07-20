package com.student;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private final StudentRepository repository;
	
	public StudentController(StudentRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@GetMapping("/students")
	Iterable<Student> all() {
		return repository.findAll();
	}
	
//	@PostMapping("/students")
//	Student newStudent(@RequestBody Student newStudent) {
//		return repository.save(newStudent);
//	}
//	
	@PostMapping(value="/students",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	Student newStudent(@RequestBody MultiValueMap<String, String> formData) {
		Student stud = new Student();
		stud.setName(formData.getFirst("name"));
		stud.setEmail(formData.getFirst("email"));
		
		return repository.save(stud);
	}
	@GetMapping("/student/{id}")
	Student one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}
	
	@PutMapping("/student/{id}")
	Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
		
	   return repository.findById(id)
			.map(student -> {
				student.setName(newStudent.getName());
			    student.setEmail(newStudent.getEmail());
			    student.setCourses(newStudent.getCourses());
			  
			    return repository.save(student);
			})
			.orElseGet(() -> {
				newStudent.setId(id);
				return repository.save(newStudent);
			});
	}
	
	@DeleteMapping("/students/{id}")
	void deleteStudent(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
