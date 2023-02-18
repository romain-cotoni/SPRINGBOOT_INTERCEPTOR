package fr.springboot.interceptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.interceptor.model.AppModel;

@Repository
public interface AppRepository extends JpaRepository<AppModel,Integer> {
	
}
