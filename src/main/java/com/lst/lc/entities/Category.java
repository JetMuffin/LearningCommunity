package com.lst.lc.entities;

// Generated 2015-7-13 13:31:58 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "LearningCommunity")
public class Category implements java.io.Serializable {

	private String categoryName;
	private Admin admin;
	private Date time;
	private String description;
	private String enabled;
	private Set<Course> courses = new HashSet<Course>(0);

	public Category() {
	}

	public Category(String categoryName, Admin admin, Date time) {
		this.categoryName = categoryName;
		this.admin = admin;
		this.time = time;
	}

	public Category(String categoryName, Admin admin, Date time,
			String description, String enabled, Set<Course> courses) {
		this.categoryName = categoryName;
		this.admin = admin;
		this.time = time;
		this.description = description;
		this.enabled = enabled;
		this.courses = courses;
	}

	@Id
	@Column(name = "categoryName", unique = true, nullable = false, length = 20)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", nullable = false)
	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "enabled", length = 10)
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
