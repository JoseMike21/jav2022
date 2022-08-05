
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.FrmMostrar;

// windowListener interacuta con el comportamiento de la ventana
public class ControladorMostar implements ActionListener, WindowListener{

     // creamos la estructura basica, llamaos a las ventanas que tengan interaccion
        FrmMostrar vMo = new FrmMostrar();
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        
        // el constructor
        public ControladorMostar(FrmMostrar vMo, PaisVO pvo, PaisDAO pdao){
            this.vMo = vMo;
            this.pvo = pvo;
            this.pdao = pdao;
            // para el boton
            vMo.btnCancelar.addActionListener(this);
            //para la ventana
            vMo.addWindowListener(this); 
           
        }
    
        // ahora el metodo que va a llenar los valores en la tabla de la vista
        private void mostrar(){
            DefaultTableModel m = new DefaultTableModel();
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
            
            vMo.tblMostrar.setModel(m);
            // en java swin definimos por los anchos de columna
            TableColumn cCero = vMo.tblMostrar.getColumnModel().getColumn(0);
            cCero.setMaxWidth(75);
            cCero.setMinWidth(45);
            TableColumn cUno = vMo.tblMostrar.getColumnModel().getColumn(1);
            cUno.setMaxWidth(200);
            cUno.setMinWidth(100);
                    
            
        }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vMo.btnCancelar){
            vMo.dispose();
        }
    }
//utilizaremos este, para que cuando abra la ventana se ejecute.
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
        
    }
    
}
