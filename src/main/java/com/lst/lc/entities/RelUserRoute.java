package com.lst.lc.entities;

// Generated 2015-7-18 14:55:52 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RelUserRoute generated by hbm2java
 */
@Entity
@Table(name = "relUserRoute", catalog = "LearningCommunity")
public class RelUserRoute implements java.io.Serializable {

	private RelUserRouteId id;
	private StudyRoute studyRoute;
	private User user;
	private Date time;
	private int progress;

	public RelUserRoute() {
	}

	public RelUserRoute(RelUserRouteId id, StudyRoute studyRoute, User user,
			Date time, int progress) {
		this.id = id;
		this.studyRoute = studyRoute;
		this.user = user;
		this.time = time;
		this.progress = progress;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "userId", nullable = false)),
			@AttributeOverride(name = "routeId", column = @Column(name = "routeId", nullable = false)) })
	public RelUserRouteId getId() {
		return this.id;
	}

	public void setId(RelUserRouteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId", nullable = false, insertable = false, updatable = false)
	public StudyRoute getStudyRoute() {
		return this.studyRoute;
	}

	public void setStudyRoute(StudyRoute studyRoute) {
		this.studyRoute = studyRoute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "progress", nullable = false)
	public int getProgress() {
		return this.progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}
