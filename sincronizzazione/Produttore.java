package sincronizzazione;
import java.util.*;

public class Produttore extends Thread
{
    ProduciConsuma monitor;

    public Produttore(ProduciConsuma monitor)
    {
        this.monitor = monitor;
    }
    
    public void run(){
        System.out.println("produttore");
        while (true){
            int dato = 1 + (int)(Math.random()*9);
            monitor.metti(dato);
            if(dato == 5) break;
        }
    }

}
