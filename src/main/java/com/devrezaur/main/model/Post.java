package com.devrezaur.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "posts")
@Component
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int id;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "title")
	private String title;

	@Column(name = "desc")
	private String desc;

	@Column(name = "resource")
	private String resource;

	@Column(name = "resources_link")
	private String resourcesLink;

	@Column(name = "class_link")
	private String classLink;

	public Post() {
		super();
	}

	public Post(int id, int courseId, String title, String desc, String resourcesLink, String resource, String classLink) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.desc = desc;
		this.resource = resource;
		this.resourcesLink = resourcesLink;
		this.classLink = classLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getResourcesLink() {
		return resourcesLink;
	}

	public void setResourcesLink(String resourcesLink) {
		this.resourcesLink = resourcesLink;
	}

	public String getClassLink() {
		return classLink;
	}

	public void setClassLink(String classLink) {
		this.classLink = classLink;
	}

}
