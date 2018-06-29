package springMVC3.controller;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC3.entity.Order;
import springMVC3.helper.Drink;
import springMVC3.helper.PaymentType;
import springMVC3.helper.SandwichType;
import springMVC3.helper.SizeType;
import springMVC3.service.PersistenceServiceInterface;

@Controller
@RequestMapping("/mealController")
public class MealController {
	@Autowired
	@Qualifier("persistenceService")
	private PersistenceServiceInterface persistenceServiceInterface;
	@Value("#{sauceAddings}")
	private Map<String, String> sauceAddings; //sauceAdding values injected from sauceAddings.properties through ApplicationContext.xml mapping
	@GetMapping("/home")
	@RequestMapping(path="/home1", method=RequestMethod.GET)
	public String showHomePage1(Model model) {
		model.addAttribute("homeFormType", 1);
		return "home";
	}
	@GetMapping("/home2")
	public String showHomePage2(Model model) {
		model.addAttribute("homeFormType", 2);
		return "home";
	}
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
		persistenceServiceInterface.saveOrder(order);
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
		List<Order> orderList = persistenceServiceInterface.getAllOrders();
		model.addAttribute("orderList", orderList);
		return "managementFormQueryAllResult";
	}
	@RequestMapping("/managementFormQueryOrderIdResult")
	public String showManagementFormQueryOrderIdResultPage(@RequestParam(name="orderId") long orderId, Model model, HttpServletRequest request) {
		Order order = persistenceServiceInterface.getOrderById(orderId);
		model.addAttribute("order", order);
		model.addAttribute("orderId", orderId);
		return "managementFormQueryOrderIdResult";
	}
	@RequestMapping("/managementFormQuerySSNResult")
	public String showManagementFormQuerySSNResultPage(@RequestParam(name="SSN") long SSN, Model model, HttpServletRequest request) {
		List<Order> orderList = persistenceServiceInterface.getOrderBySSN(SSN);
		model.addAttribute("orderList", orderList);
		model.addAttribute("SSN", SSN);
		return "managementFormQuerySSNResult";
	}
	@RequestMapping("/managementFormDeleteOrderResult")
	public String showManagementFormDeleteOrderResultPage(@RequestParam(name="orderId") long orderId, Model model, HttpServletRequest request) {
		model.addAttribute("orderId", orderId);
		Order deletingOrder = persistenceServiceInterface.getOrderById(orderId);
		model.addAttribute("deletingOrder", deletingOrder);
		boolean deleted = persistenceServiceInterface.deleteOrder(orderId);
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


/*
- Same as SpringMVC3JPA, but, in this project, using applicationContext confs (instead of hibernate.cfg.xml) 
to config DataSource, SessionFactory, transaction-manager and its annotation in the form of @Component beans 
and dependencies (through XML) that can be injected automatically through @Autowired at the DAO, and the 
@Transactional annotation used, for avoiding dealing manually with the creation of the sessionFactory or 
manually managing the transactions of the currentSession, which saves a lot of code. 
- Also, uses @Repository (son of @Component) at the DAO, to make it a @Component bean (through Annotation), 
to have it instantiated, to have its dependencies injected automatically (including the SessionFactory bean) 
and to be registered by the framework at the project in order to be used at the controller. 
- At the controller, on the other hand, the DAO (or its interface) is the one to be injected through @Autowired,
with all dependencies set (including SessionFactory and DataSource).
- @RequestMapping can explicitly specify a requestMethod-type constraint, for ex. RequestMethod.GET, or 
RequestMethod.POST, or use the abbreviated annotations @GetMapping or @PostMapping instead.
- A form type number attribute has been added to the Model at the showHomePage method in order to make the
home page show different forms (with different link urls) according to the forwarding or redirecting from
the welcome page. If "forward" is used, the complete url for the controller (starting from the controller 
requestMapping url - for ex. href="mealController/orderForm") is used. If "redirect" is used, only the 
controller methods' request mapping urls are used (for ex. href="orderForm").
- A @Service @Component has been added as a Service Facade between DAO (@Repository) and the controller 
(@Controller), having the DAO injected through @Autowired (Annotation) at it. The Service then was injected 
at the controller, replacing the DAO. The main purpose is to be able to deal with multiple DAOs through an unique
Service layer at the controller. The @Transactional annotation can then be transferred from eventual multiple DAOs 
to the unique service layer methods, saving some code. 
*/
