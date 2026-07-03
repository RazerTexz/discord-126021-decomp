package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.d.h.b */
/* JADX INFO: compiled from: FinalizerCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class C1705b<T> extends CloseableReference<T> {
    public C1705b(T t, InterfaceC1709f<T> interfaceC1709f, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, interfaceC1709f, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public Object clone() throws CloneNotSupportedException {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f19442n) {
                    super.finalize();
                    return;
                }
                T tM8646c = this.f19443o.m8646c();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.f19443o));
                objArr[2] = tM8646c == null ? null : tM8646c.getClass().getName();
                C1691a.m987o("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.f19443o.m8644a();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
