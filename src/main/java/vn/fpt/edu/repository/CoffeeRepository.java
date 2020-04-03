package vn.fpt.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.fpt.edu.entity.CoffeeEntity;

@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer> {

}
