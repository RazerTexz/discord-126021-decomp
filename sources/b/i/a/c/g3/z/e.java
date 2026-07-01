package b.i.a.c.g3.z;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.v0;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CameraMotionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends v0 {
    public final DecoderInputBuffer u;
    public final x v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public d f996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f997y;

    public e() {
        super(6);
        this.u = new DecoderInputBuffer(1);
        this.v = new x();
    }

    @Override // b.i.a.c.v0
    public void B() {
        d dVar = this.f996x;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // b.i.a.c.v0
    public void D(long j, boolean z2) {
        this.f997y = Long.MIN_VALUE;
        d dVar = this.f996x;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // b.i.a.c.v0
    public void H(j1[] j1VarArr, long j, long j2) {
        this.w = j2;
    }

    @Override // b.i.a.c.g2
    public int a(j1 j1Var) {
        return "application/x-camera-motion".equals(j1Var.w) ? 4 : 0;
    }

    @Override // b.i.a.c.f2
    public boolean b() {
        return j();
    }

    @Override // b.i.a.c.f2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.f2, b.i.a.c.g2
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // b.i.a.c.f2
    public void q(long j, long j2) {
        float[] fArr;
        while (!j() && this.f997y < 100000 + j) {
            this.u.p();
            if (I(A(), this.u, 0) != -4 || this.u.n()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.u;
            this.f997y = decoderInputBuffer.n;
            if (this.f996x != null && !decoderInputBuffer.m()) {
                this.u.s();
                ByteBuffer byteBuffer = this.u.l;
                int i = e0.a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    this.v.C(byteBuffer.array(), byteBuffer.limit());
                    this.v.E(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i2 = 0; i2 < 3; i2++) {
                        fArr2[i2] = Float.intBitsToFloat(this.v.h());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.f996x.a(this.f997y - this.w, fArr);
                }
            }
        }
    }

    @Override // b.i.a.c.v0, b.i.a.c.b2$b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 8) {
            this.f996x = (d) obj;
        }
    }
}
