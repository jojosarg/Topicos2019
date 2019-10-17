package Vistas;

import Models.TblProducto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Producto extends Stage  {
    private Label[] lbCampos;
    public TextField txtID, txtNombre, txtCant, txtCosto, txtPrecio, txtTalla;
    private ComboBox cbxMarca;
    private VBox vFormulario;
    private HBox[] hBoxes;
    private Button btnGuardar;
    private Scene scene;
    private TblProducto objp;
    private TableView tbvTabla;
    public boolean editar=false;




    public Producto(TableView tbvTabla){
        CrearGUI();
        this.tbvTabla=tbvTabla;


        this.setTitle("Gestionar Producto");
        this.setScene(scene);
        this.show();
    }

    private void CrearGUI() {
        lbCampos=new Label[7];
        hBoxes=new HBox[7];
        btnGuardar=new Button("Guardar");
        btnGuardar.setOnAction(event->GuardarProducto());
        objp = new TblProducto();
        vFormulario=new VBox();
        String[] textos={"No","Descripcion","Existencia","Costo","Precio","Talla", "Marca"};
        for (int i = 0; i < lbCampos.length; i++) {

            lbCampos[i]=new Label(textos[i]);
            hBoxes[i]=new HBox();
            hBoxes[i].getChildren().add(lbCampos[i]);

        }
        txtID=new TextField();
        hBoxes[0].getChildren().add(txtID);
        txtNombre=new TextField();
        hBoxes[1].getChildren().add(txtNombre);
        txtCant=new TextField();
        hBoxes[2].getChildren().add(txtCant);
        txtCosto=new TextField();
        hBoxes[3].getChildren().add(txtCosto);
        txtPrecio=new TextField();
        hBoxes[4].getChildren().add(txtPrecio);
        txtTalla=new TextField();
        hBoxes[5].getChildren().add(txtTalla);
        cbxMarca=new ComboBox();
        hBoxes[6].getChildren().add(cbxMarca);

        vFormulario.getChildren().addAll(hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3],hBoxes[4],hBoxes[5],hBoxes[6],btnGuardar);
        scene=new Scene(vFormulario, 300,200);


    }

    private void GuardarProducto() {
        try {
        objp.setDscproducto(txtNombre.getText());
        objp.setCantidad(Integer.parseInt(txtCant.getText()));
        objp.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objp.setCosto(Float.parseFloat(txtCosto.getText()));
        objp.setTalla(txtTalla.getText());

        if (editar){
            objp.setIdproducto(Integer.parseInt(txtID.getText()));
            objp.upproducto();
        }
        else {
            objp.insproducto();
        }

        Alert alerta=new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensaje de sistema");
        alerta.setHeaderText("Confirmacion de operacion");
        alerta.setContentText("Operacion Exitosa :D");
        alerta.showAndWait();
        tbvTabla.setItems(objp.selallproducto());
        tbvTabla.refresh();
        this.close();

        }catch (Exception e){

        }

    }
}
