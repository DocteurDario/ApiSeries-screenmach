package Servicio;

public interface IConvierteDatos {
    /////////////////////////////////////////////////////////////////////////////////
    //  Nuevo:
    //     - " <T> T " se utiliza cuando se desconoce que tipo de dato va a recibir
    //
    //     - tambien se puede utilizar para pasar una clase sin necesida de especificar
    //      que clase.
    /////////////////////////////////////////////////////////////////////////////////

    <T> T obtenerDatos( String json, Class<T> clase);

}
