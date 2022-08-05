
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmInsertar;

public class ControladorInsertar implements ActionListener {

    FrmInsertar vIn = new   FrmInsertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorInsertar (FrmInsertar vIn, PaisVO pvo, PaisDAO pdao){
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vIn.btnRegistrar.addActionListener(this);
        vIn.btnCancelar.addActionListener(this);
    }
    
    private void registrarPais() {
	// el set escribe lo que obtiene del get que pide info a la vista.
	this.pvo.setNombrePais(this.vIn.jtxtNombrePais1.getText());
	this.pvo.setCapitalPais(vIn.jtxtCapitalPais.getText());
	this.pvo.setPoblacionPais(Long.parseLong(this.vIn.jtxtPoblacionPais.getText()));
        //usamos un metodo que obtenga la fecha del dia
        // creamos una nueva clase llamada extras.java, donde usaremos el metodo para llamar la hora
        this.pvo.setFechaIngPais(Extras.fechaHoy());
        
        //pdao.insertar(pvo);
        // aca estamos haciendo su retorno
       
        if(pdao.insertar(pvo) == true){
            vIn.jopMensaje.showMessageDialog(vIn, "Datos Registrados correctamente");
            this.vIn.jtxtNombrePais1.setText("");
            this.vIn.jtxtCapitalPais.setText("");
            this.vIn.jtxtPoblacionPais.setText("");

        }else{
            vIn.jopMensaje.showMessageDialog(vIn, "Error, Datos no  Registrados");
            this.vIn.jtxtNombrePais1.setText("");
            this.vIn.jtxtCapitalPais.setText("");
            this.vIn.jtxtPoblacionPais.setText("");
    }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // que boton tiene interaccion.
        if (e.getSource()== vIn.btnRegistrar) {
            if(!this.vIn.jtxtNombrePais1.getText().equals("")&& !this.vIn.jtxtCapitalPais.getText().equals("") && !this.vIn.jtxtPoblacionPais.getText().equals("")){
            this.registrarPais();    
            }else{
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe llenar todos los campos.");
            }
            
        }
        if(e.getSource()== vIn.btnCancelar){
            vIn.dispose();
        }
    
    
        } 
	

}
