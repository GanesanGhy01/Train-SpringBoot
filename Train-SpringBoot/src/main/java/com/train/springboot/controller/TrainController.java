package com.train.springboot.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.springboot.request.TrainRequest;
import com.train.springboot.response.TrainResponse;
import com.train.springboot.service.TrainService;

@RestController
public class TrainController {
	
	@Autowired
	TrainService tservice;
	
	@GetMapping("/getTrain")
	public List<TrainResponse> getTrain(){
		return tservice.getAllTrainDetails();
	}
	@GetMapping("/getTrain/{trainid}")
	public TrainResponse getTrainOne(@PathVariable("trainid") int trainid) {
		return tservice.getTrain(trainid);
		
	}
	
	@PostMapping("/saveTrain")
	public TrainResponse saveTrain(@RequestBody TrainRequest tr) {
		return tservice.saveTrain(tr);
	}
	
	@PutMapping("/updateTrain")
	public TrainResponse updateTrain(@RequestBody TrainRequest tr) {
		return tservice.updateTrain(tr);
	}
	
	@DeleteMapping("/deleteTrain/{trainid}")
	public String deleteTrain(@PathVariable("trainid") int trainid) {
		return tservice.deleteTrain(trainid);
	}
}
