package b.i.c.u.p;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1788b;
    public final String c;
    public final f d;
    public final d$a e;

    public a(String str, String str2, String str3, f fVar, d$a d_a, a$a a_a) {
        this.a = str;
        this.f1788b = str2;
        this.c = str3;
        this.d = fVar;
        this.e = d_a;
    }

    @Override // b.i.c.u.p.d
    @Nullable
    public f a() {
        return this.d;
    }

    @Override // b.i.c.u.p.d
    @Nullable
    public String b() {
        return this.f1788b;
    }

    @Override // b.i.c.u.p.d
    @Nullable
    public String c() {
        return this.c;
    }

    @Override // b.i.c.u.p.d
    @Nullable
    public d$a d() {
        return this.e;
    }

    @Override // b.i.c.u.p.d
    @Nullable
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.a;
        if (str != null ? str.equals(dVar.e()) : dVar.e() == null) {
            String str2 = this.f1788b;
            if (str2 != null ? str2.equals(dVar.b()) : dVar.b() == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(dVar.c()) : dVar.c() == null) {
                    f fVar = this.d;
                    if (fVar != null ? fVar.equals(dVar.a()) : dVar.a() == null) {
                        d$a d_a = this.e;
                        if (d_a == null) {
                            if (dVar.d() == null) {
                                return true;
                            }
                        } else if (d_a.equals(dVar.d())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f1788b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d$a d_a = this.e;
        return iHashCode4 ^ (d_a != null ? d_a.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("InstallationResponse{uri=");
        sbU.append(this.a);
        sbU.append(", fid=");
        sbU.append(this.f1788b);
        sbU.append(", refreshToken=");
        sbU.append(this.c);
        sbU.append(", authToken=");
        sbU.append(this.d);
        sbU.append(", responseCode=");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
