
// esto es una funcion de javaScrpt que tiene de seleccionar una tabla y
// agregarle paginacion y mas
$(document).ready(function() {
    //Cuando la pagina se inicia esto es lo primero que se carga
    cargarHogares();
    //Actualiza el Email del usuario
    //$('#hogares').DataTable();
    //actualizarEmailDelUsuario();

});

let hogarSeleccionado = {};

async function cargarHogares() {
    //con await espera el resultado, asi que se le agrega a la funcion que es asincronica async
    const request = await fetch('api/hogares', {
        method: 'GET', //metodo GET
        //headers: getHeaders()
    });
    //la respuesta se esta convirtiendo en JSON
    const hogares = await request.json();

    let listadoHtml = '';
    for(let hogar of hogares){
        let color;
        let estadoTexto ;
        let botonOn;
        let botonOff;
        if(hogar.estado == 1){
            if(hogar.tipo == 'Luz'){
                estadoTexto = 'Encendido';
                botonOn = 'Encender';
                botonOff = 'Apagar';
            }else{
                botonOn = 'Abrir';
                botonOff = 'Cerrar';
                estadoTexto = 'Abierto';
            }
            color = "green";
        }else{
            if(hogar.tipo == 'Luz'){
                estadoTexto = 'Apagado';
                botonOn = 'Encender';
                botonOff = 'Apagar';
            }else{
                botonOn = 'Abrir';
                botonOff = 'Cerrar';
                estadoTexto = 'Cerrado';
            }
            color = "red";
        }

        let botonEncender = '<a href="#" onclick="encender('+hogar.pin+')" class="btn btn-info">'+ botonOn +'</a>';
        let botonApagar = '<a href="#" onclick="apagar('+hogar.pin+')" class="btn btn-secondary">'+ botonOff +'</a>';

        //Estamos consultando esta condicional donde preguntamos si es nulo entonces se agregara - sino el telefono
        //let telefono = usuario.telefono == null ? '-' : usuario.telefono;

        let hogarHtml = '<tr>\n' +
            '                  <td>'+hogar.id+'</td>\n' +
            '                  <td>'+hogar.tipo+'</td>\n' +
            '                  <td>'+hogar.nombre+'</td>\n' +
            '                  <td>'+hogar.pin+'</td>\n' +
            '                  <td style="color:'+color+';" ><strong>'+estadoTexto+'</strong></td>\n' +
            '                  <td>'+botonEncender+'</td>\n' +
            '                  <td>'+botonApagar+'</td>\n' +
            '                  <td></td>\n' +
            '             </tr>';
        listadoHtml += hogarHtml;
    }

    console.log(hogares);

    document.querySelector('#hogares tbody').outerHTML = listadoHtml;
}


async function encender(pin) {
    let encender;
    //con await espera el resultado, asi que se le agrega a la funcion que es asincronica async
    const request = await fetch('api/hogares/'+pin, {
        method: 'GET', //metodo GET
        //headers: getHeaders()
    });
    //la respuesta se esta convirtiendo en JSON
    let hogar = await request.json();

    if(hogar.tipo == 'Luz'){
        encender = 'encender';
    }else{
        encender = 'Abrir';
    }

    //con confirm mostramos un cartel de pregunta si le click a si devuelve "true" sino "false"
    if(!confirm('¿Desea '+ encender +' la '+ hogar.tipo +' del '+hogar.nombre+' ?')){
        return ;
    }
    hogar.estado = 1;

    //con await espera el resultado, asi que se le agrega a la funcion que es asincronica async
    const request1 = await fetch('api/hogares', {
        method: 'PUT', //metodo PUT
        headers: {//tipos que se aceptara
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, //Esto lo que hace es convertir objeto de JavaScript y lo convierte a JSON
        body:await JSON.stringify(hogar)
    });
    //actualiza para que se visualice los cambios
    location.reload();
    alert("La solicitud fue un exito Exito.");
    //window.location.href = 'login.html';
}


async function apagar(pin) {
    let apagar;
    //con await espera el resultado, asi que se le agrega a la funcion que es asincronica async
    const request = await fetch('api/hogares/'+pin, {
        method: 'GET', //metodo GET
        //headers: getHeaders()
    });
    //la respuesta se esta convirtiendo en JSON
    let hogar = await request.json();

    if(hogar.tipo == 'Luz'){
        apagar = 'apagar';
    }else{
        apagar = 'cerrar';
    }

    //con confirm mostramos un cartel de pregunta si le click a si devuelve "true" sino "false"
    if(!confirm('¿Desea '+ apagar +' la '+ hogar.tipo +' del '+hogar.nombre+' ?')){
        return ;
    }
    hogar.estado = 0;

    //con await espera el resultado, asi que se le agrega a la funcion que es asincronica async
    const request1 = await fetch('api/hogares', {
        method: 'PUT', //metodo PUT
        headers: {//tipos que se aceptara
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, //Esto lo que hace es convertir objeto de JavaScript y lo convierte a JSON
        body:await JSON.stringify(hogar)
    });
    //actualiza para que se visualice los cambios
    location.reload();
    alert("La solicitud fue un exito Exito.");
    //window.location.href = 'login.html';


}
