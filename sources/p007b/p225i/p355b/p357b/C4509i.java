package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.i */
/* JADX INFO: compiled from: ComparatorOrdering.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4509i<T> extends AbstractC4506g0<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<T> comparator;

    public C4509i(Comparator<T> comparator) {
        Objects.requireNonNull(comparator);
        this.comparator = comparator;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4506g0, java.util.Comparator
    public int compare(T t, T t2) {
        return this.comparator.compare(t, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C4509i) {
            return this.comparator.equals(((C4509i) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
