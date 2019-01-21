
public class Cinema
{
    public int postiLiberi;
    
    public Cinema(int posti){
        postiLiberi = posti;
    }
    
    public int vendi(int bigliettiRichiesti, int cassa){
        System.out.println("Richiesti " + bigliettiRichiesti + " biglietti alla cassa n." + cassa);
        int postiResidui = postiLiberi;
        if(postiLiberi >= bigliettiRichiesti){
           postiResidui = postiLiberi - bigliettiRichiesti;
           System.out.println("Venduti " + bigliettiRichiesti + " biglietti dalla cassa n." + cassa);
        }
        System.out.println("Rimangono " + postiResidui + " biglietti");
        postiLiberi = postiResidui;
        return postiLiberi;
    }
}
