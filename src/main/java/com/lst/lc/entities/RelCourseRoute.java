package com.lst.lc.entities;

// Generated 2015-7-13 13:31:58 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelCourseRoute generated by hbm2java
 */
@Entity
@Table(name = "relCourseRoute", catalog = "LearningCommunity")
public class RelCourseRoute implements java.io.Serializable {

	private RelCourseRouteId id;
	private Course course;
	private StudyRoute studyRoute;
	private String description;

	public RelCourseRoute() {
	}

	public RelCourseRoute(RelCourseRouteId id, Course course,
			StudyRoute studyRoute, String description) {
		this.id = id;
		this.course = course;
		this.studyRoute = studyRoute;
		this.description = description;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "courseId", column = @Column(name = "courseId", nullable = false)),
			@AttributeOverride(name = "routeId", column = @Column(name = "routeId", nullable = false)) })
	public RelCourseRouteId getId() {
		return this.id;
	}

	public void setId(RelCourseRouteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseId", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId", nullable = false, insertable = false, updatable = false)
	public StudyRoute getStudyRoute() {
		return this.studyRoute;
	}

	public void setStudyRoute(StudyRoute studyRoute) {
		this.studyRoute = studyRoute;
	}

	@Column(name = "description", nullable = false, length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
