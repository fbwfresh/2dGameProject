import Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public Player(GamePanel gamePanel,KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction = "right";
    }
    public void update(){
        if (keyHandler.upPressed == true){
            direction ="up";
            y -= speed;
        } else if (keyHandler.downPressed == true) {
            direction="down";
            y += speed;
        } else if (keyHandler.leftPressed == true){
            direction = "left";
            x -= speed;
        } else if(keyHandler.rightPressed == true){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D graphics2D){
//        graphics2D.setColor(Color.YELLOW);
//        graphics2D.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize);
        BufferedImage image = null;

        switch (direction){
            case ("up") :
                image = up1;
                break;
            case ("down") :
                image = down1;
                break;
            case("left") :
                image = left1;
                break;
            case("right") :
                image = right1;
                break;

        }
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Users/macuser/Desktop/Kenzie/Term4/My2DGame/untitled/src/Player/right2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
