package springMVC2.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import springMVC2.model.Address;
import springMVC2.model.Help;
import springMVC2.model.Person;

@Controller
@RequestMapping("/personController")
public class PersonController {
	@RequestMapping("/personForm")
	public String showPersonFormPage(Model model, HttpServletRequest request) {
		Person personSession = (Person)request.getSession().getAttribute("personSession"); //getting Session saved Person object, if exists, for showing already populated form.
		if(personSession!=null) {
			model.addAttribute("person", personSession); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		} else {
			model.addAttribute("person", new Person()); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		}
		return "personForm";
	}
	@RequestMapping("/personFormResult")
	public String showPersonFormResultPage(@ModelAttribute("person") Person person, HttpServletRequest request) { //Model attributes are Request scoped. They endure only 1 mcv cycle: the bean is sent to the spring form, is populated, returns with the request of the form, can have its values processed and is Dispatched with the Request object to ONLY ONE RESULT JSP. From the next request on, the attribute does not exist any longer. If you wanna persist the attribute and its values, you gotta set them with another scope - session or servletContext scopes, so that they can endure and have their values used not only on the right next result jsp but on any other - as long as the session or application are alive. If the only need for that Model attribute values is at the next result jsp, then the request default scope is sufficient, and no scope change is needed. The Model object will always be of Request scope. For Session or ServletContext scopes get the servlet api objects from the Request object. You can't change Model scope.
		request.getSession().setAttribute("personSession", new Person(person)); //cloning, instead of using a referrence to the same object, for not getting the parsed String (birthDate field), but the original and right String format - yyyy-mm-dd - which will later be parsed here again. If the same object is added to the session, the birthDate in the session will also have the value parsed to the long date String format and will cause an error after the request is sent here again for parsing again. The value of the birthDate must be in the yyyy-mm-dd format every time it gets here for being parsed and sent to the result jsp in the Model (request) scope.  
		String birthDate = LocalDate.parse(person.getBirthDate()).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
		String age = Help.calculateAge2(LocalDate.parse(person.getBirthDate()));
		person.setBirthDate(birthDate);
		person.setAge(age);
		return "personFormResult";
	}
	@RequestMapping("/addressForm")
	public String showAddressFormPage(Model model, HttpServletRequest request) { //getting Session saved Address object, if exists, for showing already populated form.
		Address addressSession = (Address)request.getSession().getAttribute("addressSession");
		if(addressSession!=null) {
			model.addAttribute("address", addressSession); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		} else {
			model.addAttribute("address", new Address()); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		}
		return "addressForm";
	}
	@RequestMapping("/addressFormResult")
	public String showAddressFormResultPage(@ModelAttribute("address") Address address, HttpServletRequest request, Model model) { //Model attributes are Request scoped. They endure only 1 mcv cycle: the bean is sent to the spring form, is populated, returns with the request of the form, can have its values processed and is Dispatched with the Request object to ONLY ONE RESULT JSP. From the next request on, the attribute does not exist any longer. If you wanna persist the attribute and its values, you gotta set them with another scope - session or servletContext scopes, so that they can endure and have their values used not only on the right next result jsp but on any other - as long as the session or application are alive. If the only need for that Model attribute values is at the next result jsp, then the request default scope is sufficient, and no scope change is needed. The Model object will always be of Request scope. For Session or ServletContext scopes get the servlet api objects from the Request object. You can't change Model scope.
		request.getSession().setAttribute("addressSession", address); //the same object of the Model (Request) is set to the Session. Any modification of the object in one scope will reflect into the other. If there's any risk on that, clone it and use different Address objects for each scope. 
//		request.getServletContext().setAttribute("addressApplication", address); //idem above.
		Person personSession = (Person)request.getSession().getAttribute("personSession"); //getting Session saved Person object, if exists, for showing already populated form.
		if(personSession!=null) {
			model.addAttribute("person", personSession); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		} else {
			model.addAttribute("person", new Person()); //each time you send to a jsp with a spring form, you must add to the Model (Request) the modelAttribute - the bean - that is going to be used at that spring form, either a blank new one, or other, previously populated and saved at other scopes - session or servletContext, for instance. Or populated at the constructor itself, or from a property file, database, webservice, whatever.
		} 
		return "personForm";
	}
}


/* Explaining this web app MVC beans' cycles:

The program first leads to the Home. From there you can be linked to the Person formulary or to the Address formulary. If linked to the Person formulary, you're mapped through the /personForm url to the showPersonFormPage(Model model, HttpServletRequest request) method. Here, before dispatching to the personForm.jsp (where a Spring form is waiting a Model attribute bean to populate), you must add a bean attribute to the Model, but first you check if the Person attribute already is saved at the Session scope, to send it, already populated. If not, you send a blank new Person bean. The personForm.jsp spring form thus populates the Person bean through the paths of each other form tag and sends that bean on the request of the form to the /personFormResult url, that maps to the showPersonFormResultPage(@ModelAttribute("person") Person person, HttpServletRequest request) method. Inside this method, the first thing is to save the Person bean in a Session scope (for using all long the Session time, and not only in the right next dispatch). After, it process the values and dispatches to the personFormResult.jsp where they're displayed. At the personForm.jsp, another scenario could happen, which is the case of clicking on the Address Formulary button (before submitting the Person form request to the @Controller. In this case, the thread will be directed to the /addressForm, and thus to the showAddressFormPage(Model model, HttpServletRequest request) method first. Here, before redirecting to the Address formulary (where a Spring form is waiting a Model attribute bean to populate), you must add a bean attribute to the Model, but first you check if the Address attribute already is saved at the Session scope, to send it, already populated. If not, you send a blank new Address bean. The addressForm.jsp spring form thus populates the Person bean through the paths of each other form tag and sends that bean on the request of the form to the /addressFormResult url, that maps to the showAddressFormResultPage(@ModelAttribute("address") Address address, HttpServletRequest request, Model model) method. Here, the first thing is to save that address bean of the Model (Request scoped) in a Session scope, for later use at any session jsp, and not only at the next one. Instead of Session scope, ServletContext (Application) scope could also be used, if it were the case. This method will redirect to the same personForm.jsp page accessed before, whose spring form will be waiting a Person bean to populate. Thus, a Person bean attribute must first be added to the Model object. If a Person bean has already been populated and saved at the Session it is got and sent, otherwise a new blank one is added and sent to the personForm.jsp. At the personForm.jsp the form data is filled or updated and follows the same as already described at the main scenario above. Another alternative scenario would be that, from the Home page the Address Formulary link had been chosen at first, rather than the Person Formulary link, but the procedure and events would be similar as already described.

Important facts at this app example:

1 -> every time you're directing from a @Controller method to a jsp that has a Spring form waiting a Model bean to populate, you must create and add that bean to the Model (even if you had done that before - 'cause the last addings would be lost at that time, as Model is Request scoped!).

2 -> when adding that bean to the Model you can add an already populated one, getting it from Session or ServletContext scopes (if they have been saved before). The spring form thus reads all the values and appear already populated for the client to check it and update what fields he wants.

3 -> after returning from each spring form to a @Controller method, you must save that Model bean (Request scoped) to a Session or ServletContext scope, if you wish to use it later and not only at the right next dispatch. If you only want to use the just returned bean values at a result jsp, right next, then you don't need to save at other scopes 'cause the Model attributes will be set to the Request object being dispatched to that one and only result jsp (but not any others). And the attributes set to the Model will die there. While the Session or ServletContext saved ones will endure, for later use (either pre-filling later spring forms or showing at other result jsps).

*/

