package b.i.a.f.i.b;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k7 implements Runnable {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ i7 k;
    public final /* synthetic */ i7 l;
    public final /* synthetic */ long m;
    public final /* synthetic */ h7 n;

    public k7(h7 h7Var, Bundle bundle, i7 i7Var, i7 i7Var2, long j) {
        this.n = h7Var;
        this.j = bundle;
        this.k = i7Var;
        this.l = i7Var2;
        this.m = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h7 h7Var = this.n;
        Bundle bundle = this.j;
        i7 i7Var = this.k;
        i7 i7Var2 = this.l;
        long j = this.m;
        Objects.requireNonNull(h7Var);
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        h7Var.B(i7Var, i7Var2, j, true, h7Var.e().z(null, "screen_view", bundle, null, true));
    }
}
