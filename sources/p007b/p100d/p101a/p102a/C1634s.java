package p007b.p100d.p101a.p102a;

import android.content.Context;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* JADX INFO: renamed from: b.d.a.a.s */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1634s {

    /* JADX INFO: renamed from: a */
    public final Context f2989a;

    /* JADX INFO: renamed from: b */
    public final C1633r f2990b;

    public C1634s(Context context, InterfaceC1622g interfaceC1622g) {
        this.f2989a = context;
        this.f2990b = new C1633r(this, interfaceC1622g);
    }

    /* JADX INFO: renamed from: a */
    public final void m812a() {
        C1633r c1633r = this.f2990b;
        Context context = this.f2989a;
        if (!c1633r.f2987b) {
            C3941a.m5416f("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(c1633r.f2988c.f2990b);
            c1633r.f2987b = false;
        }
    }
}
