package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.Statement;

public class TblMarca {
    private int idmarca;
    private String dscmarca;

    //concepto de encapsulamiento
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getDscmarca() {
        return dscmarca;
    }

    public void setDscmarca(String dscmarca) {
        this.dscmarca = dscmarca;
    }

    //INSERTAR MARCA
    public void insmarcar(){
        String query="INSERT INTO tblmarca (marca) VALUES ('"+dscmarca+"')";
        try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }
    }
    //ACTULIZAR
    public void upmarca(){
        String query="update tblmarca SET marca ='"+dscmarca+"' where idmarca = "+idmarca;
        try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }

    }
    //BORRAR MARCA
    public void delmarca(){
        String query="delete from tblmarca where idmarca = "+idmarca;
        try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){

        }

    }
    //SELECCIONAR
    public ObservableList<TblMarca> selallmarca() {
        String query = "SELECT * FROM tblmarca";
        ObservableList<TblMarca> ListMarca = FXCollections.observableArrayList();

        try {
            TblMarca objm = null;
            Statement stm = Conexion.conexion.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                objm = new TblMarca();
                objm.setIdmarca(resultSet.getInt("idmarca"));
                objm.setDscmarca(resultSet.getString("dscmarca"));
                ListMarca.add(objm);

                //investigar como se llena una lista observable
                //crear el dao de productos
            }

        } catch (Exception e) {

        }
        return ListMarca;
    }

    //SELECCIONAR POR ID DE LA MARCA
    public TblMarca selbyidmarca(){
        String query="select * from tblmarca where idmarca="+idmarca;
        TblMarca objm=null;
        try{
            Statement stm=Conexion.conexion.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            if (resultSet.next()){
                objm=new TblMarca();
                objm.setIdmarca(resultSet.getInt("idmarca"));
                objm.setDscmarca(resultSet.getString("dscmarca"));

            }
        }catch (Exception e){

        }
        return objm;
    }
}
