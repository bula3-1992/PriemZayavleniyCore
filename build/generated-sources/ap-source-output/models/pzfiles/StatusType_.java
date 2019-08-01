package models.pzfiles;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.pzfiles.Filestore;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(StatusType.class)
public class StatusType_ { 

    public static volatile SingularAttribute<StatusType, String> description;
    public static volatile CollectionAttribute<StatusType, Filestore> filestoreCollection;
    public static volatile SingularAttribute<StatusType, String> type;

}