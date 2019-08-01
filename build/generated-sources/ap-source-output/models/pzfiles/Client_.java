package models.pzfiles;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.pzfiles.ClientType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> pfNom;
    public static volatile SingularAttribute<Client, Integer> status;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, ClientType> clientType;

}