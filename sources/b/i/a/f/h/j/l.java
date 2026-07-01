package b.i.a.f.h.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements ServiceConnection {
    public volatile k0 j;
    public volatile boolean k;
    public final /* synthetic */ j l;

    public l(j jVar) {
        this.l = jVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AnimatableValueParser.u("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.l.H("Service connected with null binder");
                    notifyAll();
                    return;
                }
                k0 l0Var = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        l0Var = iInterfaceQueryLocalInterface instanceof k0 ? (k0) iInterfaceQueryLocalInterface : new l0(iBinder);
                        this.l.C("Bound to IAnalyticsService interface");
                    } else {
                        this.l.A("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.l.H("Service connect failed to get IAnalyticsService");
                }
                if (l0Var == null) {
                    try {
                        b.i.a.f.e.n.a aVarB = b.i.a.f.e.n.a.b();
                        j jVar = this.l;
                        aVarB.c(jVar.j.f1417b, jVar.l);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (this.k) {
                    this.j = l0Var;
                } else {
                    this.l.D("onServiceConnected received after the timeout limit");
                    this.l.q().a(new m(this, l0Var));
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
        AnimatableValueParser.u("AnalyticsServiceConnection.onServiceDisconnected");
        this.l.q().a(new n(this, componentName));
    }
}
