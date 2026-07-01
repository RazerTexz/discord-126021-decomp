package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends v$d$d {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1723b;
    public final v$d$d$a c;
    public final v$d$d$b d;
    public final v$d$d$c e;

    public j(long j, String str, v$d$d$a v_d_d_a, v$d$d$b v_d_d_b, v$d$d$c v_d_d_c, j$a j_a) {
        this.a = j;
        this.f1723b = str;
        this.c = v_d_d_a;
        this.d = v_d_d_b;
        this.e = v_d_d_c;
    }

    @Override // b.i.c.m.d.m.v$d$d
    @NonNull
    public v$d$d$a a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d
    @NonNull
    public v$d$d$b b() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v$d$d
    @Nullable
    public v$d$d$c c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v$d$d
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$d
    @NonNull
    public String e() {
        return this.f1723b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d)) {
            return false;
        }
        v$d$d v_d_d = (v$d$d) obj;
        if (this.a == v_d_d.d() && this.f1723b.equals(v_d_d.e()) && this.c.equals(v_d_d.a()) && this.d.equals(v_d_d.b())) {
            v$d$d$c v_d_d_c = this.e;
            if (v_d_d_c == null) {
                if (v_d_d.c() == null) {
                    return true;
                }
            } else if (v_d_d_c.equals(v_d_d.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1723b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        v$d$d$c v_d_d_c = this.e;
        return (v_d_d_c == null ? 0 : v_d_d_c.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Event{timestamp=");
        sbU.append(this.a);
        sbU.append(", type=");
        sbU.append(this.f1723b);
        sbU.append(", app=");
        sbU.append(this.c);
        sbU.append(", device=");
        sbU.append(this.d);
        sbU.append(", log=");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
