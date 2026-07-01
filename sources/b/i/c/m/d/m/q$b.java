package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$b extends v$d$d$a$b$d$a$a {
    public Long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1732b;
    public String c;
    public Long d;
    public Integer e;

    public v$d$d$a$b$d$a a() {
        String strW = this.a == null ? " pc" : "";
        if (this.f1732b == null) {
            strW = b.d.b.a.a.w(strW, " symbol");
        }
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " offset");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " importance");
        }
        if (strW.isEmpty()) {
            return new q(this.a.longValue(), this.f1732b, this.c, this.d.longValue(), this.e.intValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }
}
