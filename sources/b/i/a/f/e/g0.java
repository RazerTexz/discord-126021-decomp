package b.i.a.f.e;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g0 {
    public static final g0 a = new g0(true, null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1349b;
    public final String c;
    public final Throwable d;

    public g0(boolean z2, String str, Throwable th) {
        this.f1349b = z2;
        this.c = str;
        this.d = th;
    }

    public static g0 b(@NonNull String str) {
        return new g0(false, str, null);
    }

    public static g0 c(@NonNull String str, @NonNull Throwable th) {
        return new g0(false, str, th);
    }

    public String a() {
        return this.c;
    }
}
