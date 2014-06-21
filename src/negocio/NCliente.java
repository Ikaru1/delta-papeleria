/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesoDato.Cliente;
import accesoDato.DataAccesObject;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vehimar
 */
public class NCliente {

    private DataAccesObject DAO;
    private Cliente cliente;
    private static int ERROR_NOMBRE = 0;
    private static int ERROR_ID = 1;

    /**
     * Inicializa la clase NCliente
     */
    public NCliente() {
        this.DAO = new DataAccesObject();
        this.cliente = new Cliente();
    }

    /**
     * agrea un nuevo cliente al catalago de cliente
     *
     * @param nombre
     */
    public void agregar(String nombre) {
        if (!nombre.isEmpty()) {
            cliente.setId(null);
            cliente.setNombre(nombre);
            DAO.insertarObject(cliente);
        } else {
        }
    }

    /**
     * retorna un cliente,buscandolo por el nombre
     *
     * @param nombre
     * @return
     */
    public Cliente obtener(String nombre) {
        String sql = "from Cliente where nombre like '%" + nombre + "%'";
        return (Cliente) DAO.getObject(sql);
    }

    /**
     * retorna un cliente, buscando por el id
     *
     * @param id
     * @return
     */
    public Cliente obtener(Integer id) {
        String sql = "from Cliente where id = " + id;
        return (Cliente) DAO.getObject(sql);
    }

    /**
     * retorna una LinkdedList de todos los clientes
     *
     * @return
     */
    public LinkedList<Cliente> listar() {
        LinkedList<Cliente> result = new LinkedList<>();
        List<Object> lista = DAO.listarObject("Cliente");
        for (int i = 0; i < lista.size(); i++) {
            Cliente auxLugar = (Cliente) lista.get(i);
            result.add(auxLugar);
        }
        return result;
    }

    /**
     * modifica, un cliente
     *
     * @param id
     * @param nombre
     */
    public void modificar(Integer id, String nombre) {
        cliente.setId(id);
        cliente.setNombre(nombre);
        DAO.modificarObject(cliente);
    }

    public static void main(String[] args) {
        NCliente ncliente = new NCliente();
        LinkedList<Cliente> lista = ncliente.listar();
        System.out.println(lista.size());
    }
}
