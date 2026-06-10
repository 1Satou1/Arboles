
package arboles;

/**
 *
 * @author Miguel
 */
public class Nodo {
    
    public Nodo LD;
    public Nodo LI;
    public char Dato;

    public Nodo() {
        this.LD = null;
        this.LI = null;
        
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public Nodo getLI() {
        return LI;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }

    public char getDato() {
        return Dato;
    }

    public void setDato(char Dato) {
        this.Dato = Dato;
    }
    
    
    
    
    
    
    
    
}
