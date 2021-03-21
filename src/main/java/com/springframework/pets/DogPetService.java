package com.springframework.pets;

//@Profile({"dog", "default"})
//@Service
public class DogPetService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}