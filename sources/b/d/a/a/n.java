package b.d.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import java.util.concurrent.Callable;

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
        if (aVar2.l(new Callable() { // from class: b.d.a.a.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int iN;
                n nVar = this.j;
                synchronized (nVar.j) {
                    if (!nVar.k) {
                        int i2 = 3;
                        try {
                            String packageName = nVar.m.e.getPackageName();
                            int i3 = 16;
                            iN = 3;
                            while (true) {
                                if (i3 < 3) {
                                    i3 = 0;
                                    break;
                                }
                                try {
                                    iN = nVar.m.f.N(i3, packageName, "subs");
                                    if (iN == 0) {
                                        break;
                                    }
                                    i3--;
                                } catch (Exception unused) {
                                    i2 = iN;
                                    b.i.a.f.h.n.a.f("BillingClient", "Exception while checking if billing is supported; try to reconnect");
                                    nVar.m.a = 0;
                                    nVar.m.f = null;
                                    iN = i2;
                                }
                            }
                            Objects.requireNonNull(nVar.m);
                            boolean z2 = true;
                            nVar.m.h = i3 >= 3;
                            if (i3 < 3) {
                                b.i.a.f.h.n.a.e("BillingClient", "In-app billing API does not support subscription on this device.");
                            }
                            for (int i4 = 16; i4 >= 3; i4--) {
                                iN = nVar.m.f.N(i4, packageName, "inapp");
                                if (iN == 0) {
                                    nVar.m.i = i4;
                                    break;
                                }
                            }
                            a aVar3 = nVar.m;
                            int i5 = aVar3.i;
                            aVar3.o = i5 >= 16;
                            aVar3.n = i5 >= 15;
                            aVar3.m = i5 >= 14;
                            aVar3.l = i5 >= 10;
                            aVar3.k = i5 >= 9;
                            if (i5 < 6) {
                                z2 = false;
                            }
                            aVar3.j = z2;
                            if (i5 < 3) {
                                b.i.a.f.h.n.a.f("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            }
                            if (iN == 0) {
                                nVar.m.a = 2;
                            } else {
                                nVar.m.a = 0;
                                nVar.m.f = null;
                            }
                        } catch (Exception unused2) {
                        }
                        if (iN == 0) {
                            nVar.a(p.i);
                        } else {
                            nVar.a(p.a);
                        }
                    }
                }
                return null;
            }
        }, 30000L, new Runnable() { // from class: b.d.a.a.l
            @Override // java.lang.Runnable
            public final void run() {
                n nVar = this.j;
                nVar.m.a = 0;
                nVar.m.f = null;
                nVar.a(p.k);
            }
        }, aVar2.i()) == null) {
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
