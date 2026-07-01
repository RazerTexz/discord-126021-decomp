package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3570b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public final Iterator<T> j;
        public int k;

        public a(d dVar) {
            this.j = dVar.a.iterator();
            this.k = dVar.f3570b;
        }

        public final void a() {
            while (this.k > 0 && this.j.hasNext()) {
                this.j.next();
                this.k--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.j.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3570b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.f3570b + i;
        return i2 < 0 ? new d(this, i) : new d(this.a, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        int i2 = this.f3570b;
        int i3 = i2 + i;
        return i3 < 0 ? new s(this, i) : new r(this.a, i2, i3);
    }
}
