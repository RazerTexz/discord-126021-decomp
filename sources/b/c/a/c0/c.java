package b.c.a.c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: compiled from: LottieValueCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class c<T> {
    public final b<T> a = new b<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f349b;

    public c(@Nullable T t) {
        this.f349b = null;
        this.f349b = t;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        b<T> bVar = this.a;
        bVar.a = t;
        bVar.f348b = t2;
        return this.f349b;
    }
}
