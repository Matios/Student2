package com.student;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javassist.expr.NewArray;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(StudentRepository srepository, CourseRepository crepository) {
// 		Course course1 = new Course("Java", "A", 1);
// 		Course course2 = new Course("HTML", "C", 2);
// 		Course course3 = new Course("CSS", "D", 3);
// 		//Course course4 = new Course("JavaScript", "A", 4);
//		ArrayList<Course> arr = new ArrayList<>();
//		
//		arr.add(course1);
//		arr.add(course2);
//		arr.add(course3);
//		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		HashMap<String, String> courses = new HashMap<String, String>();
		courses.put("Java", "A");
		courses.put("Jim", "D");
		courses.put("English", "F");
		courses.put("Math", "A");
		
		HashMap<String, String> jcourses = new HashMap<String, String>();
		jcourses.put("Java", "C");
		jcourses.put("Jim", "D");
		
		return args -> {

//		    log.info("Preloading " + srepository.save(new Student("Alex", "alex@my.com", courses)));
//			log.info("Preloading " + srepository.save(new Student("Jose", "jose@my.com", jcourses)));
//			log.info("Preloading " + srepository.save(new Student("Tom", "tom@my.com", courses)));
		};
	}
}
