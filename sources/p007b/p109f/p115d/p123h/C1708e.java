package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.d.h.e */
/* JADX INFO: compiled from: RefCountCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class C1708e<T> extends CloseableReference<T> {
    public C1708e(SharedReference<T> sharedReference, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(sharedReference, interfaceC10637c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> clone() {
        C1460d.m419B(m8643x());
        return new C1708e(this.f19443o, this.f19444p, this.f19445q);
    }

    public C1708e(T t, InterfaceC1709f<T> interfaceC1709f, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
        super(t, interfaceC1709f, interfaceC10637c, th);
    }
}
