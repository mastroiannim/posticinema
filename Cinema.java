
public class Cinema
{
    public int postiLiberi;
    public int venduti = 0;
    
    public Cinema(int posti){
        postiLiberi = posti;
    }
    
    public synchronized int vendi(int bigliettiRichiesti, int cassa){
        ///System.out.println("Richiesti " + bigliettiRichiesti + " biglietti alla cassa n." + cassa);
            int postiResidui = postiLiberi;
            if(postiLiberi >= bigliettiRichiesti){
               postiResidui = postiLiberi - bigliettiRichiesti;
               venduti+=bigliettiRichiesti;
               System.out.println("Venduti " + bigliettiRichiesti + "/" + postiLiberi + " biglietti dalla cassa n." + cassa);
            }else{
                //System.out.println("Posti non disponibili");
            }
            try{
                Thread.sleep(1 + (int)(Math.random()*1));
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            //System.out.println("Rimangono " + postiResidui + " biglietti");
            postiLiberi = postiResidui;
        return postiLiberi;
    }
    
    public static void main(String[] args){
        Cinema c = new Cinema(150);
        Cassa[] casse = new Cassa[50];
        for(int i=0; i<casse.length; i++){
            casse[i] = new Cassa(c);
        }
        for(int i=0; i<casse.length; i++){
            casse[i].start();
        }
        try{
            for(int i=0; i<casse.length; i++){
                casse[i].join();
            }
            System.out.println("liberi " + c.postiLiberi);
            System.out.println("venduti " + c.venduti);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}






