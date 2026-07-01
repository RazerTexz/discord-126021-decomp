package b.g.a.c.i0;

import b.g.a.c.PropertyName;
import b.g.a.c.h0.ClassKey;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.i0.p, reason: use source file name */
/* JADX INFO: compiled from: RootNameLookup.java */
/* JADX INFO: loaded from: classes3.dex */
public class RootNameLookup implements Serializable {
    private static final long serialVersionUID = 1;
    public transient LRUMap<ClassKey, PropertyName> j = new LRUMap<>(20, 200);

    public Object readResolve() {
        return new RootNameLookup();
    }
}
