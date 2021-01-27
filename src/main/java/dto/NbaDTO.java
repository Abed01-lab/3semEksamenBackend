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
public class NbaDTO {
    private String seasonYear;
    private String seasonPhase;
    private String version;
    private String lastUpdated;

    public NbaDTO(String seasonYear, String seasonPhase, String version, String lastUpdated) {
        this.seasonYear = seasonYear;
        this.seasonPhase = seasonPhase;
        this.version = version;
        this.lastUpdated = lastUpdated;
    } 

    public String getSeasonPhase() {
        return seasonPhase;
    }
}
