package b.i.b.b;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.k0, reason: use source file name */
/* JADX INFO: compiled from: ReverseNaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final ReverseNaturalOrdering j = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return j;
    }

    @Override // b.i.b.b.Ordering
    public <S extends Comparable> Ordering<S> b() {
        return NaturalOrdering.j;
    }

    @Override // b.i.b.b.Ordering, java.util.Comparator
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
