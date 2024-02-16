package it.unibo.model.tiles.loader.gameobjects;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unibo.commons.Constants;
import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.TagType;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.tiles.loader.manager.GameObjectType;
import it.unibo.model.tiles.loader.manager.TileLoaderManager;

/**
 * The TileLoaderGameObjects class is responsible for loading objects from the TMX file
 * and populating the TileLoaderManager with saws and platforms.
 */
public class TileLoaderGameObjectsImpl implements TileLoaderGameObjects {

    private final TileLoaderManager tileLoaderManager;
    private final DocumentExtractor documentExtractor;

    /**
     * Constructs a TileLoaderGameObjectsImpl with the specified TileLoaderManager
     * and DocumentExtractor.
     *
     * @param tileLoaderManager  The tile loader manager.
     * @param documentExtractor The document extractor.
     */
    public TileLoaderGameObjectsImpl(final TileLoaderManager tileLoaderManager, final DocumentExtractor documentExtractor) {
        this.tileLoaderManager = tileLoaderManager;
        this.documentExtractor = documentExtractor;
    }

    /**
     * Loads platforms and circular saws from an XML document.
     */
    @Override
    public void load() {
        this.loadObjects(GameObjectType.SAWS);
        this.loadObjects(GameObjectType.PLATFORMS);
    }

    /**
     * Loads objects from the TMX file and populates the TileManager.
     *
     * @param nameObjects The name of the objects to load.
     */
    private void loadObjects(final GameObjectType nameObjects) {
        final NodeList objects = documentExtractor.getElements(TagType.OBJECTGROUP);
        IntStream.range(0, objects.getLength())
            .mapToObj(i -> (Element) objects.item(i))
            .collect(Collectors.toList()).stream()
                .filter(node -> nameObjects.toString()
                    .equals(((Element) node).getAttribute(TagType.NAME.toString())))
                .findFirst()
                .ifPresent(objectGroupElement -> {
                    final NodeList objectsInGroup = ((Element) objectGroupElement)
                        .getElementsByTagName(TagType.OBJECT.toString());
                    IntStream.range(0, objectsInGroup.getLength())
                        .mapToObj(i -> (Element) objectsInGroup.item(i))
                        .collect(Collectors.toList()).stream()
                            .map(objectNode -> (Element) objectNode)
                            .forEach(objectElement -> {
                                final int x = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.X.toString())));
                                final int y = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.Y.toString())));
                                final int width = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.WIDTH.toString())));
                                if (GameObjectType.SAWS.equals(nameObjects)) {
                                    this.tileLoaderManager.setSaw(new CircularSawImpl(
                                        x * Constants.SCALE_PROPORTION,
                                        y * Constants.SCALE_PROPORTION,
                                        (int) (width * Constants.SCALE_PROPORTION)));
                                } else {
                                    this.tileLoaderManager.setPlatform(new PlatformImpl(
                                        x * Constants.SCALE_PROPORTION,
                                        y * Constants.SCALE_PROPORTION,
                                        (int) (width * Constants.SCALE_PROPORTION),
                                        (int) (Integer.parseInt(
                                            this.tileLoaderManager.trim(
                                                objectElement
                                                    .getAttribute(TagType.HEIGHT.toString()))) * Constants.SCALE_PROPORTION)));
                                }
                            });
                });
    }

}
