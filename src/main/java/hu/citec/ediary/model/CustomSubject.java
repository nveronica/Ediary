package hu.citec.ediary.model;

import java.time.LocalDate;

public class CustomSubject {
	
	private int subjectId;
	private int userId;
	private String descrip;
	private int grade;
	private String subjectName;
	private String studentName;
	private int teacherId;
	private LocalDate date;
	
	public CustomSubject() {
		
	}

	public CustomSubject(int subjectId, int userId, String descrip, int grade, String subjectName, String studentName,
			int teacherId, LocalDate date) {
		this.subjectId = subjectId;
		this.userId = userId;
		this.descrip = descrip;
		this.grade = grade;
		this.subjectName = subjectName;
		this.studentName = studentName;
		this.teacherId = teacherId;
		this.date = date;
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

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomSubject [subjectId=" + subjectId + ", userId=" + userId + ", descrip=" + descrip + ", grade="
				+ grade + ", subjectName=" + subjectName + ", studentName=" + studentName + ", teacherId=" + teacherId
				+ ", date=" + date + "]";
	}

	
	
}
