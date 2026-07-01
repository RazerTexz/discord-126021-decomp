package b.i.a.f.e.h.j;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a<L> {
    public final L a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1367b;

    public k$a(L l, String str) {
        this.a = l;
        this.f1367b = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k$a)) {
            return false;
        }
        k$a k_a = (k$a) obj;
        return this.a == k_a.a && this.f1367b.equals(k_a.f1367b);
    }

    public final int hashCode() {
        return this.f1367b.hashCode() + (System.identityHashCode(this.a) * 31);
    }
}
