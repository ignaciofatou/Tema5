/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_XML.A_Champions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



/**
 *
 * @author Ignacio
 */
public class Partido {
    
    private String equipo1;
    private String equipo2;
    
    public Partido(String p_Equipo1, String p_Equipo2){
        equipo1 = p_Equipo1;
        equipo2 = p_Equipo2;
    }
    
    public Element getPartidoXML(Document documento, Element elementoRaiz){

        //Creamos el Elemento PARTIDO
        Element elementoPatido = documento.createElement("PARTIDO");
        elementoRaiz.appendChild(elementoPatido);

        //Crear un elemento EQUIPO 1 colgando de PARTIDO
        Element elementoEquipo1 = documento.createElement("EQUIPO");
        elementoPatido.appendChild(elementoEquipo1);        
        Text textoEquipo1 = documento.createTextNode(equipo1);
        elementoEquipo1.appendChild(textoEquipo1);

        //Crear un elemento EQUIPO 2 colgando de PARTIDO
        Element elementoEquipo2 = documento.createElement("EQUIPO");
        elementoPatido.appendChild(elementoEquipo2);
        Text textoEquipo2 = documento.createTextNode(equipo2);
        elementoEquipo2.appendChild(textoEquipo2);

        //Retornamos el Element
        return elementoPatido;
    }
    
}
