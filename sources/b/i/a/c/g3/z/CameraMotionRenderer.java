package b.i.a.c.g3.z;

import androidx.annotation.Nullable;
import b.i.a.c.BaseRenderer;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.i.a.c.g3.z.e, reason: use source file name */
/* JADX INFO: compiled from: CameraMotionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraMotionRenderer extends BaseRenderer {
    public final DecoderInputBuffer u;
    public final ParsableByteArray v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public CameraMotionListener f996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f997y;

    public CameraMotionRenderer() {
        super(6);
        this.u = new DecoderInputBuffer(1);
        this.v = new ParsableByteArray();
    }

    @Override // b.i.a.c.BaseRenderer
    public void B() {
        CameraMotionListener cameraMotionListener = this.f996x;
        if (cameraMotionListener != null) {
            cameraMotionListener.c();
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void D(long j, boolean z2) {
        this.f997y = Long.MIN_VALUE;
        CameraMotionListener cameraMotionListener = this.f996x;
        if (cameraMotionListener != null) {
            cameraMotionListener.c();
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void H(Format2[] format2Arr, long j, long j2) {
        this.w = j2;
    }

    @Override // b.i.a.c.RendererCapabilities
    public int a(Format2 format2) {
        return "application/x-camera-motion".equals(format2.w) ? 4 : 0;
    }

    @Override // b.i.a.c.Renderer2
    public boolean b() {
        return j();
    }

    @Override // b.i.a.c.Renderer2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.Renderer2, b.i.a.c.RendererCapabilities
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // b.i.a.c.Renderer2
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
                int i = Util2.a;
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

    @Override // b.i.a.c.BaseRenderer, b.i.a.c.PlayerMessage.b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 8) {
            this.f996x = (CameraMotionListener) obj;
        }
    }
}
