package models.pzfiles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.pzfiles.Client;
import models.pzfiles.ContentFile;
import models.pzfiles.DirectionType;
import models.pzfiles.MessageType;
import models.pzfiles.StatusType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(Filestore.class)
public class Filestore_ { 

    public static volatile SingularAttribute<Filestore, String> comm;
    public static volatile SingularAttribute<Filestore, Short> addtype;
    public static volatile SingularAttribute<Filestore, StatusType> status;
    public static volatile SingularAttribute<Filestore, DirectionType> direction;
    public static volatile SingularAttribute<Filestore, Date> sendTime;
    public static volatile SingularAttribute<Filestore, Integer> signerId;
    public static volatile SingularAttribute<Filestore, Client> senderId;
    public static volatile CollectionAttribute<Filestore, ContentFile> contentFileCollection;
    public static volatile SingularAttribute<Filestore, MessageType> messageType;
    public static volatile SingularAttribute<Filestore, String> id;
    public static volatile SingularAttribute<Filestore, Client> receiverId;
    public static volatile SingularAttribute<Filestore, String> transId;
    public static volatile SingularAttribute<Filestore, String> container;
    public static volatile SingularAttribute<Filestore, Date> receiveTime;
    public static volatile SingularAttribute<Filestore, Client> providerId;
    public static volatile SingularAttribute<Filestore, Date> providerTime;

}