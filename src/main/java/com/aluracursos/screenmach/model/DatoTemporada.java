package com.aluracursos.screenmach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoTemporada(
        @JsonAlias("Season")
        Integer numero,
        @JsonAlias("Episodes")
        List<DatosEpisodios> episodios
) {}
