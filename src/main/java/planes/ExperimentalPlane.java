package planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
            ExperimentalTypes vtol, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    } // я бы его убрала

    @Override
    public boolean equals(Object o) {

        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }

    @Override
    public int getMaxFlightDistance() {
        return super.getMaxFlightDistance();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
