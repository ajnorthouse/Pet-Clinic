package com.cognixia.jump.springcloud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	List<Pet> findAll();
	Optional<Pet> findByPetId(Integer petId);
	List<Pet> findAllByName(String name);
	List<Pet> findAllByAge(Integer age);
	List<Pet> findAllByWeight(Double weight);
	List<Pet> findAllByPetType(String type);
	List<Pet> findAllByCustomerId(Integer customerId);

}