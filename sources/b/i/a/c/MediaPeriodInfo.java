package b.i.a.c;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.r1, reason: use source file name */
/* JADX INFO: compiled from: MediaPeriodInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaPeriodInfo {
    public final MediaSource2.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1058b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public MediaPeriodInfo(MediaSource2.a aVar, long j, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        AnimatableValueParser.j(!z5 || z3);
        AnimatableValueParser.j(!z4 || z3);
        if (!z2 || (!z3 && !z4 && !z5)) {
            z6 = true;
        }
        AnimatableValueParser.j(z6);
        this.a = aVar;
        this.f1058b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
    }

    public MediaPeriodInfo a(long j) {
        return j == this.c ? this : new MediaPeriodInfo(this.a, this.f1058b, j, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public MediaPeriodInfo b(long j) {
        return j == this.f1058b ? this : new MediaPeriodInfo(this.a, j, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        return this.f1058b == mediaPeriodInfo.f1058b && this.c == mediaPeriodInfo.c && this.d == mediaPeriodInfo.d && this.e == mediaPeriodInfo.e && this.f == mediaPeriodInfo.f && this.g == mediaPeriodInfo.g && this.h == mediaPeriodInfo.h && this.i == mediaPeriodInfo.i && Util2.a(this.a, mediaPeriodInfo.a);
    }

    public int hashCode() {
        return ((((((((((((((((this.a.hashCode() + 527) * 31) + ((int) this.f1058b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
