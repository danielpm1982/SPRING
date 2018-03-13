package springMVC1.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	@RequestMapping("/form")
	public String showFormPage() {
		return "form";
	}
	@RequestMapping("/formResult")
	public String showFormResultPage(HttpServletRequest request, Model model) {
		model.addAttribute("name",request.getParameter("name"));
		model.addAttribute("birthDate", LocalDate.parse(request.getParameter("birthDate")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		return "formResult";
	}
}
