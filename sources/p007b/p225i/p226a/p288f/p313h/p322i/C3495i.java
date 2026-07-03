package p007b.p225i.p226a.p288f.p313h.p322i;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.i.i */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3495i extends WeakReference<Throwable> {

    /* JADX INFO: renamed from: a */
    public final int f9660a;

    public C3495i(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f9660a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C3495i.class) {
            if (this == obj) {
                return true;
            }
            C3495i c3495i = (C3495i) obj;
            if (this.f9660a == c3495i.f9660a && get() == c3495i.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9660a;
    }
}
