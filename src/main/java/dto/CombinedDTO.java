/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author abed
 */
public class CombinedDTO {
    private String chuckNorrisJoke;
    private String dadJoke;
    private String swPlanet;
    private String catFacts;
    private String nbaSeasonPhase;

    public CombinedDTO(ChuckDTO chuckDto, DadDTO dadDto, SwapiDTO swapiDto, CatDTO catDto, NbaDTO nbaDto) {
        this.chuckNorrisJoke = chuckDto.getValue();
        this.dadJoke = dadDto.getJoke();
        this.swPlanet = swapiDto.getName();
        this.catFacts = catDto.getText();
        this.nbaSeasonPhase = nbaDto.getSeasonPhase();
    }

    public String getChuckNorrisJoke() {
        return chuckNorrisJoke;
    }

    public String getDadJoke() {
        return dadJoke;
    }

    public String getSwPlanet() {
        return swPlanet;
    }

    public String getCatFacts() {
        return catFacts;
    }

    public String getNbaSeasonPhase() {
        return nbaSeasonPhase;
    }
    
}
