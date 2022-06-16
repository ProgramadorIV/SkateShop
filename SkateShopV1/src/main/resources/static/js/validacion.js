
document.getElementById("nombre").addEventListener("blur", comprobarNombre);
document.getElementById("imagen").addEventListener("blur", comprobarImagen);
document.getElementById("marca").addEventListener("blur", comprobarMarca);
document.getElementById("precio").addEventListener("blur", comprobarPrecio);
document.getElementById("cantidad").addEventListener("blur", comprobarCantidad);


function revisarTodoElFormulario(){

    let resultado = false;

    resultado = comprobarNombre() &&
                comprobarImagen() &&
                comprobarMarca() &&
                comprobarPrecio() &&
                comprobarCantidad()

    formulario.enviar.className = resultado?"btn btn-success":"btn btn-danger";

    return resultado;
}

//

function comprobarNombre(){

    let campoNombre = formulario.nombre;
    let comprobacion = campoNombre.value!=="";
    let error;

    if(comprobacion){

        comprobacion = isNaN(campoNombre.value);

        if(comprobacion){

            campoNombre.value = camelizar(campoNombre.value);
        }
        else{
            error = "El nombre no puede ser unicamente numérico.";
        }
        
    }
    else{
        error = "Este campo no se puede quedar vacio."
    }

    cambiarApariencia(campoNombre, comprobacion, error);

    return comprobacion;
}

//Método para comprobar la url de la imagen, manda error si está vacia o si no coincide con una url de imagen.

function comprobarImagen(){

    let campoImagen = formulario.imagen;
    let comprobacion = campoImagen.value !=="";
    let error;

    if(comprobacion){

        comprobacion = isValidHttpUrl(imagen.value) && (imagen.value.endsWith(".jpg") || imagen.value.endsWith(".png"));

        if(!comprobacion){

            error = "El dato introducido no coincide con una url de imagen.";
        }
        
    }
    else{
        error = "Este campo no se puede quedar vacio.";
    }

    cambiarApariencia(campoImagen, comprobacion, error);

    return comprobacion;
}

//Método para comprobar si se selecciona una marca, si no coincide con ninguna de las marcas previstas da error.

function comprobarMarca(){

    let campoMarca = formulario.marca;
    let marcas = ["BD", "Dickies", "Element", "Grizzly", "Imagine", "Independent", "LuckyBearings", "Primitive", 
    "Real", "SkateShop", "Spitfire", "Venture"];
    let error;

    let comprobacion = marcas.includes(campoMarca.value);

    if(!comprobacion){

        error = "Debe marcar alguna de las marcas."
    }
    cambiarApariencia(campoMarca, comprobacion, error);

    return comprobacion;
}

//Da error si el input no es númerico.

function comprobarPrecio(){

    let campoPrecio = formulario.precio;
    let comprobacion = campoPrecio.value!=="";
    let error;

    if(comprobacion){
        
        if(campoPrecio.value<=0){
            error = "En esta tienda no regalamos nada.";
            comprobacion = false;
        }
    }
    else{
        error = "Este campo no se puede quedar vacio.";
    }
    cambiarApariencia(campoPrecio, comprobacion, error);
    
    return comprobacion;
}

//Da error si el input no es numérico.

function comprobarCantidad(){

    let campoCantidad = formulario.cantidad;
    let comprobacion = campoCantidad.value!=="";
    let error;

    if(comprobacion){

        if(campoCantidad.value <= 0){
            error = "El valor debe ser al menos 1.";
            comprobacion = false;

        }
        else if(!Number.isInteger(campoCantidad.value)){
            error = "El valor debe ser un entero.";
            comprobacion = false;

        }
    }
    else{
        error = "Este campo no se puede quedar vacio.";
    }
    cambiarApariencia(campoCantidad, comprobacion, error);

    return comprobacion;

}

//PASAR CAMPOS NECESARIOS AQUÍ.
function cambiarApariencia(campo, estado, error){

    if(estado){

        campo.classList.remove("border-danger");
		campo.classList.add("border-success");
        campo.parentNode.previousElementSibling.style.display = "none";
    }
    else{

        campo.classList.add("border-danger");
		campo.classList.remove("border-success");
        campo.parentNode.previousElementSibling.innerText = error;
        campo.parentNode.previousElementSibling.style.display = "block";
    }
}

//Métodos Helper

function isValidHttpUrl(string) {
    let url;
    
    try {
      url = new URL(string);
    } catch (_) {
      return false;  
    }
  
    return url.protocol === "http:" || url.protocol === "https:";
  }

  function camelizar(str){

    var palabras = str.split(" ");

    for(let i=0; i<palabras.length; i++){

        let palabritas = palabras[i].split('');
        palabritas[0] = palabritas[0].toUpperCase();
        palabras[i] = palabritas.join('');

    }
    
    return palabras.join(' ');
}

