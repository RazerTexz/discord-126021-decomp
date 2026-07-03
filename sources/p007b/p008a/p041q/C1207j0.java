package p007b.p008a.p041q;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.j0 */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1207j0 {

    /* JADX INFO: renamed from: a */
    public final C1190b f1635a;

    /* JADX INFO: renamed from: b */
    public final C1190b f1636b;

    /* JADX INFO: renamed from: c */
    public final C1188a f1637c;

    /* JADX INFO: renamed from: d */
    public final int f1638d;

    /* JADX INFO: renamed from: e */
    public final C1188a f1639e;

    public C1207j0(C1190b c1190b, C1190b c1190b2, C1188a c1188a, int i, C1188a c1188a2) {
        C12238m.checkNotNullParameter(c1190b, "videoBudget");
        C12238m.checkNotNullParameter(c1190b2, "videoCapture");
        C12238m.checkNotNullParameter(c1188a, "videoBitrate");
        C12238m.checkNotNullParameter(c1188a2, "desktopBitrate");
        this.f1635a = c1190b;
        this.f1636b = c1190b2;
        this.f1637c = c1188a;
        this.f1638d = i;
        this.f1639e = c1188a2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1207j0)) {
            return false;
        }
        C1207j0 c1207j0 = (C1207j0) obj;
        return C12238m.areEqual(this.f1635a, c1207j0.f1635a) && C12238m.areEqual(this.f1636b, c1207j0.f1636b) && C12238m.areEqual(this.f1637c, c1207j0.f1637c) && this.f1638d == c1207j0.f1638d && C12238m.areEqual(this.f1639e, c1207j0.f1639e);
    }

    public int hashCode() {
        C1190b c1190b = this.f1635a;
        int iHashCode = (c1190b != null ? c1190b.hashCode() : 0) * 31;
        C1190b c1190b2 = this.f1636b;
        int iHashCode2 = (iHashCode + (c1190b2 != null ? c1190b2.hashCode() : 0)) * 31;
        C1188a c1188a = this.f1637c;
        int iHashCode3 = (((iHashCode2 + (c1188a != null ? c1188a.hashCode() : 0)) * 31) + this.f1638d) * 31;
        C1188a c1188a2 = this.f1639e;
        return iHashCode3 + (c1188a2 != null ? c1188a2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("VideoQualityManagerOptions(videoBudget=");
        sbM833U.append(this.f1635a);
        sbM833U.append(", videoCapture=");
        sbM833U.append(this.f1636b);
        sbM833U.append(", videoBitrate=");
        sbM833U.append(this.f1637c);
        sbM833U.append(", videoBitrateFloor=");
        sbM833U.append(this.f1638d);
        sbM833U.append(", desktopBitrate=");
        sbM833U.append(this.f1639e);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
