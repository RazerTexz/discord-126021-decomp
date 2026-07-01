package b.g.a.c.g0;

import b.g.a.c.JavaType;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.u.StdSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.h, reason: use source file name */
/* JADX INFO: compiled from: ContainerSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    public ContainerSerializer(Class<T> cls) {
        super(cls);
    }

    public abstract ContainerSerializer<?> p(TypeSerializer typeSerializer);

    public abstract boolean q(T t);

    public ContainerSerializer(JavaType javaType) {
        super(javaType);
    }

    public ContainerSerializer(Class<?> cls, boolean z2) {
        super(cls, z2);
    }

    public ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer._handledType, false);
    }
}
