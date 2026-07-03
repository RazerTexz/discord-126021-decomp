package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p278y2.C3142n;

/* JADX INFO: renamed from: b.i.a.c.y2.m */
/* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* JADX INFO: loaded from: classes3.dex */
public class HandlerC3141m extends Handler {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3142n f9068a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3141m(C3142n c3142n, Looper looper) {
        super(looper);
        this.f9068a = c3142n;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C3142n.a aVar;
        C3142n c3142n = this.f9068a;
        Objects.requireNonNull(c3142n);
        int i = message.what;
        if (i == 0) {
            aVar = (C3142n.a) message.obj;
            try {
                c3142n.f9071c.queueInputBuffer(aVar.f9077a, aVar.f9078b, aVar.f9079c, aVar.f9081e, aVar.f9082f);
            } catch (RuntimeException e) {
                c3142n.f9074f.set(e);
            }
        } else if (i != 1) {
            if (i != 2) {
                c3142n.f9074f.set(new IllegalStateException(String.valueOf(message.what)));
            } else {
                c3142n.f9075g.m3026b();
            }
            aVar = null;
        } else {
            aVar = (C3142n.a) message.obj;
            int i2 = aVar.f9077a;
            int i3 = aVar.f9078b;
            MediaCodec.CryptoInfo cryptoInfo = aVar.f9080d;
            long j = aVar.f9081e;
            int i4 = aVar.f9082f;
            try {
                synchronized (C3142n.f9070b) {
                    c3142n.f9071c.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                }
            } catch (RuntimeException e2) {
                c3142n.f9074f.set(e2);
            }
        }
        if (aVar != null) {
            ArrayDeque<C3142n.a> arrayDeque = C3142n.f9069a;
            synchronized (arrayDeque) {
                arrayDeque.add(aVar);
            }
        }
    }
}
