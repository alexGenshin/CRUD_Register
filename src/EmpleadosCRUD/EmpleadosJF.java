package EmpleadosCRUD;

import Usuarios.Conexion;
import Usuarios.SQL_Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.view.JasperViewer;

public class EmpleadosJF extends javax.swing.JFrame {

    private Connection con = null;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Registros?user=root&password=");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
    DefaultComboBoxModel modelo;
    Empleado per = new Empleado();
    SQLEmpleados modSql = new SQLEmpleados();
    Conexion cn = new Conexion();
    double SueldoNeto;

    public void limpiarCajas() {
        txtcod.setText(null);
        txtNombre.setText(null);
        txtDireccion.setText(null);
        txtEdad.setText(null);
        txtDni.setText(null);
        txtDepa.setSelectedItem(null);
        txtCiudad.setText(null);
        txtTelefono.setText(null);
        txtSueldoBase.setText(null);
        txtSueldoBoni.setText(null);
        txtDesc.setText(null);
        txtSueldoNeto.setText(null);
        txtHoras.setText(null);
        txtActivo.setSelected(false);
        txtInactivo.setSelected(false);
    }

    public void mostrarDatos() {
        String[] titulos = {"ID", "NOMBRE", "DIRECCION", "EDAD", "DNI", "CIUDAD",
            "SUELDO", "ESTADO", "TELEF", "ID_Dep"};
        String[] registros = new String[10];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from Empleados";
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("Codigo");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("Direccion");
                registros[3] = rs.getString("Edad");
                registros[4] = rs.getString("Dni");
                registros[5] = rs.getString("Ciudad");
                registros[6] = rs.getString("Sueldo_Neto");
                registros[7] = rs.getString("Estado");
                registros[8] = rs.getString("Telefono");
                registros[9] = rs.getString("ID_Depa");
//                  registros[10]=rs.getString("Id_Usuario");
                modelo.addRow(registros);
            }
            TablaEmpleados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos" + e.getMessage());
        }
    }

    public EmpleadosJF() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        modelo = new DefaultComboBoxModel();
        cargarComboBox();
        mostrarDatos();
    }

    public void cargarComboBox() {
        Conexion con = new Conexion();
        Connection cn;
        ResultSet res;
        try {
            String sql = "Select * from departamentos";
            PreparedStatement pre = getConexion().prepareCall(sql);
            res = pre.executeQuery();
            modelo.removeAllElements();
            while (res.next()) {
                modelo.addElement(res.getString("Tipo"));
            }
            txtDepa.setModel(modelo);

        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
    }

    public void insertar() throws Exception {
        per.setIdEmpleado(Integer.parseInt(txtcod.getText()));
        per.setNombre(txtNombre.getText());
        per.setDireccion(txtDireccion.getText());
        per.setEdad(Integer.parseInt(txtEdad.getText()));
        per.setDni(txtDni.getText());
        per.setCiudad(txtCiudad.getText());
        Sueldo_();
        per.setSueldoNeto(SueldoNeto);

        if (this.txtActivo.isSelected()) {
            per.setEstado("Activo");
        } else {
            per.setEstado("Inactivo");
        }
        per.setTelefono(txtTelefono.getText());
        per.setDepa(this.txtDepa.getSelectedItem().toString());

        modSql.actualizarEmpleado(per);
        JOptionPane.showMessageDialog(null, "Datos insertados");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtActivo = new javax.swing.JRadioButton();
        txtInactivo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSueldoBase = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSueldoBoni = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSueldoNeto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDepa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        Reportetxt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel3.setText("Direccion");

        jLabel4.setText("Edad");

        jLabel5.setText("Dni");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado");

        buttonGroup1.add(txtActivo);
        txtActivo.setText("Activo");

        buttonGroup1.add(txtInactivo);
        txtInactivo.setText("Inactivo");

        jLabel7.setText("Ciudad");

        jLabel8.setText("Telefono");

        jLabel10.setText("Sueldo Base");

        jLabel11.setText("Sueldo Bonificado");

        txtSueldoBoni.setEditable(false);

        jLabel12.setText("Horas Extras");

        jLabel13.setText("Descuento");

        txtDesc.setEditable(false);
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        jLabel14.setText("Sueldo Neto");

        txtSueldoNeto.setEditable(false);

        jLabel15.setText("Departamento");

        txtDepa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " \t--Seleccione el Departamento--", "Financiero", "Recursos Humanos", "Marketing", "Comercial", "Compras", "Logística y Operaciones", "Control de Gestión", " " }));
        txtDepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepaActionPerformed(evt);
            }
        });

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEmpleados);

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("    ID");

        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });

        Reportetxt.setText("Generar Reporte");
        Reportetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportetxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(62, 62, 62)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDepa, 0, 224, Short.MAX_VALUE)
                                    .addComponent(txtDni))
                                .addGap(207, 207, 207))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                            .addComponent(txtDireccion)
                                            .addComponent(txtEdad)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(35, 35, 35)
                                        .addComponent(txtActivo)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtInactivo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCiudad)
                            .addComponent(txtTelefono)
                            .addComponent(txtSueldoBase)
                            .addComponent(txtSueldoBoni)
                            .addComponent(txtDesc)
                            .addComponent(txtSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12))
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnGuardar)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(47, 47, 47)
                        .addComponent(btnEliminar)
                        .addGap(28, 28, 28)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reportetxt)
                        .addGap(397, 397, 397))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDepa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtActivo)
                                .addComponent(txtInactivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtSueldoBoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton1)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(Reportetxt))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void Sueldo_() {
        Double SBase = Double.parseDouble(txtSueldoBase.getText());
        Double horas = Double.parseDouble(txtHoras.getText());
        double sueldoBon;
        sueldoBon = SBase + (horas * 12);
        double desc;
        if (sueldoBon >= 0 & sueldoBon <= 1200) {
            desc = sueldoBon * 0.02;
        } else if (sueldoBon > 1200 & sueldoBon <= 2500) {
            desc = sueldoBon * 0.05;
        } else {
            desc = sueldoBon * 0.07;
        }

        SueldoNeto = sueldoBon - desc;
        txtSueldoBoni.setText(String.valueOf(sueldoBon));
        txtDesc.setText(String.valueOf(desc));
        txtSueldoNeto.setText(String.valueOf(SueldoNeto));
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        per.setNombre(txtNombre.getText());
        per.setDireccion(txtDireccion.getText());
        per.setEdad(Integer.parseInt(txtEdad.getText()));
        per.setDni(txtDni.getText());
        per.setCiudad(txtCiudad.getText());
        Sueldo_();

        per.setSueldoNeto(SueldoNeto);

        if (this.txtActivo.isSelected()) {
            per.setEstado("Activo");
        } else {
            per.setEstado("Inactivo");
        }
        per.setTelefono(txtTelefono.getText());
        per.setDepa(this.txtDepa.getSelectedItem().toString());
        // per.setUsuar(2);
        modSql.GuardarDatos(per);
        JOptionPane.showMessageDialog(null, "Registro Guardado");

        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtDepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadosMouseClicked
        int filaSelect = TablaEmpleados.rowAtPoint(evt.getPoint());
        this.txtcod.setText(String.valueOf(this.TablaEmpleados.getValueAt(filaSelect, 0)));
        txtNombre.setText(TablaEmpleados.getValueAt(filaSelect, 1).toString());
        txtDireccion.setText(TablaEmpleados.getValueAt(filaSelect, 2).toString());
        txtEdad.setText(TablaEmpleados.getValueAt(filaSelect, 3).toString());
        txtDni.setText(TablaEmpleados.getValueAt(filaSelect, 4).toString());
        txtCiudad.setText(TablaEmpleados.getValueAt(filaSelect, 5).toString());

        txtSueldoBase.setText("");
        txtSueldoBoni.setText("");
        txtDesc.setText("");
        txtHoras.setText("");
        txtSueldoNeto.setText(TablaEmpleados.getValueAt(filaSelect, 6).toString());
        if (TablaEmpleados.getValueAt(filaSelect, 7).toString().equals("Inactivo")) {
            txtInactivo.setSelected(true);
        } else {
            txtActivo.setSelected(true);
        }
        txtTelefono.setText(TablaEmpleados.getValueAt(filaSelect, 8).toString());
    }//GEN-LAST:event_TablaEmpleadosMouseClicked

    public void eliminarRegistros() {
        int filaSelecionada = TablaEmpleados.getSelectedRow();
        try {
            String SQL = "Delete from Empleados where Codigo=" + TablaEmpleados.getValueAt(filaSelecionada, 0);
            Statement st = con.createStatement();
            int n = st.executeUpdate(SQL);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar Registros" + e.getMessage());
        }
    }


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarRegistros();
        mostrarDatos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            insertar();
            mostrarDatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void ReportetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportetxtActionPerformed
      try {
        Conexion con = new Conexion();
      Connection conn=con.getConexion();
       JasperReport reporte=null;
       String path="src\\CRUD_Tienda\\Reporte1.jasper";
            reporte=(JasperReport)JRLoader.loadObjectFromFile(path);
              JasperPrint jprint=JasperFillManager.fillReport(reporte,null,conn);
              JasperViewer view =new JasperViewer(jprint,false);
              view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(EmpleadosJF.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    }//GEN-LAST:event_ReportetxtActionPerformed

    public void insertarDatos() {
        try {

            String SQL = "insert into usuarios() values(?,?,?,?,?)";
            /*  PreparedStatement pst=con.PrepareStatement(SQL);
          pst.setString(1,txtNombre.getText());
          pst.setString(2,txtApellidos.getText);
            .....
            
            
             */
        } catch (Exception e) {

        }
    }

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
            java.util.logging.Logger.getLogger(EmpleadosJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadosJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadosJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadosJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadosJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reportetxt;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton txtActivo;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JComboBox<String> txtDepa;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JRadioButton txtInactivo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldoBase;
    private javax.swing.JTextField txtSueldoBoni;
    private javax.swing.JTextField txtSueldoNeto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables
}
