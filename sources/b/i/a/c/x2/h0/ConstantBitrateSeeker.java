package b.i.a.c.x2.h0;

import b.i.a.c.t2.MpegAudioUtil;
import b.i.a.c.x2.ConstantBitrateSeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.c, reason: use source file name */
/* JADX INFO: compiled from: ConstantBitrateSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.a aVar, boolean z2) {
        super(j, j2, aVar.f, aVar.c, z2);
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long a() {
        return -1L;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long d(long j) {
        return ConstantBitrateSeekMap.e(j, this.f1167b, this.e);
    }
}
