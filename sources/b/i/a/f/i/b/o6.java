package b.i.a.f.i.b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o6 implements Runnable {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ c6 m;

    public o6(c6 c6Var, AtomicReference atomicReference, String str, String str2) {
        this.m = c6Var;
        this.j = atomicReference;
        this.k = str;
        this.l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7 q7VarX = this.m.a.x();
        AtomicReference atomicReference = this.j;
        String str = this.k;
        String str2 = this.l;
        q7VarX.b();
        q7VarX.t();
        q7VarX.z(new f8(q7VarX, atomicReference, null, str, str2, q7VarX.I(false)));
    }
}
