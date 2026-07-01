package b.i.a.c.y2;

import android.media.MediaCodec$CryptoInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Objects;

/* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends Handler {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Looper looper) {
        super(looper);
        this.a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n$a n_a;
        n nVar = this.a;
        Objects.requireNonNull(nVar);
        int i = message.what;
        if (i == 0) {
            n_a = (n$a) message.obj;
            try {
                nVar.c.queueInputBuffer(n_a.a, n_a.f1309b, n_a.c, n_a.e, n_a.f);
            } catch (RuntimeException e) {
                nVar.f.set(e);
            }
        } else if (i != 1) {
            if (i != 2) {
                nVar.f.set(new IllegalStateException(String.valueOf(message.what)));
            } else {
                nVar.g.b();
            }
            n_a = null;
        } else {
            n_a = (n$a) message.obj;
            int i2 = n_a.a;
            int i3 = n_a.f1309b;
            MediaCodec$CryptoInfo mediaCodec$CryptoInfo = n_a.d;
            long j = n_a.e;
            int i4 = n_a.f;
            try {
                synchronized (n.f1308b) {
                    nVar.c.queueSecureInputBuffer(i2, i3, mediaCodec$CryptoInfo, j, i4);
                }
            } catch (RuntimeException e2) {
                nVar.f.set(e2);
            }
        }
        if (n_a != null) {
            ArrayDeque<n$a> arrayDeque = n.a;
            synchronized (arrayDeque) {
                arrayDeque.add(n_a);
            }
        }
    }
}
