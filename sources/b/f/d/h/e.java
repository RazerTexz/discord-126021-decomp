package b.f.d.h;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.CloseableReference$c;
import com.facebook.common.references.SharedReference;

/* JADX INFO: compiled from: RefCountCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class e<T> extends CloseableReference<T> {
    public e(SharedReference<T> sharedReference, CloseableReference$c closeableReference$c, Throwable th) {
        super(sharedReference, closeableReference$c, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
        b.c.a.a0.d.B(x());
        return new e(this.o, this.p, this.q);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public e(T t, f<T> fVar, CloseableReference$c closeableReference$c, Throwable th) {
        super(t, fVar, closeableReference$c, th);
    }
}
