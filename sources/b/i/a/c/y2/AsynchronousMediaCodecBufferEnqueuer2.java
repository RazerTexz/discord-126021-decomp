package b.i.a.c.y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.ConditionVariable;
import b.i.a.c.f3.Util2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.c.y2.n, reason: use source file name */
/* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public class AsynchronousMediaCodecBufferEnqueuer2 {

    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<a> a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1308b = new Object();
    public final MediaCodec c;
    public final HandlerThread d;
    public Handler e;
    public final AtomicReference<RuntimeException> f;
    public final ConditionVariable g;
    public boolean h;

    /* JADX INFO: renamed from: b.i.a.c.y2.n$a */
    /* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1309b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;
    }

    public AsynchronousMediaCodecBufferEnqueuer2(MediaCodec mediaCodec, HandlerThread handlerThread) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.c = mediaCodec;
        this.d = handlerThread;
        this.g = conditionVariable;
        this.f = new AtomicReference<>();
    }

    @Nullable
    public static byte[] b(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] c(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static a e() {
        ArrayDeque<a> arrayDeque = a;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new a();
            }
            return arrayDeque.removeFirst();
        }
    }

    public final void a() throws InterruptedException {
        this.g.a();
        Handler handler = this.e;
        int i = Util2.a;
        handler.obtainMessage(2).sendToTarget();
        ConditionVariable conditionVariable = this.g;
        synchronized (conditionVariable) {
            while (!conditionVariable.f971b) {
                conditionVariable.wait();
            }
        }
    }

    public void d() {
        if (this.h) {
            try {
                Handler handler = this.e;
                int i = Util2.a;
                handler.removeCallbacksAndMessages(null);
                a();
                f();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void f() {
        RuntimeException andSet = this.f.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }
}
