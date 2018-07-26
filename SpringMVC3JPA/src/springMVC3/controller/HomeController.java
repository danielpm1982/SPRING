package springMVC3.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springMVC3.model.DAO;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHomePage(HttpServletRequest request) {
		DAO.initialize(request);
		return "home";
	}
}
