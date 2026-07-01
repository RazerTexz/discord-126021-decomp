package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1713b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final v$d h;
    public final v$c i;

    public b(String str, String str2, int i, String str3, String str4, String str5, v$d v_d, v$c v_c, b$a b_a) {
        this.f1713b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = v_d;
        this.i = v_c;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String b() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String d() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v
    @Nullable
    public v$c e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        v$d v_d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f1713b.equals(vVar.g()) && this.c.equals(vVar.c()) && this.d == vVar.f() && this.e.equals(vVar.d()) && this.f.equals(vVar.a()) && this.g.equals(vVar.b()) && ((v_d = this.h) != null ? v_d.equals(vVar.h()) : vVar.h() == null)) {
            v$c v_c = this.i;
            if (v_c == null) {
                if (vVar.e() == null) {
                    return true;
                }
            } else if (v_c.equals(vVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.v
    public int f() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String g() {
        return this.f1713b;
    }

    @Override // b.i.c.m.d.m.v
    @Nullable
    public v$d h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f1713b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003;
        v$d v_d = this.h;
        int iHashCode2 = (iHashCode ^ (v_d == null ? 0 : v_d.hashCode())) * 1000003;
        v$c v_c = this.i;
        return iHashCode2 ^ (v_c != null ? v_c.hashCode() : 0);
    }

    @Override // b.i.c.m.d.m.v
    public v$a i() {
        return new b$b(this, null);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CrashlyticsReport{sdkVersion=");
        sbU.append(this.f1713b);
        sbU.append(", gmpAppId=");
        sbU.append(this.c);
        sbU.append(", platform=");
        sbU.append(this.d);
        sbU.append(", installationUuid=");
        sbU.append(this.e);
        sbU.append(", buildVersion=");
        sbU.append(this.f);
        sbU.append(", displayVersion=");
        sbU.append(this.g);
        sbU.append(", session=");
        sbU.append(this.h);
        sbU.append(", ndkPayload=");
        sbU.append(this.i);
        sbU.append("}");
        return sbU.toString();
    }
}
