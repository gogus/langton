package lu.mikolaj.langton.service;

import lu.mikolaj.langton.domain.Ant;
import lu.mikolaj.langton.domain.World;
import lu.mikolaj.langton.form.SimulateForm;
import org.springframework.stereotype.Service;

@Service
public class LangtonService {
    public World simulate(SimulateForm simulateForm) {
        World world = new World();
        Ant ant = world.getAnt();

        for (int step = 1; step <= simulateForm.getSteps(); step++) {
            ant.turnDirection();
            ant.moveForward(world);
        }

        return world;
    }
}
