package b.f.d.h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.CloseableReference$c;

/* JADX INFO: compiled from: NoOpCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T> extends CloseableReference<T> {
    public d(T t, f<T> fVar, CloseableReference$c closeableReference$c, Throwable th) {
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
}
