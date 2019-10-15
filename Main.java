package sample;

import Events.EventoBoton;
import Events.EventoVentana;
import Vistas.BuscaMinas;
import Vistas.ProductosBD;
import Vistas.Taquimecanografo;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements EventHandler {

    private Scene escena;
    private BorderPane contedor;
    private MenuBar mnbMenu;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem mitBuscaMinas, mitSalir, mitTaqui, mitBD;

    private Button btnEjemplo;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        contedor = new BorderPane();
        mnbMenu = new MenuBar();
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        menSalir = new Menu("Salir");
        mnbMenu.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);

        mitBuscaMinas = new MenuItem("Busca Minas");
        mitBuscaMinas.setOnAction(event -> EventosMenu(1));
        mitTaqui=new MenuItem("taquimecanografo");
        mitTaqui.setOnAction(event -> EventosMenu(2));
        mitBD=new MenuItem("Base de Datos");
        mitBD.setOnAction(actionEvent -> EventosMenu(3));

        mitSalir = new MenuItem("Bye :)");
        mitSalir.setOnAction(event -> EventosMenu(100));
        menSalir.getItems().add(mitSalir);

        menCompetencia1.getItems().addAll(mitBuscaMinas, mitTaqui, mitBD);


        //btnEjemplo = new Button("Ejemplo");
        //contedor.setCenter(btnEjemplo);

        //btnEjemplo.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        //btnEjemplo.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoBoton());
        /*btnEjemplo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Manejo de evento directo");
            }
        });
        btnEjemplo.setOnAction(event -> {
            System.out.println("Manejo de evento lambda");
        });*/
        //btnEjemplo.setOnAction(event -> EventosMenu(1));
        //btnEjemplo2.setOnAction(event-> EventosMenu(2));

        contedor.setTop(mnbMenu);
        escena = new Scene(contedor,300,60);
        escena.getStylesheets().add(getClass().getResource("../CSS/Estilos.css").toExternalForm());
        escena.getStylesheets().add(getClass().getResource("../CSS/BootStrap3.css").toExternalForm());

        primaryStage.addEventFilter(WindowEvent.WINDOW_SHOWN,new EventoVentana());
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Hola mundo de los eventos :)");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    private void EventosMenu(int opc) {
        switch (opc){
            case 1: new BuscaMinas();           break;
            case 2: new Taquimecanografo();     break;
            case 3: new ProductosBD();          break;
            case 100: System.exit(0);

        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        BuscaMinas objBM = new BuscaMinas();
    }
}
