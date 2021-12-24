package hu.citec.ediary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.citec.ediary.dao.UserRepository;
import hu.citec.ediary.model.CustomGrade;
import hu.citec.ediary.model.CustomSubject;
import hu.citec.ediary.model.CustomUser;
import hu.citec.ediary.model.Subject;
import hu.citec.ediary.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findUsers() {
		return repository.findUser();
	}
	
	public List<CustomUser> findCustoms(){
		return repository.findCustomUser();
	}

	public void deleteUserById(int userId) {
		repository.deleteUserById(userId);
		
	}
	
	public List<Subject> findSubjects(){
		return repository.findSubject();
	}
	
	public List<CustomUser> findStudentParent(){
		return repository.findStudentParent();
	}

	public CustomUser findStudentById(int userId) {
		return repository.findStudentById(userId);
		
	}

	public List<CustomUser> findStudents() {
		return repository.findStudents();
	}

	public List<CustomSubject> findCustomSubject(int userId) {
		return repository.findCustomSubject(userId);
		
	}

	public List<CustomSubject> findCustomStudent(String studentName) {
		return repository.findStudentByName(studentName);
	}

	public List<CustomSubject> findSubjectById(String name, int subjectId, int userId) {
		return repository.findSubjectById(name, subjectId, userId);
	}

	public void addGrade(CustomGrade customGrade) {
		repository.addGrade(customGrade);
		
	}

	public void addCustomUser(CustomUser newUser) {
		repository.addCustomUser(newUser);
	}

	
}
