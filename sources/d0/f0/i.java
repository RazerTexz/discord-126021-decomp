package d0.f0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> implements Sequence<T> {
    public final Function0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, T> f3573b;

    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, KMarkers {
        public T j;
        public int k = -2;

        public a() {
        }

        public final void a() {
            T t;
            if (this.k == -2) {
                t = (T) i.this.a.invoke();
            } else {
                Function1 function1 = i.this.f3573b;
                T t2 = this.j;
                Intrinsics3.checkNotNull(t2);
                t = (T) function1.invoke(t2);
            }
            this.j = t;
            this.k = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.k < 0) {
                a();
            }
            return this.k == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.k < 0) {
                a();
            }
            if (this.k == 0) {
                throw new NoSuchElementException();
            }
            T t = this.j;
            Objects.requireNonNull(t, "null cannot be cast to non-null type T");
            this.k = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(function0, "getInitialValue");
        Intrinsics3.checkNotNullParameter(function1, "getNextValue");
        this.a = function0;
        this.f3573b = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a();
    }
}
