package com.easyskillup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.easyskillup.model.Trainee;
import com.easyskillup.model.TraineeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TraineeRepoTest {

	@Autowired
	private TraineeRepository repo;

	@Test
	public void testFindAllTrainees() {
		List<Trainee> trainees = StreamSupport.stream(repo.findAll().spliterator(), false)
								.collect(Collectors.toList());
		System.err.println(trainees.size());
		assertThat(trainees).hasSizeGreaterThan(0);
	}
	
	@Test
	public void testCreateNewTrainee() {
		Trainee t = new Trainee();
		t.setFirstName("Rohit");
		t.setLastName("Sharma");
		t.setYear("2019");
		repo.save(t);
		
		assertThat(t.getId()).isNotNull();
	}
}
