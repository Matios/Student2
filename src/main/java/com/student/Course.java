package com.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {
	private @Id @GeneratedValue Long id;
	private String courseName;
	private String grade;
	private int studentId;
	
	public Course(String courseName, String grade, int studentId) {
		super();
		this.courseName = courseName;
		this.grade = grade;
		this.studentId = studentId;
	}
	
	public Course() {
	}
	
}
