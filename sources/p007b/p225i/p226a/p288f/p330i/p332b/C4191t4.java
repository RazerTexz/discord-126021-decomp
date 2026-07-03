package p007b.p225i.p226a.p288f.p330i.p332b;

import java.lang.Thread;

/* JADX INFO: renamed from: b.i.a.f.i.b.t4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4191t4 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    public final String f11225a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C4169r4 f11226b;

    public C4191t4(C4169r4 c4169r4, String str) {
        this.f11226b = c4169r4;
        this.f11225a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f11226b.mo5726g().f11141f.m5861b(this.f11225a, th);
    }
}
