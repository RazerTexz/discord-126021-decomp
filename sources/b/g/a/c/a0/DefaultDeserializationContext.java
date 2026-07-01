package b.g.a.c.a0;

import b.g.a.c.DeserializationContext;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.a0.d, reason: use source file name */
/* JADX INFO: compiled from: DefaultDeserializationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    private List<?> _objectIdResolvers;

    /* JADX INFO: renamed from: b.g.a.c.a0.d$a */
    /* JADX INFO: compiled from: DefaultDeserializationContext.java */
    public static final class a extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public a(DeserializerFactory deserializerFactory) {
            super(deserializerFactory, null);
        }
    }

    public DefaultDeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        super(deserializerFactory, null);
    }
}
