package b.i.a.f.i.b;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s8 implements Runnable {
    public final p8 j;
    public final int k;
    public final q3 l;
    public final Intent m;

    public s8(p8 p8Var, int i, q3 q3Var, Intent intent) {
        this.j = p8Var;
        this.k = i;
        this.l = q3Var;
        this.m = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p8 p8Var = this.j;
        int i = this.k;
        q3 q3Var = this.l;
        Intent intent = this.m;
        if (p8Var.a.f(i)) {
            q3Var.n.b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            p8Var.b().n.a("Completed wakeful intent.");
            p8Var.a.b(intent);
        }
    }
}
