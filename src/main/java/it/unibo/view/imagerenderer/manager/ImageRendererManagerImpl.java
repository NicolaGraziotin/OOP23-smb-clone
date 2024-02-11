package it.unibo.view.imagerenderer.manager;

import java.awt.image.BufferedImage;
import java.util.List;

import it.unibo.controller.GameController;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSaws;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSawsImpl;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationary;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationaryImpl;
import it.unibo.view.imagerenderer.loader.ImageLoader;
import it.unibo.view.imagerenderer.loader.ImageLoaderImpl;

/**
 * The ImageRendererManager class is responsible for managing the rendering of the game map.
 */
public class ImageRendererManagerImpl implements ImageRendererManager {

    private final GameController gameController;
    private final ImageRendererSaws imageRendererSaws;
    private final ImageRendererStationary imageRendererStationary;
    private final ImageLoader imageLoader;

    /**
     * Constructs an ImageRendererManager with the specified number of rows and columns for the game map.
     *
     * @param numRows    The number of rows in the game map.
     * @param numColumns The number of columns in the game map.
     */
    public ImageRendererManagerImpl(final GameController gameController) {
        this.gameController = gameController;
        this.imageRendererSaws = new ImageRendererSawsImpl(
            this.gameController.getNumRows(), this.gameController.getNumCols());
        this.imageRendererStationary = new ImageRendererStationaryImpl(
            this.gameController.getNumRows(), this.gameController.getNumCols());
        this.imageLoader = new ImageLoaderImpl();
    }

    /**
     * Manage the rendering of circular Saws, Stationary Tiles, Background and MeatBoy into a list of BufferedImages.
     *
     * @return A list of BufferedImages representing the rendered game elements.
     */
    @Override
    public List<BufferedImage> render() {
        return List.of(
            this.imageRendererSaws.render(this.gameController.getSaws()),
            this.imageRendererStationary.render(this.gameController.getStationary()),
            this.imageLoader.load(ImageType.BACKGROUND),
            this.imageLoader.load(ImageType.MEAT_BOY));
    }

}
