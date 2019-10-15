package Components;

import Models.TblProducto;
import Vistas.Producto;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<TblProducto,String> {
    Button btnCelda;
    int opc;
    TblProducto objp;
    Producto objprod;
    public ButtonCell(int opc){
        this.opc=opc;
        if (opc==1){
            btnCelda=new Button("Editar");
            btnCelda.setOnAction(Event ->editar() );
        }
        else{
            btnCelda=new Button("Eliminar");
            btnCelda.setOnAction(Event ->eliminar());
        }
    }

    private void eliminar() {
        objp=ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
        objp.eliminar();
        ButtonCell.this.getTableView().setItems(objp.selallproducto());
        ButtonCell.this.getTableView().refresh();
        System.out.println("hola");
    }

    private void editar() {
        objprod=new Producto(ButtonCell.this.getTableView());

    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            setGraphic(btnCelda);
        }
    }
}
