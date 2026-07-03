package p007b.p225i.p226a.p288f.p313h.p327n;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.a.f.h.n.h */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3948h<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Object[] f10483j = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: c */
    public abstract int mo5430c(Object[] objArr, int i);

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: d */
    public abstract int mo5431d();

    /* JADX INFO: renamed from: e */
    public abstract int mo5432e();

    @NullableDecl
    /* JADX INFO: renamed from: g */
    public abstract Object[] mo5433g();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f10483j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        int size = size();
        int length = tArr.length;
        if (length < size) {
            Object[] objArrMo5433g = mo5433g();
            if (objArrMo5433g != null) {
                return (T[]) Arrays.copyOfRange(objArrMo5433g, mo5432e(), mo5431d(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (length > size) {
            tArr[size] = null;
        }
        mo5430c(tArr, 0);
        return tArr;
    }
}
