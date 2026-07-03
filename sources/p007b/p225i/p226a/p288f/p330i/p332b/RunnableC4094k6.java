package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;

/* JADX INFO: renamed from: b.i.a.f.i.b.k6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4094k6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f10878j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10879k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f10880l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Bundle f10881m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ boolean f10882n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ boolean f10883o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ boolean f10884p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ String f10885q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ C3999c6 f10886r;

    public RunnableC4094k6(C3999c6 c3999c6, String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        this.f10886r = c3999c6;
        this.f10878j = str;
        this.f10879k = str2;
        this.f10880l = j;
        this.f10881m = bundle;
        this.f10882n = z2;
        this.f10883o = z3;
        this.f10884p = z4;
        this.f10885q = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10886r.m5543F(this.f10878j, this.f10879k, this.f10880l, this.f10881m, this.f10882n, this.f10883o, this.f10884p, this.f10885q);
    }
}
