package ruAppline.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ruAppline.logic.Compass;
import ruAppline.logic.Degrees;

import java.util.Map;

public class Controller {

    private Compass compass = new Compass();



    @PostMapping(value = "/createCompass", consumes = "application/json")
    public void addSides(@RequestBody Map<String, String> sides) {
        for (Map.Entry<String, String> entry : sides.entrySet()) {
            String side = entry.getKey(); 
            Degrees degrees = new Degrees(entry.getValue()); 
            compass.addSide(side, degrees); 
        }
    }


    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<String, Degrees> getAll() {
        return compass.getCompass();
    }



    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestParam int degree){
        return compass.getSide(degree);
    }

}

