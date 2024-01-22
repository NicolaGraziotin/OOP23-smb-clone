package it.unibo.model.tiles;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class TileSetImpl implements TileSet{

	private final URL tmx;
	private final List<Tile> tiles;

	/**
	 * Constructs a new TileSet object by parsing a tmx file.
	 * @param tmx The tmx file to parse
	 */
	public TileSetImpl(URL tmx) {
		this.tmx = tmx;
		this.tiles = new ArrayList<>();
		try {
			read();
		} catch (ParserConfigurationException | SAXException | IOException exception) {
			exception.printStackTrace();
		}
	}

    public void read() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(tmx.getPath());
        NodeList tileSetNodeList = document.getElementsByTagName("tileset");
        int numTileSets = tileSetNodeList.getLength();
		
		for (int i = 0; i < numTileSets; i++) {
            Element tilesetElement = (Element) Objects.requireNonNull(tileSetNodeList.item(i));

            divideSpriteSheet(Integer.parseInt(Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("width").getTextContent()),
                Integer.parseInt(Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("height").getTextContent()), 
				Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("source").getTextContent());
        }
		
	}

	public void divideSpriteSheet(int width, int height, String srcImage) throws IOException {
		for( int row=0 ; row<height ; row+=20 ) {
			for( int column=0 ; column<width ; column+=20 ) {	
				Tile tile = new TileImpl(row, column, srcImage);
				tiles.add(tile);
			}
		}
	}

	public List<Tile> getTiles(){
		return this.tiles;
	}

}
