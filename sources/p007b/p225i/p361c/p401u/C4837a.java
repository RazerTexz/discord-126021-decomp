package p007b.p225i.p361c.p401u;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.u.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4837a extends AbstractC4847k {

    /* JADX INFO: renamed from: a */
    public final String f12918a;

    /* JADX INFO: renamed from: b */
    public final long f12919b;

    /* JADX INFO: renamed from: c */
    public final long f12920c;

    public C4837a(String str, long j, long j2, a aVar) {
        this.f12918a = str;
        this.f12919b = j;
        this.f12920c = j2;
    }

    @Override // p007b.p225i.p361c.p401u.AbstractC4847k
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6750a() {
        return this.f12918a;
    }

    @Override // p007b.p225i.p361c.p401u.AbstractC4847k
    @NonNull
    /* JADX INFO: renamed from: b */
    public long mo6751b() {
        return this.f12920c;
    }

    @Override // p007b.p225i.p361c.p401u.AbstractC4847k
    @NonNull
    /* JADX INFO: renamed from: c */
    public long mo6752c() {
        return this.f12919b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4847k)) {
            return false;
        }
        AbstractC4847k abstractC4847k = (AbstractC4847k) obj;
        return this.f12918a.equals(abstractC4847k.mo6750a()) && this.f12919b == abstractC4847k.mo6752c() && this.f12920c == abstractC4847k.mo6751b();
    }

    public int hashCode() {
        int iHashCode = (this.f12918a.hashCode() ^ 1000003) * 1000003;
        long j = this.f12919b;
        long j2 = this.f12920c;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InstallationTokenResult{token=");
        sbM833U.append(this.f12918a);
        sbM833U.append(", tokenExpirationTimestamp=");
        sbM833U.append(this.f12919b);
        sbM833U.append(", tokenCreationTimestamp=");
        return C1643a.m815C(sbM833U, this.f12920c, "}");
    }
}
