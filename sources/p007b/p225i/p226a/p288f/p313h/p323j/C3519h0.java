package p007b.p225i.p226a.p288f.p313h.p323j;

/* JADX INFO: renamed from: b.i.a.f.h.j.h0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3519h0 {

    /* JADX INFO: renamed from: a */
    public final C3515g f9733a;

    /* JADX INFO: renamed from: b */
    public final C3521i0 f9734b = new C3521i0();

    public C3519h0(C3515g c3515g) {
        this.f9733a = c3515g;
    }

    /* JADX INFO: renamed from: a */
    public final void m4454a(String str, boolean z2) {
        if (!"ga_dryRun".equals(str)) {
            this.f9733a.m4451c().m4439x("Bool xml configuration name not recognized", str);
        } else {
            this.f9734b.f9741e = z2 ? 1 : 0;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4455b(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f9734b.f9740d = i;
        } else {
            this.f9733a.m4451c().m4439x("Int xml configuration name not recognized", str);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4456c(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f9734b.f9737a = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.f9734b.f9738b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f9734b.f9739c = str2;
        } else {
            this.f9733a.m4451c().m4439x("String xml configuration name not recognized", str);
        }
    }
}
