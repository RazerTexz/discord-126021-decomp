package p007b.p225i.p226a.p288f.p330i.p332b;

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
import com.google.android.gms.common.ConnectionResult;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;

/* JADX INFO: renamed from: b.i.a.f.i.b.k8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC4096k8 implements ServiceConnection, AbstractC3345b.a, AbstractC3345b.b {

    /* JADX INFO: renamed from: j */
    public volatile boolean f10892j;

    /* JADX INFO: renamed from: k */
    public volatile C4168r3 f10893k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4161q7 f10894l;

    public ServiceConnectionC4096k8(C4161q7 c4161q7) {
        this.f10894l = c4161q7;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b.a
    @MainThread
    /* JADX INFO: renamed from: c */
    public final void mo4144c(int i) {
        C1460d.m575u("MeasurementServiceConnection.onConnectionSuspended");
        this.f10894l.mo5726g().f11148m.m5860a("Service connection suspended");
        this.f10894l.mo5725f().m5852v(new RunnableC4140o8(this));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b.b
    @MainThread
    /* JADX INFO: renamed from: g */
    public final void mo4146g(@NonNull ConnectionResult connectionResult) {
        C1460d.m575u("MeasurementServiceConnection.onConnectionFailed");
        C4202u4 c4202u4 = this.f10894l.f11202a;
        C4157q3 c4157q3 = c4202u4.f11262j;
        C4157q3 c4157q4 = (c4157q3 == null || !c4157q3.m5856n()) ? null : c4202u4.f11262j;
        if (c4157q4 != null) {
            c4157q4.f11144i.m5861b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f10892j = false;
            this.f10893k = null;
        }
        this.f10894l.mo5725f().m5852v(new RunnableC4129n8(this));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b.a
    @MainThread
    /* JADX INFO: renamed from: i */
    public final void mo4145i(@Nullable Bundle bundle) {
        C1460d.m575u("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f10894l.mo5725f().m5852v(new RunnableC4107l8(this, this.f10893k.m4142w()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f10893k = null;
                this.f10892j = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1460d.m575u("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f10892j = false;
                this.f10894l.mo5726g().f11141f.m5860a("Service connected with null binder");
                return;
            }
            InterfaceC4068i3 c4091k3 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c4091k3 = iInterfaceQueryLocalInterface instanceof InterfaceC4068i3 ? (InterfaceC4068i3) iInterfaceQueryLocalInterface : new C4091k3(iBinder);
                    this.f10894l.mo5726g().f11149n.m5860a("Bound to IMeasurementService interface");
                } else {
                    this.f10894l.mo5726g().f11141f.m5861b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f10894l.mo5726g().f11141f.m5860a("Service connect failed to get IMeasurementService");
            }
            if (c4091k3 == null) {
                this.f10892j = false;
                try {
                    C3398a c3398aM4181b = C3398a.m4181b();
                    C4161q7 c4161q7 = this.f10894l;
                    c3398aM4181b.m4183c(c4161q7.f11202a.f11254b, c4161q7.f11153c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f10894l.mo5725f().m5852v(new RunnableC4085j8(this, c4091k3));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        C1460d.m575u("MeasurementServiceConnection.onServiceDisconnected");
        this.f10894l.mo5726g().f11148m.m5860a("Service disconnected");
        this.f10894l.mo5725f().m5852v(new RunnableC4118m8(this, componentName));
    }
}
