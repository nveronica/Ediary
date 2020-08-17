package hu.citec.ediary.model;

import java.sql.Date;
import java.time.LocalDate;

//INSERT INTO subject_grade (id, subject_id, user_id, grade_date, descrioption, teacher_id, grade_date) VALUES (?, ?, ?,?,?,?,?)
public class CustomGrade {
	private int id;
	private int subjectId;
	private int userId;
	private Date gradeDate;
	private String description;
	private int teacherId;
	private int grade;

	public CustomGrade() {
	}

	public CustomGrade(int id, int subjectId, int userId, Date gradeDate, String description, int teacherId,
			int grade) {
		
		this.id = id;
		this.subjectId = subjectId;
		this.userId = userId;
		this.gradeDate = gradeDate;
		this.description = description;
		this.teacherId = teacherId;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getGradeDate() {
		return gradeDate;
	}

	public void setGradeDate(Date gradeDate) {
		this.gradeDate = gradeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "CustomGrade [id=" + id + ", subjectId=" + subjectId + ", userId=" + userId + ", gradeDate=" + gradeDate
				+ ", description=" + description + ", teacherId=" + teacherId + ", grade=" + grade + "]";
	}


	
	
}
