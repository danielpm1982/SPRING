package springMVC1.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springMVC1.model.Help;

@Controller
@RequestMapping("/appController")
public class AppController {
	@RequestMapping("/form")
	public String showFormPage() {
		return "form";
	}
//	@RequestMapping("/formResult")
//	public String showFormResultPage(HttpServletRequest request, Model model) {
//		model.addAttribute("name",request.getParameter("name"));
//		model.addAttribute("birthDate", LocalDate.parse(request.getParameter("birthDate")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
//		return "formResult";
//	}
	@RequestMapping("/formResult")
	public String showFormResultPage(@RequestParam("name") String name, @RequestParam("birthDate") String birthDate, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("birthDate", LocalDate.parse(birthDate).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		model.addAttribute("age", Help.calculateAge(LocalDate.parse(birthDate)));
		return "formResult";
	}
}
