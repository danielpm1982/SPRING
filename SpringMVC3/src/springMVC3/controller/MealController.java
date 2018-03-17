package springMVC3.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springMVC3.model.Drink;
import springMVC3.model.PaymentType;
import springMVC3.model.Sandwich;
import springMVC3.model.SandwichType;
import springMVC3.model.SizeType;
@Controller
@RequestMapping("/mealController")
public class MealController {
	@Value("#{sauceAddings}")
	private Map<String, String> sauceAddings; //sauceAdding values injected from sauceAddings.properties through ApplicationContext.xml mapping
	@RequestMapping("/sandwichForm")
	public String showSandwichFormPage(Model model, HttpServletRequest request) {
		Sandwich sandwich = (Sandwich)request.getSession().getAttribute("sandwichSession"); //chekcing the last Session set sandwich, and retrieving if it exists
		if(sandwich!=null) {
			model.addAttribute("sandwich", sandwich);
		} else {
			model.addAttribute("sandwich", new Sandwich()); //if no Session sandwich bean exists, create a blank new one
		}
		model.addAttribute("sandwichNames", SandwichType.values()); //data structure of EnumTypes (stringifiable) to populate select options
		model.addAttribute("sizeNames", SizeType.values()); //data structure of EnumTypes (stringifiable) to populate select options
		model.addAttribute("drinkNames", Drink.getDrinkList()); //data structure of beans (with properties defined) to populate select options
		model.addAttribute("sauceNames", sauceAddings); //data structure of Strings from external file properties to populate select options
		model.addAttribute("paymentNames", PaymentType.values());
		return "sandwichForm";
	}
	@RequestMapping("/sandwichFormResult")
	public String showSandwichFormResultPage(@ModelAttribute("sandwich") Sandwich sandwich, HttpServletRequest request) {
		request.getSession().setAttribute("sandwichSession", sandwich); //from all model attributes, only sandwich bean needs to be saved in the Session, with its properties' values filled out at the spring form (for later use). All other model (Request) beans are lost 
		return "sandwichFormResult";
	}
}
