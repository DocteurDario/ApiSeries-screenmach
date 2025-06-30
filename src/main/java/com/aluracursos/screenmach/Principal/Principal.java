package com.aluracursos.screenmach.Principal;

import Servicio.ConsumoApi;
import Servicio.ConvierteDatos;
import Servicio.IConvierteDatos;
import com.aluracursos.screenmach.model.DatoTemporada;
import com.aluracursos.screenmach.model.DatosEpisodios;
import com.aluracursos.screenmach.model.DatosSerie;
import com.aluracursos.screenmach.model.Episodio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado= new Scanner(System.in);

    private ConsumoApi consumoApi = new ConsumoApi();

    private final String URL_BASE = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=4fc7c187";

    private ConvierteDatos convierte = new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Por favor escribir el nombre de la serie que deseas buscar");

        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + API_KEY);
        var datos = convierte.obtenerDatos( json , DatosSerie.class);

        //Busca los datos de todas las temporadas
        List<DatoTemporada> temporadaList = new ArrayList<>();
        for( int i = 1 ; i <= datos.totalDeTemporadas() ; i ++)
        {
            json = consumoApi.obtenerDatos
                    (URL_BASE+nombreSerie.replace(" ","+")+"&Season="
                            +i+"&apikey=4fc7c187");
            DatoTemporada datosTemporada = convierte.obtenerDatos(json,DatoTemporada.class);

            temporadaList.add(datosTemporada);
        }
        //temporadaList.forEach(System.out::println);
        //temporadaList.forEach( temporadalist->System.out.println(temporadalist));

        /*
        for (int i =0; i < datos.totalDeTemporadas(); i ++)
        {
            List<DatosEpisodios> episodiosTemporada =  temporadaList.get(i).episodios();
            for (int j =0 ; j < episodiosTemporada.size(); j++){
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }
*/
        //simplificar la linea de arriba en una sola. utilizando funciones lambda:
        temporadaList.forEach(t->t.episodios().forEach(e->System.out.println(e.titulo())));

        //Convertit todas las informaciones a una lista del tipo Datos Episodios

        List<DatosEpisodios>datosEpisodios =temporadaList.stream()
                .flatMap(t->t.episodios().stream()).collect(Collectors.toList());



        //top 5 mejores.
        System.out.println("Top 5 :");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisodios::evaluacion).reversed())
                .limit((5))
                .forEach(System.out::println);

        //Convertir los datos a una lista de tipo Episodios
        List<Episodio> episodios =  temporadaList.stream()
                .flatMap ( t -> t.episodios().stream()
                .map( d -> new Episodio(t.numero(),d)))
                .collect(Collectors.toList());

        // Busqueda de episodios a partir de x año
        System.out.println(" Por favor  indicar el año a partir del cual desas ver los episodios");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha,1,1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter( e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach( e ->  System.out.println( "Temporada " + e.getTemporada() +
                        "Episodio " +  e.getTitulo() +
                        "Fecha de Lanzamiento " +  e.getFechaDeLanzamiento()
                ));


//        //Buscar episodio por un pedazo del titulo:
//        System.out. println("Por favor escribir el titulo del episodio que desea ver");
//        var pedazoTitulo = teclado.nextLine();
//        Optional<Episodio>episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
//                .findFirst();
//        if(episodioBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Los datos son: " + episodioBuscado.get());
//        }else{
//            System.out.println("Episodio no encontrado" );
//        }
        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter( e-> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        // DoubleSummaryStatistics : es una clase y trae un metodo toString.
        // trae:
        // //count=69, sum=604,900000, min=4,000000, average=8,766667, max=9,900000
        // contar los registros, la suma de las evaluaciones, el minimo, el promedio, maximo.
        DoubleSummaryStatistics est = episodios.stream()
                .filter( e -> e.getEvaluacion() > 0.0)
                .collect( Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println(est);
        //se puede personalizar de la siguiente forma:
        System.out.println(" Media de las evaluaciones: " + est.getAverage());
        System.out.println("Episodio mejor evaluado " + est.getMax());
        System.out.println("Episodio Por evaluado:  " + est.getMin());
     }


}
