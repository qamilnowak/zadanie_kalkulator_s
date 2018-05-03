package controller;
import java.util.Collection;
import model.Wage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.WageService;

@RestController
@RequestMapping("/api")
public class WageController {

	@Autowired
    WageService ws;

    @RequestMapping("/wages")
    public  Collection<Wage> getWages() {
        return ws.getWages();
    }


    @RequestMapping(value="/wages1", method = RequestMethod.POST)
    public void rap(@RequestBody Wage wage){
        System.out.println(wage.getKwota());
        System.out.println(wage.getWaluta());
        ws.updateWages(wage.getKwota(), wage.getWaluta());

    }


}



