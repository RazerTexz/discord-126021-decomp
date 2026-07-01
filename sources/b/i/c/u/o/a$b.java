package b.i.c.u.o;

import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b extends d$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c$a f1785b;
    public String c;
    public String d;
    public Long e;
    public Long f;
    public String g;

    public a$b() {
    }

    @Override // b.i.c.u.o.d$a
    public d a() {
        String strW = this.f1785b == null ? " registrationStatus" : "";
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " expiresInSecs");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " tokenCreationEpochInSecs");
        }
        if (strW.isEmpty()) {
            return new a(this.a, this.f1785b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    @Override // b.i.c.u.o.d$a
    public d$a b(c$a c_a) {
        Objects.requireNonNull(c_a, "Null registrationStatus");
        this.f1785b = c_a;
        return this;
    }

    public d$a c(long j) {
        this.e = Long.valueOf(j);
        return this;
    }

    public d$a d(long j) {
        this.f = Long.valueOf(j);
        return this;
    }

    public a$b(d dVar, a$a a_a) {
        a aVar = (a) dVar;
        this.a = aVar.f1784b;
        this.f1785b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = Long.valueOf(aVar.f);
        this.f = Long.valueOf(aVar.g);
        this.g = aVar.h;
    }
}
