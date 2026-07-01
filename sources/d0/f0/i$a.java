package d0.f0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a<T> implements Iterator<T>, d0.z.d.g0.a {
    public T j;
    public int k = -2;
    public final /* synthetic */ i l;

    public i$a(i iVar) {
        this.l = iVar;
    }

    public final void a() {
        T t;
        if (this.k == -2) {
            t = (T) i.access$getGetInitialValue$p(this.l).invoke();
        } else {
            Function1 function1Access$getGetNextValue$p = i.access$getGetNextValue$p(this.l);
            T t2 = this.j;
            d0.z.d.m.checkNotNull(t2);
            t = (T) function1Access$getGetNextValue$p.invoke(t2);
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
