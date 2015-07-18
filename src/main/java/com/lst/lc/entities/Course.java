package com.lst.lc.entities;

// Generated 2015-7-18 14:50:41 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course", catalog = "LearningCommunity")
public class Course implements java.io.Serializable {

	private Integer courseId;
	private Category category;
	private Direction direction;
	private String title;
	private String description;
	private int studentNums;
	private float duration;
	private Date createTime;
	private String difficulty;
	private String imageUrl;
	private String isFinished;
	private String enabled;
	private Set<RelUserCourse> relUserCourses = new HashSet<RelUserCourse>(0);
	private Set<CourseLesson> courseLessons = new HashSet<CourseLesson>(0);
	private Set<RelCourseRoute> relCourseRoutes = new HashSet<RelCourseRoute>(0);

	public Course() {
	}

	public Course(Category category, Direction direction, String title,
			String description, int studentNums, float duration,
			Date createTime, String difficulty, String imageUrl,
			String isFinished, String enabled) {
		this.category = category;
		this.direction = direction;
		this.title = title;
		this.description = description;
		this.studentNums = studentNums;
		this.duration = duration;
		this.createTime = createTime;
		this.difficulty = difficulty;
		this.imageUrl = imageUrl;
		this.isFinished = isFinished;
		this.enabled = enabled;
	}

	public Course(Category category, Direction direction, String title,
			String description, int studentNums, float duration,
			Date createTime, String difficulty, String imageUrl,
			String isFinished, String enabled,
			Set<RelUserCourse> relUserCourses, Set<CourseLesson> courseLessons,
			Set<RelCourseRoute> relCourseRoutes) {
		this.category = category;
		this.direction = direction;
		this.title = title;
		this.description = description;
		this.studentNums = studentNums;
		this.duration = duration;
		this.createTime = createTime;
		this.difficulty = difficulty;
		this.imageUrl = imageUrl;
		this.isFinished = isFinished;
		this.enabled = enabled;
		this.relUserCourses = relUserCourses;
		this.courseLessons = courseLessons;
		this.relCourseRoutes = relCourseRoutes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "courseId", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "directionId", nullable = false)
	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "studentNums", nullable = false)
	public int getStudentNums() {
		return this.studentNums;
	}

	public void setStudentNums(int studentNums) {
		this.studentNums = studentNums;
	}

	@Column(name = "duration", nullable = false, precision = 12, scale = 0)
	public float getDuration() {
		return this.duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "difficulty", nullable = false, length = 10)
	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	@Column(name = "imageUrl", nullable = false, length = 200)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "isFinished", nullable = false, length = 10)
	public String getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}

	@Column(name = "enabled", nullable = false, length = 10)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<RelUserCourse> getRelUserCourses() {
		return this.relUserCourses;
	}

	public void setRelUserCourses(Set<RelUserCourse> relUserCourses) {
		this.relUserCourses = relUserCourses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<CourseLesson> getCourseLessons() {
		return this.courseLessons;
	}

	public void setCourseLessons(Set<CourseLesson> courseLessons) {
		this.courseLessons = courseLessons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<RelCourseRoute> getRelCourseRoutes() {
		return this.relCourseRoutes;
	}

	public void setRelCourseRoutes(Set<RelCourseRoute> relCourseRoutes) {
		this.relCourseRoutes = relCourseRoutes;
	}

}
