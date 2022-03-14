package com.kafein.moviemanager.repository;


import com.kafein.moviemanager.model.entity.ServiceLog;
import org.springframework.data.repository.CrudRepository;

public interface ServiceLogRepository extends CrudRepository<ServiceLog,Integer> {
}
