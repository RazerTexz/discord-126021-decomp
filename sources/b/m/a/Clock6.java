package b.m.a;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.d, reason: use source file name */
/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Clock6 {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f1904b;

    public Clock6(long j, Long l) {
        this.a = j;
        this.f1904b = l;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Clock6) {
                Clock6 clock6 = (Clock6) obj;
                if (!(this.a == clock6.a) || !Intrinsics3.areEqual(this.f1904b, clock6.f1904b)) {
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
        StringBuilder sbU = outline.U("KronosTime(posixTimeMs=");
        sbU.append(this.a);
        sbU.append(", timeSinceLastNtpSyncMs=");
        return outline.G(sbU, this.f1904b, ")");
    }
}
