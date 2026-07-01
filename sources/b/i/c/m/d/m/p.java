package b.i.c.m.d.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends v$d$d$a$b$d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1730b;
    public final w<v$d$d$a$b$d$a> c;

    public p(String str, int i, w wVar, p$a p_a) {
        this.a = str;
        this.f1730b = i;
        this.c = wVar;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d
    @NonNull
    public w<v$d$d$a$b$d$a> a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d
    public int b() {
        return this.f1730b;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d
    @NonNull
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a$b$d)) {
            return false;
        }
        v$d$d$a$b$d v_d_d_a_b_d = (v$d$d$a$b$d) obj;
        return this.a.equals(v_d_d_a_b_d.c()) && this.f1730b == v_d_d_a_b_d.b() && this.c.equals(v_d_d_a_b_d.a());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1730b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Thread{name=");
        sbU.append(this.a);
        sbU.append(", importance=");
        sbU.append(this.f1730b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
