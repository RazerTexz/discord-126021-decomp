package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p260g3.C2781r;
import p007b.p225i.p226a.p242c.p265v2.C2955c;
import p007b.p225i.p355b.p356a.InterfaceC4492l;

/* JADX INFO: renamed from: b.i.a.c.y2.l */
/* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class C3140l implements InterfaceC3148t {

    /* JADX INFO: renamed from: a */
    public final MediaCodec f9059a;

    /* JADX INFO: renamed from: b */
    public final C3143o f9060b;

    /* JADX INFO: renamed from: c */
    public final C3142n f9061c;

    /* JADX INFO: renamed from: d */
    public final boolean f9062d;

    /* JADX INFO: renamed from: e */
    public boolean f9063e;

    /* JADX INFO: renamed from: f */
    public int f9064f = 0;

    /* JADX INFO: renamed from: g */
    @Nullable
    public Surface f9065g;

    /* JADX INFO: renamed from: b.i.a.c.y2.l$b */
    /* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
    public static final class b implements InterfaceC3148t.b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC4492l<HandlerThread> f9066a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC4492l<HandlerThread> f9067b;

        public b(final int i, boolean z2) {
            InterfaceC4492l<HandlerThread> interfaceC4492l = new InterfaceC4492l() { // from class: b.i.a.c.y2.a
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new HandlerThread(C3140l.m3833l(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
                }
            };
            InterfaceC4492l<HandlerThread> interfaceC4492l2 = new InterfaceC4492l() { // from class: b.i.a.c.y2.b
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new HandlerThread(C3140l.m3833l(i, "ExoPlayer:MediaCodecQueueingThread:"));
                }
            };
            this.f9066a = interfaceC4492l;
            this.f9067b = interfaceC4492l2;
        }

        @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3140l mo3845a(InterfaceC3148t.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.f9107a.f9112a;
            C3140l c3140l = null;
            try {
                String strValueOf = String.valueOf(str);
                C1460d.m515f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    C3140l c3140l2 = new C3140l(mediaCodecCreateByCodecName, this.f9066a.get(), this.f9067b.get(), false, null);
                    try {
                        C1460d.m508d0();
                        C3140l.m3832k(c3140l2, aVar.f9108b, aVar.f9110d, aVar.f9111e, 0, false);
                        return c3140l2;
                    } catch (Exception e) {
                        e = e;
                        c3140l = c3140l2;
                        if (c3140l != null) {
                            c3140l.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }
    }

    public C3140l(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, a aVar) {
        this.f9059a = mediaCodec;
        this.f9060b = new C3143o(handlerThread);
        this.f9061c = new C3142n(mediaCodec, handlerThread2);
        this.f9062d = z2;
    }

    /* JADX INFO: renamed from: k */
    public static void m3832k(C3140l c3140l, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z2) {
        C3143o c3143o = c3140l.f9060b;
        MediaCodec mediaCodec = c3140l.f9059a;
        C1460d.m426D(c3143o.f9085c == null);
        c3143o.f9084b.start();
        Handler handler = new Handler(c3143o.f9084b.getLooper());
        mediaCodec.setCallback(c3143o, handler);
        c3143o.f9085c = handler;
        C1460d.m515f("configureCodec");
        c3140l.f9059a.configure(mediaFormat, surface, mediaCrypto, i);
        C1460d.m508d0();
        if (z2) {
            c3140l.f9065g = c3140l.f9059a.createInputSurface();
        }
        C3142n c3142n = c3140l.f9061c;
        if (!c3142n.f9076h) {
            c3142n.f9072d.start();
            c3142n.f9073e = new HandlerC3141m(c3142n, c3142n.f9072d.getLooper());
            c3142n.f9076h = true;
        }
        C1460d.m515f("startCodec");
        c3140l.f9059a.start();
        C1460d.m508d0();
        c3140l.f9064f = 1;
    }

    /* JADX INFO: renamed from: l */
    public static String m3833l(int i, String str) {
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

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: a */
    public boolean mo3834a() {
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: b */
    public void mo3835b(int i, int i2, C2955c c2955c, long j, int i3) {
        C3142n c3142n = this.f9061c;
        c3142n.m3852f();
        C3142n.a aVarM3849e = C3142n.m3849e();
        aVarM3849e.f9077a = i;
        aVarM3849e.f9078b = i2;
        aVarM3849e.f9079c = 0;
        aVarM3849e.f9081e = j;
        aVarM3849e.f9082f = i3;
        MediaCodec.CryptoInfo cryptoInfo = aVarM3849e.f9080d;
        cryptoInfo.numSubSamples = c2955c.f7907f;
        cryptoInfo.numBytesOfClearData = C3142n.m3848c(c2955c.f7905d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = C3142n.m3848c(c2955c.f7906e, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrM3847b = C3142n.m3847b(c2955c.f7903b, cryptoInfo.key);
        Objects.requireNonNull(bArrM3847b);
        cryptoInfo.key = bArrM3847b;
        byte[] bArrM3847b2 = C3142n.m3847b(c2955c.f7902a, cryptoInfo.iv);
        Objects.requireNonNull(bArrM3847b2);
        cryptoInfo.iv = bArrM3847b2;
        cryptoInfo.mode = c2955c.f7904c;
        if (C2738e0.f6708a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(c2955c.f7908g, c2955c.f7909h));
        }
        c3142n.f9073e.obtainMessage(1, aVarM3849e).sendToTarget();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: c */
    public void mo3836c(int i, long j) {
        this.f9059a.releaseOutputBuffer(i, j);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: d */
    public int mo3837d() {
        int iM3861b;
        C3143o c3143o = this.f9060b;
        synchronized (c3143o.f9083a) {
            iM3861b = -1;
            if (!c3143o.m3854b()) {
                IllegalStateException illegalStateException = c3143o.f9095m;
                if (illegalStateException != null) {
                    c3143o.f9095m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = c3143o.f9092j;
                if (codecException != null) {
                    c3143o.f9092j = null;
                    throw codecException;
                }
                C3147s c3147s = c3143o.f9086d;
                if (!(c3147s.f9104c == 0)) {
                    iM3861b = c3147s.m3861b();
                }
            }
        }
        return iM3861b;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: e */
    public int mo3838e(MediaCodec.BufferInfo bufferInfo) {
        int iM3861b;
        C3143o c3143o = this.f9060b;
        synchronized (c3143o.f9083a) {
            iM3861b = -1;
            if (!c3143o.m3854b()) {
                IllegalStateException illegalStateException = c3143o.f9095m;
                if (illegalStateException != null) {
                    c3143o.f9095m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = c3143o.f9092j;
                if (codecException != null) {
                    c3143o.f9092j = null;
                    throw codecException;
                }
                C3147s c3147s = c3143o.f9087e;
                if (!(c3147s.f9104c == 0)) {
                    iM3861b = c3147s.m3861b();
                    if (iM3861b >= 0) {
                        C1460d.m438H(c3143o.f9090h);
                        MediaCodec.BufferInfo bufferInfoRemove = c3143o.f9088f.remove();
                        bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                    } else if (iM3861b == -2) {
                        c3143o.f9090h = c3143o.f9089g.remove();
                    }
                }
            }
        }
        return iM3861b;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: f */
    public void mo3839f(final InterfaceC3148t.c cVar, Handler handler) {
        m3844m();
        this.f9059a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: b.i.a.c.y2.c
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                C3140l c3140l = this.f9047a;
                InterfaceC3148t.c cVar2 = cVar;
                Objects.requireNonNull(c3140l);
                ((C2781r.b) cVar2).m3176b(c3140l, j, j2);
            }
        }, handler);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void flush() {
        this.f9061c.m3851d();
        this.f9059a.flush();
        final C3143o c3143o = this.f9060b;
        final MediaCodec mediaCodec = this.f9059a;
        Objects.requireNonNull(mediaCodec);
        final Runnable runnable = new Runnable() { // from class: b.i.a.c.y2.j
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        };
        synchronized (c3143o.f9083a) {
            c3143o.f9093k++;
            Handler handler = c3143o.f9085c;
            int i = C2738e0.f6708a;
            handler.post(new Runnable() { // from class: b.i.a.c.y2.d
                @Override // java.lang.Runnable
                public final void run() {
                    C3143o c3143o2 = c3143o;
                    Runnable runnable2 = runnable;
                    synchronized (c3143o2.f9083a) {
                        if (!c3143o2.f9094l) {
                            long j = c3143o2.f9093k - 1;
                            c3143o2.f9093k = j;
                            if (j <= 0) {
                                if (j < 0) {
                                    c3143o2.m3855c(new IllegalStateException());
                                } else {
                                    c3143o2.m3853a();
                                    try {
                                        runnable2.run();
                                    } catch (IllegalStateException e) {
                                        c3143o2.m3855c(e);
                                    } catch (Exception e2) {
                                        c3143o2.m3855c(new IllegalStateException(e2));
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: g */
    public void mo3840g(int i) {
        m3844m();
        this.f9059a.setVideoScalingMode(i);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        C3143o c3143o = this.f9060b;
        synchronized (c3143o.f9083a) {
            mediaFormat = c3143o.f9090h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @Nullable
    /* JADX INFO: renamed from: h */
    public ByteBuffer mo3841h(int i) {
        return this.f9059a.getInputBuffer(i);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    /* JADX INFO: renamed from: i */
    public void mo3842i(Surface surface) {
        m3844m();
        this.f9059a.setOutputSurface(surface);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    @Nullable
    /* JADX INFO: renamed from: j */
    public ByteBuffer mo3843j(int i) {
        return this.f9059a.getOutputBuffer(i);
    }

    /* JADX INFO: renamed from: m */
    public final void m3844m() {
        if (this.f9062d) {
            try {
                this.f9061c.m3850a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        C3142n c3142n = this.f9061c;
        c3142n.m3852f();
        C3142n.a aVarM3849e = C3142n.m3849e();
        aVarM3849e.f9077a = i;
        aVarM3849e.f9078b = i2;
        aVarM3849e.f9079c = i3;
        aVarM3849e.f9081e = j;
        aVarM3849e.f9082f = i4;
        Handler handler = c3142n.f9073e;
        int i5 = C2738e0.f6708a;
        handler.obtainMessage(0, aVarM3849e).sendToTarget();
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void release() {
        try {
            if (this.f9064f == 1) {
                C3142n c3142n = this.f9061c;
                if (c3142n.f9076h) {
                    c3142n.m3851d();
                    c3142n.f9072d.quit();
                }
                c3142n.f9076h = false;
                C3143o c3143o = this.f9060b;
                synchronized (c3143o.f9083a) {
                    c3143o.f9094l = true;
                    c3143o.f9084b.quit();
                    c3143o.m3853a();
                }
            }
            this.f9064f = 2;
            Surface surface = this.f9065g;
            if (surface != null) {
                surface.release();
            }
            if (this.f9063e) {
                return;
            }
            this.f9059a.release();
            this.f9063e = true;
        } catch (Throwable th) {
            Surface surface2 = this.f9065g;
            if (surface2 != null) {
                surface2.release();
            }
            if (!this.f9063e) {
                this.f9059a.release();
                this.f9063e = true;
            }
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void releaseOutputBuffer(int i, boolean z2) {
        this.f9059a.releaseOutputBuffer(i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t
    public void setParameters(Bundle bundle) {
        m3844m();
        this.f9059a.setParameters(bundle);
    }
}
