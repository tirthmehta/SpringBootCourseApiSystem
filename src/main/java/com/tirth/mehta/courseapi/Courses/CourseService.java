package com.tirth.mehta.courseapi.Courses;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirth.mehta.courseapi.Topics.Topic;
import com.tirth.mehta.courseapi.Topics.TopicRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicRepository topicRepository;

	public List<Course> getAllCourses(String id)
	{
//		List<Course> courses=new ArrayList<>();
//		Topic t=this.topicRepository.findById(id).orElse(null);
//		
//		this.courseRepository.findAll().forEach(courses::add);
//		return courses;
		return this.courseRepository.findByTopicId(id);
	}
	
	public Course getCourse(String courseid)
	{
		return this.courseRepository.findById(courseid).orElse(null);
	}
	
	public void addCourse(Course course)
	{
		this.courseRepository.save(course);
	}
	
	public void updateCourse(Course course, String courseid)
	{
		this.courseRepository.save(course);
	}
	
	public void deleteCourse(String id)
	{
		this.courseRepository.deleteById(id);
	}
}
