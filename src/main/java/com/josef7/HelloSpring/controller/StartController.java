package com.josef7.HelloSpring.controller;

import com.josef7.HelloSpring.domain.Person;
import com.josef7.HelloSpring.service.PersonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class StartController
{
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String start(Model model)
    {
        ArrayList<Person> persons = (ArrayList<Person>) personService.listPersons();

        Logger logger = LoggerFactory.getLogger(StartController.class);
        logger.info("Executing the SpringBoot MVC controller");

        model.addAttribute("persons", persons);

        return "index";
    }

    @GetMapping("/add")
    public String addPerson(Person person)
    {
        return "modify";
    }

    @PostMapping("/save")
    public String savePerson(@Valid Person person, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "modify";
        }

        personService.save(person);

        return "redirect:/";
    }

    @GetMapping("/edit/{idPersona}")
    public String editPerson(Person person, Model model)
    {
        person = personService.getPerson(person);
        model.addAttribute("person", person);

        return "modify";
    }

    @GetMapping("/delete")
    public String deletePerson(Person person)
    {
        personService.delete(person);

        return "redirect:/";
    }
}
















