package b.i.a.c;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.ExoPlayerImplInternal2;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ ExoPlayerImpl j;
    public final /* synthetic */ ExoPlayerImplInternal2.d k;

    public /* synthetic */ c0(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal2.d dVar) {
        this.j = exoPlayerImpl;
        this.k = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        boolean z2;
        long jM0;
        ExoPlayerImpl exoPlayerImpl = this.j;
        ExoPlayerImplInternal2.d dVar = this.k;
        int i = exoPlayerImpl.f960x - dVar.c;
        exoPlayerImpl.f960x = i;
        boolean z3 = true;
        if (dVar.d) {
            exoPlayerImpl.f961y = dVar.e;
            exoPlayerImpl.f962z = true;
        }
        if (dVar.f) {
            exoPlayerImpl.A = dVar.g;
        }
        if (i == 0) {
            Timeline timeline = dVar.f1012b.f1146b;
            if (!exoPlayerImpl.F.f1146b.q() && timeline.q()) {
                exoPlayerImpl.G = -1;
                exoPlayerImpl.H = 0L;
            }
            if (!timeline.q()) {
                List listAsList = Arrays.asList(((PlaylistTimeline) timeline).r);
                AnimatableValueParser.D(listAsList.size() == exoPlayerImpl.m.size());
                for (int i2 = 0; i2 < listAsList.size(); i2++) {
                    exoPlayerImpl.m.get(i2).f963b = (Timeline) listAsList.get(i2);
                }
            }
            long j2 = -9223372036854775807L;
            if (exoPlayerImpl.f962z) {
                if (dVar.f1012b.c.equals(exoPlayerImpl.F.c) && dVar.f1012b.e == exoPlayerImpl.F.t) {
                    z3 = false;
                }
                if (z3) {
                    if (timeline.q() || dVar.f1012b.c.a()) {
                        jM0 = dVar.f1012b.e;
                    } else {
                        PlaybackInfo playbackInfo = dVar.f1012b;
                        jM0 = exoPlayerImpl.m0(timeline, playbackInfo.c, playbackInfo.e);
                    }
                    j2 = jM0;
                }
                j = j2;
                z2 = z3;
            } else {
                j = -9223372036854775807L;
                z2 = false;
            }
            exoPlayerImpl.f962z = false;
            exoPlayerImpl.s0(dVar.f1012b, 1, exoPlayerImpl.A, false, z2, exoPlayerImpl.f961y, j, -1);
        }
    }
}
