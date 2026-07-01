package b.m.a;

import d0.z.d.m;

/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f1904b;

    public d(long j, Long l) {
        this.a = j;
        this.f1904b = l;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (!(this.a == dVar.a) || !m.areEqual(this.f1904b, dVar.f1904b)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.f1904b;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("KronosTime(posixTimeMs=");
        sbU.append(this.a);
        sbU.append(", timeSinceLastNtpSyncMs=");
        return b.d.b.a.a.G(sbU, this.f1904b, ")");
    }
}
