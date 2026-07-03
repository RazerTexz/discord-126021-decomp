package p007b.p225i.p226a.p288f.p340n;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.a.f.n.d0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4360d0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4358c0 f11477j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Callable f11478k;

    public RunnableC4360d0(C4358c0 c4358c0, Callable callable) {
        this.f11477j = c4358c0;
        this.f11478k = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f11477j.m6024s(this.f11478k.call());
        } catch (Exception e) {
            this.f11477j.m6025t(e);
        } catch (Throwable th) {
            this.f11477j.m6025t(new RuntimeException(th));
        }
    }
}
