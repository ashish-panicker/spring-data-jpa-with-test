package com.easyskillup;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyskillup.model.Trainee;
import com.easyskillup.model.TraineeNotFoundException;
import com.easyskillup.model.TraineeRepository;

@RestController
@RequestMapping("trainees")
public class TraineeController {

	@Autowired
	private TraineeRepository repo;

	@GetMapping("/")
	public Iterable<Trainee> findAll() {
		List<Trainee> trainees = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
		System.err.println(trainees.get(0));
		return trainees;
	}

	@GetMapping(value = "/{id}")
	public Trainee findById(@PathVariable long id) throws TraineeNotFoundException {
		return repo.findById(id).orElseThrow(TraineeNotFoundException::new);
	}

	@PostMapping
	public Trainee create(@RequestBody Trainee trainee) {
		return repo.save(trainee);
	}

}
