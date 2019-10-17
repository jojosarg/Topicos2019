package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class TblProducto {
    private int idproducto;
    private String dscproducto;
    private int cantidad;
    private float costo;
    private float precio;
    private String talla;
    private int idmarca;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDscproducto() {
        return dscproducto;
    }

    public void setDscproducto(String dscproducto) {
        this.dscproducto = dscproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    //INSERTAR producto
    public void insproducto()throws Exception {

        String query="INSERT INTO productos (desc_producto, cantidad, costo, precio, talla, idmarca)  " +
                "VALUES ('"+dscproducto+"',"+cantidad+","+costo+","+precio+",'"+talla+"',2)";
        //try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        //}catch (Exception e){

        //}
    }
    //ACTULIZAR PRODUCTO
    public void upproducto(){
        String query="update productos SET desc_producto ='"+dscproducto+"', " +
                "cantidad="+cantidad+", costo="+costo+", precio="+precio+", " +
                "talla='"+talla+"' where idproducto = "+idproducto;
        try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();

        }

    }
    //BORRAR producto
    public void eliminar(){
        String query="delete from productos where idproducto = "+idproducto;
        try{
            Statement stm = Conexion.conexion.createStatement();
            stm.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();


        }

    }
    //Busqueda por nombre
    public ObservableList<TblProducto> selallprodbyname(){
        String query="select * from productos where desc_producto like '%"+dscproducto+"%' ";
        ObservableList<TblProducto> ListProd = FXCollections.observableArrayList();

        try {
            TblProducto objp = null;
            Statement stm = Conexion.conexion.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                objp = new TblProducto();
                objp.setIdproducto(resultSet.getInt("idproducto"));
                objp.setDscproducto(resultSet.getString("desc_producto"));
                objp.setCantidad(resultSet.getInt("cantidad"));
                objp.setCosto(resultSet.getFloat("costo"));
                objp.setPrecio(resultSet.getFloat("precio"));
                objp.setTalla(resultSet.getString("talla"));
                ListProd.add(objp);


            }

        } catch (Exception e) {

        }
        return ListProd;
    }


    //SELECCIONAR
    public ObservableList<TblProducto> selallproducto() {
        String query = "SELECT * FROM productos";
        ObservableList<TblProducto> ListProd = FXCollections.observableArrayList();

        try {
            TblProducto objp = null;
            Statement stm = Conexion.conexion.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                objp = new TblProducto();
                objp.setIdproducto(resultSet.getInt("idproducto"));
                objp.setDscproducto(resultSet.getString("desc_producto"));
                objp.setCantidad(resultSet.getInt("cantidad"));
                objp.setCosto(resultSet.getFloat("costo"));
                objp.setPrecio(resultSet.getFloat("precio"));
                objp.setTalla(resultSet.getString("talla"));
                ListProd.add(objp);


            }

        } catch (Exception e) {

        }
        return ListProd;
    }



}


