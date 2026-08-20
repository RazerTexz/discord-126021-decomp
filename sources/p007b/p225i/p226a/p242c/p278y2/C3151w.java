package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p260g3.C2781r;
import p007b.p225i.p226a.p242c.p265v2.C2955c;

/* JADX INFO: renamed from: b.i.a.c.y2.w */
/* JADX INFO: compiled from: SynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3151w implements InterfaceC3148t {

    /* JADX INFO: renamed from: a */
    public final MediaCodec f9120a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public ByteBuffer[] f9121b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public ByteBuffer[] f9122c;

    public C3151w(MediaCodec mediaCodec, Surface surface, a aVar) {
        this.f9120a = mediaCodec;
        if (C2738e0.f6708a < 21) {
            this.f9121b = mediaCodec.getInputBuffers();
            this.f9122c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: a */
    public boolean mo3834a() {
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: b */
    public void mo3835b(int i, int i2, C2955c c2955c, long j, int i3) {
        this.f9120a.queueSecureInputBuffer(i, i2, c2955c.f7910i, j, i3);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @RequiresApi(21)
    /* JADX INFO: renamed from: c */
    public void mo3836c(int i, long j) {
        this.f9120a.releaseOutputBuffer(i, j);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: d */
    public int mo3837d() {
        return this.f9120a.dequeueInputBuffer(0L);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: e */
    public int mo3838e(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f9120a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && C2738e0.f6708a < 21) {
                this.f9122c = this.f9120a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @RequiresApi(23)
    /* JADX INFO: renamed from: f */
    public void mo3839f(final InterfaceC3148t.c cVar, Handler handler) {
        this.f9120a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: b.i.a.c.y2.i
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                C3151w c3151w = this.f9055a;
                InterfaceC3148t.c cVar2 = cVar;
                Objects.requireNonNull(c3151w);
                ((C2781r.b) cVar2).m3176b(c3151w, j, j2);
            }
        }, handler);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void flush() {
        this.f9120a.flush();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: g */
    public void mo3840g(int i) {
        this.f9120a.setVideoScalingMode(i);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public MediaFormat getOutputFormat() {
        return this.f9120a.getOutputFormat();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @Nullable
    /* JADX INFO: renamed from: h */
    public ByteBuffer mo3841h(int i) {
        return C2738e0.f6708a >= 21 ? this.f9120a.getInputBuffer(i) : this.f9121b[i];
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @RequiresApi(23)
    /* JADX INFO: renamed from: i */
    public void mo3842i(Surface surface) {
        this.f9120a.setOutputSurface(surface);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @Nullable
    /* JADX INFO: renamed from: j */
    public ByteBuffer mo3843j(int i) {
        return C2738e0.f6708a >= 21 ? this.f9120a.getOutputBuffer(i) : this.f9122c[i];
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.f9120a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void release() {
        this.f9121b = null;
        this.f9122c = null;
        this.f9120a.release();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void releaseOutputBuffer(int i, boolean z2) {
        this.f9120a.releaseOutputBuffer(i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.f9120a.setParameters(bundle);
    }
}
