

// *******************************************************************
// *******************************************************************
// ******                                                       ******
// ******               UTILIDADES JAVASCRIPT                   ******
// ******                                                       ******
// *******************************************************************
// *******************************************************************


//  +-------------------------------------------------+
//  |   agregarTextoAUnNodo                           |
//  |                                                 |
//  |   Añade un nodo-texto a un nodo existente,      |
//  |   como ultimo hijo                              |
//  +-------------------------------------------------+

function agregarTextoAUnNodo(nodopadre, texto) {
    nodopadre.appendChild(document.createTextNode(texto));
}


//  +-------------------------------------------------+
//  |   borrarContenidoDeNodo                         |
//  |                                                 |
//  |   Elimina todos el contenido de un nodo         |
//  |   Se incluyen dos versiones                     |
//  +-------------------------------------------------+

function borrarContenidoDeNodo(nodo) {

    // VERSION 1: Borrar su innerHTML
    // nodo.innerHTML = '';

    // VERSION 2: Eliminar todos los hijos en un bucle
    while (nodo.firstChild) {
        nodo.removeChild(nodo.firstChild);
    }
}


