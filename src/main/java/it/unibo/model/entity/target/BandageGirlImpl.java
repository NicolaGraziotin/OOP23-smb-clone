package it.unibo.model.entity.target;

import it.unibo.commons.Constants;
import it.unibo.model.entity.EntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

public class BandageGirlImpl extends EntityImpl<RectangleHitbox> implements BandageGirl {

    public BandageGirlImpl(double x, double y) {
        super(x, y, new RectangleHitbox(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE));
    }
}
