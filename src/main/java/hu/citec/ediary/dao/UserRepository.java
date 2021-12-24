package hu.citec.ediary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.citec.ediary.model.CustomGrade;
import hu.citec.ediary.model.CustomSubject;
import hu.citec.ediary.model.CustomUser;
import hu.citec.ediary.model.Subject;
import hu.citec.ediary.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findUser() {
		String query = "SELECT user_id AS userId, username, user_password, fullname, email, activated, blocked FROM users";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(User.class));
	}
	
	public List<CustomUser> findStudentParent(){
		String query = "SELECT * FROM role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE role_type = 'SZULO' AND u.activated IS NOT NULL OR role_type = 'DIAK'";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomUser.class));
	}
	
	public List<CustomUser> findCustomUser() {
		String query = "SELECT * FROM role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE u.activated IS NOT NULL";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomUser.class));
	}
	
	public void deleteUserById(int userId) {
		String query = "DELETE FROM users WHERE user_id = ?";
		jdbcTemplate.update(query, ps -> ps.setInt(1, userId));
	}
	
	public List<Subject> findSubject(){
		String query = "SELECT subject_id AS id, subject_name AS name FROM subject";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Subject.class));
	}

	public CustomUser findStudentById(int userId) {
		String query = "SELECT user_id as userId FROM role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE role_type = 'DIAK' AND u.activated IS NOT NULL AND u.user_id = ?";
		return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(CustomUser.class), userId);
	}

	public List<CustomUser> findStudents() {
		String query = "SELECT * FROM role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE role_type = 'DIAK'";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomUser.class));
	}

	public List<CustomSubject> findCustomSubject(int userId) {
		String query = "SELECT * FROM subject_grade sb RIGHT JOIN subject s ON sb.subject_id=s.subject_id JOIN users u ON sb.user_id=u.user_id WHERE u.user_id=?";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomSubject.class), userId);
	}

	public List<CustomSubject> findStudentByName(String studentName) {
		String query ="SELECT * FROM subject_grade sb RIGHT JOIN subject s ON sb.subject_id=s.subject_id JOIN users u ON sb.user_id=u.user_id WHERE u.username=?";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomSubject.class), studentName);
	}

	public List<CustomSubject> findSubjectById(String name, int subjectId, int teacherId) {
		String query ="SELECT s.subject_id as 'subjectId', sb.grade as 'grade', sb.descrioption as 'descrip',sb.grade_date as 'date', s.subject_name, sb.user_id FROM subject_grade sb RIGHT JOIN subject s ON sb.subject_id=s.subject_id JOIN users u ON sb.user_id=u.user_id WHERE u.username=? OR s.subject_id=? OR teacher_id=? IS NULL ";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CustomSubject.class), name, subjectId, teacherId);
	}

	public void addGrade(CustomGrade customGrade) {
		String query = "INSERT INTO subject_grade (id, subject_id, user_id, grade_date, descrioption, teacher_id, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, customGrade.getId(), customGrade.getSubjectId(), customGrade.getUserId(), customGrade.getGradeDate(), customGrade.getDescription(), customGrade.getTeacherId(), customGrade.getGrade());
		
	}

	public void addCustomUser(CustomUser newUser) {
		String query = "INSERT INTO users(`user_id`, `username`, `user_password`, `fullname`, `email`, `activated`, `blocked`) VALUES (?,?,?,?,?,?,?)";
		//jdbcTemplate.update(query,newUser.getUserId(),newUser.getUserName(),newUser.getGrade);
		
	}

	
}