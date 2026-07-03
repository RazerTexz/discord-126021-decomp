package p007b.p225i.p226a.p288f.p313h.p326m;

import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.f.h.m.i */
/* JADX INFO: loaded from: classes3.dex */
public final class C3932i extends AbstractC3935l<MessageListener> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ List f10459a;

    public C3932i(List list) {
        this.f10459a = list;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k.b
    /* JADX INFO: renamed from: a */
    public final void mo4107a(Object obj) {
        MessageListener messageListener = (MessageListener) obj;
        for (Update update : this.f10459a) {
            if (update.m9123w0(1)) {
                messageListener.onFound(update.f20766l);
            }
            if (update.m9123w0(2)) {
                messageListener.onLost(update.f20766l);
            }
            if (update.m9123w0(4)) {
                messageListener.onDistanceChanged(update.f20766l, update.f20767m);
            }
            if (update.m9123w0(8)) {
                messageListener.onBleSignalChanged(update.f20766l, update.f20768n);
            }
        }
    }
}
