package it.unibo.model.entity.obstacles;

public class DisapperingPlatformImpl extends PlatformImpl implements DisapperingPlatform{
    private boolean visible;

    public DisapperingPlatformImpl(double x, double y, int width, int height) {
        super(x, y, width, height);
        this.visible = true;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public void disablePlatform() {
        this.visible = false;
    }
    
}
