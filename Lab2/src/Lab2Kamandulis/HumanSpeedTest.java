/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2Kamandulis;

import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import laborai.demo.AutoGamyba;
import laborai.demo.Automobilis;
import static laborai.demo.GreitaveikosTyrimas.FINISH_COMMAND;
import laborai.demo.Timekeeper;
import laborai.gui.MyException;

/**
 *
 * @author pk
 */
public class HumanSpeedTest {
    public static final String FINISH_COMMAND = "finish";
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("laborai.gui.messages");

    private final BlockingQueue resultsLogger = new SynchronousQueue();
    private final Semaphore semaphore = new Semaphore(-1);
    private final Timekeeper tk;
    
    private static final String[] TYRIMU_VARDAI = {"TreeSet.add", "HashSet.add", "TreeSet.contains", "HashSet.contains"};
    private static int[] quantityArrayForTests = {2_000, 4_000, 8_000, 16_000};
    private static Random rng = new Random();
    
    public HumanSpeedTest(){
        semaphore.release();
        tk = new Timekeeper(quantityArrayForTests, resultsLogger, semaphore);
    }
    
    public void startTheTest() {
        try {
            long memTotal = Runtime.getRuntime().totalMemory();
            getResultsLogger().add("memTotal= "+memTotal+"\r\n");
            SisteminisTyrimas();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void SisteminisTyrimas() throws InterruptedException {
        for (int n : quantityArrayForTests) {
            // Setup
            TreeSet<Integer> treeSet = new TreeSet<Integer>();
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for(int i = 0; i < n; i++) {
                int nextInt = rng.nextInt();
                treeSet.add(nextInt);
                hashSet.add(nextInt);
            }
            // Act
            int numberToAdd = rng.nextInt();
            int lookFor = rng.nextInt();
            tk.startAfterPause();
            tk.start();
            for(int i = 0; i < n; i++) {
                treeSet.add(numberToAdd);
            }
            tk.finish(TYRIMU_VARDAI[0]);
            for(int i = 0; i < n; i++) {
                hashSet.add(numberToAdd);
            }
            tk.finish(TYRIMU_VARDAI[1]);
            for(int i = 0; i < n; i++) {
                treeSet.contains(lookFor);
            }
            tk.finish(TYRIMU_VARDAI[2]);
            for(int i = 0; i < n; i++) {
                hashSet.contains(lookFor);
            }
            tk.finish(TYRIMU_VARDAI[3]);
            tk.seriesFinish();
        }
        tk.logResult(FINISH_COMMAND);
    }

    public BlockingQueue<String> getResultsLogger() {
        return resultsLogger;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
