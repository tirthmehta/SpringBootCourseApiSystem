package com.tirth.mehta.courseapi.Courses;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tirth.mehta.courseapi.Topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return this.courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicid}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicid}/courses")
	public void addCourse( @RequestBody Course course,@PathVariable String topicid)
	{
		Topic t=new Topic(topicid,"","");
		course.setTopic(t);
		this.courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicid}/courses/{courseid}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicid,@PathVariable String courseid)
	{
		Topic t=new Topic(topicid,"","");
		course.setTopic(t);
		this.courseService.updateCourse(course,courseid);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		this.courseService.deleteCourse(id);
	}
}
