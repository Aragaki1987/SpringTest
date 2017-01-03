package com.san.spring.controller;

import com.san.spring.bean.Spitter;
import com.san.spring.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by AnNN1 on 1/3/2017.
 */
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(
            SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors) {
        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()){
                System.out.println(error.toString());
            }
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" +
                spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        System.out.println("Get");
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
