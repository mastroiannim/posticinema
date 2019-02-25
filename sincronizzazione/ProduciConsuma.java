package sincronizzazione;

public class ProduciConsuma
{
    Object riempito = new String("riempito");
    Object svuotato = new String("svuotato");
    Integer buffer;
         
    public void metti(int dato){
        try{
            synchronized (svuotato){
                if(buffer != null){
                    System.out.println("metti: buffer pieno... attendo");
                    svuotato.wait();
                }
            }
            
            synchronized (riempito){
                buffer = dato;
                System.out.println("metti: dato " + dato + " inserito");
                riempito.notify();
                System.out.println("metti: notifico che il dato " + buffer + " è inserito");
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public int preleva(){
        try{
            synchronized (riempito){
                if(buffer == null){
                    System.out.println("preleva: buffer vuoto... attendo");
                    riempito.wait();
                }
            }
            
            synchronized (svuotato){
                int dato = buffer;
                System.out.println("preleva: dato " + dato + " consumato");
                buffer = null;
                svuotato.notify();
                System.out.println("preleva: notifico che il buffer è vuoto");
                return dato;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public static void main () throws Exception{
     
        ProduciConsuma monitor = new ProduciConsuma();
        Produttore p = new Produttore(monitor);
        Consumatore c = new Consumatore(monitor);
        System.out.println("inizio");
        p.start();
        c.start();
        
        p.join();
        c.join();
        System.out.println("fine");
    }
}
