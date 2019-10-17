package Events;

import Models.TblProducto;
import Vistas.ProductosBD;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class BuscarProducto implements EventHandler<KeyEvent> {
    TblProducto objp=null;
    ProductosBD objbd=null;

    public BuscarProducto(ProductosBD objbd){
        this.objbd=objbd;
    }
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode().isLetterKey() || keyEvent.getCode().isWhitespaceKey()){
            System.out.println(objbd.txtBuscar.getText());
            objp=new TblProducto();
            objp.setDscproducto(objbd.txtBuscar.getText());
            objbd.tbvTabla.setItems(objp.selallprodbyname());
            objbd.tbvTabla.refresh();
        }

    }
}
