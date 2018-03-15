package springMVC2.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springMVC2.model.Address;
import springMVC2.model.Help;
import springMVC2.model.Person;

@Controller
@RequestMapping("/personController")
public class PersonController {
	@RequestMapping("/personForm")
	public String showPersonFormPage(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}
	@RequestMapping("/personFormResult")
	public String showPersonFormResultPage(@ModelAttribute("person") Person person) {
		String birthDate = LocalDate.parse(person.getBirthDate()).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
		String age = Help.calculateAge2(LocalDate.parse(person.getBirthDate()));
		person.setBirthDate(birthDate);
		person.setAge(age);
		return "personFormResult";
	}
	@RequestMapping("/addressForm")
	public String showAddressFormPage(Model model) {
		model.addAttribute("address", new Address());
		return "addressForm";
	}
	@RequestMapping("/addressFormResult")
	public String showAddressFormResultPage(@ModelAttribute("address") Address address, HttpServletRequest request, Model model) {
		request.getSession().setAttribute("addressSession", address);
//		request.getServletContext().setAttribute("addressApplication", address);
		model.addAttribute("person", new Person());
		return "personForm";
	}
}
