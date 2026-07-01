package b.i.b.b;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.f0, reason: use source file name */
/* JADX INFO: compiled from: NaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final NaturalOrdering j = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return j;
    }

    @Override // b.i.b.b.Ordering
    public <S extends Comparable> Ordering<S> b() {
        return ReverseNaturalOrdering.j;
    }

    @Override // b.i.b.b.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Objects.requireNonNull(comparable);
        Objects.requireNonNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
