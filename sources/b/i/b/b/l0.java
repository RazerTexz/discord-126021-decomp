package b.i.b.b;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ReverseOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l0<T> extends g0<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final g0<? super T> forwardOrder;

    public l0(g0<? super T> g0Var) {
        this.forwardOrder = g0Var;
    }

    @Override // b.i.b.b.g0
    public <S extends T> g0<S> b() {
        return this.forwardOrder;
    }

    @Override // b.i.b.b.g0, java.util.Comparator
    public int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l0) {
            return this.forwardOrder.equals(((l0) obj).forwardOrder);
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
