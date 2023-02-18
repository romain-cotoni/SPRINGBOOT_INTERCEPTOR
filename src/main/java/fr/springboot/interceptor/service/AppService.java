package fr.springboot.interceptor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.springboot.interceptor.model.AppModel;
import fr.springboot.interceptor.repository.AppRepository;

@Service
public class AppService {

	@Autowired
	private AppRepository appRepository;

	public Iterable<AppModel> getEntities() {
		return appRepository.findAll();
	}
	
	public AppModel getEntity(int id) throws Exception {
		return appRepository.findById(id).get();		
	}

	public AppModel createEntity(AppModel appModel) throws Exception {
	    return appRepository.save(appModel);
	}


}
