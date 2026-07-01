package com.facebook.common.references;

import android.graphics.Bitmap;
import b.f.d.h.a;
import b.f.d.h.b;
import b.f.d.h.c;
import b.f.d.h.d;
import b.f.d.h.e;
import b.f.d.h.f;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {
    public static Class<CloseableReference> j = CloseableReference.class;
    public static int k = 0;
    public static final f<Closeable> l = new CloseableReference$a();
    public static final CloseableReference$c m = new CloseableReference$b();
    public boolean n = false;
    public final SharedReference<T> o;
    public final CloseableReference$c p;
    public final Throwable q;

    public CloseableReference(SharedReference<T> sharedReference, CloseableReference$c closeableReference$c, Throwable th) {
        Objects.requireNonNull(sharedReference);
        this.o = sharedReference;
        synchronized (sharedReference) {
            sharedReference.b();
            sharedReference.c++;
        }
        this.p = closeableReference$c;
        this.q = th;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference A(Closeable closeable) {
        return D(closeable, l);
    }

    public static <T> CloseableReference<T> D(T t, f<T> fVar) {
        return H(t, fVar, m);
    }

    public static <T> CloseableReference<T> H(T t, f<T> fVar, CloseableReference$c closeableReference$c) {
        if (t == null) {
            return null;
        }
        return I(t, fVar, closeableReference$c, closeableReference$c.b() ? new Throwable() : null);
    }

    public static <T> CloseableReference<T> I(T t, f<T> fVar, CloseableReference$c closeableReference$c, Throwable th) {
        if ((t instanceof Bitmap) || (t instanceof c)) {
            int i = k;
            if (i == 1) {
                return new b(t, fVar, closeableReference$c, th);
            }
            if (i == 2) {
                return new e(t, fVar, closeableReference$c, th);
            }
            if (i == 3) {
                return new d(t, fVar, closeableReference$c, th);
            }
        }
        return new a(t, fVar, closeableReference$c, th);
    }

    public static <T> CloseableReference<T> n(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.f();
        }
        return null;
    }

    public static <T> List<CloseableReference<T>> q(Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<CloseableReference<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(n(it.next()));
        }
        return arrayList;
    }

    public static void s(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static void t(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference<?> closeableReference : iterable) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        }
    }

    public static boolean y(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.x();
    }

    public abstract CloseableReference<T> b();

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public void close() {
        synchronized (this) {
            if (this.n) {
                return;
            }
            this.n = true;
            this.o.a();
        }
    }

    public synchronized CloseableReference<T> f() {
        if (!x()) {
            return null;
        }
        return b();
    }

    public synchronized T u() {
        T tC;
        b.c.a.a0.d.B(!this.n);
        tC = this.o.c();
        Objects.requireNonNull(tC);
        return tC;
    }

    public synchronized boolean x() {
        return !this.n;
    }

    public CloseableReference(T t, f<T> fVar, CloseableReference$c closeableReference$c, Throwable th) {
        this.o = new SharedReference<>(t, fVar);
        this.p = closeableReference$c;
        this.q = th;
    }
}
