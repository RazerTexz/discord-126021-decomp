package b.i.a.f.e.h.j;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ g0 j;

    public f0(g0 g0Var) {
        this.j = g0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((g$b) this.j.h).b(new ConnectionResult(4));
    }
}
