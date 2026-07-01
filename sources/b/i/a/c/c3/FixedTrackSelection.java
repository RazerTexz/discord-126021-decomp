package b.i.a.c.c3;

import b.i.a.c.a3.TrackGroup;

/* JADX INFO: renamed from: b.i.a.c.c3.k, reason: use source file name */
/* JADX INFO: compiled from: FixedTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FixedTrackSelection extends BaseTrackSelection {
    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2) {
        super(trackGroup, new int[]{i}, i2);
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public int b() {
        return 0;
    }
}
