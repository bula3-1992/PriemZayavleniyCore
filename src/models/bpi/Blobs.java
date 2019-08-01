/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.bpi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 003-0823
 */
@Entity
public class Blobs implements Serializable {

    @Id
    private String id;
    private byte[] body;
    private byte[] communicationBody;

    public Blobs() {

    }

    public String getId() {
        return this.id;
    }

    public byte[] getBody() {
        return this.body;
    }

    public byte[] getCommunicationBody() {
        return this.communicationBody;
    }

}
