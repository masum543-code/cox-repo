package com.masum.company.Services;

import com.masum.company.DataEntryPoint.DataEntry;
import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataEntryService {
    @Autowired
    private MongoRepository mongoRepository;

    public List<DataEntry> finddata(){
        return mongoRepository.findAll();
    }

    public void postData(DataEntry dataEntry){
        mongoRepository.save(dataEntry);
    }

    public Optional<DataEntry> findByid(String id){
        return mongoRepository.findById(id);
    }
    public void delete(String id){
        mongoRepository.deleteById(id);
    }




}
