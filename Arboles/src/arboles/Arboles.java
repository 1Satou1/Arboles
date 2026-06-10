package arboles;

/**
 *
 * @author Miguel
 */
import arboles.ArbolBinario;
import static arboles.ArbolBinario.imprimirmodoarbol;
import java.util.Scanner;

public class Arboles {

    static Scanner lea = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        
        DBFACEG
        ACDMQPOTBE
        
         */

        ArbolBinario arbolPro = new ArbolBinario();
        int i = 0;
        char x;
        
        arbolPro.llenarArbol(fraseConstructora());
        while (i==0) {
            
            
            imprimirmodoarbol(arbolPro.Punta);
            

            System.out.println("Que metodo usar? : ");
            System.out.println("");
            System.out.println("Mostrar Arbol<0>");
            System.out.println("Mostrar Preorden <1>");            
            System.out.println("Mostrar Posorden <2>");            
            System.out.println("Mostrar Inorden <3>");            
            System.out.println("Contar Padres <4>");            
            System.out.println("Contar Hojas <5>");            
            System.out.println("Eliminar <6>");            
            System.out.println("Mostrar Hermano <7>");            
            System.out.println("Mostrar Nivel <8>");            
            System.out.println("Mostrar Altura <9>");            
            System.out.println("Mostrar Primo Hermanos <10>");            
            System.out.println("Mostrar Ancestros <11>");            
            System.out.println("Insertar <12>");            
            System.out.println("Salir del todo <13>");            
            int opc= lea.nextInt();
            
            switch(opc){
                case 0:
                    arbolPro.mostrarArbol(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 1:
                    arbolPro.mostrarPreOrden(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    arbolPro.mostrarPosOrden(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 3:
                    arbolPro.mostrarInOrden(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 4:
                    arbolPro.contarPadres(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 5:
                    arbolPro.contarHojas(arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 6:
                    System.out.println("Dato a eliminar: ");
                    x = lea.next().charAt(0);
                    arbolPro.eliminar(arbolPro.Punta, x);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 7:
                    System.out.println("Dato a buscar Hermano: ");
                    x = lea.next().charAt(0);
                    arbolPro.mostrarHermano(arbolPro.Punta, x);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 8:
                    System.out.println("Dato a buscar nivel: ");
                    x = lea.next().charAt(0);
                    System.out.println(arbolPro.nivelretur(arbolPro.Punta, x, 1));
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 9:
                    System.out.println("Dato a buscar altura: ");
                    x = lea.next().charAt(0);
                    System.out.println(ArbolBinario.altura(arbolPro.buscarDato(arbolPro.Punta, x)));
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 10:
                    System.out.println("Dato a mostrar Primo Hermanos: ");
                    x = lea.next().charAt(0);
                    arbolPro.primohermanos(x,arbolPro.Punta);
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 11:
                    System.out.println("Dato a mostrar ancestros: ");
                    x = lea.next().charAt(0);
                    arbolPro.mostrarancestros(arbolPro.buscarDato(arbolPro.Punta, x));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 12:
                    System.out.println("Dato a ingresar : ");
                    x = lea.next().charAt(0);
                    arbolPro.insertar(x);
                    System.out.println("");
                    System.out.println("");
                    break;
                case 13:
                    i=1;
                    System.out.println("");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Su mama");
                    System.out.println("");
                    System.out.println("");
                    break;
                
                
            }
            
        }

    }

    static char[] fraseConstructora() {

        System.out.println("Escribe frase de letras sin espacios: ");
        String cadena = lea.next();

        char VC[] = cadena.toCharArray();

        return VC;
    }

}
