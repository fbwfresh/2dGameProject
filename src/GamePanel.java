import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //Game Screen

    //SCREEN SETTINGS
    final int orginalTitleSize = 16; //16x16 tile for the main character, tile size for a lot of things
    final int scale = 3;
    final int tileSize = orginalTitleSize * scale; //48x48

    //4 by 3 ratio
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576  pixels

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    //Set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    int FPS = 60;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);  //can help with rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true); //With this the gamePanel can be focused to recieve key input
    }
public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
//    public void run() {
//        double drawInterval = 1000000000/FPS; //1 second being divided by 60 which will let us draw the screen 60 times per second
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        //Creating the Game loop
//        while(gameThread != null){
//
//            //1.Update information such as character position
//            update();
//            //2.Draw the screen with the update information
//            //If FPS 60 does this 60 times per second
//            repaint();//how you call the paint component method
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000; //converting it to milliseconds
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//                Thread.sleep((long)remainingTime);
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//              e.printStackTrace();
//            }
//        }
//    }
    public void run(){
        double drawInterval = 1000000000/ FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1){
            update();
            repaint();
            delta--;
        }
        }

    }

    public void update(){
    if (keyHandler.upPressed == true){
        playerY -= playerSpeed;
    } else if (keyHandler.downPressed == true) {
        playerY += playerSpeed;
    } else if (keyHandler.leftPressed == true){
        playerX -= playerSpeed;
    } else if(keyHandler.rightPressed == true){
        playerX += playerSpeed;
    }

    }

    //Graphics is a class that has many functions to draw objects on the screen
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        //Graphics2D class extends Graphics class to provide more control over geometry, coordinate transformations,color management, and text layout
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(playerX,playerY,tileSize,tileSize);
        graphics2D.dispose(); //saves memory
    }
}
