package b.i.a.f.i.b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l6 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ c6 k;

    public l6(c6 c6Var, long j) {
        this.k = c6Var;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.w(this.j, true);
        this.k.p().A(new AtomicReference<>());
    }
}
