package com.josef7.HelloSpring.service;


import com.josef7.HelloSpring.dao.PersonDAO;
import com.josef7.HelloSpring.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService
{
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Person> listPersons()
    {
        return (List<Person>) personDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Person person)
    {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person)
    {
        personDAO.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person getPerson(Person person)
    {
        return personDAO.findById(person.getIdPersona()).orElse(null);
    }
}
