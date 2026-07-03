package p007b.p225i.p355b.p357b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.r */
/* JADX INFO: compiled from: ImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4527r<E> extends AbstractC4519n<E> implements Set<E> {

    /* JADX INFO: renamed from: k */
    public static final /* synthetic */ int f12057k = 0;

    /* JADX INFO: renamed from: l */
    @RetainedWith
    @NullableDecl
    @LazyInit
    public transient AbstractC4523p<E> f12058l;

    /* JADX INFO: renamed from: b.i.b.b.r$a */
    /* JADX INFO: compiled from: ImmutableSet.java */
    public static class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public a(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return AbstractC4527r.m6282n(this.elements);
        }
    }

    /* JADX INFO: renamed from: k */
    public static int m6279k(int i) {
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

    /* JADX INFO: renamed from: l */
    public static <E> AbstractC4527r<E> m6280l(int i, Object... objArr) {
        if (i == 0) {
            return C4512j0.f12032m;
        }
        if (i == 1) {
            return new C4526q0(objArr[0]);
        }
        int iM6279k = m6279k(i);
        Object[] objArr2 = new Object[iM6279k];
        int i2 = iM6279k - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            C3404f.m4363y(obj, i5);
            int iHashCode = obj.hashCode();
            int iM4277c1 = C3404f.m4277c1(iHashCode);
            while (true) {
                int i6 = iM4277c1 & i2;
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
                iM4277c1++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new C4526q0(objArr[0], i3);
        }
        if (m6279k(i4) < iM6279k / 2) {
            return m6280l(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new C4512j0(objArr, i3, objArr2, i2, i4);
    }

    /* JADX INFO: renamed from: m */
    public static <E> AbstractC4527r<E> m6281m(Collection<? extends E> collection) {
        if ((collection instanceof AbstractC4527r) && !(collection instanceof SortedSet)) {
            AbstractC4527r<E> abstractC4527r = (AbstractC4527r) collection;
            if (!abstractC4527r.mo6246i()) {
                return abstractC4527r;
            }
        }
        Object[] array = collection.toArray();
        return m6280l(array.length, array);
    }

    /* JADX INFO: renamed from: n */
    public static <E> AbstractC4527r<E> m6282n(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? m6280l(eArr.length, (Object[]) eArr.clone()) : new C4526q0(eArr[0]);
        }
        return C4512j0.f12032m;
    }

    /* JADX INFO: renamed from: r */
    public static <E> AbstractC4527r<E> m6283r(E e, E e2, E e3) {
        return m6280l(3, e, e2, e3);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: c */
    public AbstractC4523p<E> mo6253c() {
        AbstractC4523p<E> abstractC4523p = this.f12058l;
        if (abstractC4523p != null) {
            return abstractC4523p;
        }
        AbstractC4523p<E> abstractC4523pMo6252o = mo6252o();
        this.f12058l = abstractC4523pMo6252o;
        return abstractC4523pMo6252o;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC4527r) && mo6278p() && ((AbstractC4527r) obj).mo6278p() && hashCode() != obj.hashCode()) {
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
        return C4507h.m6238a(this);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX INFO: renamed from: o */
    public AbstractC4523p<E> mo6252o() {
        return AbstractC4523p.m6261k(toArray());
    }

    /* JADX INFO: renamed from: p */
    public boolean mo6278p() {
        return this instanceof C4512j0;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    public Object writeReplace() {
        return new a(toArray());
    }
}
