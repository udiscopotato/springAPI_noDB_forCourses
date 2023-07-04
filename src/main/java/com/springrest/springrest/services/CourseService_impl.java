package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseService_impl implements CourseService {
	
	List<Course> list;
	
	
	
	public CourseService_impl() {
		list = new ArrayList<>();
		list.add(new Course(277, "java core", "first test"));
		list.add(new Course(474,"spring boot", "creating rest api using springbott"));
		list.add(new Course(117, "pythonn", "second test"));
		list.add(new Course(118, "JavaScript", "Most Popular in the world"));
	}



	@Override
	public List<Course> getCourses() {
		
		return list;
	}

    
	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course: list) {
			if(course.getId() == courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}



	@Override
	public Course updateCourse(Course data) {
//		Course c = null;
		for(Course course: list) {
			if (data.getId() == course.getId()) {
				course.setTitle(data.getTitle());
				course.setDescription(data.getDescription());
				break;
			}
		}
		return data;
	}



	@Override
	public Course removeCourse(long courseId) {
		Course c = null;
		for(Course course: list) {
			if(course.getId() == courseId) {
				c=course;
				list.remove(course);
				break;
			}
		}
		return c;
	}

}
