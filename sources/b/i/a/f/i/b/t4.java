package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t4 implements Thread$UncaughtExceptionHandler {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r4 f1568b;

    public t4(r4 r4Var, String str) {
        this.f1568b = r4Var;
        this.a = str;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f1568b.g().f.b(this.a, th);
    }
}
