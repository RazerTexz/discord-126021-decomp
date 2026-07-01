package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b extends v$d$d$a$a {
    public v$d$d$a$b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w<v$b> f1725b;
    public Boolean c;
    public Integer d;

    public k$b() {
    }

    public v$d$d$a a() {
        String strW = this.a == null ? " execution" : "";
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " uiOrientation");
        }
        if (strW.isEmpty()) {
            return new k(this.a, this.f1725b, this.c, this.d.intValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    public k$b(v$d$d$a v_d_d_a, k$a k_a) {
        k kVar = (k) v_d_d_a;
        this.a = kVar.a;
        this.f1725b = kVar.f1724b;
        this.c = kVar.c;
        this.d = Integer.valueOf(kVar.d);
    }
}
