/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_XML.B_Tiempo;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ignacio
 */
public class Localidad {
    
    private final String DATOS_AEMET = "http://www.aemet.es/xml/municipios/localidad_";
    private final String EXTENSION   = ".xml";
    public  int cod_ciudad;
    private int temperaturaMaxima;
    private int temperaturaMinima;
    
    public Localidad(int cod_ciudad){
        this.cod_ciudad = cod_ciudad;
        getDatosXML();
    }
    
    private void getDatosXML(){
        //Generamos el Enlace para Obtener los Datos
        String enlaceCiudad = DATOS_AEMET + this.cod_ciudad + EXTENSION;
        
        try {
            DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(enlaceCiudad);
            
            //Obtener el elemento raíz del documento
            Element raiz = documento.getDocumentElement();
            
            Attr predicc = raiz.getAttributeNode("prediccion");
            
            
            
            //Recuperamos el Nodo de Prediccion (Solo hay uno)
            Node prediccion = raiz.getElementsByTagName("prediccion").item(0);
            
            //Obtener la lista de los datos que contiene esa prediccion
            NodeList fechas = prediccion.getChildNodes();
            
            //Recorrer la lista de fechas
            for(int i=0; i<fechas.getLength(); i++) {
                //Obtener de la lista una fecha tras otra
                Node fecha = fechas.item(i);
                
                
                if (fecha.getNodeType()==Node.ELEMENT_NODE) {
                    System.out.println("Dato: " + fecha.getNodeName());
                    
                    
                    fecha.getAttributes().getNamedItem("descripcion").getTextContent());
                }
                

            }
            
            
            
            //Obtener la lista de nodos que tienen etiqueta "temperatura"
            //NodeList listaTemperatura = raiz.getElementsByTagName("temperatura");
            
            //Recorrer la lista de temperatura
            //for(int i=0; i<listaTemperatura.getLength(); i++) {
                //Obtener de la lista una temperatura tras otra
            //    Node temperatura = listaTemperatura.item(i);
                
                
           // }

            
            
            
        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
            ex.printStackTrace();
        }        
    }
    
    
}
