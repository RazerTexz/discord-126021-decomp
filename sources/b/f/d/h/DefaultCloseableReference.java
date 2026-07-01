package b.f.d.h;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;

/* JADX INFO: renamed from: b.f.d.h.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultCloseableReference<T> extends CloseableReference<T> {
    public DefaultCloseableReference(SharedReference<T> sharedReference, CloseableReference.c cVar, Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> clone() {
        AnimatableValueParser.B(x());
        return new DefaultCloseableReference(this.o, this.p, this.q != null ? new Throwable(this.q) : null);
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
                FLog.o("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.p.a(this.o, this.q);
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public DefaultCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.c cVar, Throwable th) {
        super(t, resourceReleaser, cVar, th);
    }
}
