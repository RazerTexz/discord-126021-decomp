package b.i.a.f.e.h.j;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k$c extends b.i.a.f.h.e.c {
    public final /* synthetic */ k a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c(k kVar, Looper looper) {
        super(looper);
        this.a = kVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        b.c.a.a0.d.l(message.what == 1);
        k$b k_b = (k$b) message.obj;
        L l = this.a.f1366b;
        if (l == 0) {
            k_b.b();
            return;
        }
        try {
            k_b.a(l);
        } catch (RuntimeException e) {
            k_b.b();
            throw e;
        }
    }
}
