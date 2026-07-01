package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: Ordering.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0<T> implements Comparator<T> {
    public static <T> g0<T> a(Comparator<T> comparator) {
        return comparator instanceof g0 ? (g0) comparator : new i(comparator);
    }

    public <S extends T> g0<S> b() {
        return new l0(this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);
}
