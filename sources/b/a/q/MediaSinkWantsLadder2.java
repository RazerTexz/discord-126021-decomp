package b.a.q;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.b, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder2 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f256b;
    public final int c;
    public final Integer d;

    public MediaSinkWantsLadder2(int i, int i2, int i3, Integer num) {
        this.a = i;
        this.f256b = i2;
        this.c = i3;
        this.d = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder2)) {
            return false;
        }
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = (MediaSinkWantsLadder2) obj;
        return this.a == mediaSinkWantsLadder2.a && this.f256b == mediaSinkWantsLadder2.f256b && this.c == mediaSinkWantsLadder2.c && Intrinsics3.areEqual(this.d, mediaSinkWantsLadder2.d);
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.f256b) * 31) + this.c) * 31;
        Integer num = this.d;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("IVideoQuality(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f256b);
        sbU.append(", framerate=");
        sbU.append(this.c);
        sbU.append(", pixelCount=");
        return outline.F(sbU, this.d, ")");
    }
}
