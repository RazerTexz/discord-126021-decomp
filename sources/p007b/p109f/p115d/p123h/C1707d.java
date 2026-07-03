package p007b.p109f.p115d.p123h;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.d.h.d */
/* JADX INFO: compiled from: NoOpCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class C1707d<T> extends CloseableReference<T> {
    public C1707d(T t, InterfaceC1709f<T> interfaceC1709f, CloseableReference.InterfaceC10637c interfaceC10637c, Throwable th) {
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
}
