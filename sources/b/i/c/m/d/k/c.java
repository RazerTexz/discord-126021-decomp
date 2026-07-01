package b.i.c.m.d.k;

import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends o0 {
    public final b.i.c.m.d.m.v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1678b;

    public c(b.i.c.m.d.m.v vVar, String str) {
        Objects.requireNonNull(vVar, "Null report");
        this.a = vVar;
        Objects.requireNonNull(str, "Null sessionId");
        this.f1678b = str;
    }

    @Override // b.i.c.m.d.k.o0
    public b.i.c.m.d.m.v a() {
        return this.a;
    }

    @Override // b.i.c.m.d.k.o0
    public String b() {
        return this.f1678b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.a.equals(o0Var.a()) && this.f1678b.equals(o0Var.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1678b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CrashlyticsReportWithSessionId{report=");
        sbU.append(this.a);
        sbU.append(", sessionId=");
        return b.d.b.a.a.J(sbU, this.f1678b, "}");
    }
}
