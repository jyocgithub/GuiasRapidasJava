// ===================================================================
//   FECHAS EN JAVASCRIPT
// ===================================================================

// ===================================================================
//   CREAR FECHA
// ===================================================================

var date = new Date("2001-12-31");
var date2 = new Date(1998, 9, 30, 13, 40, 05);
var date3 = new Date(1223727718982);
console.log(date);
console.log(date2);
console.log(date3);


var datehoy = new Date();
console.log(datehoy); // en formato fecha
var datehoy2 = Date.now();
console.log(datehoy2); // en timpestamp

// ===================================================================
//   FORMATEAR FECHA
// ===================================================================

var fechaformateada = datehoy.toLocaleDateString();
var fechaformateadaSpain = Intl.DateTimeFormat("es-ES").format(datehoy)
console.log(fechaformateada); // foarmto mas/dia/año
console.log(fechaformateadaSpain); // foarmto dia/mes/año



// ===================================================================
//   COMPARAR FECHAS
// ===================================================================
// comparar puede ser con > o < pero para igual se usasu timestamp
if (date > date2) {
    console.log("mayor " + date);
} else {
    console.log("mayor " + date2);
}


var date8 = new Date(1998, 9, 30, 13, 40, 05);
var date9 = new Date(1998, 9, 30, 13, 40, 05);
// if (date8 === date9) {    // NO FUNCIONA, son objetos, asi compara referencias
if (date8.getTime() === date9.getTime()) {
    console.log("iguales");
} else {
    console.log("distintas");

}



// ===================================================================
//   OBTENER INFORMACION DE LA FECHA
// ===================================================================
console.log(date.getFullYear()) // 2001
console.log(date.getMonth()) // 11 (zero-based index)
console.log(date.getDate()) // 31
console.log(date.getDay()) // 1 (zero-based index starting from Sunday)
console.log(date.getHours()) // 1
console.log(date.getMinutes()) // 0



// ===================================================================
//   CAMBIAR CONTENIDO DE UNA FECHA
// ===================================================================
date.setYear(1998);
date.setMonth(4);
date.setDate(12);
date.setHours(12);
date.setMinutes(21);