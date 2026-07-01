package b.i.b.a;

import b.i.b.a.Splitter3;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {
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
        Splitter3.a aVar = (Splitter3.a) this;
        int i2 = aVar.o;
        while (true) {
            int i3 = aVar.o;
            if (i3 == -1) {
                aVar.j = 3;
                t = null;
                break;
            }
            Splitter splitter = (Splitter) aVar;
            int iA = splitter.q.a.a(splitter.l, i3);
            if (iA == -1) {
                iA = aVar.l.length();
                aVar.o = -1;
            } else {
                aVar.o = iA + 1;
            }
            int i4 = aVar.o;
            if (i4 == i2) {
                int i5 = i4 + 1;
                aVar.o = i5;
                if (i5 > aVar.l.length()) {
                    aVar.o = -1;
                }
            } else {
                while (i2 < iA && aVar.m.b(aVar.l.charAt(i2))) {
                    i2++;
                }
                while (iA > i2) {
                    int i6 = iA - 1;
                    if (!aVar.m.b(aVar.l.charAt(i6))) {
                        break;
                    }
                    iA = i6;
                }
                if (!aVar.n || i2 != iA) {
                    int i7 = aVar.p;
                    if (i7 == 1) {
                        iA = aVar.l.length();
                        aVar.o = -1;
                        while (iA > i2) {
                            int i8 = iA - 1;
                            if (!aVar.m.b(aVar.l.charAt(i8))) {
                                break;
                            }
                            iA = i8;
                        }
                    } else {
                        aVar.p = i7 - 1;
                    }
                    t = (T) aVar.l.subSequence(i2, iA).toString();
                    break;
                }
                i2 = aVar.o;
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
