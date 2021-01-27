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
public class CatDTO {
    private String used;
    private String source;
    private String type;
    private String deleted;
    private String _id;
    private String __v;
    private String text;
    private String updatedAt;
    private String createdAt;
    private StatusDTO status;
    private String user;

    public CatDTO(String used, String source, String type, String deleted, String _id, String __v, String text, String updatedAt, String createdAt, StatusDTO status, String user) {
        this.used = used;
        this.source = source;
        this.type = type;
        this.deleted = deleted;
        this._id = _id;
        this.__v = __v;
        this.text = text;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.user = user;
    }

    public String getText() {
        return text;
    }
    
} 
