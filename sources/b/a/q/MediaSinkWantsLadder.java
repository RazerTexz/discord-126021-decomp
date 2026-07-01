package b.a.q;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.a, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f255b;
    public final Integer c;

    public MediaSinkWantsLadder(int i, int i2, Integer num) {
        this.a = i;
        this.f255b = i2;
        this.c = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder)) {
            return false;
        }
        MediaSinkWantsLadder mediaSinkWantsLadder = (MediaSinkWantsLadder) obj;
        return this.a == mediaSinkWantsLadder.a && this.f255b == mediaSinkWantsLadder.f255b && Intrinsics3.areEqual(this.c, mediaSinkWantsLadder.c);
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.f255b) * 31;
        Integer num = this.c;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Bitrate(min=");
        sbU.append(this.a);
        sbU.append(", max=");
        sbU.append(this.f255b);
        sbU.append(", target=");
        return outline.F(sbU, this.c, ")");
    }
}
