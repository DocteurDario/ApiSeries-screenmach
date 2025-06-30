package com.aluracursos.screenmach;

import Servicio.ConsumoApi;
import Servicio.ConvierteDatos;
import com.aluracursos.screenmach.Principal.EjemploStreams;
import com.aluracursos.screenmach.Principal.Principal;
import com.aluracursos.screenmach.model.DatoTemporada;
import com.aluracursos.screenmach.model.DatosEpisodios;
import com.aluracursos.screenmach.model.DatosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.muestraElMenu();

		EjemploStreams ejemploStreams = new EjemploStreams();
		ejemploStreams.muestraEjemplo();

		/*
		var consumoApi = new ConsumoApi();

		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187");
		//var json2 = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=4fc7c187");
		//var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json"); game of thrones

		ConvierteDatos convierteDatos = new ConvierteDatos();
		var datosSerie = convierteDatos.obtenerDatos(json, DatosSerie.class);
		System.out.println(datosSerie);

		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=4fc7c187");
		DatosEpisodios datosEpisodios = convierteDatos.obtenerDatos(json, DatosEpisodios.class);
		System.out.println(datosEpisodios);


		List<DatoTemporada> temporadaList = new ArrayList<>();
		for( int i = 1 ; i <= datosSerie.totalDeTemporadas() ; i ++)
			{
				json = consumoApi.obtenerDatos
						("https://www.omdbapi.com/?t=game+of+thrones&Season="
								+i+"&apikey=4fc7c187");
				DatoTemporada datosTemporada = convierteDatos.obtenerDatos(json,DatoTemporada.class);

				temporadaList.add(datosTemporada);
			}
		//temporadaList.forEach(System.out::println);
		temporadaList.forEach( temporadalist->System.out.println(temporadalist));
	*/

	}

}
