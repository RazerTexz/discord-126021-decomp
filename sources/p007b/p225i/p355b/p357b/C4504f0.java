package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.f0 */
/* JADX INFO: compiled from: NaturalOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4504f0 extends AbstractC4506g0<Comparable> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C4504f0 f12005j = new C4504f0();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f12005j;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4506g0
    /* JADX INFO: renamed from: b */
    public <S extends Comparable> AbstractC4506g0<S> mo6236b() {
        return C4514k0.f12038j;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4506g0, java.util.Comparator
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
