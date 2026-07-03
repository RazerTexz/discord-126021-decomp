package p507d0.p578f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.r */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12079r<T> implements Sequence<T>, InterfaceC12066e<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25116a;

    /* JADX INFO: renamed from: b */
    public final int f25117b;

    /* JADX INFO: renamed from: c */
    public final int f25118c;

    /* JADX INFO: renamed from: d0.f0.r$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25119j;

        /* JADX INFO: renamed from: k */
        public int f25120k;

        public a() {
            this.f25119j = C12079r.this.f25116a.iterator();
        }

        /* JADX INFO: renamed from: a */
        public final void m10065a() {
            while (this.f25120k < C12079r.this.f25117b && this.f25119j.hasNext()) {
                this.f25119j.next();
                this.f25120k++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m10065a();
            return this.f25120k < C12079r.this.f25118c && this.f25119j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m10065a();
            if (this.f25120k >= C12079r.this.f25118c) {
                throw new NoSuchElementException();
            }
            this.f25120k++;
            return this.f25119j.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12079r(Sequence<? extends T> sequence, int i, int i2) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        this.f25116a = sequence;
        this.f25117b = i;
        this.f25118c = i2;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("startIndex should be non-negative, but is ", i).toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("endIndex should be non-negative, but is ", i2).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(C1643a.m875s("endIndex should be not less than startIndex, but was ", i2, " < ", i).toString());
        }
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> drop(int i) {
        int i2 = this.f25118c;
        int i3 = this.f25117b;
        return i >= i2 - i3 ? C12075n.emptySequence() : new C12079r(this.f25116a, i3 + i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> take(int i) {
        int i2 = this.f25118c;
        int i3 = this.f25117b;
        return i >= i2 - i3 ? this : new C12079r(this.f25116a, i3, i + i3);
    }
}
