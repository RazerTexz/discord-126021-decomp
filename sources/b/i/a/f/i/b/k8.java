package b.i.a.f.i.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.k.b$a;
import b.i.a.f.e.k.b$b;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k8 implements ServiceConnection, b$a, b$b {
    public volatile boolean j;
    public volatile r3 k;
    public final /* synthetic */ q7 l;

    public k8(q7 q7Var) {
        this.l = q7Var;
    }

    @Override // b.i.a.f.e.k.b$a
    @MainThread
    public final void c(int i) {
        b.c.a.a0.d.u("MeasurementServiceConnection.onConnectionSuspended");
        this.l.g().m.a("Service connection suspended");
        this.l.f().v(new o8(this));
    }

    @Override // b.i.a.f.e.k.b$b
    @MainThread
    public final void g(@NonNull ConnectionResult connectionResult) {
        b.c.a.a0.d.u("MeasurementServiceConnection.onConnectionFailed");
        u4 u4Var = this.l.a;
        q3 q3Var = u4Var.j;
        q3 q3Var2 = (q3Var == null || !q3Var.n()) ? null : u4Var.j;
        if (q3Var2 != null) {
            q3Var2.i.b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.j = false;
            this.k = null;
        }
        this.l.f().v(new n8(this));
    }

    @Override // b.i.a.f.e.k.b$a
    @MainThread
    public final void i(@Nullable Bundle bundle) {
        b.c.a.a0.d.u("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.l.f().v(new l8(this, this.k.w()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.k = null;
                this.j = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.c.a.a0.d.u("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.j = false;
                this.l.g().f.a("Service connected with null binder");
                return;
            }
            i3 k3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    k3Var = iInterfaceQueryLocalInterface instanceof i3 ? (i3) iInterfaceQueryLocalInterface : new k3(iBinder);
                    this.l.g().n.a("Bound to IMeasurementService interface");
                } else {
                    this.l.g().f.b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.l.g().f.a("Service connect failed to get IMeasurementService");
            }
            if (k3Var == null) {
                this.j = false;
                try {
                    b.i.a.f.e.n.a aVarB = b.i.a.f.e.n.a.b();
                    q7 q7Var = this.l;
                    aVarB.c(q7Var.a.f1570b, q7Var.c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.l.f().v(new j8(this, k3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        b.c.a.a0.d.u("MeasurementServiceConnection.onServiceDisconnected");
        this.l.g().m.a("Service disconnected");
        this.l.f().v(new m8(this, componentName));
    }
}
