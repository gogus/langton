package lu.mikolaj.langton.service;

import lu.mikolaj.langton.entity.Ant;
import lu.mikolaj.langton.entity.Cell;
import lu.mikolaj.langton.entity.World;

public class LangtonService {
    public World simulate(int numberOfSteps) {
        World world = new World();
        Ant ant = world.getAnt();

        for (int step = 1; step <= numberOfSteps; step++) {
            ant.turnDirection();
            ant.moveForward();

            Cell cell = world.findCell(ant.getCurrentCell().getCoordinateX(), ant.getCurrentCell().getCoordinateY());
            if (cell != null) {
                ant.setCurrentCell(cell);
            }

            world.addVisitedCell(ant.getCurrentCell());
        }

        return world;
    }
}
