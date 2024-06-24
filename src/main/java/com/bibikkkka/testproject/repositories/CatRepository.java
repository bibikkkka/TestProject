package com.bibikkkka.testproject.repositories;

import com.bibikkkka.testproject.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {}
