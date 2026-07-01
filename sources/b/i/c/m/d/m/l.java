package b.i.c.m.d.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends v$d$d$a$b {
    public final w<v$d$d$a$b$d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v$d$d$a$b$b f1726b;
    public final v$d$d$a$b$c c;
    public final w<v$d$d$a$b$a> d;

    public l(w wVar, v$d$d$a$b$b v_d_d_a_b_b, v$d$d$a$b$c v_d_d_a_b_c, w wVar2, l$a l_a) {
        this.a = wVar;
        this.f1726b = v_d_d_a_b_b;
        this.c = v_d_d_a_b_c;
        this.d = wVar2;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b
    @NonNull
    public w<v$d$d$a$b$a> a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b
    @NonNull
    public v$d$d$a$b$b b() {
        return this.f1726b;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b
    @NonNull
    public v$d$d$a$b$c c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b
    @NonNull
    public w<v$d$d$a$b$d> d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a$b)) {
            return false;
        }
        v$d$d$a$b v_d_d_a_b = (v$d$d$a$b) obj;
        return this.a.equals(v_d_d_a_b.d()) && this.f1726b.equals(v_d_d_a_b.b()) && this.c.equals(v_d_d_a_b.c()) && this.d.equals(v_d_d_a_b.a());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1726b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Execution{threads=");
        sbU.append(this.a);
        sbU.append(", exception=");
        sbU.append(this.f1726b);
        sbU.append(", signal=");
        sbU.append(this.c);
        sbU.append(", binaries=");
        sbU.append(this.d);
        sbU.append("}");
        return sbU.toString();
    }
}
