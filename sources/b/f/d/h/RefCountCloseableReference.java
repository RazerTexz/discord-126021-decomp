package b.f.d.h;

import b.c.a.a0.AnimatableValueParser;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;

/* JADX INFO: renamed from: b.f.d.h.e, reason: use source file name */
/* JADX INFO: compiled from: RefCountCloseableReference.java */
/* JADX INFO: loaded from: classes.dex */
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    public RefCountCloseableReference(SharedReference<T> sharedReference, CloseableReference.c cVar, Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: b */
    public CloseableReference<T> clone() {
        AnimatableValueParser.B(x());
        return new RefCountCloseableReference(this.o, this.p, this.q);
    }

    public RefCountCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.c cVar, Throwable th) {
        super(t, resourceReleaser, cVar, th);
    }
}
