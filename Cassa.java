import java.util.*;

public class Cassa extends Thread
{
    private Cinema c;
    private int numeroCassa;
    public static int numeroCasseTotali = 0;
    
    public Cassa(Cinema c){
        this.c = c;
        numeroCassa = ++numeroCasseTotali;
    }
    
    public void run(){
        try{
            int residui = c.postiLiberi;
            while(residui > 0){
                int attesa = 500 + (int)(Math.random()*1500);
                Thread.sleep(attesa);
                int bigliettiRichiesti = 1 + (int)(Math.random()*3);
                residui = c.vendi(bigliettiRichiesti, numeroCassa);
            }
            System.out.println("Cassa " + numeroCassa + " finito");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}