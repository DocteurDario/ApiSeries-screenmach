package com.aluracursos.screenmach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// la notacion @JsonIgnoreProperties( innoreUnknown = true)
// se utiliza para el error "UnrecognizedPropertyException: Unrecognized field "Year" "
// para que si encuentra alguna propiedad de json que no reconozca la ignore.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title")
        String titulo,

        @JsonAlias("totalSeasons")
        Integer totalDeTemporadas,

        @JsonAlias("imdbRating")
        String evaluacion ){
}
