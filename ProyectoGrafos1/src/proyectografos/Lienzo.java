package proyectografos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author basti
 */
public class Lienzo extends JPanel implements MouseListener{
    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlaces;
    private Point p1,p2;
    public static int aux=0,aux1=0,auxx=0;
    public static String matrizAristas[][];
    public static String matrizCamino[][];
    public static String arregloNodos[];
    
    ;
    
    public Lienzo(){
        this.vectorNodos = new Vector <>();
        this.vectorEnlaces = new Vector <>();
        this.addMouseListener(this);
        matrizAristas= new String[20][4];
        matrizCamino= new String[20][4];
        arregloNodos= new String[20];
        
    }
    
    @Override
    public void paint(Graphics g) {
        for (Nodo nodos : vectorNodos){
            nodos.pintar(g);
        }
        
        for (Enlace enlace : vectorEnlaces){
            enlace.pintar(g);

            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //this.setBackground(Color.BLUE);
        if (e.getButton() == MouseEvent.BUTTON1) {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre al nodo");
           
            //Aqui empieza el if
           // if(nombre.isLetter(){
            //Character.isLetter(nombre.charAt(1));
            arregloNodos[aux1]=nombre;
            
            //arregloNodos[aux1]=nombre.substring(0, 1);
           
            
            /*System.out.println("Los nodos actuales son   :");
            for(int i=0;i<=aux1;i++){
                System.out.println("  Nombre del nodo: "+ arregloNodos[i]);
            }*/
            aux1++;
            this.vectorNodos.add(new Nodo(e.getX(),e.getY(),nombre));
            this.paint(this.getGraphics()); // Esto arreglo el problema de que se "pintaran" otras cosas sobre el Jpanel
            
            //aqui termina el if
            /*else{
                    JOptionPane.showMessageDialog(null, "Ingrese una letra.");
                    }*/
            }
        if(e.getButton() == MouseEvent.BUTTON3){
            for(Nodo nodo: vectorNodos){
                if(new Rectangle(nodo.getX() - Nodo.d/2, nodo.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(e.getPoint())){
                    
                    if(p1==null)
                    {                        
                        p1 = new Point(nodo.getX(),nodo.getY());
                        String nombrep1= nodo.getNombre();
                        
                        matrizAristas[aux][2]=nombrep1;
                        
                    }
                    else{
                        
                        p2=new Point(nodo.getX(),nodo.getY());
                        String nombrep2= nodo.getNombre();
                        String nombre = JOptionPane.showInputDialog("Ingrese nombre al camino");
                        String tamaño = JOptionPane.showInputDialog("Ingrese tamaño al camino");
                        
                        if (Comunes.isNumeric(tamaño)){
                            matrizAristas[aux][0]=nombre;
                            matrizAristas[aux][1]=tamaño;
                            matrizAristas[aux][3]=nombrep2;

                            aux++;


                            this.vectorEnlaces.add(new Enlace(p1.x,p1.y,p2.x,p2.y,nombre,tamaño));

                            this.paint(this.getGraphics());
                            p1 = null;
                            p2 = null;
                            
                         
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Ingrese Solo Numeros");        
                            p2=new Point(nodo.getX(),nodo.getY());
                            String nombrep= nodo.getNombre();
                            String nombr = JOptionPane.showInputDialog("Ingrese nombre al camino");
                            String tamañ = JOptionPane.showInputDialog("Ingrese tamaño al camino");
                            matrizAristas[aux][0]=nombr;
                            matrizAristas[aux][1]=tamañ;
                            matrizAristas[aux][3]=nombrep;
                            aux++;
                             this.vectorEnlaces.add(new Enlace(p1.x,p1.y,p2.x,p2.y,nombr,tamañ));

                            this.paint(this.getGraphics());
                            p1 = null;
                            p2 = null;
                        }
                        
                       if(p1==null && p2==null){
                         
                         String pru,pru1;  
                         pru = matrizAristas[aux][1];
                         System.out.println(pru);
                         pru++;
                         pru1 = matrizCamino[auxx][1]=pru;
                         System.out.println(pru1);
                         
                       }
                        
                        
                        
                        
                                }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}

