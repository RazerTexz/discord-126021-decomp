package b.i.b.b;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: ReverseNaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends g0<Comparable> implements Serializable {
    public static final k0 j = new k0();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return j;
    }

    @Override // b.i.b.b.g0
    public <S extends Comparable> g0<S> b() {
        return f0.j;
    }

    @Override // b.i.b.b.g0, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Objects.requireNonNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
