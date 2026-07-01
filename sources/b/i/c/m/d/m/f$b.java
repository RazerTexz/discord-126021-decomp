package b.i.c.m.d.m;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b extends v$d$b {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1719b;
    public Long c;
    public Long d;
    public Boolean e;
    public v$d$a f;
    public v$d$f g;
    public v$d$e h;
    public v$d$c i;
    public w<v$d$d> j;
    public Integer k;

    public f$b() {
    }

    @Override // b.i.c.m.d.m.v$d$b
    public v$d a() {
        String strW = this.a == null ? " generator" : "";
        if (this.f1719b == null) {
            strW = b.d.b.a.a.w(strW, " identifier");
        }
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " startedAt");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " crashed");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " app");
        }
        if (this.k == null) {
            strW = b.d.b.a.a.w(strW, " generatorType");
        }
        if (strW.isEmpty()) {
            return new f(this.a, this.f1719b, this.c.longValue(), this.d, this.e.booleanValue(), this.f, this.g, this.h, this.i, this.j, this.k.intValue(), null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    public v$d$b b(boolean z2) {
        this.e = Boolean.valueOf(z2);
        return this;
    }

    public f$b(v$d v_d, f$a f_a) {
        f fVar = (f) v_d;
        this.a = fVar.a;
        this.f1719b = fVar.f1718b;
        this.c = Long.valueOf(fVar.c);
        this.d = fVar.d;
        this.e = Boolean.valueOf(fVar.e);
        this.f = fVar.f;
        this.g = fVar.g;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = Integer.valueOf(fVar.k);
    }
}
