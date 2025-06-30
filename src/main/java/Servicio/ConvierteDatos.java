package Servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{

    // Se utiliza para mapear los datos.
    private ObjectMapper objectMapper = new ObjectMapper();


    //Este metodo recibe un json y una clase
    //luego la retorna, pero lo que va a hacer objectMapper.readValue(json,class)
    // es tranformar el json en la clase que le pasemos.
    // Como el metodo puede retornar un EXCEPTIO el IDE pide que lo trate.
    // Puedo pedir al metodo que lo trate, o poner un try catch.
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }





}
