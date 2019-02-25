package sincronizzazione;

public class Consumatore extends Thread
{
    ProduciConsuma monitor;

    public Consumatore(ProduciConsuma monitor)
    {
        this.monitor = monitor;
    }
    
    public void run(){
        System.out.println("consumatore");
        while (true){
            if(monitor.preleva() == 5) break;
        }
    }

}
