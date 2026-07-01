package b.d.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.billingclient.api.BillingResult;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements ServiceConnection {
    public final Object j = new Object();
    public boolean k = false;
    public b l;
    public final /* synthetic */ a m;

    public /* synthetic */ n(a aVar, b bVar) {
        this.m = aVar;
        this.l = bVar;
    }

    public final void a(BillingResult billingResult) {
        synchronized (this.j) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.i.a.f.h.n.d bVar;
        b.i.a.f.h.n.a.e("BillingClient", "Billing service connected.");
        a aVar = this.m;
        int i = b.i.a.f.h.n.c.a;
        if (iBinder == null) {
            bVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            bVar = iInterfaceQueryLocalInterface instanceof b.i.a.f.h.n.d ? (b.i.a.f.h.n.d) iInterfaceQueryLocalInterface : new b.i.a.f.h.n.b(iBinder);
        }
        aVar.f = bVar;
        a aVar2 = this.m;
        if (aVar2.l(new m(this), 30000L, new l(this), aVar2.i()) == null) {
            a(this.m.k());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b.i.a.f.h.n.a.f("BillingClient", "Billing service disconnected.");
        this.m.f = null;
        this.m.a = 0;
        synchronized (this.j) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.onBillingServiceDisconnected();
            }
        }
    }
}
