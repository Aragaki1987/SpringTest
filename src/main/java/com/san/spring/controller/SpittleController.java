package com.san.spring.controller;

import com.san.spring.bean.Spittle;
import com.san.spring.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.ResponseWrapper;
import java.util.List;

/**
 * Created by AnNN1 on 1/3/2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(
            SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    public SpittleController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = "0x7fffffffffffffffL") long max,
                           @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        System.out.println("Max " + max);
        System.out.println("Count " + count);
        List<Spittle> test = spittleRepository.findSpittles(max, count);
        System.out.println("Test List " + test);
        model.addAttribute(test);
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(
            @PathVariable("spittleId") long spittleId, Model model) {
        Spittle test = spittleRepository.findOne(spittleId);
        model.addAttribute("expectedSpittle", test);
        return "spittles";
    }
}
