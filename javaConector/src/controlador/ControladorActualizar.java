
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmMenu;


public class ControladorActualizar implements ActionListener, WindowListener, MouseListener{

    FrmActualizar fa = new FrmActualizar();
    FrmMenu fm = new FrmMenu();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorActualizar(FrmActualizar fa, PaisVO pvo, PaisDAO pdao) {
        this.fa = fa;
        this.pvo = pvo;
        this.pdao = pdao;
        
        fa.btnAceptar.addActionListener(this);
        fa.btnCancelar.addActionListener(this);
        fa.addWindowListener(this);
        fa.addMouseListener(this);
        
    }
    
    private void mostrar(){
            DefaultTableModel m = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; 
                }
              
            };
            
            // para que  la tabla este vacia.
            m.setColumnCount(0);
            // los encabezados de las columnas.
            m.addColumn("ID del Pais");
            m.addColumn("Nombre del Pais");
            m.addColumn("Capital dle Pais");
            m.addColumn("Poblacion del Pais");
            
            
            
           
            // llenamos la tabla.tipo PaisVO
            for (PaisVO pvo : pdao.consultar()) {
                //addRow recorre un array de objetos. este caso usara un array de objetos.
                m.addRow(new Object[]{pvo.getIdPais(), pvo.getNombrePais(), pvo.getCapitalPais(), pvo.getPoblacionPais()});
                
            }
            
            fa.tbActualizar.setModel(m);
            // en java swin definimos por los anchos de columna
            TableColumn cCero = fa.tbActualizar.getColumnModel().getColumn(0);
            cCero.setMaxWidth(75);
            cCero.setMinWidth(45);
            TableColumn cUno = fa.tbActualizar.getColumnModel().getColumn(1);
            cUno.setMaxWidth(200);
            cUno.setMinWidth(100);
        }
    
    
    private void leerActual(){
        
        fa.txtIdPais.setText((String.valueOf(fa.tbActualizar.getValueAt(fa.tbActualizar.getSelectedRow(), 0))));
        fa.txtNombrePais.setText((String) (fa.tbActualizar.getValueAt(fa.tbActualizar.getSelectedRow(), 1)));
        fa.txtCapital.setText((String) (fa.tbActualizar.getValueAt(fa.tbActualizar.getSelectedRow(), 2)));
        fa.txtPoblacion.setText(String.valueOf(fa.tbActualizar.getValueAt(fa.tbActualizar.getSelectedRow(), 3)));
        
    }
    
    private void actualizarValor(){
        this.pvo.setIdPais(Integer.parseInt( this.fa.txtIdPais.getText()));
        this.pvo.setNombrePais(( this.fa.txtNombrePais.getText()));
        this.pvo.setCapitalPais(( fa.txtCapital.getText()));
        pvo.setPoblacionPais(Long.parseLong (fa.txtPoblacion.getText()));
        this.pdao.actualizar(pvo);
    
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fa.btnCancelar) {
            fa.dispose();
           
            
        }
        if (e.getSource() == fa.btnAceptar){
            this.actualizarValor();
            this.mostrar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()== 1){
           this.leerActual();
         
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

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
