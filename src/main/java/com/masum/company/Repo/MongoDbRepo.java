package com.masum.company.Repo;

import com.masum.company.DataEntryPoint.DataEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbRepo extends MongoRepository<DataEntry, String> {



}
