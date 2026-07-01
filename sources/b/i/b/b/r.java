package b.i.b.b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r<E> extends n<E> implements Set<E> {
    public static final /* synthetic */ int k = 0;

    @RetainedWith
    @NullableDecl
    @LazyInit
    public transient p<E> l;

    public static int k(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return BasicMeasure.EXACTLY;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> r<E> l(int i, Object... objArr) {
        if (i == 0) {
            return j0.m;
        }
        if (i == 1) {
            return new q0(objArr[0]);
        }
        int iK = k(i);
        Object[] objArr2 = new Object[iK];
        int i2 = iK - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            b.i.a.f.e.o.f.y(obj, i5);
            int iHashCode = obj.hashCode();
            int iC1 = b.i.a.f.e.o.f.c1(iHashCode);
            while (true) {
                int i6 = iC1 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iC1++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new q0(objArr[0], i3);
        }
        if (k(i4) < iK / 2) {
            return l(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new j0(objArr, i3, objArr2, i2, i4);
    }

    public static <E> r<E> m(Collection<? extends E> collection) {
        if ((collection instanceof r) && !(collection instanceof SortedSet)) {
            r<E> rVar = (r) collection;
            if (!rVar.i()) {
                return rVar;
            }
        }
        Object[] array = collection.toArray();
        return l(array.length, array);
    }

    public static <E> r<E> n(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? l(eArr.length, (Object[]) eArr.clone()) : new q0(eArr[0]);
        }
        return j0.m;
    }

    public static <E> r<E> r(E e, E e2, E e3) {
        return l(3, e, e2, e3);
    }

    @Override // b.i.b.b.n
    public p<E> c() {
        p<E> pVar = this.l;
        if (pVar != null) {
            return pVar;
        }
        p<E> pVarO = o();
        this.l = pVarO;
        return pVarO;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof r) && p() && ((r) obj).p() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return h.a(this);
    }

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return j();
    }

    public p<E> o() {
        return p.k(toArray());
    }

    public boolean p() {
        return this instanceof j0;
    }

    @Override // b.i.b.b.n
    public Object writeReplace() {
        return new r$a(toArray());
    }
}
