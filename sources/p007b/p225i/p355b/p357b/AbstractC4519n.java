package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.n */
/* JADX INFO: compiled from: ImmutableCollection.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4519n<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Object[] f12039j = new Object[0];

    /* JADX INFO: renamed from: b.i.b.b.n$a */
    /* JADX INFO: compiled from: ImmutableCollection.java */
    public static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a */
        public Object[] f12040a;

        /* JADX INFO: renamed from: b */
        public int f12041b;

        /* JADX INFO: renamed from: c */
        public boolean f12042c;

        public a(int i) {
            C3404f.m4189A(i, "initialCapacity");
            this.f12040a = new Object[i];
            this.f12041b = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.n$b */
    /* JADX INFO: compiled from: ImmutableCollection.java */
    public static abstract class b<E> {
        /* JADX INFO: renamed from: a */
        public static int m6260a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: c */
    public AbstractC4523p<E> mo6253c() {
        if (!isEmpty()) {
            return AbstractC4523p.m6261k(toArray());
        }
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        return (AbstractC4523p<E>) C4508h0.f12012l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    /* JADX INFO: renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        AbstractC4530s0<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: e */
    public Object[] mo6243e() {
        return null;
    }

    /* JADX INFO: renamed from: g */
    public int mo6244g() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: h */
    public int mo6245h() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: i */
    public abstract boolean mo6246i();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public abstract AbstractC4530s0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f12039j);
    }

    public Object writeReplace() {
        return new AbstractC4523p.c(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrMo6243e = mo6243e();
            if (objArrMo6243e != null) {
                return (T[]) Arrays.copyOfRange(objArrMo6243e, mo6245h(), mo6244g(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo6242d(tArr, 0);
        return tArr;
    }
}
