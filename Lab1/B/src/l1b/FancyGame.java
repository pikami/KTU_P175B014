/* @author Pijus Kamandulis */
package l1b;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.*;
import studijosKTU.ScreenKTU;

enum Directions { UP, DOWN, LEFT, RIGHT };

class Block {
    // Position
    public int x;
    public int y;
    // Props
    private int colorIndex;
    
    public Block(int x, int y, Color color, FancyGame scr) {
        super();
        this.x = x;
        this.y = y;
        scr.setBackColor(color);
        scr.fillRect(y, x, 1, 1);
    }

    public Block(int x, int y, FancyGame src) {
        this(x, y, FancyGame.BodyColors[0], src);
        colorIndex = 0;
    }

    public void destroy(FancyGame scr) {
        scr.setBackColor(FancyGame.BackgroundColor);
        scr.fillRect(y, x, 1, 1);
    }
    
    public void nextColor(FancyGame scr) {
        if(colorIndex >= FancyGame.BodyColors.length - 1)
            colorIndex = 0;
        else colorIndex++;
        scr.setBackColor(FancyGame.BodyColors[colorIndex]);
        scr.fillRect(y, x, 1, 1);
    }
}

class Snake {
    // Pos
    public int x;
    public int y;
    // Direction
    public Directions direction;
    // Body blocks
    private List<Block> BodyBlocks;
    // Game object
    private FancyGame GameObject;
    
    public Snake(FancyGame scr) {
        x = 0;
        y = 0;
        direction = Directions.DOWN;
        BodyBlocks = new ArrayList();
        GameObject = scr;
    }
    
    private void checkForCollision() {
        // Collides with it self
        Block collider = getCollider(x, y);
        if(collider != null) {
             int countOfDestroyedBodyParts = BodyBlocks.indexOf(collider);
             GameObject.CurrentScore = Math.max(GameObject.CurrentScore - countOfDestroyedBodyParts, 0);
        }
        // Goes out of the map
        if(FancyGame.mHeight <= y) y = 0;
        else if(0 > y) y = FancyGame.mHeight - 1;
        else if(FancyGame.mWidth <= x) x = 0;
        else if(0 > x) x = FancyGame.mWidth -1;
    }
    
    private void removeLastBlocks(int blocksToRemoveCount){
        List<Block> blocksToBeRemoved = BodyBlocks.subList(0, blocksToRemoveCount);
        blocksToBeRemoved.forEach((block) -> block.destroy(GameObject));
        BodyBlocks.removeAll(blocksToBeRemoved);
    }
    
    public void move() {
        // Update coors
        switch(direction) {
            case UP: y--; break;
            case DOWN: y++; break;
            case LEFT: x--; break;
            case RIGHT: x++; break;
        }
        checkForCollision();
        // Destroy chewed off body blocks
        if(BodyBlocks.size() > GameObject.CurrentScore + FancyGame.initialSnakeLen) {
            int blocksToRemoveCount = BodyBlocks.size() - (GameObject.CurrentScore + FancyGame.initialSnakeLen);
            removeLastBlocks(blocksToRemoveCount);
        }
        // Create next body block
        Block nextBlock = new Block(x, y, FancyGame.BodyColor, GameObject);
        BodyBlocks.add(nextBlock);
    }
    
    public Block getCollider(int x, int y) {
        Optional<Block> collision = BodyBlocks.stream().filter((block) -> block.y == y && block.x == x).findFirst();
        return collision.isPresent() ? collision.get() : null;
    }
    
    public void changeDirection(Directions newDirection) {
        switch(newDirection) {
            case UP:
                if(direction == Directions.DOWN) return;
                break;
            case DOWN:
                if(direction == Directions.UP) return;
                break;
            case LEFT:
                if(direction == Directions.RIGHT) return;
                break;
            case RIGHT:
                if(direction == Directions.LEFT) return;
                break;
        }
        direction = newDirection;
    }
    
    public void cycleBodyColors() {
        BodyBlocks.forEach((block) -> block.nextColor(GameObject));
    }
}

public class FancyGame extends ScreenKTU {
    // Color config
    static final public Color BodyColor            = Color.white;
    static final public Color BackgroundColor      = Color.blue;
    static final public Color FoodColor            = Color.red;
    static final public Color InfoBackgroundColor  = Color.black;
    static final public Color InfoTextColor        = Color.white; 
    static final public Color[] BodyColors         = { Color.green, Color.pink, Color.magenta,
                                                       Color.yellow, Color.orange, Color.orange};
    // Map config
    static final private int cHeight = 20, cWidth = 20;
    static final public int  mHeight = 20, mWidth = 20;
    // Gameplay config
    static final private int timerDelay = 50;
    static final public int  initialSnakeLen = 3;
    // Info area config
    static final private int infoAreaHeight = 1;
    // Objects
    private Snake player;
    public  int CurrentScore;
    private Block FoodBlock;
    private Random RNG = new Random();
    
    
    FancyGame() {
        super(cHeight, cWidth, mHeight + infoAreaHeight, mWidth, Fonts.boldB);
        player = new Snake(this);
        createFoodBlock();
    }
    
    @Override
    public void show() {
        refresh(100);
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            // Change player direction
            case 38: player.changeDirection(Directions.UP); break;
            case 40: player.changeDirection(Directions.DOWN); break;
            case 37: player.changeDirection(Directions.LEFT); break;
            case 39: player.changeDirection(Directions.RIGHT); break;
            case 90: CurrentScore += 20; break;
        }
    }
    
    public void createFoodBlock() {
        while(true) {
            int x = RNG.nextInt(mWidth);
            int y = RNG.nextInt(mHeight);
            if(player.getCollider(x, y) == null){
                FoodBlock = new Block(x, y, FoodColor, this);
                break;
            }
        }
    }
    
    public void onTimerTick() {
        player.move();
        if(player.x == FoodBlock.x && player.y == FoodBlock.y) {
            CurrentScore++;
            createFoodBlock();
        }
        player.cycleBodyColors();
        drawInfoArea();
        refresh(80);
    }
    
    public void drawInfoArea() {
        setBackColor(InfoBackgroundColor);
        fillRect(mHeight, 0, infoAreaHeight, mWidth);
        setFontColor(InfoTextColor);
        print(mHeight, 0 , "Score: " + CurrentScore);
    }
    
    public void runTimer() {
        new javax.swing.Timer(timerDelay, (ActionEvent e) -> {
            onTimerTick();
        }).start();
    }
    
    public static void main(String[] args) {
        FancyGame theGame = new FancyGame();
        theGame.runTimer();
    }
}
