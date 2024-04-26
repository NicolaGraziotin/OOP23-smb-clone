package it.unibo.model.entity.obstacles;

import it.unibo.commons.Constants;

public class DynamicSawImpl extends CircularSawImpl implements DynamicSaw{

    private double speedMul;
    private double minRange;
    private double maxRange;
    /**
     * Represents the default speed value for an entity.
     * This constant is typically used when no specific speed multiplier is set.
     */
    public static final double SPEED = 3 * Constants.SCALE_PROPORTION;

    public DynamicSawImpl(double x, double y, int radius) {
        super(x, y, radius);
        this.speedMul = 1;
        this.minRange = 0;
    }

    @Override
    public double getSpeedMul() {
        return this.speedMul;
    }

    @Override
    public double getMinRangeOfMouvement() {
        return this.minRange;
    }

    @Override
    public double getMaxRangeOfMouvement() {
        return this.maxRange;
    }

    @Override
    public void setSpeedMul(double speedMul) {
        this.speedMul = speedMul;
    }

    /*raggio di movimento della sega circolare*/
    @Override
    public void setMinRangeOfMouvement(double minRange) {
        this.minRange = minRange;
    }
    
    @Override
    public void setMaxRangeOfMouvement(double maxRange) {
        this.maxRange = maxRange;
    }
}
