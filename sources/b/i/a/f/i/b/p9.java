package b.i.a.f.i.b;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p9 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ Bundle k;
    public final /* synthetic */ n9 l;

    public p9(n9 n9Var, String str, Bundle bundle) {
        this.l = n9Var;
        this.j = str;
        this.k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        t9 t9VarT = this.l.a.k.t();
        String str = this.j;
        Bundle bundle = this.k;
        Objects.requireNonNull((b.i.a.f.e.o.c) this.l.a.k.o);
        this.l.a.m(t9VarT.B(str, "_err", bundle, "auto", System.currentTimeMillis(), false, false), this.j);
    }
}
