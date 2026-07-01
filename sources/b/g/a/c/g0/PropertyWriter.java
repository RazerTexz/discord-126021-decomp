package b.g.a.c.g0;

import b.g.a.c.PropertyMetadata;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.c0.ConcreteBeanPropertyBase;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.g0.n, reason: use source file name */
/* JADX INFO: compiled from: PropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyWriter extends ConcreteBeanPropertyBase implements Serializable {
    private static final long serialVersionUID = 1;

    public PropertyWriter(PropertyMetadata propertyMetadata) {
        super(propertyMetadata);
    }

    public PropertyWriter(BeanPropertyDefinition beanPropertyDefinition) {
        super(beanPropertyDefinition.o());
    }

    public PropertyWriter(PropertyWriter propertyWriter) {
        super(propertyWriter);
    }
}
