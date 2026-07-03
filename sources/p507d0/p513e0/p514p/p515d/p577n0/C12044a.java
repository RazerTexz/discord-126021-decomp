package p507d0.p513e0.p514p.p515d.p577n0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.e0.p.d.n0.a */
/* JADX INFO: compiled from: ConsPStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12044a<E> implements Iterable<E> {

    /* JADX INFO: renamed from: j */
    public static final C12044a<Object> f25018j = new C12044a<>();

    /* JADX INFO: renamed from: k */
    public final E f25019k;

    /* JADX INFO: renamed from: l */
    public final C12044a<E> f25020l;

    /* JADX INFO: renamed from: m */
    public final int f25021m;

    /* JADX INFO: renamed from: d0.e0.p.d.n0.a$a */
    /* JADX INFO: compiled from: ConsPStack.java */
    public static class a<E> implements Iterator<E> {

        /* JADX INFO: renamed from: j */
        public C12044a<E> f25022j;

        public a(C12044a<E> c12044a) {
            this.f25022j = c12044a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25022j.f25021m > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            C12044a<E> c12044a = this.f25022j;
            E e = c12044a.f25019k;
            this.f25022j = c12044a.f25020l;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C12044a() {
        this.f25021m = 0;
        this.f25019k = null;
        this.f25020l = null;
    }

    public static <E> C12044a<E> empty() {
        return (C12044a<E>) f25018j;
    }

    /* JADX INFO: renamed from: c */
    public final C12044a<E> m10049c(Object obj) {
        if (this.f25021m == 0) {
            return this;
        }
        if (this.f25019k.equals(obj)) {
            return this.f25020l;
        }
        C12044a<E> c12044aM10049c = this.f25020l.m10049c(obj);
        return c12044aM10049c == this.f25020l ? this : new C12044a<>(this.f25019k, c12044aM10049c);
    }

    /* JADX INFO: renamed from: d */
    public final C12044a<E> m10050d(int i) {
        if (i < 0 || i > this.f25021m) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.f25020l.m10050d(i - 1);
    }

    public E get(int i) {
        if (i < 0 || i > this.f25021m) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return new a(m10050d(i)).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(C1643a.m871q("Index: ", i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new a(m10050d(0));
    }

    public C12044a<E> minus(int i) {
        return m10049c(get(i));
    }

    public C12044a<E> plus(E e) {
        return new C12044a<>(e, this);
    }

    public int size() {
        return this.f25021m;
    }

    public C12044a(E e, C12044a<E> c12044a) {
        this.f25019k = e;
        this.f25020l = c12044a;
        this.f25021m = c12044a.f25021m + 1;
    }
}
