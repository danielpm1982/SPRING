package springMVC3.controller;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC3.model.DAO;
import springMVC3.model.Drink;
import springMVC3.model.Order;
import springMVC3.model.PaymentType;
import springMVC3.model.SandwichType;
import springMVC3.model.SizeType;
@Controller
@RequestMapping("/mealController")
public class MealController {
	@Value("#{sauceAddings}")
	private Map<String, String> sauceAddings; //sauceAdding values injected from sauceAddings.properties through ApplicationContext.xml mapping
	@RequestMapping("/orderForm")
	public String showOrderFormPage(Model model, HttpServletRequest request) {
		Order order = (Order)request.getSession().getAttribute("orderSession"); //checking the last set Session order, and retrieving if it exists
		setModelAttributes(model, order);
		return "orderForm";
	}
	@RequestMapping("/orderFormResult")
	public String showOrderFormResultPage(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, HttpServletRequest request, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			setModelAttributes(model, order); //for sending to the form page again, all model attributes must be set again, and the order here will be the one not yet saved at the session, but that returned from the form previously
			return "orderForm";
		}
		request.getSession().setAttribute("orderSession", order); //from all model attributes, only order bean needs to be saved in the Session, with its properties' values filled out at the spring form (for later use). All other model (Request) beans are lost 
		DAO.saveOrder(order);
		return "orderFormResult";
	}
	@RequestMapping("/newOrderFormResult")
	public String showNewOrderFormResultPage(HttpServletRequest request, Model model) {
		Order order = null;
		request.getSession().setAttribute("orderSession", order); 
		setModelAttributes(model, order);
		return "orderForm";
	}
	@RequestMapping("/managementForm")
	public String showManagementFormPage(Model model, HttpServletRequest request) {
		return "managementForm";
	}
	@RequestMapping("/managementFormQueryAllResult")
	public String showManagementFormResultPage(Model model, HttpServletRequest request) {
		List<Order> orderList = DAO.getAllOrders();
		model.addAttribute("orderList", orderList);
		return "managementFormQueryAllResult";
	}
	@RequestMapping("/managementFormQueryOrderIdResult")
	public String showManagementFormQueryOrderIdResultPage(@RequestParam(name="orderId") long orderId, Model model, HttpServletRequest request) {
		Order order = DAO.getOrderById(orderId);
		model.addAttribute("order", order);
		model.addAttribute("orderId", orderId);
		return "managementFormQueryOrderIdResult";
	}
	@RequestMapping("/managementFormQuerySSNResult")
	public String showManagementFormQuerySSNResultPage(@RequestParam(name="SSN") long SSN, Model model, HttpServletRequest request) {
		List<Order> orderList = DAO.getOrderBySSN(SSN);
		model.addAttribute("orderList", orderList);
		model.addAttribute("SSN", SSN);
		return "managementFormQuerySSNResult";
	}
	@RequestMapping("/managementFormDeleteOrderResult")
	public String showManagementFormDeleteOrderResultPage(@RequestParam(name="orderId") long orderId, Model model, HttpServletRequest request) {
		model.addAttribute("orderId", orderId);
		Order deletingOrder = DAO.getOrderById(orderId);
		model.addAttribute("deletingOrder", deletingOrder);
		boolean deleted = DAO.deleteOrder(orderId);
		model.addAttribute("deleted", deleted);
		return "managementFormDeleteOrderResult";
	}
	private void setModelAttributes(Model model, Order order) {
		if(order!=null) {
			model.addAttribute("order", order);
		} else {
			model.addAttribute("order", new Order()); //if no Session order bean exists, create a blank new one
		}
		model.addAttribute("sandwichNames", SandwichType.values()); //data structure of EnumTypes (stringifiable) to populate select options
		model.addAttribute("sizeNames", SizeType.values()); //data structure of EnumTypes (stringifiable) to populate select options
		model.addAttribute("drinkNames", Drink.getDrinkList()); //data structure of beans (with properties defined) to populate select options
		model.addAttribute("sauceNames", sauceAddings); //data structure of Strings from external file properties to populate select options
		model.addAttribute("paymentNames", PaymentType.values());
	}
	@RequestMapping("/underConstruction")
	public String showUnderConstructionFormPage() {
		return "underConstruction";
	}
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, trimmer);
	}
}
