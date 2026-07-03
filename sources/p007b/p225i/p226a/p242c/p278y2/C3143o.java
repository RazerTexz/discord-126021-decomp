package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: b.i.a.c.y2.o */
/* JADX INFO: compiled from: AsynchronousMediaCodecCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class C3143o extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b */
    public final HandlerThread f9084b;

    /* JADX INFO: renamed from: c */
    public Handler f9085c;

    /* JADX INFO: renamed from: h */
    @Nullable
    @GuardedBy("lock")
    public MediaFormat f9090h;

    /* JADX INFO: renamed from: i */
    @Nullable
    @GuardedBy("lock")
    public MediaFormat f9091i;

    /* JADX INFO: renamed from: j */
    @Nullable
    @GuardedBy("lock")
    public MediaCodec.CodecException f9092j;

    /* JADX INFO: renamed from: k */
    @GuardedBy("lock")
    public long f9093k;

    /* JADX INFO: renamed from: l */
    @GuardedBy("lock")
    public boolean f9094l;

    /* JADX INFO: renamed from: m */
    @Nullable
    @GuardedBy("lock")
    public IllegalStateException f9095m;

    /* JADX INFO: renamed from: a */
    public final Object f9083a = new Object();

    /* JADX INFO: renamed from: d */
    @GuardedBy("lock")
    public final C3147s f9086d = new C3147s();

    /* JADX INFO: renamed from: e */
    @GuardedBy("lock")
    public final C3147s f9087e = new C3147s();

    /* JADX INFO: renamed from: f */
    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f9088f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g */
    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> f9089g = new ArrayDeque<>();

    public C3143o(HandlerThread handlerThread) {
        this.f9084b = handlerThread;
    }

    @GuardedBy("lock")
    /* JADX INFO: renamed from: a */
    public final void m3853a() {
        if (!this.f9089g.isEmpty()) {
            this.f9091i = this.f9089g.getLast();
        }
        C3147s c3147s = this.f9086d;
        c3147s.f9102a = 0;
        c3147s.f9103b = -1;
        c3147s.f9104c = 0;
        C3147s c3147s2 = this.f9087e;
        c3147s2.f9102a = 0;
        c3147s2.f9103b = -1;
        c3147s2.f9104c = 0;
        this.f9088f.clear();
        this.f9089g.clear();
        this.f9092j = null;
    }

    @GuardedBy("lock")
    /* JADX INFO: renamed from: b */
    public final boolean m3854b() {
        return this.f9093k > 0 || this.f9094l;
    }

    /* JADX INFO: renamed from: c */
    public final void m3855c(IllegalStateException illegalStateException) {
        synchronized (this.f9083a) {
            this.f9095m = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f9083a) {
            this.f9092j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.f9083a) {
            this.f9086d.m3860a(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f9083a) {
            MediaFormat mediaFormat = this.f9091i;
            if (mediaFormat != null) {
                this.f9087e.m3860a(-2);
                this.f9089g.add(mediaFormat);
                this.f9091i = null;
            }
            this.f9087e.m3860a(i);
            this.f9088f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f9083a) {
            this.f9087e.m3860a(-2);
            this.f9089g.add(mediaFormat);
            this.f9091i = null;
        }
    }
}
