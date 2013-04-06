/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;
import java.util.List;
import powerdsd.rest.TbRequisitoria;
import powerdsd.rest.TbRequisitoria_;
//import powerdsd.dao2.TbRequisitoria;

/**
 * Jersey REST client generated for REST resource:TbRequisitoriaFacadeREST
 * [domain.tbrequisitoria]<br>
 * USAGE:
 * <pre>
 *        ClienteREST client = new ClienteREST();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author u05521
 */
public class ClienteREST {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebRequisitoria/webresources";

    //private static final String BASE_URI = "http://localhost:8080/WEB-INF/webresources";
    public ClienteREST() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("domain.tbrequisitoria");
    }

    public void remove(String id) throws UniformInterfaceException {
        webResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    public <T> T findByDni(Class<T> responseType, String dni) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{dni}));
        return resource.get(responseType);
    }

    public String countREST() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void edit_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public void create_XML(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
    }

    public void create_JSON(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(requestEntity);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }

//    public static void main(String args[])throws UniformInterfaceException
//{
//
//ClienteREST client1=new ClienteREST();
//ClientResponse response=client1.findByDni(ClientResponse.class, "04001524");
//
//GenericType<List<TbRequisitoria>> genericType = new GenericType<List<TbRequisitoria>>() {};
//// Returns an ArrayList of Players from the web service
//List<TbRequisitoria> data= new ArrayList<TbRequisitoria>();
//data=(response.getEntity(genericType));
//System.out.println("Retreiving and Displaying Players Details");
//for( TbRequisitoria players:data ){
//System.out.println("IdReq: "+players.getIdReq());
//System.out.println("DniPersona: "+players.getDniPersona());
//System.out.println("CodDelito: "+players.getCodDelito());
//System.out.println("CodEstado:"+players.getCodEstado());
//} 
//    
//}
    public boolean validaRequisitoria(String dni) throws UniformInterfaceException {

        ClientResponse response = this.findByDni(ClientResponse.class, dni);

        GenericType<List<TbRequisitoria>> genericType = new GenericType<List<TbRequisitoria>>() {
        };

        // Returns an ArrayList of Players from the web service
        List<TbRequisitoria> data = new ArrayList<TbRequisitoria>();

        data = (response.getEntity(genericType));

        if (data.isEmpty()) {
            return false;
        } else {
            System.out.println("Retreiving and Displaying Players Details");

            for (TbRequisitoria players : data) {
                System.out.println("IdReq: " + players.getIdReq());
                System.out.println("DniPersona: " + players.getDniPersona());
                System.out.println("CodDelito: " + players.getCodDelito());
                System.out.println("CodEstado:" + players.getCodEstado());
            }
            return true;
        }
    }

    public List<TbRequisitoria> obtenerDatosRequisitoria(String dni) throws UniformInterfaceException, Exception {

        ClientResponse response = this.findByDni(ClientResponse.class, dni);

        GenericType<List<TbRequisitoria>> genericType = new GenericType<List<TbRequisitoria>>() {
        };
        
        List<TbRequisitoria> data =(response.getEntity(genericType));

        if (data.isEmpty()) {
            return null;
        } else { 
            return data;
        }
    }
}