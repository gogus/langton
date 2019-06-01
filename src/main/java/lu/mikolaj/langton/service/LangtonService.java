package lu.mikolaj.langton.service;

import lu.mikolaj.langton.domain.Ant;
import lu.mikolaj.langton.domain.World;
import org.springframework.stereotype.Service;

@Service
public class LangtonService {
    public World simulate(int numberOfSteps) {
        World world = new World();
        Ant ant = world.getAnt();

        for (int step = 1; step <= numberOfSteps; step++) {
            ant.turnDirection();
            ant.moveForward(world);
        }

        return world;
    }
}
