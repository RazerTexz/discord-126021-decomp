package b.i.a.f.i.b;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m8 implements Runnable {
    public final /* synthetic */ ComponentName j;
    public final /* synthetic */ k8 k;

    public m8(k8 k8Var, ComponentName componentName) {
        this.k = k8Var;
        this.j = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q7.x(this.k.l, this.j);
    }
}
