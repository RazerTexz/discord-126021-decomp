package b.i.a.c.y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.i.a.c.y2.AsynchronousMediaCodecBufferEnqueuer2;
import java.util.ArrayDeque;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.y2.m, reason: use source file name */
/* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsynchronousMediaCodecBufferEnqueuer extends Handler {
    public final /* synthetic */ AsynchronousMediaCodecBufferEnqueuer2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsynchronousMediaCodecBufferEnqueuer(AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2, Looper looper) {
        super(looper);
        this.a = asynchronousMediaCodecBufferEnqueuer2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AsynchronousMediaCodecBufferEnqueuer2.a aVar;
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.a;
        Objects.requireNonNull(asynchronousMediaCodecBufferEnqueuer2);
        int i = message.what;
        if (i == 0) {
            aVar = (AsynchronousMediaCodecBufferEnqueuer2.a) message.obj;
            try {
                asynchronousMediaCodecBufferEnqueuer2.c.queueInputBuffer(aVar.a, aVar.f1309b, aVar.c, aVar.e, aVar.f);
            } catch (RuntimeException e) {
                asynchronousMediaCodecBufferEnqueuer2.f.set(e);
            }
        } else if (i != 1) {
            if (i != 2) {
                asynchronousMediaCodecBufferEnqueuer2.f.set(new IllegalStateException(String.valueOf(message.what)));
            } else {
                asynchronousMediaCodecBufferEnqueuer2.g.b();
            }
            aVar = null;
        } else {
            aVar = (AsynchronousMediaCodecBufferEnqueuer2.a) message.obj;
            int i2 = aVar.a;
            int i3 = aVar.f1309b;
            MediaCodec.CryptoInfo cryptoInfo = aVar.d;
            long j = aVar.e;
            int i4 = aVar.f;
            try {
                synchronized (AsynchronousMediaCodecBufferEnqueuer2.f1308b) {
                    asynchronousMediaCodecBufferEnqueuer2.c.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                }
            } catch (RuntimeException e2) {
                asynchronousMediaCodecBufferEnqueuer2.f.set(e2);
            }
        }
        if (aVar != null) {
            ArrayDeque<AsynchronousMediaCodecBufferEnqueuer2.a> arrayDeque = AsynchronousMediaCodecBufferEnqueuer2.a;
            synchronized (arrayDeque) {
                arrayDeque.add(aVar);
            }
        }
    }
}
