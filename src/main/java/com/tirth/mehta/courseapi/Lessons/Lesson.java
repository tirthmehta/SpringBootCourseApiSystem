package com.tirth.mehta.courseapi.Lessons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tirth.mehta.courseapi.Courses.Course;
import com.tirth.mehta.courseapi.Topics.Topic;

@Entity
@Table
public class Lesson {
	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private Course course;
	

	public Lesson(String id, String name, String description,String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course=new Course(courseId,"","",null);
	}
	protected Lesson()
	{
		
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
