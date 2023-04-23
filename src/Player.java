import Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    //made these final because I am using it as the camera and just making the map scroll as my character "moves"
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        this.screenY = gamePanel.screenHeight/2 - (gamePanel.tileSize/2);
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues(){
        worldX=0;
        worldY=48;
        speed=4;
        direction = "right";
    }
    public void update(){
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true){
            if (keyHandler.upPressed == true){
                direction ="up";
                worldY -= speed;
            } else if (keyHandler.downPressed == true) {
                direction="down";
                worldY += speed;
            } else if (keyHandler.leftPressed == true){
                direction = "left";
                worldX -= speed;
            } else if(keyHandler.rightPressed == true){
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;
            if (spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum ==2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
               }
    }
    public void draw(Graphics2D graphics2D){
//        graphics2D.setColor(Color.YELLOW);
//        graphics2D.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize);
        BufferedImage image = null;

        switch (direction){
            case ("up") :
                if (spriteNum == 1){
                    image=up1;
                }if (spriteNum == 2){
                    image = up2;
            }
                break;
            case ("down") :
                if (spriteNum == 1){
                    image=down1;
                }if (spriteNum == 2){
                image =down2;
            }
                break;
            case("left") :
                if (spriteNum == 1){
                    image=left1;
                }if (spriteNum == 2){
                image =left2;
            }
                break;
            case("right") :
                if (spriteNum == 1){
                    image=right1;
                }if (spriteNum == 2){
                image =right2;
            }
                break;
        }
        graphics2D.drawImage(image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize,null);
    }
    public void getPlayerImage(){
        try {
             up1 = ImageIO.read(new File("src/resources/Player/zup1.png"));
             up2 = ImageIO.read(new File("src/resources/Player/zup2.png"));
             down1 = ImageIO.read(new File("src/resources/Player/zdown1.png"));
             down2 = ImageIO.read(new File("src/resources/Player/zdown2.png"));
             left1 = ImageIO.read(new File("src/resources/Player/zleft1.png"));
             left2 = ImageIO.read(new File("src/resources/Player/zleft2.png"));
             right1 = ImageIO.read(new File("src/resources/Player/zright1.png"));
             right2 = ImageIO.read(new File("src/resources/Player/zright2.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Image up2Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/up2.png");
//        Image down1Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/Down1.png");
//        Image down2Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/down2.png");
//        Image left1Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left1.png");
//        Image left2Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left2.png");
//        Image right1Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right1.png");
//        Image right2Image = Toolkit.getDefaultToolkit().getImage("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right2.png");

//            up2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/up2.png"));
//            down1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/Down1.png"));
//            down2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/down2.png"));
//            left1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left1.png"));
//            left2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left2.png"));
//            right1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right1.png"));
//            right2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right2.png"));

    }
}
