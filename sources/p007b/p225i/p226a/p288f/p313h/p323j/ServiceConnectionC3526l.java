package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;

/* JADX INFO: renamed from: b.i.a.f.h.j.l */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC3526l implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public volatile InterfaceC3525k0 f9754j;

    /* JADX INFO: renamed from: k */
    public volatile boolean f9755k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C3522j f9756l;

    public ServiceConnectionC3526l(C3522j c3522j) {
        this.f9756l = c3522j;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1460d.m575u("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.f9756l.m4429H("Service connected with null binder");
                    notifyAll();
                    return;
                }
                InterfaceC3525k0 c3527l0 = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        c3527l0 = iInterfaceQueryLocalInterface instanceof InterfaceC3525k0 ? (InterfaceC3525k0) iInterfaceQueryLocalInterface : new C3527l0(iBinder);
                        this.f9756l.m4427C("Bound to IAnalyticsService interface");
                    } else {
                        this.f9756l.m4426A("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.f9756l.m4429H("Service connect failed to get IAnalyticsService");
                }
                if (c3527l0 == null) {
                    try {
                        C3398a c3398aM4181b = C3398a.m4181b();
                        C3522j c3522j = this.f9756l;
                        c3398aM4181b.m4183c(c3522j.f9684j.f9722b, c3522j.f9742l);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (this.f9755k) {
                    this.f9754j = c3527l0;
                } else {
                    this.f9756l.m4428D("onServiceConnected received after the timeout limit");
                    this.f9756l.m4435q().m3968a(new RunnableC3528m(this, c3527l0));
                }
                notifyAll();
            } catch (Throwable th) {
                notifyAll();
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C1460d.m575u("AnalyticsServiceConnection.onServiceDisconnected");
        this.f9756l.m4435q().m3968a(new RunnableC3530n(this, componentName));
    }
}
