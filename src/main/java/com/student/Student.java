package com.student;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

	@Entity
	@Data
public class Student {
	
	private @Id @GeneratedValue Long id;
	private String name;
	private String email;
	private HashMap<String, String> courses;
	//private ArrayList<Course> myCourse = new ArrayList<>();
	
	Student() {
	}

	public Student(String name, String email, HashMap<String, String> courses) {
		super();
		this.name = name;
		this.email = email;
		this.courses = courses;
	}
	
//	public Student( String name, String email) {
//		super();
//		this.name = name;
//		this.email = email;
//		//this.myCourse = myCourse;
//	}

//	public double getGpa() {
//		double gpa2 = 0;
//		double total = 0;
//		int count = this.courses.size();
//		for (Course course : myCourse) {
//			if (course.getGrade() == "A") {
//				total = total + 4;
//			}
//			else if (course.getGrade() == "B") {
//				total = total + 3;
//			}
//			else if (course.getGrade() == "C") {
//				total = total + 2;
//			}
//			else if (course.getGrade() == "D") {
//				total = total + 1;
//			}
//		}
//		
//		 gpa2= total/count;
//		 return gpa2;
//	}
	
//	public double getGPA() {
//		double gpa = 0;
//		double total = 0;
//		int classCount = this.courses.size();
//		for (HashMap.Entry<String,String> entry : this.courses.entrySet()) {
//			switch (entry.getValue()) {
//			case "A":
//				total = total + 4;
//				break;
//			case "B":
//				total = total + 3;
//				break;
//			case "C":
//				total = total + 2;
//				break;
//			case "D":
//				total = total + 1;
//				break;
//			}
//		}
//		gpa = total / classCount;
//		return gpa;
//	}

	@Override
	public String toString() {
		return "you did it";
	}

}
