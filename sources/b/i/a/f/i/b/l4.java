package b.i.a.f.i.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.MainThread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l4 implements ServiceConnection {
    public final String j;
    public final /* synthetic */ m4 k;

    public l4(m4 m4Var, String str) {
        this.k = m4Var;
        this.j = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.k.a.g().i.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = b.i.a.f.h.l.e3.a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            b.i.a.f.h.l.e2 d3Var = iInterfaceQueryLocalInterface instanceof b.i.a.f.h.l.e2 ? (b.i.a.f.h.l.e2) iInterfaceQueryLocalInterface : new b.i.a.f.h.l.d3(iBinder);
            if (d3Var == null) {
                this.k.a.g().i.a("Install Referrer Service implementation was not found");
            } else {
                this.k.a.g().n.a("Install Referrer Service connected");
                this.k.a.f().v(new o4(this, d3Var, this));
            }
        } catch (Exception e) {
            this.k.a.g().i.b("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.k.a.g().n.a("Install Referrer Service disconnected");
    }
}
