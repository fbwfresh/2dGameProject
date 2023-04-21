import Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNumber[][];
//    int[][] map = {
//            {1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1},
//            {1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1},
//            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
//            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
//            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
//            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
//            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
//
//    };


    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        getTileImage();
        mapTileNumber = new int[gamePanel.maxScreenColumn][gamePanel.maxScreenRow];
     //   loadMap();
    }
//    public void loadMap(){
//        try {
//            File file = new File("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/src/map1");
//            FileInputStream inputStream = new FileInputStream(file);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//           // InputStream inputStream = getClass().getResourceAsStream("/src/map01");
//            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            int col = 0;
//            int row = 0;
//            while(col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow){
//                String line = bufferedReader.readLine();
////                System.out.println(line);
//
//                while(col < gamePanel.maxScreenColumn){
//                    String numbers[] = line.split(",");
//                    int num = Integer.valueOf(numbers[col]);
//                    mapTileNumber[col][row] = num;
//                    col++;
//                    if(col == gamePanel.maxScreenColumn){
//                        col = 0;
//                        row++;
//                    }
//                }
//            }
//            bufferedReader.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("res/Tiles/tile98.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("res/Tiles/cloud.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("res/Tiles/skynight.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(new File("res/Tiles/tile52.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(new File("res/Tiles/grass.png"));
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(new File("res/Tiles/cloud2.png"));

            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(new File("res/Tiles/5.png"));

            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(new File("res/Tiles/partialClouds.png"));

            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(new File("res/Tiles/skybackground.png"));

            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read(new File("res/Tiles/tile110.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D){
        //tiles are being sized by 16 x 3
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
//        while(col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow){
//            int tileNum = mapTileNumber[col][row];
//            graphics2D.drawImage(tiles[tileNum].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
//            col++;
//            x+=gamePanel.tileSize;
//            if(col == gamePanel.maxScreenColumn){
//                col = 0;
//                x =0;
//                row++;
//                y += gamePanel.tileSize;
//            }
//        }
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[6].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            graphics2D.drawImage(tiles[2].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);

            graphics2D.drawImage(tiles[8].image,x,48,gamePanel.tileSize, gamePanel.tileSize,null);
            graphics2D.drawImage(tiles[9].image,x,48,gamePanel.tileSize, gamePanel.tileSize,null);

            x+=48;

//            if (i % 2 == 1){
//                graphics2D.drawImage(tiles[1].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
//            }
//            if (i == 0 || i ==7 || i ==12){
//                graphics2D.drawImage(tiles[5].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
//            }
//            if (i == gamePanel.maxScreenColumn){
//                x =0;
//                y +=48;
//            }
        }
        x=0;
        y+=96;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[4].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[0].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }
        x = 0;
        y +=48;
        for (int i = 0; i < gamePanel.maxScreenColumn; i++) {
            graphics2D.drawImage(tiles[3].image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);
            x+=48;
        }

    }
}
