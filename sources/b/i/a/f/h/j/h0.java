package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f1418b = new i0();

    public h0(g gVar) {
        this.a = gVar;
    }

    public final void a(String str, boolean z2) {
        if (!"ga_dryRun".equals(str)) {
            this.a.c().x("Bool xml configuration name not recognized", str);
        } else {
            this.f1418b.e = z2 ? 1 : 0;
        }
    }

    public final void b(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f1418b.d = i;
        } else {
            this.a.c().x("Int xml configuration name not recognized", str);
        }
    }

    public final void c(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f1418b.a = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.f1418b.f1420b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f1418b.c = str2;
        } else {
            this.a.c().x("String xml configuration name not recognized", str);
        }
    }
}
