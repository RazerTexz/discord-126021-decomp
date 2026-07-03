package p007b.p225i.p355b.p356a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p355b.p356a.C4491k;

/* JADX INFO: renamed from: b.i.b.a.a */
/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4481a<T> implements Iterator<T> {

    /* JADX INFO: renamed from: j */
    public int f11938j = 2;

    /* JADX INFO: renamed from: k */
    @NullableDecl
    public T f11939k;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        T t;
        int i = this.f11938j;
        if (!(i != 4)) {
            throw new IllegalStateException();
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h == 0) {
            return true;
        }
        if (iM758h == 2) {
            return false;
        }
        this.f11938j = 4;
        C4491k.a aVar = (C4491k.a) this;
        int i2 = aVar.f11964o;
        while (true) {
            int i3 = aVar.f11964o;
            if (i3 == -1) {
                aVar.f11938j = 3;
                t = null;
                break;
            }
            C4489i c4489i = (C4489i) aVar;
            int iMo6209a = c4489i.f11956q.f11957a.mo6209a(c4489i.f11961l, i3);
            if (iMo6209a == -1) {
                iMo6209a = aVar.f11961l.length();
                aVar.f11964o = -1;
            } else {
                aVar.f11964o = iMo6209a + 1;
            }
            int i4 = aVar.f11964o;
            if (i4 == i2) {
                int i5 = i4 + 1;
                aVar.f11964o = i5;
                if (i5 > aVar.f11961l.length()) {
                    aVar.f11964o = -1;
                }
            } else {
                while (i2 < iMo6209a && aVar.f11962m.mo6210b(aVar.f11961l.charAt(i2))) {
                    i2++;
                }
                while (iMo6209a > i2) {
                    int i6 = iMo6209a - 1;
                    if (!aVar.f11962m.mo6210b(aVar.f11961l.charAt(i6))) {
                        break;
                    }
                    iMo6209a = i6;
                }
                if (!aVar.f11963n || i2 != iMo6209a) {
                    int i7 = aVar.f11965p;
                    if (i7 == 1) {
                        iMo6209a = aVar.f11961l.length();
                        aVar.f11964o = -1;
                        while (iMo6209a > i2) {
                            int i8 = iMo6209a - 1;
                            if (!aVar.f11962m.mo6210b(aVar.f11961l.charAt(i8))) {
                                break;
                            }
                            iMo6209a = i8;
                        }
                    } else {
                        aVar.f11965p = i7 - 1;
                    }
                    t = (T) aVar.f11961l.subSequence(i2, iMo6209a).toString();
                    break;
                }
                i2 = aVar.f11964o;
            }
        }
        this.f11939k = t;
        if (this.f11938j == 3) {
            return false;
        }
        this.f11938j = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11938j = 2;
        T t = this.f11939k;
        this.f11939k = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
