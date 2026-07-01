package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCodec$BufferInfo;
import android.media.MediaCodec$Callback;
import android.media.MediaCodec$CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: AsynchronousMediaCodecCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class o extends MediaCodec$Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f1310b;
    public Handler c;

    @Nullable
    @GuardedBy("lock")
    public MediaFormat h;

    @Nullable
    @GuardedBy("lock")
    public MediaFormat i;

    @Nullable
    @GuardedBy("lock")
    public MediaCodec$CodecException j;

    @GuardedBy("lock")
    public long k;

    @GuardedBy("lock")
    public boolean l;

    @Nullable
    @GuardedBy("lock")
    public IllegalStateException m;
    public final Object a = new Object();

    @GuardedBy("lock")
    public final s d = new s();

    @GuardedBy("lock")
    public final s e = new s();

    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec$BufferInfo> f = new ArrayDeque<>();

    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> g = new ArrayDeque<>();

    public o(HandlerThread handlerThread) {
        this.f1310b = handlerThread;
    }

    @GuardedBy("lock")
    public final void a() {
        if (!this.g.isEmpty()) {
            this.i = this.g.getLast();
        }
        s sVar = this.d;
        sVar.a = 0;
        sVar.f1313b = -1;
        sVar.c = 0;
        s sVar2 = this.e;
        sVar2.a = 0;
        sVar2.f1313b = -1;
        sVar2.c = 0;
        this.f.clear();
        this.g.clear();
        this.j = null;
    }

    @GuardedBy("lock")
    public final boolean b() {
        return this.k > 0 || this.l;
    }

    public final void c(IllegalStateException illegalStateException) {
        synchronized (this.a) {
            this.m = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onError(MediaCodec mediaCodec, MediaCodec$CodecException mediaCodec$CodecException) {
        synchronized (this.a) {
            this.j = mediaCodec$CodecException;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.a) {
            this.d.a(i);
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        synchronized (this.a) {
            MediaFormat mediaFormat = this.i;
            if (mediaFormat != null) {
                this.e.a(-2);
                this.g.add(mediaFormat);
                this.i = null;
            }
            this.e.a(i);
            this.f.add(mediaCodec$BufferInfo);
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.a) {
            this.e.a(-2);
            this.g.add(mediaFormat);
            this.i = null;
        }
    }
}
