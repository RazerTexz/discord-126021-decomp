package com.facebook.common.references;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Closeables;
import b.f.d.e.FLog;
import b.f.d.h.DefaultCloseableReference;
import b.f.d.h.FinalizerCloseableReference;
import b.f.d.h.HasBitmap;
import b.f.d.h.NoOpCloseableReference;
import b.f.d.h.RefCountCloseableReference;
import b.f.d.h.ResourceReleaser;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {
    public static Class<CloseableReference> j = CloseableReference.class;
    public static int k = 0;
    public static final ResourceReleaser<Closeable> l = new a();
    public static final c m = new b();
    public boolean n = false;
    public final SharedReference<T> o;
    public final c p;
    public final Throwable q;

    public static class a implements ResourceReleaser<Closeable> {
        @Override // b.f.d.h.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    public static class b implements c {
        @Override // com.facebook.common.references.CloseableReference.c
        public void a(SharedReference<Object> sharedReference, Throwable th) {
            Object objC = sharedReference.c();
            Class<CloseableReference> cls = CloseableReference.j;
            Class<CloseableReference> cls2 = CloseableReference.j;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = objC == null ? null : objC.getClass().getName();
            FLog.m(cls2, "Finalized without closing: %x %x (type = %s)", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.c
        public boolean b() {
            return false;
        }
    }

    public interface c {
        void a(SharedReference<Object> sharedReference, Throwable th);

        boolean b();
    }

    public CloseableReference(SharedReference<T> sharedReference, c cVar, Throwable th) {
        Objects.requireNonNull(sharedReference);
        this.o = sharedReference;
        synchronized (sharedReference) {
            sharedReference.b();
            sharedReference.c++;
        }
        this.p = cVar;
        this.q = th;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference A(Closeable closeable) {
        return D(closeable, l);
    }

    public static <T> CloseableReference<T> D(T t, ResourceReleaser<T> resourceReleaser) {
        return H(t, resourceReleaser, m);
    }

    public static <T> CloseableReference<T> H(T t, ResourceReleaser<T> resourceReleaser, c cVar) {
        if (t == null) {
            return null;
        }
        return I(t, resourceReleaser, cVar, cVar.b() ? new Throwable() : null);
    }

    public static <T> CloseableReference<T> I(T t, ResourceReleaser<T> resourceReleaser, c cVar, Throwable th) {
        if ((t instanceof Bitmap) || (t instanceof HasBitmap)) {
            int i = k;
            if (i == 1) {
                return new FinalizerCloseableReference(t, resourceReleaser, cVar, th);
            }
            if (i == 2) {
                return new RefCountCloseableReference(t, resourceReleaser, cVar, th);
            }
            if (i == 3) {
                return new NoOpCloseableReference(t, resourceReleaser, cVar, th);
            }
        }
        return new DefaultCloseableReference(t, resourceReleaser, cVar, th);
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

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract CloseableReference<T> clone();

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
        return clone();
    }

    public synchronized T u() {
        T tC;
        AnimatableValueParser.B(!this.n);
        tC = this.o.c();
        Objects.requireNonNull(tC);
        return tC;
    }

    public synchronized boolean x() {
        return !this.n;
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, c cVar, Throwable th) {
        this.o = new SharedReference<>(t, resourceReleaser);
        this.p = cVar;
        this.q = th;
    }
}
