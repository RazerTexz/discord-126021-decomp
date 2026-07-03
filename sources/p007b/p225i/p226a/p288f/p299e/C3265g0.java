package p007b.p225i.p226a.p288f.p299e;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.f.e.g0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3265g0 {

    /* JADX INFO: renamed from: a */
    public static final C3265g0 f9319a = new C3265g0(true, null, null);

    /* JADX INFO: renamed from: b */
    public final boolean f9320b;

    /* JADX INFO: renamed from: c */
    public final String f9321c;

    /* JADX INFO: renamed from: d */
    public final Throwable f9322d;

    public C3265g0(boolean z2, String str, Throwable th) {
        this.f9320b = z2;
        this.f9321c = str;
        this.f9322d = th;
    }

    /* JADX INFO: renamed from: b */
    public static C3265g0 m4026b(@NonNull String str) {
        return new C3265g0(false, str, null);
    }

    /* JADX INFO: renamed from: c */
    public static C3265g0 m4027c(@NonNull String str, @NonNull Throwable th) {
        return new C3265g0(false, str, th);
    }

    /* JADX INFO: renamed from: a */
    public String mo4025a() {
        return this.f9321c;
    }
}
