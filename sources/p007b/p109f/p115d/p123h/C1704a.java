package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.d.h.a */
/* JADX INFO: compiled from: DefaultCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class C1704a<T> extends CloseableReference<T> {
    public C1704a(SharedReference<T> sharedReference, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(sharedReference, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> clone() {
        C1460d.m419B(m8643x());
        return new C1704a(this.f19443o, this.f19444p, this.f19445q != null ? new Throwable(this.f19445q) : null);
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
                C1691a.m987o("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.f19444p.mo1252a(this.f19443o, this.f19445q);
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public C1704a(T t, InterfaceC1709f<T> interfaceC1709f, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, interfaceC1709f, interfaceC10637c, th);
    }
}
