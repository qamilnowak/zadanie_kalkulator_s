package controller;
import java.util.Collection;
import model.Wage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;
import service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksController {

	@Autowired
	BooksService bs;

    @RequestMapping("/wages")
    public  Collection<Wage> getWages() {
        return bs.getWages();
    }


    @RequestMapping(value="/wages1", method = RequestMethod.POST)
public void rap(@RequestBody Wage wage){

        System.out.println(wage.getKwota());
        System.out.println(wage.getWaluta());
  //      bs.updateWages(wage.getKwota());

    }


    @RequestMapping(value="/wages2", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Wage wage) {
        return "result";
    }

}



