package com.lst.lc.entities;

// Generated 2015-7-18 14:50:41 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Feedback generated by hbm2java
 */
@Entity
@Table(name = "feedback", catalog = "LearningCommunity")
public class Feedback implements java.io.Serializable {

	private Integer feedbackId;
	private User user;
	private Date time;
	private String title;
	private String content;
	private int isHandled;

	public Feedback() {
	}

	public Feedback(User user, Date time, String title, String content,
			int isHandled) {
		this.user = user;
		this.time = time;
		this.title = title;
		this.content = content;
		this.isHandled = isHandled;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "feedbackId", unique = true, nullable = false)
	public Integer getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
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

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "isHandled", nullable = false)
	public int getIsHandled() {
		return this.isHandled;
	}

	public void setIsHandled(int isHandled) {
		this.isHandled = isHandled;
	}

}
