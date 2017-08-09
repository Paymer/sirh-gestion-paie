package dev.paie.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;

//en ID se tiene que meter el tipo del identificante
public interface AvantageRepository extends JpaRepository<Avantage, Integer> {

	
}
