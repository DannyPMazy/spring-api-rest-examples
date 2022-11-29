package com.dresses.example.second.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dresses.example.second.model.*;

@Repository
public interface DressProductRepository extends CrudRepository<DressProduct, Long> {

}
