package b.i.a.f.i.b;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o8 implements Runnable {
    public final /* synthetic */ k8 j;

    public o8(k8 k8Var) {
        this.j = k8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7.x(this.j.l, new ComponentName(this.j.l.a.f1570b, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
