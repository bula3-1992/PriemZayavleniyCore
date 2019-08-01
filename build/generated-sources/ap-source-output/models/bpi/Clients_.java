package models.bpi;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, Date> sysTime;
    public static volatile SingularAttribute<Clients, Integer> id;
    public static volatile SingularAttribute<Clients, String> phone;
    public static volatile SingularAttribute<Clients, String> pfNom;
    public static volatile SingularAttribute<Clients, String> name;
    public static volatile SingularAttribute<Clients, Integer> userId;
    public static volatile SingularAttribute<Clients, Integer> providerId;
    public static volatile SingularAttribute<Clients, String> ptksCode;
    public static volatile SingularAttribute<Clients, Short> ctype;
    public static volatile SingularAttribute<Clients, Integer> senderId;
    public static volatile SingularAttribute<Clients, Date> createDate;
    public static volatile SingularAttribute<Clients, Integer> ownerPf;

}