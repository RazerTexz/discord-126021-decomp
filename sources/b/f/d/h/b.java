package b.f.d.h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.CloseableReference$c;

/* JADX INFO: compiled from: FinalizerCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> extends CloseableReference<T> {
    public b(T t, f<T> fVar, CloseableReference$c closeableReference$c, Throwable th) {
        super(t, fVar, closeableReference$c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
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
                if (this.n) {
                    super.finalize();
                    return;
                }
                T tC = this.o.c();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.o));
                objArr[2] = tC == null ? null : tC.getClass().getName();
                b.f.d.e.a.o("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.o.a();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
