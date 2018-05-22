package com.tirth.mehta.courseapi.Lessons;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirth.mehta.courseapi.Topics.Topic;
import com.tirth.mehta.courseapi.Topics.TopicRepository;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String id)
	{
		return this.lessonRepository.findByCourseId(id);
	}
	
	public Lesson getLesson(String lessonid)
	{
		return this.lessonRepository.findById(lessonid).orElse(null);
	}
	
	public void addLesson(Lesson lesson)
	{
		this.lessonRepository.save(lesson);
	}
	
	public void updateLesson(Lesson lesson)
	{
		this.lessonRepository.save(lesson);
	}
	
	public void deleteLesson(String id)
	{
		this.lessonRepository.deleteById(id);
	}
}
