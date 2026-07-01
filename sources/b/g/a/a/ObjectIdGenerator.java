package b.g.a.a;

import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.a.i0, reason: use source file name */
/* JADX INFO: compiled from: ObjectIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {
    public abstract boolean a(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> b(Class<?> cls);

    public abstract T c(Object obj);

    public abstract Class<?> d();

    public abstract ObjectIdGenerator<T> e(Object obj);
}
