package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.entity.AbstractEntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

public class PlatformImpl extends AbstractEntityImpl<RectangleHitbox> implements Platform{

    public PlatformImpl(final double x, final double y, final double width, final double height){
        super(x, y, width, height, new RectangleHitbox(x, y, width, height));
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }
}
