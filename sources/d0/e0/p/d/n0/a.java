package d0.e0.p.d.n0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ConsPStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<E> implements Iterable<E> {
    public static final a<Object> j = new a<>();
    public final E k;
    public final a<E> l;
    public final int m;

    public a() {
        this.m = 0;
        this.k = null;
        this.l = null;
    }

    public static <E> a<E> empty() {
        return (a<E>) j;
    }

    public final a<E> c(Object obj) {
        if (this.m == 0) {
            return this;
        }
        if (this.k.equals(obj)) {
            return this.l;
        }
        a<E> aVarC = this.l.c(obj);
        return aVarC == this.l ? this : new a<>(this.k, aVarC);
    }

    public final a<E> d(int i) {
        if (i < 0 || i > this.m) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.l.d(i - 1);
    }

    public E get(int i) {
        if (i < 0 || i > this.m) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return new a$a(d(i)).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.q("Index: ", i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new a$a(d(0));
    }

    public a<E> minus(int i) {
        return c(get(i));
    }

    public a<E> plus(E e) {
        return new a<>(e, this);
    }

    public int size() {
        return this.m;
    }

    public a(E e, a<E> aVar) {
        this.k = e;
        this.l = aVar;
        this.m = aVar.m + 1;
    }
}
