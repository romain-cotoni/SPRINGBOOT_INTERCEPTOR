package fr.springboot.interceptor.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.springboot.interceptor.model.AppModel;
import fr.springboot.interceptor.service.AppService;

@RestController
@RequestMapping("/api/interceptor")
public class AppController {

	private static int count = 0; 
	
	@Autowired
	private AppService appService;
	
	@GetMapping("")
	public Iterable<AppModel> getEntities() {
		return appService.getEntities();
	}
	
	@GetMapping("/{id}")
	public AppModel getEntity(@PathVariable int id) throws Exception {
		return appService.getEntity(id);
	}
	
	@PostMapping("")
	public AppModel createEntity() throws Exception {
		AppModel appModel = new AppModel("helloworld "+(++count),count);
		return appService.createEntity(appModel);
	}
	
	
}
