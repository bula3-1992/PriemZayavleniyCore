package models.pzfiles;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.pzfiles.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(ClientType.class)
public class ClientType_ { 

    public static volatile SingularAttribute<ClientType, Short> idType;
    public static volatile CollectionAttribute<ClientType, Client> clientCollection;
    public static volatile SingularAttribute<ClientType, String> description;

}