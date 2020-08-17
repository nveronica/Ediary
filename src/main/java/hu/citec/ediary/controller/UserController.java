package hu.citec.ediary.controller;

import hu.citec.ediary.model.CustomGrade;
import hu.citec.ediary.model.CustomSubject;
import hu.citec.ediary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
	@Autowired
	public UserService service;

	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("customUser", service.findStudentParent());
		return "user";
	}

	@GetMapping("/teacher")
	public String teacher(Model model) {
		model.addAttribute("customUser", service.findStudents());
		return "teacher";
	}

	@GetMapping("/student/{userId}")
	public String getStudentForTeacher(Model model, @PathVariable int userId) {
		Model addAttribute = model.addAttribute("customSubject", service.findCustomSubject(userId));
		return "student";
	}

	@GetMapping("/student")
	public String student(Authentication auth, Model model) {
		String studentName = auth.getName();
		model.addAttribute("customSubject", service.findCustomStudent(studentName));
		return "student";
	}
	@GetMapping("/subject/{subjectId}/{teacherId}")
	public String subjectsOfStudent(Authentication auth, Model model, @PathVariable int subjectId, @PathVariable int teacherId) {
		String name = auth.getName();
		CustomSubject subject = new CustomSubject();
		List<CustomSubject> findSubjectById = service.findSubjectById(name, subjectId, teacherId);
		System.err.println("list size" + findSubjectById.size());
		if (findSubjectById.size()==2) {
			for (int i = 0; i < findSubjectById.size(); i++) {
				if (findSubjectById.get(i).getSubjectId()==subjectId) {

					subject = findSubjectById.get(i);
					model.addAttribute("subject", subject);
				}
			}

		}else {
			model.addAttribute("subject", findSubjectById);
		}
		return "subject";

	}
	@GetMapping("/add_grade")
	public String addGrade(Model model) {
		CustomGrade newGrade = new CustomGrade();
		model.addAttribute("subjectGrade",newGrade);
		System.out.println(newGrade);

		return "add_grade" ;
	}
	@PostMapping("/add_grade")
	public String addNewGrade(@ModelAttribute CustomGrade customGrade) {
		service.addGrade(customGrade);
		return "redirect:/teacher";

	}
}
