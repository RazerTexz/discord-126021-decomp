package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends v$d$d$a$b$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1727b;
    public final String c;
    public final String d;

    public m(long j, long j2, String str, String str2, m$a m_a) {
        this.a = j;
        this.f1727b = j2;
        this.c = str;
        this.d = str2;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$a
    @NonNull
    public long a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$a
    @NonNull
    public String b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$a
    public long c() {
        return this.f1727b;
    }

    @Override // b.i.c.m.d.m.v$d$d$a$b$a
    @Nullable
    public String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a$b$a)) {
            return false;
        }
        v$d$d$a$b$a v_d_d_a_b_a = (v$d$d$a$b$a) obj;
        if (this.a == v_d_d_a_b_a.a() && this.f1727b == v_d_d_a_b_a.c() && this.c.equals(v_d_d_a_b_a.b())) {
            String str = this.d;
            if (str == null) {
                if (v_d_d_a_b_a.d() == null) {
                    return true;
                }
            } else if (str.equals(v_d_d_a_b_a.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f1727b;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str = this.d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("BinaryImage{baseAddress=");
        sbU.append(this.a);
        sbU.append(", size=");
        sbU.append(this.f1727b);
        sbU.append(", name=");
        sbU.append(this.c);
        sbU.append(", uuid=");
        return b.d.b.a.a.J(sbU, this.d, "}");
    }
}
