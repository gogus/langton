package lu.mikolaj.langton.controller;

import lu.mikolaj.langton.entity.World;
import lu.mikolaj.langton.service.LangtonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulateController {

    @RequestMapping("/simulate")
    public World simulate(@RequestParam(value="steps", defaultValue = "1") String steps)
    {
        LangtonService langtonService = new LangtonService();
        return langtonService.simulate(Integer.parseInt(steps));
    }
}
