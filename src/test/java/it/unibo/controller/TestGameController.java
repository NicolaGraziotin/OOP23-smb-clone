package it.unibo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import it.unibo.commons.Point2D;
import it.unibo.controller.factory.GameControllerFactoryImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;

/**
 * JUnit test class for GameController.
 */
public class TestGameController {

    private GameController gameController;

    /**
     * Initialize the GameController before each test.
     */
    @BeforeEach
    public void init() {
        gameController = new GameControllerFactoryImpl()
            .createGameController();
        assertNotNull(this.gameController);
    }

    /**
     * Tests the {@link GameControllerImpl#getStationary()} method.
     */
    @Test
    public void testGetStationary() {
        final List<List<Optional<Tile>>> stationary = gameController.getStationary();
        assertNotNull(stationary);
    }

    /**
     * Tests the {@link GameControllerImpl#getSaws()} method.
     */
    @Test
    public void testGetSaws() {
        final List<CircularSaw> saws = gameController.getSaws();
        assertNotNull(saws);
    }

    /**
     * Tests the {@link GameControllerImpl#getPlatforms()} method.
     */
    @Test
    public void testGetPlatforms() {
        final List<Platform> platforms = gameController.getPlatforms();
        assertNotNull(platforms);
    }

    /**
     * Tests the {@link GameControllerImpl#getNumRows()} method.
     */
    @Test
    public void testGetNumRows() {
        final int numRows = gameController.getNumRows();
        assertTrue(numRows > 0);
    }

    /**
     * Tests the {@link GameControllerImpl#getNumCols()} method.
     */
    @Test
    public void testGetNumCols() {
        final int numCols = gameController.getNumCols();
        assertTrue(numCols > 0);
    }

    /**
     * Tests the {@link GameControllerImpl#getBandageGirl()} method.
     */
    @Test
    public void testGetBandageGirl() {
        final BandageGirl bandageGirl = gameController.getBandageGirl();
        assertNotNull(bandageGirl);
    }

    /**
     * Tests the {@link GameControllerImpl#getMeatBoy()} method.
     */
    @Test
    public void testGetMeatBoy() {
        final MeatBoy meatBoy = gameController.getMeatBoy();
        assertNotNull(meatBoy);
    }

    /**
     * Tests the {@link GameControllerImpl#getMeatBoyStartCoord()} method.
     */
    @Test
    public void testGetMeatBoyStartCoord() {
        final Point2D<Double, Double> meatBoyStartCoord = gameController.getMeatBoyStartCoord();
        assertNotNull(meatBoyStartCoord);
    }

}
