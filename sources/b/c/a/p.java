package b.c.a;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: LottieResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class p<V> {

    @Nullable
    public final V a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f373b;

    public p(V v) {
        this.a = v;
        this.f373b = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        V v = this.a;
        if (v != null && v.equals(pVar.a)) {
            return true;
        }
        Throwable th = this.f373b;
        if (th == null || pVar.f373b == null) {
            return false;
        }
        return th.toString().equals(this.f373b.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.f373b});
    }

    public p(Throwable th) {
        this.f373b = th;
        this.a = null;
    }
}
