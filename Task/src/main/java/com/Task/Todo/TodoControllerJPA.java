package com.Task.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.validation.Valid;

@Controller
public class TodoControllerJPA {

	
 
	@Autowired
	private TodoService todoService;////we use Autowired Annotation for using TodoService 
    
	@Autowired
	private TodoRepo repo;
	
	@RequestMapping("todolists")
	public String todolists(ModelMap model) {
		String username= GetLoggedUserName();
		List<Todo> todos = repo.findByUsername(username);
		model.addAttribute("todo", todos);
		return "todolists";
	}
	
	@RequestMapping("welcome")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", GetLoggedUserName());
		return "welcome";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String showTodoPage(ModelMap model,@Valid Todo todo , BindingResult result) {
		
		if(result.hasErrors()) {
			return "AddTodo";
		}
		
		
		String username= GetLoggedUserName();
		todo.setUsername(username);
		
		repo.save(todo);
		return "redirect:todolists";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showADDTodoPage(ModelMap model) {
		String username= GetLoggedUserName();
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "AddTodo";
	}
	
	@RequestMapping("deletetodo")
	public String deletetodolists(@RequestParam int id) {
		repo.deleteById(id);
		return "redirect:todolists";
	}
	
	@RequestMapping(value="updatetodo",method=RequestMethod.GET)
	public String showviewupdatetodolist(@RequestParam int id,ModelMap model) {
	Todo todo=	repo.findById(id).get();
	model.put("todo", todo);
		return "updatetodo";
	}
	
	@RequestMapping(value="updatetodo", method=RequestMethod.POST)
	public String updateTodoPage(ModelMap model,@Valid Todo todo , BindingResult result) {
		
		if(result.hasErrors()) {
			return "updatetodo";
		}
		
		
		String username= GetLoggedUserName();
		todo.setUsername(username);
		repo.save(todo);
		return "redirect:todolists";
	}
	
	
	private String GetLoggedUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
