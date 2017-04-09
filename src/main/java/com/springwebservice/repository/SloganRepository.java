package com.springwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springwebservice.model.Slogan;

public interface SloganRepository extends JpaRepository<Slogan, Long>
{

}
