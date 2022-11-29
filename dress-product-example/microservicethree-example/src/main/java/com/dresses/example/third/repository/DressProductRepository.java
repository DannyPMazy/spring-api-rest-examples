package com.dresses.example.third.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dresses.example.third.model.*;

@Repository
public interface DressProductRepository extends CrudRepository<DressProduct, Long> {

}
