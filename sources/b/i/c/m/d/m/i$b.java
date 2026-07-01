package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends v$d$c$a {
    public Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1722b;
    public Integer c;
    public Long d;
    public Long e;
    public Boolean f;
    public Integer g;
    public String h;
    public String i;

    public v$d$c a() {
        String strW = this.a == null ? " arch" : "";
        if (this.f1722b == null) {
            strW = b.d.b.a.a.w(strW, " model");
        }
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " cores");
        }
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " ram");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " diskSpace");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " simulator");
        }
        if (this.g == null) {
            strW = b.d.b.a.a.w(strW, " state");
        }
        if (this.h == null) {
            strW = b.d.b.a.a.w(strW, " manufacturer");
        }
        if (this.i == null) {
            strW = b.d.b.a.a.w(strW, " modelClass");
        }
        if (strW.isEmpty()) {
            return new i(this.a.intValue(), this.f1722b, this.c.intValue(), this.d.longValue(), this.e.longValue(), this.f.booleanValue(), this.g.intValue(), this.h, this.i, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
