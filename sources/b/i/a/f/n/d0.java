package b.i.a.f.n;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ c0 j;
    public final /* synthetic */ Callable k;

    public d0(c0 c0Var, Callable callable) {
        this.j = c0Var;
        this.k = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.j.s(this.k.call());
        } catch (Exception e) {
            this.j.t(e);
        } catch (Throwable th) {
            this.j.t(new RuntimeException(th));
        }
    }
}
