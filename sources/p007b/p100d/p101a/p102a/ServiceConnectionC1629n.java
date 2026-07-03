package p007b.p100d.p101a.p102a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractBinderC3943c;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3942b;
import p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d;

/* JADX INFO: renamed from: b.d.a.a.n */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1629n implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public final Object f2968j = new Object();

    /* JADX INFO: renamed from: k */
    public boolean f2969k = false;

    /* JADX INFO: renamed from: l */
    public InterfaceC1616b f2970l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C1614a f2971m;

    public /* synthetic */ ServiceConnectionC1629n(C1614a c1614a, InterfaceC1616b interfaceC1616b) {
        this.f2971m = c1614a;
        this.f2970l = interfaceC1616b;
    }

    /* JADX INFO: renamed from: a */
    public final void m811a(BillingResult billingResult) {
        synchronized (this.f2968j) {
            InterfaceC1616b interfaceC1616b = this.f2970l;
            if (interfaceC1616b != null) {
                interfaceC1616b.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC3944d c3942b;
        C3941a.m5415e("BillingClient", "Billing service connected.");
        C1614a c1614a = this.f2971m;
        int i = AbstractBinderC3943c.f10480a;
        if (iBinder == null) {
            c3942b = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            c3942b = iInterfaceQueryLocalInterface instanceof InterfaceC3944d ? (InterfaceC3944d) iInterfaceQueryLocalInterface : new C3942b(iBinder);
        }
        c1614a.f2936f = c3942b;
        C1614a c1614a2 = this.f2971m;
        if (c1614a2.m810l(new Callable() { // from class: b.d.a.a.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int iMo5420N;
                ServiceConnectionC1629n serviceConnectionC1629n = this.f2967j;
                synchronized (serviceConnectionC1629n.f2968j) {
                    if (!serviceConnectionC1629n.f2969k) {
                        int i2 = 3;
                        try {
                            String packageName = serviceConnectionC1629n.f2971m.f2935e.getPackageName();
                            int i3 = 16;
                            iMo5420N = 3;
                            while (true) {
                                if (i3 < 3) {
                                    i3 = 0;
                                    break;
                                }
                                try {
                                    iMo5420N = serviceConnectionC1629n.f2971m.f2936f.mo5420N(i3, packageName, "subs");
                                    if (iMo5420N == 0) {
                                        break;
                                    }
                                    i3--;
                                } catch (Exception unused) {
                                    i2 = iMo5420N;
                                    C3941a.m5416f("BillingClient", "Exception while checking if billing is supported; try to reconnect");
                                    serviceConnectionC1629n.f2971m.f2931a = 0;
                                    serviceConnectionC1629n.f2971m.f2936f = null;
                                    iMo5420N = i2;
                                }
                            }
                            Objects.requireNonNull(serviceConnectionC1629n.f2971m);
                            boolean z2 = true;
                            serviceConnectionC1629n.f2971m.f2938h = i3 >= 3;
                            if (i3 < 3) {
                                C3941a.m5415e("BillingClient", "In-app billing API does not support subscription on this device.");
                            }
                            for (int i4 = 16; i4 >= 3; i4--) {
                                iMo5420N = serviceConnectionC1629n.f2971m.f2936f.mo5420N(i4, packageName, "inapp");
                                if (iMo5420N == 0) {
                                    serviceConnectionC1629n.f2971m.f2939i = i4;
                                    break;
                                }
                            }
                            C1614a c1614a3 = serviceConnectionC1629n.f2971m;
                            int i5 = c1614a3.f2939i;
                            c1614a3.f2945o = i5 >= 16;
                            c1614a3.f2944n = i5 >= 15;
                            c1614a3.f2943m = i5 >= 14;
                            c1614a3.f2942l = i5 >= 10;
                            c1614a3.f2941k = i5 >= 9;
                            if (i5 < 6) {
                                z2 = false;
                            }
                            c1614a3.f2940j = z2;
                            if (i5 < 3) {
                                C3941a.m5416f("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            }
                            if (iMo5420N == 0) {
                                serviceConnectionC1629n.f2971m.f2931a = 2;
                            } else {
                                serviceConnectionC1629n.f2971m.f2931a = 0;
                                serviceConnectionC1629n.f2971m.f2936f = null;
                            }
                        } catch (Exception unused2) {
                        }
                        if (iMo5420N == 0) {
                            serviceConnectionC1629n.m811a(C1631p.f2980i);
                        } else {
                            serviceConnectionC1629n.m811a(C1631p.f2972a);
                        }
                    }
                }
                return null;
            }
        }, 30000L, new Runnable() { // from class: b.d.a.a.l
            @Override // java.lang.Runnable
            public final void run() {
                ServiceConnectionC1629n serviceConnectionC1629n = this.f2966j;
                serviceConnectionC1629n.f2971m.f2931a = 0;
                serviceConnectionC1629n.f2971m.f2936f = null;
                serviceConnectionC1629n.m811a(C1631p.f2982k);
            }
        }, c1614a2.m807i()) == null) {
            m811a(this.f2971m.m809k());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C3941a.m5416f("BillingClient", "Billing service disconnected.");
        this.f2971m.f2936f = null;
        this.f2971m.f2931a = 0;
        synchronized (this.f2968j) {
            InterfaceC1616b interfaceC1616b = this.f2970l;
            if (interfaceC1616b != null) {
                interfaceC1616b.onBillingServiceDisconnected();
            }
        }
    }
}
