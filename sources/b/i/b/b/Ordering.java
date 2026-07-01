package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.g0, reason: use source file name */
/* JADX INFO: compiled from: Ordering.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static <T> Ordering<T> a(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public <S extends T> Ordering<S> b() {
        return new ReverseOrdering(this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);
}
