package b.i.c.u;

import androidx.annotation.NonNull;
import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends k {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1778b;
    public final long c;

    public a(String str, long j, long j2, C0056a c0056a) {
        this.a = str;
        this.f1778b = j;
        this.c = j2;
    }

    @Override // b.i.c.u.k
    @NonNull
    public String a() {
        return this.a;
    }

    @Override // b.i.c.u.k
    @NonNull
    public long b() {
        return this.c;
    }

    @Override // b.i.c.u.k
    @NonNull
    public long c() {
        return this.f1778b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a()) && this.f1778b == kVar.c() && this.c == kVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.f1778b;
        long j2 = this.c;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("InstallationTokenResult{token=");
        sbU.append(this.a);
        sbU.append(", tokenExpirationTimestamp=");
        sbU.append(this.f1778b);
        sbU.append(", tokenCreationTimestamp=");
        return outline.C(sbU, this.c, "}");
    }
}
