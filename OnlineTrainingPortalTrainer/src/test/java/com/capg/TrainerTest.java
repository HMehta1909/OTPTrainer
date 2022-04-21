package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.Model.Trainer;
import com.capg.Model.Users;
import com.capg.Repository.ITrainerRepo;
import com.capg.Service.TrainerService;

@SpringBootTest
public class TrainerTest {

	@MockBean
	private ITrainerRepo repo;
	
	@Autowired
	private TrainerService service;
	
	@Test
	public void getTrainerObj() {
		String name = "HIMANSHU";
		when(repo.findByName(name)).thenReturn(new Trainer("TRN-CLO-01",new Users("TRN-CLO-01","UserName01","Pass@word01"),"HIMANSHU","CLOUD","PUNE","90000000","h@gmail.com"));
		Trainer trainer = new Trainer("TRN-CLO-01",new Users("TRN-CLO-01","UserName01","Pass@word01"),"HIMANSHU","CLOUD","PUNE","90000000","h@gmail.com");
		assertEquals(trainer,service.getTrainerByName(name).get());
	} 
	
	@Test
	public void registerTrainer() {
		Trainer trainer = new Trainer("TRN-CLO-01",new Users("TRN-CLO-01","UserName01","Pass@word01"),"HIMANSHU","CLOUD","PUNE","90000000","h@gmail.com");
		when(repo.save(trainer)).thenReturn(trainer);
		assertEquals(trainer,service.registerTrainer(trainer));
	}
}
