/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jruby.ext.bigdecimal.RubyBigDecimal;
import org.jruby.runtime.Block;
import static pkg15460679p03.Main.abrirTXT;
import static pkg15460679p03.Main.nuevoTXT;

/**
 *
 * @author mendo
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    static String ctrls = "";
    static int cont= 0;
    
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);        //Se mueve la aplicación al centro
        try {
            setIconImage(new ImageIcon(getClass().getResource("../img/app.png")).getImage());         //imagen que será usada como icono
        } catch (Exception e) {
        }
        this.setTitle("Lenguajes y Atomatas I");     //Título
        txtArea.setLineWrap(true);     //Se hace que el textArea tenga salto de linea automático
        txtRuta.setEnabled(false);      //La ruta no puede ser editada, solo puede ser vista
        txtArea.setEditable(false);     //No se puede editar el textArea hasta que se de la instrucción en los demás apartados
        btnNuevo.requestFocus();      //Focus para el botón de crear archivo
        btnBorrar.setEnabled(false);  //Inactivo mientras no se escriba en textArea                
    }
            
    void ace(String save){        
        cont++;
        ctrls = ctrls + save;        
        if(cont >= 1){
            int largo = ctrls.length()-1;
            String inicio = ctrls.substring(0,1);        
            String fin = ctrls.substring(largo);            
            if(inicio.equals("s")){
                ctrls = "";
            }else{
                if(inicio.equals("c") && fin.equals("s")){
                    String nombre = lblNombre.getText();
                    if(nombre.equals("Archivo Nuevo")){
                        btnGuardar.doClick();
                    }else{
                        String ruta = txtRuta.getText();
                        String texto = txtArea.getText();
                        nuevoTXT(ruta,texto);
                    }                
                    largo = 0;
                    cont = 0;
                }
            }
            
        }        
    }    
    
    void abrir(){        
        JFileChooser dlg = new JFileChooser();         //Librería para abrir ventana de archivos
        int option = dlg.showOpenDialog(this);          //Escoger un archivo y abrirlo con "showOpenDialog"

        if(option == JFileChooser.APPROVE_OPTION){            //Al pulsar "abrir" se activa "APPROVE_OPTION"
            File f = dlg.getSelectedFile();                                    //Tomamos el archivo seleccionado
            txtRuta.setText(f.toString());                                     //Tomamos la ruta y la convertimos en String para poderla visualizar al usuario
            String ruta = txtRuta.getText();                                 //Tomamos el String antes mencionado
            try {
                String texto = abrirTXT(ruta);                               //Mandamos la ruta al método de Main "abrirTXT" para poder abrir el .txt, y nos devuelve un String, por eso la variable "texto"
                if(texto.equals("")){                                             //Si no se manda un archivo para abrir marcará como error con una ventana emergente
                    String mensaje = "<html> <body> <b style = \'font-size: 20; color: red;\' > NO EXISTE ESE ARCHIVO </body> </html>";
                    Icon icono = new ImageIcon(getClass().getResource("../img/alert.png"));
                    JOptionPane.showMessageDialog(null, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, icono);                    
                }else{                   //Caso contrario 
                    txtArea.setEditable(true);               //Se activa el poder editar en el textArea
                    txtArea.setText(texto);                   //Adquirimos la variable texto donde se tiene el resultado de todo el método "abrirTXT" de la clase Main                    
                    lblNombre.setText(f.getName());                    //Cambiamos el label oculto por el nombre del documento seleccionado                    
                    btnBorrar.setEnabled(true);  //Se activa la opción de borrar todo
                }                
            } catch (IOException ex) {
                Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);               //Error predeterminado
            }
        }        
    }
    
    void reiniciar(){
        txtArea.setEditable(false);         //Reiniciamos todos los valores
        txtArea.setText("");                    
        lblNombre.setText("");                                        
        txtRuta.setText("");           
        btnBorrar.setEnabled(false);
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtRuta = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        lblNombre = new javax.swing.JLabel();
        btnBorrar = new org.edisoncor.gui.button.ButtonIcon();
        panel3 = new org.edisoncor.gui.panel.Panel();
        btnGuardar = new org.edisoncor.gui.button.ButtonIcon();
        panel4 = new org.edisoncor.gui.panel.Panel();
        btnAbrir = new org.edisoncor.gui.button.ButtonIcon();
        panel5 = new org.edisoncor.gui.panel.Panel();
        btnNuevo = new org.edisoncor.gui.button.ButtonIcon();
        panelRound1 = new org.edisoncor.gui.panel.PanelRound();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel1.setColorPrimario(new java.awt.Color(153, 153, 153));
        panel1.setColorSecundario(new java.awt.Color(153, 153, 153));

        panel2.setBackground(new java.awt.Color(204, 204, 204));
        panel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel2.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel2.setColorSecundario(new java.awt.Color(204, 204, 204));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtArea.setRows(5);
        txtArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea);

        txtRuta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuta.setDescripcion("Dirección del archivo");
        txtRuta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setLabelFor(txtArea);
        lblNombre.setToolTipText("GUARDAR ctrl + shiftIzq ");
        lblNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 0, 2, new java.awt.Color(0, 0, 0)));
        lblNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnBorrar.setBackground(new java.awt.Color(204, 204, 204));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_eraser_1913619.png"))); // NOI18N
        btnBorrar.setText("buttonIcon1");
        btnBorrar.setToolTipText("Borrar");
        btnBorrar.setColorDeSombra(new java.awt.Color(51, 153, 255));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        btnBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBorrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel3.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel3.setColorSecundario(new java.awt.Color(204, 204, 204));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_filesave_326.png"))); // NOI18N
        btnGuardar.setText("buttonIcon1");
        btnGuardar.setToolTipText("Guardar Archivo");
        btnGuardar.setColorDeSombra(new java.awt.Color(51, 153, 255));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel4.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel4.setColorSecundario(new java.awt.Color(204, 204, 204));

        btnAbrir.setBackground(new java.awt.Color(204, 204, 204));
        btnAbrir.setForeground(new java.awt.Color(204, 204, 204));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_open-file_85334.png"))); // NOI18N
        btnAbrir.setText("buttonIcon1");
        btnAbrir.setToolTipText("Abrir Archivo");
        btnAbrir.setColorDeSombra(new java.awt.Color(51, 153, 255));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        btnAbrir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAbrirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel5.setColorPrimario(new java.awt.Color(204, 204, 204));
        panel5.setColorSecundario(new java.awt.Color(204, 204, 204));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_File_104851.png"))); // NOI18N
        btnNuevo.setText("buttonIcon1");
        btnNuevo.setToolTipText("Nuevo Archivo");
        btnNuevo.setColorDeSombra(new java.awt.Color(51, 153, 255));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        panelRound1.setBackground(new java.awt.Color(204, 204, 204));
        panelRound1.setColorDeBorde(new java.awt.Color(204, 204, 204));
        panelRound1.setColorDeSegundoBorde(new java.awt.Color(0, 0, 0));
        panelRound1.setColorPrimario(new java.awt.Color(204, 204, 204));
        panelRound1.setColorSecundario(new java.awt.Color(204, 204, 204));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_12_2257366.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel12.setText("CREACIÓN DE ARCHIVOS TXT");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(68, 68, 68))))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaActionPerformed

    
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        String nombre = lblNombre.getText();
        if(!nombre.equals("")){            
            btnBorrar.doClick();
            abrir();
        }else{
            abrir();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        JFileChooser dlg = new JFileChooser();                    //Librería para abrir ventana de archivos
        int option = dlg.showSaveDialog(this);                      //Escoger un archivo y guardarlo con "showSaveDialog"
        if(option == JFileChooser.APPROVE_OPTION){        //Al pulsar "guardar" se activa "APPROVE_OPTION"
            File f = dlg.getSelectedFile();                                //Tomamos el archivo seleccionado            
            txtRuta.setText(f.toString());                                  //Tomamos la ruta y la convertimos en String para poderla visualizar al usuario            
            lblNombre.setText(f.getName());                            //Cambiamos el label oculto por el nombre del documento seleccionado            
            
            //Ventana emergente de guardado del archivo
            String mensaje = "<html> <body> <b style = \'font-size: 20; color: blue;\' > ARCHIVO GUARDADO CORRECTAMENTE </body> </html>";
            Icon icono = new ImageIcon(getClass().getResource("../img/if_icon-113-document-file-txt_315465.png"));
            JOptionPane.showMessageDialog(null, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, icono);  
            String ruta = txtRuta.getText();                 //Se guarda la ruta 
            String texto = txtArea.getText();               //Se guarda el texto que se escribirá en el document 
            nuevoTXT(ruta,texto);                             //Por medio del método "nuevoTXT" se mandan las dos variables(ruta,texto) para que el método guarde y escriba dentro del archivo .txt
            ctrls = "";            
        }else{
            String ruta = txtRuta.getText();                 //Se guarda la ruta 
            String texto = txtArea.getText();               //Se guarda el texto que se escribirá en el document 
            txtArea.setText(texto);
            txtRuta.setText(ruta);
        }
            ctrls = "";    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        String nombre = lblNombre.getText();
        if(!nombre.equals("")){            
            btnBorrar.doClick();                          
            lblNombre.setText("Archivo Nuevo");       //Label oculta toma este nombre para hacer referencia que se puede escribir en el textArea        
            txtArea.setText("");                                //Por si hay texto, que no debería, quitamos todo para que se inicie completamente un nuevo documento
            txtArea.setEditable(true);                      //Ahora se puede editar en el textArea
            txtArea.requestFocus();                         //Focus a textArea para que pueda iniciar el usuario y así tenga mayor comodidad
            btnBorrar.setEnabled(true);                   //Al poder editar textArea, se puede borrar
        }else{
            lblNombre.setText("Archivo Nuevo");       //Label oculta toma este nombre para hacer referencia que se puede escribir en el textArea        
            txtArea.setText("");                                //Por si hay texto, que no debería, quitamos todo para que se inicie completamente un nuevo documento
            txtArea.setEditable(true);                      //Ahora se puede editar en el textArea
            txtArea.requestFocus();                         //Focus a textArea para que pueda iniciar el usuario y así tenga mayor comodidad
            btnBorrar.setEnabled(true);                   //Al poder editar textArea, se puede borrar
        }
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //Ventana emergente para saber si el usuario desea en realidad borrar todo
        String mensaje = "<html> <body> <b style = \'font-size: 20; color: red;\' > ¿Desea guardar? </b> </body> </html>"; 
        int resp = JOptionPane.showConfirmDialog(null, mensaje, "¡Todo será borrado!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){   //Si acepta, todo será borrado
                    String nombre = lblNombre.getText();
                    if(nombre.equals("Archivo Nuevo")){
                        btnGuardar.doClick();
                    }else{
                        String ruta = txtRuta.getText();
                        String texto = txtArea.getText();
                        nuevoTXT(ruta,texto);
                    } 
                    reiniciar();
                }else{
                    reiniciar();
                }        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnNuevo.doClick();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            btnAbrir.requestFocus();
        }
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnAbrirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAbrirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAbrir.doClick();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_btnAbrirKeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnGuardar.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            btnBorrar.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnBorrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBorrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBorrar.doClick();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            txtArea.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarKeyPressed

    private void txtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyTyped
         
    }//GEN-LAST:event_txtAreaKeyTyped
      

    
    private void txtAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyPressed
        if(evt.isControlDown()){
            ace("ctrl");
        }
        if(evt.getKeyCode() == 16){                        
            evt.consume();
            ace("s");            
        }        
    }//GEN-LAST:event_txtAreaKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnBorrar.doClick();
        Icon icono = new ImageIcon(getClass().getResource("/img/bye.png"));
        String mensaje2 = "<html> <body> <b style = \'font-size: 20; color: #00B281;\' > ¡GRACIAS POR UTILIZAR NUESTRA APLICACIÓN! </b> </body> </html>";
        JOptionPane.showMessageDialog(null, mensaje2,"ADIÓS", JOptionPane.PLAIN_MESSAGE, icono);                    
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIcon btnAbrir;
    private org.edisoncor.gui.button.ButtonIcon btnBorrar;
    private org.edisoncor.gui.button.ButtonIcon btnGuardar;
    private org.edisoncor.gui.button.ButtonIcon btnNuevo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    private org.edisoncor.gui.panel.Panel panel5;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelRound panelRound1;
    private javax.swing.JTextArea txtArea;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtRuta;
    // End of variables declaration//GEN-END:variables
}
