package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends v$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1714b;
    public Integer c;
    public String d;
    public String e;
    public String f;
    public v$d g;
    public v$c h;

    public b$b() {
    }

    @Override // b.i.c.m.d.m.v$a
    public v a() {
        String strW = this.a == null ? " sdkVersion" : "";
        if (this.f1714b == null) {
            strW = b.d.b.a.a.w(strW, " gmpAppId");
        }
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " platform");
        }
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " installationUuid");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " buildVersion");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " displayVersion");
        }
        if (strW.isEmpty()) {
            return new b(this.a, this.f1714b, this.c.intValue(), this.d, this.e, this.f, this.g, this.h, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    public b$b(v vVar, b$a b_a) {
        b bVar = (b) vVar;
        this.a = bVar.f1713b;
        this.f1714b = bVar.c;
        this.c = Integer.valueOf(bVar.d);
        this.d = bVar.e;
        this.e = bVar.f;
        this.f = bVar.g;
        this.g = bVar.h;
        this.h = bVar.i;
    }
}
