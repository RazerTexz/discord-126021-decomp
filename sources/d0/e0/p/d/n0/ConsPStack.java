package d0.e0.p.d.n0;

import b.d.b.a.outline;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: d0.e0.p.d.n0.a, reason: use source file name */
/* JADX INFO: compiled from: ConsPStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ConsPStack<E> implements Iterable<E> {
    public static final ConsPStack<Object> j = new ConsPStack<>();
    public final E k;
    public final ConsPStack<E> l;
    public final int m;

    /* JADX INFO: renamed from: d0.e0.p.d.n0.a$a */
    /* JADX INFO: compiled from: ConsPStack.java */
    public static class a<E> implements Iterator<E> {
        public ConsPStack<E> j;

        public a(ConsPStack<E> consPStack) {
            this.j = consPStack;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.m > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            ConsPStack<E> consPStack = this.j;
            E e = consPStack.k;
            this.j = consPStack.l;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public ConsPStack() {
        this.m = 0;
        this.k = null;
        this.l = null;
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) j;
    }

    public final ConsPStack<E> c(Object obj) {
        if (this.m == 0) {
            return this;
        }
        if (this.k.equals(obj)) {
            return this.l;
        }
        ConsPStack<E> consPStackC = this.l.c(obj);
        return consPStackC == this.l ? this : new ConsPStack<>(this.k, consPStackC);
    }

    public final ConsPStack<E> d(int i) {
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
            return new a(d(i)).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(outline.q("Index: ", i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new a(d(0));
    }

    public ConsPStack<E> minus(int i) {
        return c(get(i));
    }

    public ConsPStack<E> plus(E e) {
        return new ConsPStack<>(e, this);
    }

    public int size() {
        return this.m;
    }

    public ConsPStack(E e, ConsPStack<E> consPStack) {
        this.k = e;
        this.l = consPStack;
        this.m = consPStack.m + 1;
    }
}
