import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {

    int frameWidht = 360;
    int frameHeight = 640;

    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    //player
    int playerStartPosX = frameWidht / 8;
    int PlayerStartPosY =  frameHeight / 2;
    int playerWidht = 34;
    int playerHeight = 24;

    Player player;

    int pipeStartPosX = frameWidht;
    int PipeStartPosY = 0;
    int PipeWidth = 64;
    int PipeHeight = 512;

    ArrayList<Pipe> pipes;
    Timer gameLoop;
    Timer pipesCooldown;
    int gravity = 1;

    boolean gameOver = false;
    double score = 0;

    private int stringWidth;
    int x = (frameWidht - stringWidth) / 2;
    int y = frameHeight / 2;


    //constructor
    public  FlappyBird(){
        setPreferredSize(new Dimension(frameWidht, frameHeight));
        setFocusable(true);
        addKeyListener(this);

        //load image
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerStartPosX, PlayerStartPosY, playerWidht, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();


        //pipes cooldown time
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        pipesCooldown.start();

        gameLoop =  new Timer(1000/60, this);
        gameLoop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public  void draw(Graphics g){
        g.drawImage(backgroundImage, 0 , 0 , frameWidht, frameHeight, null);
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        for (int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(),pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN, 32));
        if(gameOver) {
            String gameOverMessageLine1 = "Game Over!";
            String gameOverMessageLine2 = "Press R to Restart";

            int stringWidthLine1 = g.getFontMetrics().stringWidth(gameOverMessageLine1);
            int stringWidthLine2 = g.getFontMetrics().stringWidth(gameOverMessageLine2);

            int x1 = (frameWidht - stringWidthLine1) / 2;
            int x2 = (frameWidht - stringWidthLine2) / 2;

            int y = frameHeight / 2;

            g.drawString(gameOverMessageLine1, x1, y);
            g.drawString(gameOverMessageLine2, x2, y + g.getFontMetrics().getHeight());

            g.drawString("Score: " + String.valueOf((int)score), 10, 35);
        }

        else{
            g.drawString("Score: " + String.valueOf((int)score), 10,35);
        }
    }
    public  void move(){
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        for(int  i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

            if (!pipe.passed && player.getPosX()>pipe.getPosX()+pipe.getWidth()){
                pipe.passed = true;
                score += 0.5;
            }

            if (collision(player,pipe)){
                gameOver = true;
            }
        }

        if(player.getPosY()>frameHeight){
            gameOver = true;
        }
    }

    public void placePipes(){
        int randomPipePosY = (int) (PipeStartPosY - PipeHeight/4 - Math.random() * (PipeHeight/2));
        int openingSpace = frameHeight/4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPipePosY, PipeWidth, PipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, randomPipePosY + PipeHeight + openingSpace, PipeWidth, PipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public boolean collision(Player player, Pipe pipe){
        return player.getPosX() < pipe.getPosX() + pipe.getWidth() &&
                player.getPosX() + player.getWidth() > pipe.getPosX() &&
                player.getPosY() < pipe.getPosY() + pipe.getHeight() &&
                player.getPosY() + player.getHeight() > pipe.getPosY();

    }

    @Override
    public  void actionPerformed(ActionEvent e){
        move();
        repaint();
        if(gameOver){
            pipesCooldown.stop();
            gameLoop.stop();
        }
    }

    @Override
    public  void keyTyped(KeyEvent e){

    }

    @Override
    public  void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            player.setVelocityY(-10);
        }
        if (e.getKeyCode()==KeyEvent.VK_R){
            if (gameOver){
                player.setPosY(playerHeight);
                player.setVelocityY(0);
                pipes.clear();
                score=0;
                gameOver=false;
                gameLoop.start();
                pipesCooldown.start();
            }
        }
    }

    @Override
    public  void keyReleased(KeyEvent e){

    }
}