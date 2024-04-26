package it.unibo.model.entity.obstacles;

public interface DisapperingPlatform extends Platform{

    boolean isVisible();

    void disablePlatform();
}
