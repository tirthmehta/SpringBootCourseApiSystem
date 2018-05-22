package com.tirth.mehta.courseapi.Lessons;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tirth.mehta.courseapi.Courses.Course;
import com.tirth.mehta.courseapi.Topics.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonSevice;
	
	@RequestMapping("/topics/{id}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id,@PathVariable String courseId)
	{
		return this.lessonSevice.getAllLessons(courseId);
	}
	
	@RequestMapping("/topics/{topicid}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId)
	{
		return this.lessonSevice.getLesson(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicid}/courses/{courseId}/lessons")
	public void addLesson( @RequestBody Lesson lesson,@PathVariable String topicid,@PathVariable String courseId)
	{
		Topic t=new Topic(topicid,"","");
		Course c=new Course(courseId,"","",null);
		c.setTopic(t);
		lesson.setCourse(c);
		this.lessonSevice.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicid}/courses/{courseid}/lessons/{lessonid}")
	public void updateLesson(@RequestBody Lesson lesson,@PathVariable String topicid,@PathVariable String courseid)
	{
		Topic t=new Topic(topicid,"","");
		Course c=new Course(courseid,"","",null);
		c.setTopic(t);
		lesson.setCourse(c);
		this.lessonSevice.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}/courses/{id}/lessons/{lessonid}")
	public void deleteLesson(@PathVariable String lessonid)
	{
		this.lessonSevice.deleteLesson(lessonid);
	}
}
