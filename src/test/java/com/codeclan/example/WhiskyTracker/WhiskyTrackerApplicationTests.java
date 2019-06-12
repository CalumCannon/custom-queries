package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;



	@Test
	public void contextLoads() {
	}

	// Get all the whiskies for a particular year
	@Test
	public void canGetWhiskeysByYear() {
		List<Whisky> result = whiskyRepository.findWhiskeysByYear(2018);
		assertEquals(2, result.size());
	}


	// Get all the distilleries for a particular region
	@Test
	public void getAllDistilleriesFromRegion() {
		List<Distillery> result = distilleryRepository.findDistilleriesByRegion("Lowland");
		assertEquals(1, result.size());
	}

	// Get all the whisky from a particular distillery that's a specific age


}
