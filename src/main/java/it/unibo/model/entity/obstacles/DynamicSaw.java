package it.unibo.model.entity.obstacles;

public interface DynamicSaw extends CircularSaw{  
    /**
     * Retrieves the speed multiplier associated with this entity.
     *
     * @return The speed multiplier value.
     */
    double getSpeedMul();

    double getMinRangeOfMouvement();

    double getMaxRangeOfMouvement();

    /**
     * Sets the speed multiplier associated with this entity to the specified value.
     *
     * @param speedMul The new value for the speed multiplier.
     */
    void setSpeedMul(double speedMul);

    void setMinRangeOfMouvement(double mouvement);

    void setMaxRangeOfMouvement(double mouvement);
}
