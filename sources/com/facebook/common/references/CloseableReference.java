package com.facebook.common.references;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1678a;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p123h.C1704a;
import p007b.p109f.p115d.p123h.C1705b;
import p007b.p109f.p115d.p123h.C1707d;
import p007b.p109f.p115d.p123h.C1708e;
import p007b.p109f.p115d.p123h.InterfaceC1706c;
import p007b.p109f.p115d.p123h.InterfaceC1709f;

/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {

    /* JADX INFO: renamed from: j */
    public static Class<CloseableReference> f19438j = CloseableReference.class;

    /* JADX INFO: renamed from: k */
    public static int f19439k = 0;

    /* JADX INFO: renamed from: l */
    public static final InterfaceC1709f<Closeable> f19440l = new C10635a();

    /* JADX INFO: renamed from: m */
    public static final InterfaceC10637c f19441m = new C10636b();

    /* JADX INFO: renamed from: n */
    public boolean f19442n = false;

    /* JADX INFO: renamed from: o */
    public final SharedReference<T> f19443o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC10637c f19444p;

    /* JADX INFO: renamed from: q */
    public final Throwable f19445q;

    /* JADX INFO: renamed from: com.facebook.common.references.CloseableReference$a */
    public static class C10635a implements InterfaceC1709f<Closeable> {
        @Override // p007b.p109f.p115d.p123h.InterfaceC1709f
        public void release(Closeable closeable) {
            try {
                C1678a.m965a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.common.references.CloseableReference$b */
    public static class C10636b implements InterfaceC10637c {
        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* JADX INFO: renamed from: a */
        public void mo1252a(SharedReference<Object> sharedReference, Throwable th) {
            Object objM8646c = sharedReference.m8646c();
            Class<CloseableReference> cls = CloseableReference.f19438j;
            Class<CloseableReference> cls2 = CloseableReference.f19438j;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = objM8646c == null ? null : objM8646c.getClass().getName();
            C1691a.m985m(cls2, "Finalized without closing: %x %x (type = %s)", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* JADX INFO: renamed from: b */
        public boolean mo1253b() {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.facebook.common.references.CloseableReference$c */
    public interface InterfaceC10637c {
        /* JADX INFO: renamed from: a */
        void mo1252a(SharedReference<Object> sharedReference, Throwable th);

        /* JADX INFO: renamed from: b */
        boolean mo1253b();
    }

    public CloseableReference(SharedReference<T> sharedReference, InterfaceC10637c interfaceC10637c, Throwable th) {
        Objects.requireNonNull(sharedReference);
        this.f19443o = sharedReference;
        synchronized (sharedReference) {
            sharedReference.m8645b();
            sharedReference.f19448c++;
        }
        this.f19444p = interfaceC10637c;
        this.f19445q = th;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    /* JADX INFO: renamed from: A */
    public static CloseableReference m8632A(Closeable closeable) {
        return m8633D(closeable, f19440l);
    }

    /* JADX INFO: renamed from: D */
    public static <T> CloseableReference<T> m8633D(T t, InterfaceC1709f<T> interfaceC1709f) {
        return m8634H(t, interfaceC1709f, f19441m);
    }

    /* JADX INFO: renamed from: H */
    public static <T> CloseableReference<T> m8634H(T t, InterfaceC1709f<T> interfaceC1709f, InterfaceC10637c interfaceC10637c) {
        if (t == null) {
            return null;
        }
        return m8635I(t, interfaceC1709f, interfaceC10637c, interfaceC10637c.mo1253b() ? new Throwable() : null);
    }

    /* JADX INFO: renamed from: I */
    public static <T> CloseableReference<T> m8635I(T t, InterfaceC1709f<T> interfaceC1709f, InterfaceC10637c interfaceC10637c, Throwable th) {
        if ((t instanceof Bitmap) || (t instanceof InterfaceC1706c)) {
            int i = f19439k;
            if (i == 1) {
                return new C1705b(t, interfaceC1709f, interfaceC10637c, th);
            }
            if (i == 2) {
                return new C1708e(t, interfaceC1709f, interfaceC10637c, th);
            }
            if (i == 3) {
                return new C1707d(t, interfaceC1709f, interfaceC10637c, th);
            }
        }
        return new C1704a(t, interfaceC1709f, interfaceC10637c, th);
    }

    /* JADX INFO: renamed from: n */
    public static <T> CloseableReference<T> m8636n(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.m8641f();
        }
        return null;
    }

    /* JADX INFO: renamed from: q */
    public static <T> List<CloseableReference<T>> m8637q(Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<CloseableReference<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(m8636n(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: s */
    public static void m8638s(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    /* JADX INFO: renamed from: t */
    public static void m8639t(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference<?> closeableReference : iterable) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public static boolean m8640y(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.m8643x();
    }

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract CloseableReference<T> clone();

    public void close() {
        synchronized (this) {
            if (this.f19442n) {
                return;
            }
            this.f19442n = true;
            this.f19443o.m8644a();
        }
    }

    /* JADX INFO: renamed from: f */
    public synchronized CloseableReference<T> m8641f() {
        if (!m8643x()) {
            return null;
        }
        return clone();
    }

    /* JADX INFO: renamed from: u */
    public synchronized T m8642u() {
        T tM8646c;
        C1460d.m419B(!this.f19442n);
        tM8646c = this.f19443o.m8646c();
        Objects.requireNonNull(tM8646c);
        return tM8646c;
    }

    /* JADX INFO: renamed from: x */
    public synchronized boolean m8643x() {
        return !this.f19442n;
    }

    public CloseableReference(T t, InterfaceC1709f<T> interfaceC1709f, InterfaceC10637c interfaceC10637c, Throwable th) {
        this.f19443o = new SharedReference<>(t, interfaceC1709f);
        this.f19444p = interfaceC10637c;
        this.f19445q = th;
    }
}
