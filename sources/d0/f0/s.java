package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3576b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public int j;
        public final Iterator<T> k;

        public a(s sVar) {
            this.j = sVar.f3576b;
            this.k = sVar.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j > 0 && this.k.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.j;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.j = i - 1;
            return this.k.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3576b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.f3576b;
        return i >= i2 ? n.emptySequence() : new r(this.a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        return i >= this.f3576b ? this : new s(this.a, i);
    }
}
