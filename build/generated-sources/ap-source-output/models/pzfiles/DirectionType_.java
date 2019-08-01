package models.pzfiles;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.pzfiles.Filestore;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T10:37:15")
@StaticMetamodel(DirectionType.class)
public class DirectionType_ { 

    public static volatile SingularAttribute<DirectionType, String> directionType;
    public static volatile SingularAttribute<DirectionType, Integer> idDirection;
    public static volatile CollectionAttribute<DirectionType, Filestore> filestoreCollection;

}