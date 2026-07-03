package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.MainThread;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractBinderC3637e3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3623d3;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3636e2;

/* JADX INFO: renamed from: b.i.a.f.i.b.l4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC4103l4 implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public final String f10940j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4114m4 f10941k;

    public ServiceConnectionC4103l4(C4114m4 c4114m4, String str) {
        this.f10941k = c4114m4;
        this.f10940j = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f10941k.f10963a.mo5726g().f11144i.m5860a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = AbstractBinderC3637e3.f9901a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            InterfaceC3636e2 c3623d3 = iInterfaceQueryLocalInterface instanceof InterfaceC3636e2 ? (InterfaceC3636e2) iInterfaceQueryLocalInterface : new C3623d3(iBinder);
            if (c3623d3 == null) {
                this.f10941k.f10963a.mo5726g().f11144i.m5860a("Install Referrer Service implementation was not found");
            } else {
                this.f10941k.f10963a.mo5726g().f11149n.m5860a("Install Referrer Service connected");
                this.f10941k.f10963a.mo5725f().m5852v(new RunnableC4136o4(this, c3623d3, this));
            }
        } catch (Exception e) {
            this.f10941k.f10963a.mo5726g().f11144i.m5861b("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f10941k.f10963a.mo5726g().f11149n.m5860a("Install Referrer Service disconnected");
    }
}
