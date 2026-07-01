package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends v$d$d$a$b$d$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1731b;
    public final String c;
    public final long d;
    public final int e;

    public q(long j, String str, String str2, long j2, int i, q$a q_a) {
        this.a = j;
        this.f1731b = str;
        this.c = str2;
        this.d = j2;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d$a
    @Nullable
    public String a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d$a
    public int b() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d$a
    public long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d$a
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$d$a
    @NonNull
    public String e() {
        return this.f1731b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a$b$d$a)) {
            return false;
        }
        v$d$d$a$b$d$a v_d_d_a_b_d_a = (v$d$d$a$b$d$a) obj;
        return this.a == v_d_d_a_b_d_a.d() && this.f1731b.equals(v_d_d_a_b_d_a.e()) && ((str = this.c) != null ? str.equals(v_d_d_a_b_d_a.a()) : v_d_d_a_b_d_a.a() == null) && this.d == v_d_d_a_b_d_a.c() && this.e == v_d_d_a_b_d_a.b();
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1731b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.d;
        return this.e ^ ((iHashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Frame{pc=");
        sbU.append(this.a);
        sbU.append(", symbol=");
        sbU.append(this.f1731b);
        sbU.append(", file=");
        sbU.append(this.c);
        sbU.append(", offset=");
        sbU.append(this.d);
        sbU.append(", importance=");
        return b.d.b.a.a.B(sbU, this.e, "}");
    }
}
