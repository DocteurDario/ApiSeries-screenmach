package com.aluracursos.screenmach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodios(
            @JsonAlias("Title")
            String titulo,

            @JsonAlias("Episode")
            Integer numeroEpisodio,

            @JsonAlias("imdbRating")
            String evaluacion,

            @JsonAlias("Released")
            String fechaDeLanzamiento
        ) { }
/*
"Title": "Winter Is Coming",
        "Year": "2011",
        "Rated": "TV-MA",
        "Released": "17 Apr 2011",
        "Season": "1",
        "Episode": "1",
        "Runtime": "62 min",
        "Genre": "Action, Adventure, Drama",
        "Director": "Timothy Van Patten",
        "Writer": "David Benioff, D.B. Weiss, George R.R. Martin",
        "Actors": "Sean Bean, Mark Addy, Nikolaj Coster-Waldau",
        "Plot": "Lord Eddard Stark is concerned by news of a deserter from the Night's Watch; King Robert I Baratheon and the Lannisters arrive at Winterfell; the exiled Prince Viserys Targaryen forges a powerful new alliance.",
        "Language": "English",
        "Country": "United States",
        "Awards": "N/A",
        "Poster": "https://m.media-amazon.com/images/M/MV5BZDU5ZGEzODYtYWVlNC00NjYyLWJjOWYtYmNhZTc2MzUwYTliXkEyXkFqcGc@._V1_SX300.jpg",
        "Ratings": [
        {
        "Source": "Internet Movie Database",
        "Value": "8.9/10"
        }
        ],
        "Metascore": "N/A",
        "imdbRating": "8.9",
        "imdbVotes": "59069",
        "imdbID": "tt1480055",
        "seriesID": "tt0944947",
        "Type": "episode",
        "Response": "True"
        }

 */