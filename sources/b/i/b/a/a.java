package b.i.b.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> implements Iterator<T> {
    public int j = 2;

    @NullableDecl
    public T k;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        T t;
        int i = this.j;
        if (!(i != 4)) {
            throw new IllegalStateException();
        }
        int iH = b.c.a.y.b.h(i);
        if (iH == 0) {
            return true;
        }
        if (iH == 2) {
            return false;
        }
        this.j = 4;
        k$a k_a = (k$a) this;
        int i2 = k_a.o;
        while (true) {
            int i3 = k_a.o;
            if (i3 == -1) {
                k_a.j = 3;
                t = null;
                break;
            }
            i iVar = (i) k_a;
            int iA = iVar.q.a.a(iVar.l, i3);
            if (iA == -1) {
                iA = k_a.l.length();
                k_a.o = -1;
            } else {
                k_a.o = iA + 1;
            }
            int i4 = k_a.o;
            if (i4 == i2) {
                int i5 = i4 + 1;
                k_a.o = i5;
                if (i5 > k_a.l.length()) {
                    k_a.o = -1;
                }
            } else {
                while (i2 < iA && k_a.m.b(k_a.l.charAt(i2))) {
                    i2++;
                }
                while (iA > i2) {
                    int i6 = iA - 1;
                    if (!k_a.m.b(k_a.l.charAt(i6))) {
                        break;
                    }
                    iA = i6;
                }
                if (!k_a.n || i2 != iA) {
                    int i7 = k_a.p;
                    if (i7 == 1) {
                        iA = k_a.l.length();
                        k_a.o = -1;
                        while (iA > i2) {
                            int i8 = iA - 1;
                            if (!k_a.m.b(k_a.l.charAt(i8))) {
                                break;
                            }
                            iA = i8;
                        }
                    } else {
                        k_a.p = i7 - 1;
                    }
                    t = (T) k_a.l.subSequence(i2, iA).toString();
                    break;
                }
                i2 = k_a.o;
            }
        }
        this.k = t;
        if (this.j == 3) {
            return false;
        }
        this.j = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.j = 2;
        T t = this.k;
        this.k = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
