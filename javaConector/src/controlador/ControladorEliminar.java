
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmEliminar;

public class ControladorEliminar implements ActionListener, MouseListener, WindowListener{
    FrmEliminar vElim = new FrmEliminar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    

    public ControladorEliminar(FrmEliminar vElim, PaisVO pvo, PaisDAO pdao) {
        this.vElim = vElim;
        this.pvo = pvo;
        this.pdao = pdao;
        
        
        this.vElim.btnCancelar.addActionListener(this);
        this.vElim.btnAceptar.addActionListener(this);
        this.vElim.addMouseListener(this);
        this.vElim.addWindowListener(this);
        
    }
    
    // ahora el metodo que va a llenar los valores en la tabla de la vista
        private void mostrar(){
            DefaultTableModel m = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
            
            vElim.tbEliminar.setModel(m);
            // en java swin definimos por los anchos de columna
            TableColumn cCero = vElim.tbEliminar.getColumnModel().getColumn(0);
            cCero.setMaxWidth(75);
            cCero.setMinWidth(45);
            TableColumn cUno = vElim.tbEliminar.getColumnModel().getColumn(1);
            cUno.setMaxWidth(200);
            cUno.setMinWidth(100);
                    
 
        }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object valor;
         if(e.getSource() == vElim.btnCancelar){
            vElim.dispose();
        }
         
         if(e.getSource() == vElim.btnAceptar){            
            pdao.eliminar((int) (vElim.tbEliminar.getValueAt(vElim.tbEliminar.getSelectedRow(), 0)));
            this.mostrar();
         }
         
         
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
         this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
         this.mostrar();
    }

    

    
}
