package b.a.q;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f260b;
    public final a c;
    public final int d;
    public final a e;

    public j0(b bVar, b bVar2, a aVar, int i, a aVar2) {
        d0.z.d.m.checkNotNullParameter(bVar, "videoBudget");
        d0.z.d.m.checkNotNullParameter(bVar2, "videoCapture");
        d0.z.d.m.checkNotNullParameter(aVar, "videoBitrate");
        d0.z.d.m.checkNotNullParameter(aVar2, "desktopBitrate");
        this.a = bVar;
        this.f260b = bVar2;
        this.c = aVar;
        this.d = i;
        this.e = aVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return d0.z.d.m.areEqual(this.a, j0Var.a) && d0.z.d.m.areEqual(this.f260b, j0Var.f260b) && d0.z.d.m.areEqual(this.c, j0Var.c) && this.d == j0Var.d && d0.z.d.m.areEqual(this.e, j0Var.e);
    }

    public int hashCode() {
        b bVar = this.a;
        int iHashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        b bVar2 = this.f260b;
        int iHashCode2 = (iHashCode + (bVar2 != null ? bVar2.hashCode() : 0)) * 31;
        a aVar = this.c;
        int iHashCode3 = (((iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31) + this.d) * 31;
        a aVar2 = this.e;
        return iHashCode3 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("VideoQualityManagerOptions(videoBudget=");
        sbU.append(this.a);
        sbU.append(", videoCapture=");
        sbU.append(this.f260b);
        sbU.append(", videoBitrate=");
        sbU.append(this.c);
        sbU.append(", videoBitrateFloor=");
        sbU.append(this.d);
        sbU.append(", desktopBitrate=");
        sbU.append(this.e);
        sbU.append(")");
        return sbU.toString();
    }
}
