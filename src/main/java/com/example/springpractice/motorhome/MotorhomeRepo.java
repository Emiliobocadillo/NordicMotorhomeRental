/*
===============
Martin
===============
*/
package com.example.springpractice.motorhome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorhomeRepo extends JpaRepository<Motorhome, Integer> {
}
