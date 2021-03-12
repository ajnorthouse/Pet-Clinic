package com.cognixia.jump.springcloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Pet;
import com.cognixia.jump.springcloud.repository.PetRepository;
import com.cognixia.jump.springcloud.model.Customer;

@RestController
public class PetController {
	
	//repos and services
	@Autowired
	PetRepository repo;
	
	//CREATE
	@PostMapping("/customer")
	public ResponseEntity<Pet> savePet(@Valid @RequestBody Pet p) {
		//temp object
		Pet created;
		
		
		created = new Pet(p.getPetId(), p.getName(), p.getType(),
							p.getAge(), p.getWeight(), p.getCustomerId());
		
		//adds customer and returns result
		repo.save(created);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	
	
	//READ
	@GetMapping("/pets")
	public List<Pet> getAllPets() {
		return repo.findAll();
	}
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable Integer id) {
		Optional<Pet> found = repo.findByPetId(id);
		
		if (found.isEmpty()) {
			return new ResponseEntity<>(new Pet(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(found.get(), HttpStatus.OK);
	}
	@GetMapping("/pets/name/{name}")
	public List<Pet> getPetsByName(@PathVariable String name) {
		return repo.findAllByName(name);
	}
	@GetMapping("/pets/type/{type}")
	public List<Pet> getPetsByType(@PathVariable String type) {
		return repo.findAllByPetType(type);
	}
	@GetMapping("/pets/age/{age}")
	public List<Pet> getPetsByAge(@PathVariable Integer age) {
		return repo.findAllByAge(age);
	}
	@GetMapping("/pets/weight/{weight}")
	public List<Pet> getPetsByWeight(@PathVariable Double weight) {
		return repo.findAllByWeight(weight);
	}
	@GetMapping("/pets/customerId/{customerId}")
	public List<Pet> getPetByCity(@PathVariable Integer customerId) {
		return repo.findAllByCustomerId(customerId);
	}
	
	
	
	//UPDATE
	@PutMapping("/update/pet")
	public @ResponseBody String updatePet(@RequestBody Pet pet) {
		
		Optional<Pet> found = repo.findByPetId(pet.getPetId());
		
		if(found.isPresent()) {
			repo.save(pet);
			return "Saved: " + pet.toString();
		}
		else {
			return "Could not update customer with id = " + pet.getPetId();
		}
		
	}
	//patch mapping and helpers:
	@PatchMapping("pet")
	public @ResponseBody String[] patchPet(@RequestBody Map<String, String> petUpdate) {
		// collect id from map and attempt to get matching Customer
		Integer id = Integer.parseInt(petUpdate.getOrDefault("petId", "-1"));
		Optional<Pet> found = repo.findByPetId(id);
		
		// update logic
		if (id != -1L && found.isPresent()) {
			//collects the update values from the map
			Pet toUpdate = found.get();
			String newName = petUpdate.get("name");
			String newType = petUpdate.get("type");
			Integer newAge = Integer.parseInt(petUpdate.getOrDefault("age", "-1"));
			Double newWeight = Double.parseDouble(petUpdate.getOrDefault("weight", "-1.0"));
			Integer newCustomerId = Integer.parseInt(petUpdate.getOrDefault("customerId", "-1"));
			
			List<String> response = new ArrayList<String>();
			
			//updates name
			if (newName != null) {
				response.add(updatePetName(toUpdate, newName));
			}
			//updates type
			if (newType != null) {
				response.add(updatePetType(toUpdate, newType));
			}
			//updates age
			if (newAge != -1) {
				response.add(updatePetAge(toUpdate, newAge));
			}
			//updates weight
			if (newWeight != -1.0) {
				response.add(updatePetWeight(toUpdate, newWeight));
			}
			//updates customerId
			if (newCustomerId != -1) {
				response.add(updatePetCustomerId(toUpdate, newCustomerId));
			}
			
			//returns updated strings
			repo.save(toUpdate);
			return response.toArray(String[]::new);
		} 
		// failed to find Customer logic
		else {
			return new String[]{"Could not update Pet with id: " + id};
		}
	}
	String updatePetName(Pet pet, String newName) {
		String oldName = pet.getName();
		pet.setName(newName);
		return "Previous name: " + oldName + ", New: " + newName;
	}
	String updatePetType(Pet pet, String newType) {
		String oldType = pet.getType();
		pet.setType(newType);
		return "Old type: " + oldType + ", New: " + newType;
	}
	String updatePetAge(Pet pet, Integer newAge) {
		Integer oldAge = pet.getAge();
		pet.setAge(newAge);
		return "Old Age: " + oldAge + ", New: " + newAge;
	}
	String updatePetWeight(Pet pet, Double newWeight) {
		Double oldWeight = pet.getWeight();
		pet.setWeight(newWeight);
		return "Previous Weight: " + oldWeight + ", Weight: " + newWeight;
	}
	String updatePetCustomerId(Pet pet, Integer newCustomerId) {
		Integer oldCustomerId = pet.getCustomerId();
		pet.setCustomerId(newCustomerId);
		return "Previous Customer Id: " + oldCustomerId + ", New: " + newCustomerId;
	}
	
	
	
	//DELETE
	@DeleteMapping("/delete/pet/{id}")
	public ResponseEntity<String> deletePet(@PathVariable Integer id) {
		
		Optional<Pet> found = repo.findByPetId(id);
		
		if(found.isPresent()) {
			repo.deleteById((int) id);
			return ResponseEntity.status(200).body("Deleted pet with id = " + id);
		}
		else {
			return ResponseEntity.status(400).body("Pet with id = " + id + " not found.");
		}
		
	}
	
}