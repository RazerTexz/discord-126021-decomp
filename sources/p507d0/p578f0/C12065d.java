package p507d0.p578f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.d */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12065d<T> implements Sequence<T>, InterfaceC12066e<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25077a;

    /* JADX INFO: renamed from: b */
    public final int f25078b;

    /* JADX INFO: renamed from: d0.f0.d$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final Iterator<T> f25079j;

        /* JADX INFO: renamed from: k */
        public int f25080k;

        public a(C12065d c12065d) {
            this.f25079j = c12065d.f25077a.iterator();
            this.f25080k = c12065d.f25078b;
        }

        /* JADX INFO: renamed from: a */
        public final void m10060a() {
            while (this.f25080k > 0 && this.f25079j.hasNext()) {
                this.f25079j.next();
                this.f25080k--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m10060a();
            return this.f25079j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m10060a();
            return this.f25079j.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12065d(Sequence<? extends T> sequence, int i) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        this.f25077a = sequence;
        this.f25078b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> drop(int i) {
        int i2 = this.f25078b + i;
        return i2 < 0 ? new C12065d(this, i) : new C12065d(this.f25077a, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // p507d0.p578f0.InterfaceC12066e
    public Sequence<T> take(int i) {
        int i2 = this.f25078b;
        int i3 = i2 + i;
        return i3 < 0 ? new C12080s(this, i) : new C12079r(this.f25077a, i2, i3);
    }
}
