package Vistas;

import Components.ButtonCell;
import Models.TblProducto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ProductosBD extends Stage {
    private Scene escena;
    private TextField txtBuscar;
    private HBox hBuscar;
    private VBox vFormulario;
    private Button btnBuscar, btnAgregar;
    private TableView tbvTabla;

    public ProductosBD(){
        CrearGUI();
        this.setTitle("Formulario");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        hBuscar=new HBox();
        btnBuscar=new Button("Buscar");
        txtBuscar=new TextField();
        hBuscar.getChildren().addAll(txtBuscar,btnBuscar);
        tbvTabla=new TableView<>();
        CrearTabla();
        btnAgregar=new Button("Agregar");
        btnAgregar.setOnAction(event->abrirFormulario());
        vFormulario=new VBox();
        vFormulario.getChildren().addAll(hBuscar,tbvTabla,btnAgregar);
        escena=new Scene(vFormulario);
    }

    private void abrirFormulario() {
        Producto ventanaProd=new Producto(tbvTabla);
    }

    private void CrearTabla() {
        TableColumn<TblProducto, Integer> tcId = new TableColumn<>("id");
        tcId.setCellValueFactory(new PropertyValueFactory<>("idproducto"));

        TableColumn<TblProducto, String> tcDesc = new TableColumn<>("Nombre");
        tcDesc.setCellValueFactory(new PropertyValueFactory<>("dscproducto"));

        TableColumn<TblProducto, Integer> tcCant = new TableColumn<>("Stock");
        tcCant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<TblProducto, Float> tcCost = new TableColumn<>("Costo");
        tcCost.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<TblProducto, Float> tcPrec = new TableColumn<>("Precio");
        tcPrec.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<TblProducto, String> tcSize = new TableColumn<>("Talla");
        tcSize.setCellValueFactory(new PropertyValueFactory<>("Talla"));

        TableColumn<TblProducto, String> tcEditar=new TableColumn<>("Editar");
        tcEditar.setCellFactory(new Callback<TableColumn<TblProducto, String>, TableCell<TblProducto, String>>() {
            @Override
            public TableCell<TblProducto, String> call(TableColumn<TblProducto, String> tblProductoStringTableColumn) {
                return new ButtonCell(1);
            }
        });

        TableColumn<TblProducto, String> tcEliminar=new TableColumn<>("Eliminar");
        tcEliminar.setCellFactory(new Callback<TableColumn<TblProducto, String>, TableCell<TblProducto, String>>() {
            @Override
            public TableCell<TblProducto, String> call(TableColumn<TblProducto, String> tblProductoStringTableColumn) {
                return new ButtonCell(2);
            }
        });

        tbvTabla.getColumns().addAll(tcId,tcDesc,tcCant,tcCost,tcPrec,tcSize,tcEditar,tcEliminar);
        TblProducto objp=new TblProducto();
        tbvTabla.setItems(objp.selallproducto());
        System.out.println("");
    }

}
