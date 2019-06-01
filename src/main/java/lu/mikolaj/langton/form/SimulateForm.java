package lu.mikolaj.langton.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class SimulateForm {
    @NotNull
    @PositiveOrZero
    private int steps;

    public SimulateForm(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }
}
