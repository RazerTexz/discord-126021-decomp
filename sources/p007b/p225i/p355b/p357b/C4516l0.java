package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.l0 */
/* JADX INFO: compiled from: ReverseOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4516l0<T> extends AbstractC4506g0<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final AbstractC4506g0<? super T> forwardOrder;

    public C4516l0(AbstractC4506g0<? super T> abstractC4506g0) {
        this.forwardOrder = abstractC4506g0;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4506g0
    /* JADX INFO: renamed from: b */
    public <S extends T> AbstractC4506g0<S> mo6236b() {
        return this.forwardOrder;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4506g0, java.util.Comparator
    public int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C4516l0) {
            return this.forwardOrder.equals(((C4516l0) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
