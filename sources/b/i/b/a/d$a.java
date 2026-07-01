package b.i.b.a;

import java.io.Serializable;

/* JADX INFO: compiled from: Equivalence.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends d<Object> implements Serializable {
    public static final d$a j = new d$a();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return j;
    }

    @Override // b.i.b.a.d
    public boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    @Override // b.i.b.a.d
    public int b(Object obj) {
        return obj.hashCode();
    }
}
