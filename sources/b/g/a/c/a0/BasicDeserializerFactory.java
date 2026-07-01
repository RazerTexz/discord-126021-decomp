package b.g.a.c.a0;

import b.g.a.c.PropertyName;
import b.g.a.c.z.DeserializerFactoryConfig;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.a0.a, reason: use source file name */
/* JADX INFO: compiled from: BasicDeserializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    public final DeserializerFactoryConfig _factoryConfig;

    static {
        new PropertyName("@JsonUnwrapped");
    }

    public BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }
}
