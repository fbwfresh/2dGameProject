import Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;


public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNumber[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        getTileImage();
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        loadMap("src/resources/worldMap");
    }
    public void loadMap(String filePath){
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            int col = 0;
            int row = 0;
            while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
                String line = bufferedReader.readLine();
                System.out.println(line);

                while(col < gamePanel.maxWorldCol) {
                    String numbers[] = line.split(",");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row] = num;
                    col++;
                }
                    if(col == gamePanel.maxWorldCol){
                        col = 0;
                        row++;
                    }
                }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("src/resources/Tiles/ground.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("src/resources/Tiles/earth.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("src/resources/Tiles/rightcornerground.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(new File("src/resources/Tiles/stone.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(new File("src/resources/Tiles/grass.png"));

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(new File("src/resources/Tiles/tree.png"));

            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(new File("src/resources/Tiles/wall.png"));

            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(new File("src/resources/Tiles/sand.png"));

            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(new File("src/resources/Tiles/water.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D){
        //tiles are being sized by 16 x 3
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){
            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            graphics2D.drawImage(tiles[tileNum].image,screenX,screenY,gamePanel.tileSize, gamePanel.tileSize,null);
            worldCol++;

            if(worldCol == gamePanel.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
