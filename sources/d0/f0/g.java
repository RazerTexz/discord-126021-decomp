package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements Sequence<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3571b;
    public final Function1<T, Boolean> c;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public final Iterator<T> j;
        public int k = -1;
        public T l;

        public a() {
            this.j = g.this.a.iterator();
        }

        public final void a() {
            while (this.j.hasNext()) {
                T next = this.j.next();
                if (((Boolean) g.this.c.invoke(next)).booleanValue() == g.this.f3571b) {
                    this.l = next;
                    this.k = 1;
                    return;
                }
            }
            this.k = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.k == -1) {
                a();
            }
            return this.k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.k == -1) {
                a();
            }
            if (this.k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.l;
            this.l = null;
            this.k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Sequence<? extends T> sequence, boolean z2, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        this.a = sequence;
        this.f3571b = z2;
        this.c = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
