package com.josef7.HelloSpring.service;

import com.josef7.HelloSpring.domain.Person;

import java.util.List;

public interface PersonService
{
    public List<Person> listPersons();
    public void save(Person person);
    public void delete(Person person);
    public Person getPerson(Person person);
}
