package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: b.i.a.c.y2.o, reason: use source file name */
/* JADX INFO: compiled from: AsynchronousMediaCodecCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

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
    public MediaCodec.CodecException j;

    @GuardedBy("lock")
    public long k;

    @GuardedBy("lock")
    public boolean l;

    @Nullable
    @GuardedBy("lock")
    public IllegalStateException m;
    public final Object a = new Object();

    @GuardedBy("lock")
    public final IntArrayQueue d = new IntArrayQueue();

    @GuardedBy("lock")
    public final IntArrayQueue e = new IntArrayQueue();

    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f = new ArrayDeque<>();

    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> g = new ArrayDeque<>();

    public AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f1310b = handlerThread;
    }

    @GuardedBy("lock")
    public final void a() {
        if (!this.g.isEmpty()) {
            this.i = this.g.getLast();
        }
        IntArrayQueue intArrayQueue = this.d;
        intArrayQueue.a = 0;
        intArrayQueue.f1313b = -1;
        intArrayQueue.c = 0;
        IntArrayQueue intArrayQueue2 = this.e;
        intArrayQueue2.a = 0;
        intArrayQueue2.f1313b = -1;
        intArrayQueue2.c = 0;
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

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.a) {
            this.j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.a) {
            this.d.a(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            MediaFormat mediaFormat = this.i;
            if (mediaFormat != null) {
                this.e.a(-2);
                this.g.add(mediaFormat);
                this.i = null;
            }
            this.e.a(i);
            this.f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.a) {
            this.e.a(-2);
            this.g.add(mediaFormat);
            this.i = null;
        }
    }
}
