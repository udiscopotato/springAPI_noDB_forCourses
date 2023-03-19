package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.service.annotation.PutExchange;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		
		return "This is HomePage";
	}
	
	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseservice.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course data) {
		return this.courseservice.addCourse(data);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course data) {
		return this.courseservice.updateCourse(data);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public Course removeCourse(@PathVariable String courseId) {
		return this.courseservice.removeCourse(Long.parseLong(courseId));
	}
}
