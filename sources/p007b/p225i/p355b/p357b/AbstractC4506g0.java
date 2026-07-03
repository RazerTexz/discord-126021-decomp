package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.g0 */
/* JADX INFO: compiled from: Ordering.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4506g0<T> implements Comparator<T> {
    /* JADX INFO: renamed from: a */
    public static <T> AbstractC4506g0<T> m6237a(Comparator<T> comparator) {
        return comparator instanceof AbstractC4506g0 ? (AbstractC4506g0) comparator : new C4509i(comparator);
    }

    /* JADX INFO: renamed from: b */
    public <S extends T> AbstractC4506g0<S> mo6236b() {
        return new C4516l0(this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);
}
