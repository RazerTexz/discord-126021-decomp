package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r$b extends v$d$d$b$a {
    public Double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f1734b;
    public Boolean c;
    public Integer d;
    public Long e;
    public Long f;

    public v$d$d$b a() {
        String strW = this.f1734b == null ? " batteryVelocity" : "";
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " proximityOn");
        }
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " orientation");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " ramUsed");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " diskUsed");
        }
        if (strW.isEmpty()) {
            return new r(this.a, this.f1734b.intValue(), this.c.booleanValue(), this.d.intValue(), this.e.longValue(), this.f.longValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
