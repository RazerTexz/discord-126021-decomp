package b.c.a.c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: renamed from: b.c.a.c0.c, reason: use source file name */
/* JADX INFO: compiled from: LottieValueCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieValueCallback<T> {
    public final LottieFrameInfo<T> a = new LottieFrameInfo<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f349b;

    public LottieValueCallback(@Nullable T t) {
        this.f349b = null;
        this.f349b = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        LottieFrameInfo<T> lottieFrameInfo = this.a;
        lottieFrameInfo.a = t;
        lottieFrameInfo.f348b = t2;
        return this.f349b;
    }
}
