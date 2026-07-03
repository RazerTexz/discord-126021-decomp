package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.s */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12080s<T> implements Sequence<T>, InterfaceC12066e<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25122a;

    /* JADX INFO: renamed from: b */
    public final int f25123b;

    /* JADX INFO: renamed from: d0.f0.s$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public int f25124j;

        /* JADX INFO: renamed from: k */
        public final Iterator<T> f25125k;

        public a(C12080s c12080s) {
            this.f25124j = c12080s.f25123b;
            this.f25125k = c12080s.f25122a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25124j > 0 && this.f25125k.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.f25124j;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.f25124j = i - 1;
            return this.f25125k.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12080s(Sequence<? extends T> sequence, int i) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        this.f25122a = sequence;
        this.f25123b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> drop(int i) {
        int i2 = this.f25123b;
        return i >= i2 ? C12075n.emptySequence() : new C12079r(this.f25122a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> take(int i) {
        return i >= this.f25123b ? this : new C12080s(this.f25122a, i);
    }
}
