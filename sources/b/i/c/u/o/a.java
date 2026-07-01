package b.i.c.u.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1784b;
    public final c$a c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;

    public a(String str, c$a c_a, String str2, String str3, long j, long j2, String str4, a$a a_a) {
        this.f1784b = str;
        this.c = c_a;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = j2;
        this.h = str4;
    }

    @Override // b.i.c.u.o.d
    @Nullable
    public String a() {
        return this.d;
    }

    @Override // b.i.c.u.o.d
    public long b() {
        return this.f;
    }

    @Override // b.i.c.u.o.d
    @Nullable
    public String c() {
        return this.f1784b;
    }

    @Override // b.i.c.u.o.d
    @Nullable
    public String d() {
        return this.h;
    }

    @Override // b.i.c.u.o.d
    @Nullable
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f1784b;
        if (str3 != null ? str3.equals(dVar.c()) : dVar.c() == null) {
            if (this.c.equals(dVar.f()) && ((str = this.d) != null ? str.equals(dVar.a()) : dVar.a() == null) && ((str2 = this.e) != null ? str2.equals(dVar.e()) : dVar.e() == null) && this.f == dVar.b() && this.g == dVar.g()) {
                String str4 = this.h;
                if (str4 == null) {
                    if (dVar.d() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.c.u.o.d
    @NonNull
    public c$a f() {
        return this.c;
    }

    @Override // b.i.c.u.o.d
    public long g() {
        return this.g;
    }

    public int hashCode() {
        String str = this.f1784b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str2 = this.d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // b.i.c.u.o.d
    public d$a k() {
        return new a$b(this, null);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PersistedInstallationEntry{firebaseInstallationId=");
        sbU.append(this.f1784b);
        sbU.append(", registrationStatus=");
        sbU.append(this.c);
        sbU.append(", authToken=");
        sbU.append(this.d);
        sbU.append(", refreshToken=");
        sbU.append(this.e);
        sbU.append(", expiresInSecs=");
        sbU.append(this.f);
        sbU.append(", tokenCreationEpochInSecs=");
        sbU.append(this.g);
        sbU.append(", fisError=");
        return b.d.b.a.a.J(sbU, this.h, "}");
    }
}
