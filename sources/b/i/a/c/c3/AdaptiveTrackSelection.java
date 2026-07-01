package b.i.a.c.c3;

import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.i.a.c.a3.TrackGroup;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.b.b.ImmutableList2;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.c3.f, reason: use source file name */
/* JADX INFO: compiled from: AdaptiveTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public final BandwidthMeter f;
    public final Clock4 g;

    /* JADX INFO: renamed from: b.i.a.c.c3.f$a */
    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f896b;

        public a(long j, long j2) {
            this.a = j;
            this.f896b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f896b == aVar.f896b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.f896b);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.f$b */
    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static class b implements ExoTrackSelection2.b {
        public final Clock4 a = Clock4.a;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, long j, long j2, long j3, int i2, int i3, float f, float f2, List<a> list, Clock4 clock4) {
        super(trackGroup, iArr, i);
        if (j3 < j) {
            Log.w("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
        }
        this.f = bandwidthMeter;
        ImmutableList2.n(list);
        this.g = clock4;
    }

    public static void m(List<ImmutableList2.a<a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList2.a<a> aVar = list.get(i);
            if (aVar != null) {
                aVar.b(new a(j, jArr[i]));
            }
        }
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public int b() {
        return 0;
    }

    @Override // b.i.a.c.c3.BaseTrackSelection, b.i.a.c.c3.ExoTrackSelection2
    @CallSuper
    public void e() {
    }

    @Override // b.i.a.c.c3.BaseTrackSelection, b.i.a.c.c3.ExoTrackSelection2
    @CallSuper
    public void g() {
    }

    @Override // b.i.a.c.c3.BaseTrackSelection, b.i.a.c.c3.ExoTrackSelection2
    public void i(float f) {
    }
}
