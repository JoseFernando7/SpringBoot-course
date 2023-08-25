package com.josef7.HelloSpring.dao;

import com.josef7.HelloSpring.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Long> {}
