export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    img: String;


    /* Se crea el modelo de persona
    this.nombre es la variable ingresada, nombre es el parámetro ingresado
    en el constructor, se guarda en this.nombre */
    constructor(nombre: String,apellido: String, img: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
}




