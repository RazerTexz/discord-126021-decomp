package p007b.p225i.p226a.p288f.p313h.p325l;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.h3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3679h3 extends WeakReference<Throwable> {

    /* JADX INFO: renamed from: a */
    public final int f9983a;

    public C3679h3(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f9983a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C3679h3.class) {
            if (this == obj) {
                return true;
            }
            C3679h3 c3679h3 = (C3679h3) obj;
            if (this.f9983a == c3679h3.f9983a && get() == c3679h3.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9983a;
    }
}
