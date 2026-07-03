package p007b.p445m.p446a;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.d */
/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5085d {

    /* JADX INFO: renamed from: a */
    public final long f13644a;

    /* JADX INFO: renamed from: b */
    public final Long f13645b;

    public C5085d(long j, Long l) {
        this.f13644a = j;
        this.f13645b = l;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C5085d) {
                C5085d c5085d = (C5085d) obj;
                if (!(this.f13644a == c5085d.f13644a) || !C12238m.areEqual(this.f13645b, c5085d.f13645b)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f13644a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.f13645b;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("KronosTime(posixTimeMs=");
        sbM833U.append(this.f13644a);
        sbM833U.append(", timeSinceLastNtpSyncMs=");
        return C1643a.m819G(sbM833U, this.f13645b, ")");
    }
}
