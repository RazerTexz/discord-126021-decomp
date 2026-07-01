package b.i.a.c;

import android.media.MediaFormat;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k2$c implements b.i.a.c.g3.u, b.i.a.c.g3.z.d, b2$b {

    @Nullable
    public b.i.a.c.g3.u j;

    @Nullable
    public b.i.a.c.g3.z.d k;

    @Nullable
    public b.i.a.c.g3.u l;

    @Nullable
    public b.i.a.c.g3.z.d m;

    public k2$c(k2$a k2_a) {
    }

    @Override // b.i.a.c.g3.z.d
    public void a(long j, float[] fArr) {
        b.i.a.c.g3.z.d dVar = this.m;
        if (dVar != null) {
            dVar.a(j, fArr);
        }
        b.i.a.c.g3.z.d dVar2 = this.k;
        if (dVar2 != null) {
            dVar2.a(j, fArr);
        }
    }

    @Override // b.i.a.c.g3.z.d
    public void c() {
        b.i.a.c.g3.z.d dVar = this.m;
        if (dVar != null) {
            dVar.c();
        }
        b.i.a.c.g3.z.d dVar2 = this.k;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    @Override // b.i.a.c.g3.u
    public void e(long j, long j2, j1 j1Var, @Nullable MediaFormat mediaFormat) {
        b.i.a.c.g3.u uVar = this.l;
        if (uVar != null) {
            uVar.e(j, j2, j1Var, mediaFormat);
        }
        b.i.a.c.g3.u uVar2 = this.j;
        if (uVar2 != null) {
            uVar2.e(j, j2, j1Var, mediaFormat);
        }
    }

    @Override // b.i.a.c.b2$b
    public void r(int i, @Nullable Object obj) {
        if (i == 7) {
            this.j = (b.i.a.c.g3.u) obj;
            return;
        }
        if (i == 8) {
            this.k = (b.i.a.c.g3.z.d) obj;
            return;
        }
        if (i != 10000) {
            return;
        }
        b.i.a.c.g3.z.k kVar = (b.i.a.c.g3.z.k) obj;
        if (kVar == null) {
            this.l = null;
            this.m = null;
        } else {
            this.l = kVar.getVideoFrameMetadataListener();
            this.m = kVar.getCameraMotionListener();
        }
    }
}
