package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;


	@Test
	public void contextLoads() {
	}

//	@Test
//	public void createSinglePirateAndSave(){
//		Pirate pirate = new Pirate("Jack", "Sparrow", 32,);
//		pirateRepository.save(pirate);
//	}

	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("Iris");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
	}

	@Test
	public void canAddPiratesToRaidsAndRaidsToPirates() {
		Ship ship2 = new Ship("star");
		shipRepository.save(ship2);
		Pirate pirate2 = new Pirate("james", "Sparrow", 23, ship2);
		Raid raid = new Raid("Codeclan", 1000);
		pirateRepository.save(pirate2);
		raidRepository.save(raid);
		pirate2.addRaid(raid);
		pirateRepository.save(pirate2);
	}
}
