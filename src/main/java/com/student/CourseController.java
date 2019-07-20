package com.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	private final CourseRepository repository;
	
	public CourseController(CourseRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@GetMapping("/course")
	Iterable<Course> all() {
		return repository.findAll();
	}
	
	@PostMapping("/course")
	Course newCourse(@RequestBody Course newCourse) {
		return repository.save(newCourse);
	}
	
	@GetMapping("/course/{id}")
	Course one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}
	
	@PutMapping("/course/{id}")
	Course replaceCourrse(@RequestBody Course newCourse, @PathVariable Long id) {
		
	   return repository.findById(id)
			.map(course -> {
				course.setCourseName(newCourse.getCourseName());
			    course.setGrade(newCourse.getGrade());
			    return repository.save(newCourse);
			})
			.orElseGet(() -> {
				newCourse.setId(id);
				return repository.save(newCourse);
			});
	}
	
	@DeleteMapping("/course/{id}")
	void deleteCourse(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
