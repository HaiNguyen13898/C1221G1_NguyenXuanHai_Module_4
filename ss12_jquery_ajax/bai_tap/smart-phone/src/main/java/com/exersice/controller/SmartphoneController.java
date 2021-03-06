package com.exersice.controller;

import com.exersice.model.Smartphone;
import com.exersice.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartphoneForm(@PathVariable Long id){
        Optional<Smartphone> smartphone = this.smartphoneService.findById(id);
        if(!smartphone.isPresent()){
            return new ModelAndView("/index");
        }
        ModelAndView modelAndView = new ModelAndView("/phones/edit");
        modelAndView.addObject(smartphone.get());
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Smartphone> editSmartphone(@PathVariable Integer id,@RequestBody Smartphone editSmartPhone){
        this.smartphoneService.save(editSmartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
