package models.bpi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(Blobs.class)
public class Blobs_ { 

    public static volatile SingularAttribute<Blobs, String> id;
    public static volatile SingularAttribute<Blobs, byte[]> body;
    public static volatile SingularAttribute<Blobs, byte[]> communicationBody;

}