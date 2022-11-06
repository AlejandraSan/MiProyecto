export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    descripcion: string;
    img: string;


    /* Se crea el modelo de persona
    this.nombre es la variable ingresada, nombre es el parámetro ingresado
    en el constructor, se guarda en this.nombre */
    constructor(nombre: string, apellido: string, descripcion: string, img: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
}




