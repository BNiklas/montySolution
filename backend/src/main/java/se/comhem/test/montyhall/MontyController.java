package se.comhem.test.montyhall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MontyController {

    private MontyCalculator montyCalculator;

    @Autowired
    public MontyController(MontyCalculator montyCalculator) {
        this.montyCalculator = montyCalculator;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/calculate")
    public int calculate(@RequestBody Request request){
        return montyCalculator.calc(request);
    }
}
