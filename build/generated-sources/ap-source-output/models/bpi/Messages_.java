package models.bpi;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(Messages.class)
public class Messages_ { 

    public static volatile SingularAttribute<Messages, byte[]> body;
    public static volatile SingularAttribute<Messages, Short> addtype;
    public static volatile SingularAttribute<Messages, String> status;
    public static volatile SingularAttribute<Messages, Short> direction;
    public static volatile SingularAttribute<Messages, Integer> signerId;
    public static volatile SingularAttribute<Messages, Date> sendTime;
    public static volatile SingularAttribute<Messages, byte[]> communicationBody;
    public static volatile SingularAttribute<Messages, Integer> senderId;
    public static volatile SingularAttribute<Messages, String> messageType;
    public static volatile SingularAttribute<Messages, String> id;
    public static volatile SingularAttribute<Messages, Integer> receiverId;
    public static volatile SingularAttribute<Messages, String> container;
    public static volatile SingularAttribute<Messages, String> transId;
    public static volatile SingularAttribute<Messages, Date> receiveTime;
    public static volatile SingularAttribute<Messages, Integer> providerId;
    public static volatile SingularAttribute<Messages, Date> providerTime;
    public static volatile SingularAttribute<Messages, String> comment;

}