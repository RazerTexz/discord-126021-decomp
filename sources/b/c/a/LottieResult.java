package b.c.a;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.c.a.p, reason: use source file name */
/* JADX INFO: compiled from: LottieResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class LottieResult<V> {

    @Nullable
    public final V a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f373b;

    public LottieResult(V v) {
        this.a = v;
        this.f373b = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        V v = this.a;
        if (v != null && v.equals(lottieResult.a)) {
            return true;
        }
        Throwable th = this.f373b;
        if (th == null || lottieResult.f373b == null) {
            return false;
        }
        return th.toString().equals(this.f373b.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.f373b});
    }

    public LottieResult(Throwable th) {
        this.f373b = th;
        this.a = null;
    }
}
