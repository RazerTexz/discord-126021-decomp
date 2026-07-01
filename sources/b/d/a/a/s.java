package b.d.a.a;

import android.content.Context;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f453b;

    public s(Context context, g gVar) {
        this.a = context;
        this.f453b = new r(this, gVar);
    }

    public final void a() {
        r rVar = this.f453b;
        Context context = this.a;
        if (!rVar.f452b) {
            b.i.a.f.h.n.a.f("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(rVar.c.f453b);
            rVar.f452b = false;
        }
    }
}
