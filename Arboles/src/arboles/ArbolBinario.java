package arboles;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class ArbolBinario {

    static Scanner lea = new Scanner(System.in);
    Nodo Punta;

    public ArbolBinario() {
        this.Punta = null;
    }

    //puntero 0;arreglo se llama con metodo y nodo empieza siempre null
     public void llenarArbol(char[] tintin) {

        for (int i = 0; i < tintin.length; i++) {
            insertar(tintin[i]);
            //System.out.println("coso " + tintin[i]);

        }
    }

    public void insertar(char info) {
        Nodo x;
        x = new Nodo();
        x.setDato(info);
        x.LI = null;
        x.LD = null;
        if (Punta == null) {
            Punta = x;
        } else {
            Nodo anterior = null;
            Nodo r_actual;
            r_actual = Punta;
            while (r_actual != null) {
                anterior = r_actual;
                if (info < r_actual.getDato()) {
                    r_actual = r_actual.LI;
                } else {
                    r_actual = r_actual.LD;
                }
            }
            if (info < anterior.getDato()) {
                anterior.LI = x;
            } else {
                anterior.LD = x;
            }
        }
        AVL(buscarDato(Punta, info));
    }

    public int factorb(Nodo r_actual) {
        int der = 0;
        int izq = 0;

        if (r_actual.LI != null) {
            izq = altura(r_actual.LI);
        }
        if (r_actual.LD != null) {
            der = altura(r_actual.LD);
        }

        return izq - der;
    }

    public void AVL(Nodo r_actual) {
        int der = 0;
        int izq = 0;
        if (r_actual != null) {
            if (r_actual.LI != null) {
                izq = altura(r_actual.LI);
            }
            if (r_actual.LD != null) {
                der = altura(r_actual.LD);
            }

            int fac = izq - der;
            if (fac >= 2) {
                if (izq > der) {
                    if (factorb(r_actual.LI) > 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LI;
                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(q);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(q);
                            }
                            if (q.getLD() != null) {
                                p.setLI(q.getLD());
                            } else {
                                p.setLI(null);
                            }
                            q.setLD(p);
                        } else {
                            if (q.getLD() != null) {
                                p.setLI(q.getLD());
                            } else {
                                p.setLI(null);
                            }
                            q.setLD(p);
                            Punta = q;
                        }
                    } else if (factorb(r_actual.LI) < 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LI;
                        Nodo r = q.getLD();

                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(r);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(r);
                            }
                            if (r.getLI() != null) {
                                q.setLD(r.getLI());
                            } else {
                                q.setLD(null);
                            }
                            if (r.getLD() != null) {
                                p.setLI(r.getLD());
                            } else {
                                p.setLI(null);

                            }
                            r.setLI(q);
                            r.setLD(p);
                        } else {
                            if (r.getLI() != null) {
                                q.setLD(r.getLI());
                            } else {
                                q.setLD(null);
                            }
                            if (r.getLD() != null) {
                                p.setLI(r.getLD());
                            } else {
                                p.setLI(null);
                            }
                            Punta = r;
                        }
                    }
                } else { // por hijo derecho
                    if (factorb(r_actual.LD) > 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LD;
                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(q);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(q);
                            }
                            if (q.getLI() != null) {
                                p.setLD(q.getLI());
                            } else {
                                p.setLD(null);
                            }
                            q.setLI(p);
                        } else {
                            if (q.getLI() != null) {
                                p.setLD(q.getLI());
                            } else {
                                p.setLD(null);
                            }
                            q.setLI(p);
                            Punta = q;

                        }
                    } else if (factorb(r_actual.LD) < 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LD;

                        Nodo r = q.getLD();
                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(r);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(r);
                            }
                            if (r.getLD() != null) {
                                q.setLI(r.getLD());
                            } else {
                                q.setLI(null);
                            }
                            if (r.getLI() != null) {
                                p.setLD(r.getLI());
                            } else {
                                p.setLD(null);
                            }
                            r.setLI(p);
                            r.setLD(q);
                        } else {
                            if (r.getLD() != null) {
                                q.setLI(r.getLD());
                            } else {
                                q.setLI(null);
                            }
                            if (r.getLI() != null) {
                                p.setLD(r.getLI());
                            } else {
                                p.setLD(null);
                            }
                            r.setLI(p);
                            r.setLD(q);
                            Punta = r;
                        }
                    }
                }
                AVL(buscarPadreV3(Punta, r_actual.getDato()));
            } else if (fac <= -2) {
                if (izq > der) {
                    if (factorb(r_actual.LI) < 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LI;
                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(q);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(q);
                            }
                            if (q.getLD() != null) {
                                p.setLI(q.getLD());
                            } else {
                                p.setLI(null);
                            }
                            q.setLI(p);
                        } else {
                            if (q.getLD() != null) {
                                p.setLI(q.getLD());
                            } else {
                                p.setLI(null);
                            }
                            q.setLI(p);
                            Punta = q;
                        }
                    } else if (factorb(r_actual.LI) > 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LI;
                        Nodo r = q.getLI();

                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(r);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(r);
                            }
                            if (r.getLD() != null) {
                                p.setLI(r.getLD());
                            } else {
                                p.setLI(null);
                            }
                            if (r.getLI() != null) {
                                q.setLD(r.getLI());
                            } else {
                                q.setLD(null);
                            }
                            r.setLD(p);
                            r.setLI(q);
                        } else {
                            if (r.getLD() != null) {
                                p.setLI(r.getLD());
                            } else {
                                p.setLI(null);
                            }
                            if (r.getLI() != null) {
                                q.setLD(r.getLI());
                            } else {
                                q.setLD(null);
                            }
                            r.setLD(p);
                            r.setLI(q);
                            Punta = r;
                        }
                    }
                } else { // por hijo derecho
                    if (factorb(r_actual.LD) < 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LD;
                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(q);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(q);
                            }
                            if (q.getLI() != null) {
                                p.setLD(q.getLI());
                            } else {
                                p.setLD(null);
                            }
                            q.setLI(p);
                        } else {
                            if (q.getLI() != null) {
                                p.setLD(q.getLI());
                            } else {
                                p.setLD(null);
                            }
                            q.setLI(p);
                            Punta = q;

                        }
                    } else if (factorb(r_actual.LD) > 0) {
                        Nodo p = r_actual;
                        Nodo q = p.LD;
                        Nodo r = q.getLI();

                        if (p != Punta) {
                            if (buscarPadreV3(Punta, p.getDato()).getLD() == p) {
                                buscarPadreV3(Punta, p.getDato()).setLD(r);
                            } else {
                                buscarPadreV3(Punta, p.getDato()).setLI(r);
                            }
                            if (r.getLI() != null) {
                                p.setLD(r.getLI());
                            } else {
                                p.setLD(null);
                            }
                            if (r.getLD() != null) {
                                q.setLI(r.getLD());
                            } else {
                                q.setLI(null);
                            }
                            r.setLI(p);
                            r.setLD(q);

                        } else {
                            if (r.getLI() != null) {
                                p.setLD(r.getLI());
                            } else {
                                p.setLD(null);
                            }
                            if (r.getLD() != null) {
                                q.setLI(r.getLD());
                            } else {
                                q.setLI(null);
                            }
                            r.setLI(p);
                            r.setLD(q);
                            Punta = r;

                        }

                    }

                }
                AVL(buscarPadreV3(Punta, r_actual.getDato()));
            } else if (r_actual != Punta) {

                AVL(buscarPadreV3(Punta, r_actual.getDato()));

            }

        }

    }

    // P comienza en la punta del objeto que lo llama
    public void mostrarPreOrden(Nodo P) {

        if (P != null) {

            System.out.print(P.getDato() + " ");

            if (P.getLI() != null) {

                this.mostrarPreOrden(P.getLI());
            }
            if (P.getLD() != null) {

                this.mostrarPreOrden(P.getLD());
            }

        }

    }

    public void mostrarInOrden(Nodo P) {

        if (P != null) {

            if (P.getLI() != null) {

                this.mostrarInOrden(P.getLI());
            }

            System.out.print(P.getDato() + " ");

            if (P.getLD() != null) {

                this.mostrarInOrden(P.getLD());
            }

        }

    }

    public void mostrarPosOrden(Nodo P) {

        if (P.getLI() != null) {

            this.mostrarPosOrden(P.getLI());
        }

        if (P.getLD() != null) {

            this.mostrarPosOrden(P.getLD());
        }

        System.out.print(P.getDato() + " ");
    }

    //Nodo P como punta siempre
    public void mostrarArbol(Nodo P) {

        if (P != null) {
            System.out.println(P.getDato());
            this.mostrarArbol(P.getLI());
            System.out.print("\t");
            this.mostrarArbol(P.getLD());
            System.out.println("");
        }

    }

    public int contarHojas(Nodo P) {

        if (P == null) {

            return 0;
        }
        if (P.getLD() == null && P.getLI() == null) {

            return 1;
        }

        return contarHojas(P.getLI()) + contarHojas(P.getLD());
    }

    public int contarPadres(Nodo P) {

        if (P == null) {

            return 0;

        } else {

            int i = contarPadres(P.getLI());
            int o = contarPadres(P.getLD());

            if (P.getLD() != null || P.getLI() != null) {

                return i + o + 1;

            } else {

                return i + o;

            }

        }

    }

    public static int altura(Nodo P) {

        if (P == null) {
            return 0;

        } else {

            int LadoDerecho = altura(P.getLD());
            int LadoIzquierdo = altura(P.getLI());
            return Math.max(LadoDerecho, LadoIzquierdo) + 1;

        }

    }

    public Nodo buscarDato(Nodo P, char x) {

        if (P == null || P.getDato() == x) {

            return P;

        } else {

            Nodo LadoIzq = buscarDato(P.getLI(), x);
            if (LadoIzq != null) {

                return LadoIzq;

            }

            Nodo LadoDer = buscarDato(P.getLD(), x);
            return LadoDer;

        }
    }

    public void mostrarHermano(Nodo P, char x) {

        if (P != null) {

            if (P.getLD() != null && P.getLD().getDato() == x) {

                if (P.getLI() != null) {

                    System.out.println("El hermano del dato es: " + P.getLI().getDato());

                } else {

                    System.out.println("El dato no tiene hermano");
                }

            } else if (P.getLI() != null && P.getLI().getDato() == x) {

                if (P.getLD() != null) {

                    System.out.println("El hermano del dato es: " + P.getLD().getDato());

                } else {

                    System.out.println("El dato no tiene hermano");
                }

            } else {

                mostrarHermano(P.getLI(), x);
                mostrarHermano(P.getLD(), x);

            }

        }

    }

    public void eliminarHoja(Nodo r_actual, char dato) {
        Nodo p = buscarDato(r_actual, dato);
        System.out.println(p.getDato());
        //si es una hoja

        //buscar(dato, r_actual) = null;
        this.buscarPadreV3(r_actual, dato).setLD(null);

        this.buscarPadreV3(r_actual, dato).setLI(null);

    }

    public void eliminar(Nodo r_actual, char dato) {
        //por la izquierda
        Nodo p = buscarDato(r_actual, dato);
//        System.out.println(p.getDato());
        if (p.getLD() == null && p.getLI() == null)//si es una hoja
        {
            //buscar(dato, r_actual) = null;
            if (this.buscarPadreV3(r_actual, dato).getLD() != null) {
                if (this.buscarPadreV3(r_actual, dato).getLD().getDato() == dato) {
                    this.buscarPadreV3(r_actual, dato).setLD(null);
                }
            } else if (this.buscarPadreV3(r_actual, dato).getLI() != null) {
                if (this.buscarPadreV3(r_actual, dato).getLI().getDato() == dato) {
                    this.buscarPadreV3(r_actual, dato).setLI(null);
                }
            }

        } else if (p.getLD() != null && p.LI == null) {//tiene hijo derecho
            if (this.buscarPadreV3(r_actual, dato) != null) {

                Nodo q = buscarDato(r_actual, dato).getLI();
                if (q == null) {
                    q = buscarDato(r_actual, dato).getLD();
                    while (q.getLI() != null) {
                        q = q.getLI();
                    }
                } else {
                    while (q.getLD() != null) {
                        q = q.getLD();
                    }
                }

                buscarDato(r_actual, dato).setDato(q.getDato());//remplaza

                q.setDato(dato);
                eliminar(Punta, dato);

                //this.buscarPadreV3(r_actual, dato).LD = p.getLD();
            } else {
                p.setDato(' ');
            }

        } else if (p.getLD() == null && p.LI != null) {//tiene hijo izquierdo
            if (this.buscarPadreV3(r_actual, dato) != null) {

                Nodo q = buscarDato(r_actual, dato).getLI();
                if (q == null) {
                    q = buscarDato(r_actual, dato).getLD();
                    while (q.getLI() != null) {
                        q = q.getLI();
                    }
                } else {
                    while (q.getLD() != null) {
                        q = q.getLD();
                    }
                }

                buscarDato(r_actual, dato).setDato(q.getDato());//remplaza

                q.setDato(dato);
                eliminar(Punta, dato);

                //this.buscarPadreV3(r_actual, dato).LI = p.getLI();
            } else {
                p.setDato(' ');
            }

        } else {//tiene 2 hijos
            Nodo q = buscarDato(r_actual, dato).getLI();
            if (q == null) {
                q = buscarDato(r_actual, dato).getLD();
                while (q.getLI() != null) {
                    q = q.getLI();
                }
            } else {
                while (q.getLD() != null) {
                    q = q.getLD();
                }
            }

            buscarDato(r_actual, dato).setDato(q.getDato());//remplaza

            //q = null;
            q.setDato(dato);
            eliminar(Punta, dato);

        }
    }// da pero le falta un poquititico

    public void primos(char dato, Nodo r_actual) {
        int nivel = nivelretur(Punta, dato, 1);

        if (r_actual != null) {

            if (nivelretur(Punta, r_actual.getDato(), 1) == nivel) {
                if (buscarPadreV3(Punta, r_actual.getDato()) != buscarPadreV3(Punta, dato)) {
                    System.out.print(r_actual.getDato() + " ");

                }
            }
            primos(dato, r_actual.getLD());
            primos(dato, r_actual.getLI());
        }

    }

    public void primohermanos(char dato, Nodo r_actual) {
        int nivel = nivelretur(Punta, dato, 1);

        if (r_actual != null) {

            if (nivelretur(Punta, r_actual.getDato(), 1) == nivel) {
                if (buscarPadreV3(Punta, r_actual.getDato()) != buscarPadreV3(Punta, dato)) {
                    Nodo p = buscarPadreV3(Punta, buscarPadreV3(Punta, r_actual.getDato()).getDato());
                    Nodo q = buscarPadreV3(Punta, buscarPadreV3(Punta, dato).getDato());

                    if (p == q) {
                        System.out.print(r_actual.getDato() + " ");
                    }
                }
            }
            primohermanos(dato, r_actual.getLD());
            primohermanos(dato, r_actual.getLI());
        }

    }

    public void mostrarancestros(Nodo r_actual) {

        if (r_actual != null) {
            System.out.print(r_actual.getDato() + " <--");
            mostrarancestros(buscarPadreV3(Punta, r_actual.getDato()));
        }
    }

    public static void imprimirmodoarbol(Nodo r_actual) {
        int alturaa = altura(r_actual);
        arbolvoltiao(r_actual, alturaa, 0);
    }

    private static void arbolvoltiao(Nodo nodito, int altura, int nivel) {
        if (nodito == null) {
            return;
        }

        arbolvoltiao(nodito.getLD(), altura, nivel + 1);

        if (nivel != 0) {
            imprimirespacios(nivel - 1);
            System.out.print("|");
            //imprimirespacios(nivel - 1);
        }

        String dato_en_ascii = Character.toString(nodito.getDato());
        System.out.println(dato_en_ascii);

        //System.out.println(nodito.dato);
        arbolvoltiao(nodito.getLI(), altura, nivel + 1);
    }

    private static void imprimirespacios(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }

    public Nodo buscarPadreV3(Nodo r_actual, char dato) {
        if (r_actual == null || r_actual.getDato() == dato) {
            return null;
        }

        if ((r_actual.getLI() != null && r_actual.getLI().getDato() == dato) || (r_actual.getLD() != null && r_actual.getLD().getDato() == dato)) {
            return r_actual;
        }

        Nodo ladoIzq = buscarPadreV3(r_actual.getLI(), dato);
        if (ladoIzq != null) {
            return ladoIzq;
        }

        return buscarPadreV3(r_actual.getLD(), dato);
    }

    public int nivel(char dato, Nodo p) {

        if (p.getDato() == dato) {
            if (p == null) {
                return 0;
            } else {
                int ladoizq = altura(p.getLI());
                int ladoder = altura(p.getLD());
                return Math.max(ladoizq, ladoder) + 1;

            }
        } else {
            nivel(dato, p.getLI());
            nivel(dato, p.getLD());
            return 0;
        }

    }

    public int nivelretur(Nodo r_actual, char dato, int cont) {
        if (r_actual == null) {
            return 0;
        }
        if (r_actual.getDato() == dato) {
            return cont;
        }
        int bajar = nivelretur(r_actual.getLI(), dato, cont + 1);
        if (bajar != 0) {
            return bajar;
        }
        bajar = nivelretur(r_actual.getLD(), dato, cont + 1);
        return bajar;
    }

}
