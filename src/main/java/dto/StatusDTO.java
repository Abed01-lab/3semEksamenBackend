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
public class StatusDTO {
    private String verified;
    private String sentCount;

    public StatusDTO(String verified, String sentCount) {
        this.verified = verified;
        this.sentCount = sentCount;
    }
}
