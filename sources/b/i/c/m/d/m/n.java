package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends v$d$d$a$b$b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1728b;
    public final w<v$d$d$a$b$d$a> c;
    public final v$d$d$a$b$b d;
    public final int e;

    public n(String str, String str2, w wVar, v$d$d$a$b$b v_d_d_a_b_b, int i, n$a n_a) {
        this.a = str;
        this.f1728b = str2;
        this.c = wVar;
        this.d = v_d_d_a_b_b;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$b
    @Nullable
    public v$d$d$a$b$b a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$b
    @NonNull
    public w<v$d$d$a$b$d$a> b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$b
    public int c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$b
    @Nullable
    public String d() {
        return this.f1728b;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$b
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        v$d$d$a$b$b v_d_d_a_b_b;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a$b$b)) {
            return false;
        }
        v$d$d$a$b$b v_d_d_a_b_b2 = (v$d$d$a$b$b) obj;
        return this.a.equals(v_d_d_a_b_b2.e()) && ((str = this.f1728b) != null ? str.equals(v_d_d_a_b_b2.d()) : v_d_d_a_b_b2.d() == null) && this.c.equals(v_d_d_a_b_b2.b()) && ((v_d_d_a_b_b = this.d) != null ? v_d_d_a_b_b.equals(v_d_d_a_b_b2.a()) : v_d_d_a_b_b2.a() == null) && this.e == v_d_d_a_b_b2.c();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f1728b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        v$d$d$a$b$b v_d_d_a_b_b = this.d;
        return ((iHashCode2 ^ (v_d_d_a_b_b != null ? v_d_d_a_b_b.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Exception{type=");
        sbU.append(this.a);
        sbU.append(", reason=");
        sbU.append(this.f1728b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append(", causedBy=");
        sbU.append(this.d);
        sbU.append(", overflowCount=");
        return b.d.b.a.a.B(sbU, this.e, "}");
    }
}
