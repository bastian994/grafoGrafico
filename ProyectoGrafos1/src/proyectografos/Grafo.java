/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectografos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import static proyectografos.Lienzo.aux;
import static proyectografos.Lienzo.matrizAristas;

/**
 *
 * @author basti
 */
public class Grafo extends javax.swing.JFrame {

    /**
     * Creates new form Grafo
     */
    public Grafo() {
       
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        
        
        btnMatriz = new javax.swing.JButton();
        btnConexo = new javax.swing.JButton();
        btnDis = new javax.swing.JButton();
        btnCaminos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panel1 = new Lienzo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        btnMatriz.setText("Generar Matriz de Adyacencia");
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });

       btnConexo.setText("¿Es conexo?");
        btnConexo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexoActionPerformed(evt);
            }
        });

        btnDis.setText("Aplicar Disjktra");

        btnCaminos.setText("Caminos");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        panelPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        panelPrincipal.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMatriz)
                .addGap(41, 41, 41)
                .addComponent(btnConexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCaminos)
                .addGap(58, 58, 58)
                .addComponent(btnDis)
                .addGap(66, 66, 66)
                .addComponent(btnSalir)
                .addGap(396, 396, 396))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatriz)
                    .addComponent(btnConexo)
                    .addComponent(btnDis)
                    .addComponent(btnCaminos)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>   
    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {   
        String matrizAdy[][];
        matrizAdy=new String[(Lienzo.aux1+1)][(Lienzo.aux1+1)];
        System.out.println(Lienzo.aux1);
        for(int i=0;i<=Lienzo.aux1;i++){
            for(int j=0;j<=Lienzo.aux1;j++){
               if(i==0){
                   if(j==0){
                      matrizAdy[i][j]=" ";
                   }
                   else{
                       matrizAdy[i][j]=Lienzo.arregloNodos[j-1];
                   }
                           }
               
               else{
                   if(j==0){
                       matrizAdy[i][j]=Lienzo.arregloNodos[i-1];
                   }
                   else{
                       matrizAdy[i][j]="0";
                       
                   }
               }
           }
       }
        
        for (int i=0;i<=Lienzo.aux1;i++){
            for(int j=0;j<=Lienzo.aux1;j++){
                String a,b;
                a=matrizAdy[i][0];
                b=matrizAdy[0][j];
                for(int k=0;k<=Lienzo.aux;k++){
                    String c,d;
                    c=Lienzo.matrizAristas[k][2];
                    d=Lienzo.matrizAristas[k][3];
                    
                    if(a.equals(c) && b.equals(d)){
                        matrizAdy[i][j]="1";}
                    if(a.equals(d) && b.equals(c)){
                        matrizAdy[i][j]="1";
                    }
                    
                }
            }
        }
        for(int i=0;i<=Lienzo.aux1;i++){
                for(int j=0;j<=Lienzo.aux1;j++){
                    System.out.print(matrizAdy[i][j]+" ");
                }
                System.out.println("\n");
            }
            
        
        
        
    }   
    private void btnConexoActionPerformed(java.awt.event.ActionEvent evt){    
        String matrizAdy[][];
        matrizAdy=new String[(Lienzo.aux1+1)][(Lienzo.aux1+1)];
        System.out.println(Lienzo.aux1);
        for(int i=0;i<=Lienzo.aux1;i++){
            for(int j=0;j<=Lienzo.aux1;j++){
               if(i==0){
                   if(j==0){
                      matrizAdy[i][j]=" ";
                   }
                   else{
                       matrizAdy[i][j]=Lienzo.arregloNodos[j-1];
                   }
                           }
               
               else{
                   if(j==0){
                       matrizAdy[i][j]=Lienzo.arregloNodos[i-1];
                   }
                   else{
                       matrizAdy[i][j]="0";
                       
                   }
               }
           }
       }
        
        for (int i=0;i<=Lienzo.aux1;i++){
            for(int j=0;j<=Lienzo.aux1;j++){
                String a,b;
                a=matrizAdy[i][0];
                b=matrizAdy[0][j];
                for(int k=0;k<=Lienzo.aux;k++){
                    String c,d;
                    c=Lienzo.matrizAristas[k][2];
                    d=Lienzo.matrizAristas[k][3];
                    
                    if(a.equals(c) && b.equals(d)){
                        matrizAdy[i][j]="1";}
                    if(a.equals(d) && b.equals(c)){
                        matrizAdy[i][j]="1";
                    }
                    
                }
            }
        }
     
        
        int auxiliar=0;
        int aux=0;
        for(int i=1;i<=Lienzo.aux1;i++){
            auxiliar=0;
            for(int j=1;j<=Lienzo.aux1;j++){
                   if(matrizAdy[i][j].equals("0")){
                       auxiliar++;
                   }
                }
            
                if(auxiliar==Lienzo.aux1){
                    aux++;
                }
            }
        
        if(aux>=1){
            System.out.println("No es conexo");
            
        }
        if(aux==0){System.out.println("Si es conexo");}
        
        
    }                 
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }    
    
                   
                                         
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMatriz = new javax.swing.JButton();
        btnConexo = new javax.swing.JButton();
        btnDis = new javax.swing.JButton();
        btnCaminos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        btnMatriz.setText("Generar Matriz de Adyacencia");
        btnMatriz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMatrizMouseClicked(evt);
            }
        });
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });

        btnConexo.setText("¿Es conexo?");
        btnConexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConexoMouseClicked(evt);
            }
        });
        btnConexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexoActionPerformed(evt);
            }
        });

        btnDis.setText("Aplicar Disjktra");

        btnCaminos.setText("Caminos");
        btnCaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaminosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        panelPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        panelPrincipal.setForeground(new java.awt.Color(0, 255, 255));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("CAMINOS: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMatriz)
                .addGap(41, 41, 41)
                .addComponent(btnConexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCaminos)
                .addGap(58, 58, 58)
                .addComponent(btnDis)
                .addGap(66, 66, 66)
                .addComponent(btnSalir)
                .addGap(396, 396, 396))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(358, 358, 358))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatriz)
                    .addComponent(btnConexo)
                    .addComponent(btnDis)
                    .addComponent(btnCaminos)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMatrizActionPerformed

    private void btnMatrizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatrizMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMatrizMouseClicked

    private void btnConexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConexoActionPerformed

    private void btnConexoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConexoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConexoMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        //Aquì va el codigo del evento "MouseClicked"
        
    }//GEN-LAST:event_btnSalirMouseClicked
*/
    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panel1MouseClicked

    private void btnCaminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaminosActionPerformed
       
                  
    }//GEN-LAST:event_btnCaminosActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaminos;
    private javax.swing.JButton btnConexo;
    private javax.swing.JButton btnDis;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
