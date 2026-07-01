package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.MediaCodecVideoRenderer;
import b.i.a.c.v2.CryptoInfo;
import b.i.a.c.y2.MediaCodecAdapter;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.y2.w, reason: use source file name */
/* JADX INFO: compiled from: SynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    public final MediaCodec a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f1316b;

    @Nullable
    public ByteBuffer[] c;

    public SynchronousMediaCodecAdapter(MediaCodec mediaCodec, Surface surface, a aVar) {
        this.a = mediaCodec;
        if (Util2.a < 21) {
            this.f1316b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public boolean a() {
        return false;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void b(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, cryptoInfo.i, j, i3);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @RequiresApi(21)
    public void c(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public int d() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && Util2.a < 21) {
                this.c = this.a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @RequiresApi(23)
    public void f(final MediaCodecAdapter.c cVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: b.i.a.c.y2.i
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = this.a;
                MediaCodecAdapter.c cVar2 = cVar;
                Objects.requireNonNull(synchronousMediaCodecAdapter);
                ((MediaCodecVideoRenderer.b) cVar2).b(synchronousMediaCodecAdapter, j, j2);
            }
        }, handler);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void flush() {
        this.a.flush();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void g(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return this.a.getOutputFormat();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @Nullable
    public ByteBuffer h(int i) {
        return Util2.a >= 21 ? this.a.getInputBuffer(i) : this.f1316b[i];
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @RequiresApi(23)
    public void i(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @Nullable
    public ByteBuffer j(int i) {
        return Util2.a >= 21 ? this.a.getOutputBuffer(i) : this.c[i];
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void release() {
        this.f1316b = null;
        this.c = null;
        this.a.release();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void releaseOutputBuffer(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.a.setParameters(bundle);
    }
}
