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
	Optional<Pet> findByName(String name);
	Optional<Pet> findByAge(Integer age);
	Optional<Pet> findByWeight(Double weight);
	List<Pet> findAllByPetType(String type);
	List<Pet> findAllByCustomerId(Integer customerId);

}