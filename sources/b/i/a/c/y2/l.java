package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCodec$BufferInfo;
import android.media.MediaCodec$CodecException;
import android.media.MediaCodec$CryptoInfo;
import android.media.MediaCodec$CryptoInfo$Pattern;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.e0;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class l implements t {
    public final MediaCodec a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1306b;
    public final n c;
    public final boolean d;
    public boolean e;
    public int f = 0;

    @Nullable
    public Surface g;

    public l(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, l$a l_a) {
        this.a = mediaCodec;
        this.f1306b = new o(handlerThread);
        this.c = new n(mediaCodec, handlerThread2);
        this.d = z2;
    }

    public static void k(l lVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z2) {
        o oVar = lVar.f1306b;
        MediaCodec mediaCodec = lVar.a;
        b.c.a.a0.d.D(oVar.c == null);
        oVar.f1310b.start();
        Handler handler = new Handler(oVar.f1310b.getLooper());
        mediaCodec.setCallback(oVar, handler);
        oVar.c = handler;
        b.c.a.a0.d.f("configureCodec");
        lVar.a.configure(mediaFormat, surface, mediaCrypto, i);
        b.c.a.a0.d.d0();
        if (z2) {
            lVar.g = lVar.a.createInputSurface();
        }
        n nVar = lVar.c;
        if (!nVar.h) {
            nVar.d.start();
            nVar.e = new m(nVar, nVar.d.getLooper());
            nVar.h = true;
        }
        b.c.a.a0.d.f("startCodec");
        lVar.a.start();
        b.c.a.a0.d.d0();
        lVar.f = 1;
    }

    public static String l(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // b.i.a.c.y2.t
    public boolean a() {
        return false;
    }

    @Override // b.i.a.c.y2.t
    public void b(int i, int i2, b.i.a.c.v2.c cVar, long j, int i3) {
        n nVar = this.c;
        nVar.f();
        n$a n_aE = n.e();
        n_aE.a = i;
        n_aE.f1309b = i2;
        n_aE.c = 0;
        n_aE.e = j;
        n_aE.f = i3;
        MediaCodec$CryptoInfo mediaCodec$CryptoInfo = n_aE.d;
        mediaCodec$CryptoInfo.numSubSamples = cVar.f;
        mediaCodec$CryptoInfo.numBytesOfClearData = n.c(cVar.d, mediaCodec$CryptoInfo.numBytesOfClearData);
        mediaCodec$CryptoInfo.numBytesOfEncryptedData = n.c(cVar.e, mediaCodec$CryptoInfo.numBytesOfEncryptedData);
        byte[] bArrB = n.b(cVar.f1141b, mediaCodec$CryptoInfo.key);
        Objects.requireNonNull(bArrB);
        mediaCodec$CryptoInfo.key = bArrB;
        byte[] bArrB2 = n.b(cVar.a, mediaCodec$CryptoInfo.iv);
        Objects.requireNonNull(bArrB2);
        mediaCodec$CryptoInfo.iv = bArrB2;
        mediaCodec$CryptoInfo.mode = cVar.c;
        if (e0.a >= 24) {
            mediaCodec$CryptoInfo.setPattern(new MediaCodec$CryptoInfo$Pattern(cVar.g, cVar.h));
        }
        nVar.e.obtainMessage(1, n_aE).sendToTarget();
    }

    @Override // b.i.a.c.y2.t
    public void c(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // b.i.a.c.y2.t
    public int d() {
        int iB;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            iB = -1;
            if (!oVar.b()) {
                IllegalStateException illegalStateException = oVar.m;
                if (illegalStateException != null) {
                    oVar.m = null;
                    throw illegalStateException;
                }
                MediaCodec$CodecException mediaCodec$CodecException = oVar.j;
                if (mediaCodec$CodecException != null) {
                    oVar.j = null;
                    throw mediaCodec$CodecException;
                }
                s sVar = oVar.d;
                if (!(sVar.c == 0)) {
                    iB = sVar.b();
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.t
    public int e(MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        int iB;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            iB = -1;
            if (!oVar.b()) {
                IllegalStateException illegalStateException = oVar.m;
                if (illegalStateException != null) {
                    oVar.m = null;
                    throw illegalStateException;
                }
                MediaCodec$CodecException mediaCodec$CodecException = oVar.j;
                if (mediaCodec$CodecException != null) {
                    oVar.j = null;
                    throw mediaCodec$CodecException;
                }
                s sVar = oVar.e;
                if (!(sVar.c == 0)) {
                    iB = sVar.b();
                    if (iB >= 0) {
                        b.c.a.a0.d.H(oVar.h);
                        MediaCodec$BufferInfo mediaCodec$BufferInfoRemove = oVar.f.remove();
                        mediaCodec$BufferInfo.set(mediaCodec$BufferInfoRemove.offset, mediaCodec$BufferInfoRemove.size, mediaCodec$BufferInfoRemove.presentationTimeUs, mediaCodec$BufferInfoRemove.flags);
                    } else if (iB == -2) {
                        oVar.h = oVar.g.remove();
                    }
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.t
    public void f(t$c t_c, Handler handler) {
        m();
        this.a.setOnFrameRenderedListener(new c(this, t_c), handler);
    }

    @Override // b.i.a.c.y2.t
    public void flush() {
        this.c.d();
        this.a.flush();
        o oVar = this.f1306b;
        MediaCodec mediaCodec = this.a;
        Objects.requireNonNull(mediaCodec);
        j jVar = new j(mediaCodec);
        synchronized (oVar.a) {
            oVar.k++;
            Handler handler = oVar.c;
            int i = e0.a;
            handler.post(new d(oVar, jVar));
        }
    }

    @Override // b.i.a.c.y2.t
    public void g(int i) {
        m();
        this.a.setVideoScalingMode(i);
    }

    @Override // b.i.a.c.y2.t
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        o oVar = this.f1306b;
        synchronized (oVar.a) {
            mediaFormat = oVar.h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer h(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // b.i.a.c.y2.t
    public void i(Surface surface) {
        m();
        this.a.setOutputSurface(surface);
    }

    @Override // b.i.a.c.y2.t
    @Nullable
    public ByteBuffer j(int i) {
        return this.a.getOutputBuffer(i);
    }

    public final void m() {
        if (this.d) {
            try {
                this.c.a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // b.i.a.c.y2.t
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        n nVar = this.c;
        nVar.f();
        n$a n_aE = n.e();
        n_aE.a = i;
        n_aE.f1309b = i2;
        n_aE.c = i3;
        n_aE.e = j;
        n_aE.f = i4;
        Handler handler = nVar.e;
        int i5 = e0.a;
        handler.obtainMessage(0, n_aE).sendToTarget();
    }

    @Override // b.i.a.c.y2.t
    public void release() {
        try {
            if (this.f == 1) {
                n nVar = this.c;
                if (nVar.h) {
                    nVar.d();
                    nVar.d.quit();
                }
                nVar.h = false;
                o oVar = this.f1306b;
                synchronized (oVar.a) {
                    oVar.l = true;
                    oVar.f1310b.quit();
                    oVar.a();
                }
            }
            this.f = 2;
            Surface surface = this.g;
            if (surface != null) {
                surface.release();
            }
            if (this.e) {
                return;
            }
            this.a.release();
            this.e = true;
        } catch (Throwable th) {
            Surface surface2 = this.g;
            if (surface2 != null) {
                surface2.release();
            }
            if (!this.e) {
                this.a.release();
                this.e = true;
            }
            throw th;
        }
    }

    @Override // b.i.a.c.y2.t
    public void releaseOutputBuffer(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // b.i.a.c.y2.t
    public void setParameters(Bundle bundle) {
        m();
        this.a.setParameters(bundle);
    }
}
