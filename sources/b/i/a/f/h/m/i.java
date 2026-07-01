package b.i.a.f.h.m;

import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends l<MessageListener> {
    public final /* synthetic */ List a;

    public i(List list) {
        this.a = list;
    }

    @Override // b.i.a.f.e.h.j.k.b
    public final void a(Object obj) {
        MessageListener messageListener = (MessageListener) obj;
        for (Update update : this.a) {
            if (update.w0(1)) {
                messageListener.onFound(update.l);
            }
            if (update.w0(2)) {
                messageListener.onLost(update.l);
            }
            if (update.w0(4)) {
                messageListener.onDistanceChanged(update.l, update.m);
            }
            if (update.w0(8)) {
                messageListener.onBleSignalChanged(update.l, update.n);
            }
        }
    }
}
