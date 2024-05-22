package com.train.springboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.springboot.entity.Train;
import com.train.springboot.repo.TrainRepo;
import com.train.springboot.request.TrainRequest;
import com.train.springboot.response.TrainResponse;

@Service
public class TrainService {
	
	@Autowired(required=true)
	TrainRepo trepo;
	
	public List<TrainResponse> getAllTrainDetails(){
		List<TrainResponse> tres = new ArrayList<>();
		List<Train> train = trepo.findAll();
		for(Train t : train) {
			TrainResponse tr = new TrainResponse();
			tr.setTrainid(t.getTrainid());
			tr.setTrainno(t.getTrainno());
			tr.setTrainname(t.getTrainname());
			tr.setStart(t.getStart());
			tr.setDestination(t.getDestination());
			tr.setStartingtime(t.getStartingtime());
			tr.setEndingtime(t.getEndingtime());
			tr.setAvalseat(t.getAvalseat());
			tres.add(tr);
		}
		return tres;
	}
	
	public TrainResponse getTrain(int trainid) {
		Train t = trepo.findById(trainid).get();
		TrainResponse tr = new TrainResponse();
		tr.setTrainid(t.getTrainid());
		tr.setTrainno(t.getTrainno());
		tr.setTrainname(t.getTrainname());
		tr.setStart(t.getStart());
		tr.setDestination(t.getDestination());
		tr.setStartingtime(t.getStartingtime());
		tr.setEndingtime(t.getEndingtime());
		tr.setAvalseat(t.getAvalseat());
		return tr;
	}
	
	public TrainResponse saveTrain(TrainRequest tr) {
		
		Train t = new Train();
		t.setTrainid(tr.getTrainid());
		t.setTrainno(tr.getTrainno());
		t.setTrainname(tr.getTrainname());
		t.setStart(tr.getStart());
		t.setDestination(tr.getDestination());
		t.setStartingtime(tr.getStartingtime());
		t.setEndingtime(tr.getEndingtime());
		t.setAvalseat(tr.getAvalseat());
		
		Train t1 = trepo.save(t);
		
		TrainResponse tres = new TrainResponse();
		
		tres.setTrainid(t1.getTrainid());
		tres.setTrainno(t1.getTrainno());
		tres.setTrainname(t1.getTrainname());
		tres.setStart(t1.getStart());
		tres.setDestination(t1.getDestination());
		tres.setStartingtime(t1.getStartingtime());
		tres.setEndingtime(t1.getEndingtime());
		tres.setAvalseat(t1.getAvalseat());
		return tres;
	}
	
	public TrainResponse updateTrain(TrainRequest tr) {
		
		Train t = new Train();
		t.setTrainid(tr.getTrainid());
		t.setTrainno(tr.getTrainno());
		t.setTrainname(tr.getTrainname());
		t.setStart(tr.getStart());
		t.setDestination(tr.getDestination());
		t.setStartingtime(tr.getStartingtime());
		t.setEndingtime(tr.getEndingtime());
		t.setAvalseat(tr.getAvalseat());
		
		Train t1 = trepo.save(t);
		
		TrainResponse tres = new TrainResponse();
		
		tres.setTrainid(t1.getTrainid());
		tres.setTrainno(t1.getTrainno());
		tres.setTrainname(t1.getTrainname());
		tres.setStart(t1.getStart());
		tres.setDestination(t1.getDestination());
		tres.setStartingtime(t1.getStartingtime());
		tres.setEndingtime(t1.getEndingtime());
		tres.setAvalseat(t1.getAvalseat());
		return tres;
	}
	
	public String deleteTrain(int trainid) {
		trepo.deleteById(trainid);
		return "Record is deleted...";
		
	}
}
//{
//    "trainno":22,
//    "trainname":"chennai exp",
//    "start":"chennai",
//    "destination":"mumbai",
//    "startingtime":"10",
//    "endingtime":"20",
//    "avalseat":19
//}
