package b.i.a.f.i.b;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k6 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ Bundle m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ boolean o;
    public final /* synthetic */ boolean p;
    public final /* synthetic */ String q;
    public final /* synthetic */ c6 r;

    public k6(c6 c6Var, String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        this.r = c6Var;
        this.j = str;
        this.k = str2;
        this.l = j;
        this.m = bundle;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        this.q = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.r.F(this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }
}
