package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import java.util.HashMap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p313h.p320g.HandlerC3484d;

/* JADX INFO: renamed from: b.i.a.f.e.k.t0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3382t0 extends AbstractC3351e {

    /* JADX INFO: renamed from: d */
    public final Context f9565d;

    /* JADX INFO: renamed from: e */
    public final Handler f9566e;

    /* JADX INFO: renamed from: c */
    public final HashMap<C3376q0, ServiceConnectionC3378r0> f9564c = new HashMap<>();

    /* JADX INFO: renamed from: f */
    public final C3398a f9567f = C3398a.m4181b();

    /* JADX INFO: renamed from: g */
    public final long f9568g = 5000;

    /* JADX INFO: renamed from: h */
    public final long f9569h = 300000;

    public C3382t0(Context context) {
        this.f9565d = context.getApplicationContext();
        this.f9566e = new HandlerC3484d(context.getMainLooper(), new C3380s0(this));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3351e
    /* JADX INFO: renamed from: c */
    public final boolean mo4154c(C3376q0 c3376q0, ServiceConnection serviceConnection, String str) {
        boolean z2;
        C1460d.m595z(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f9564c) {
            try {
                ServiceConnectionC3378r0 serviceConnectionC3378r0 = this.f9564c.get(c3376q0);
                if (serviceConnectionC3378r0 == null) {
                    serviceConnectionC3378r0 = new ServiceConnectionC3378r0(this, c3376q0);
                    serviceConnectionC3378r0.f9553j.put(serviceConnection, serviceConnection);
                    serviceConnectionC3378r0.m4176a(str);
                    this.f9564c.put(c3376q0, serviceConnectionC3378r0);
                } else {
                    this.f9566e.removeMessages(0, c3376q0);
                    if (serviceConnectionC3378r0.f9553j.containsKey(serviceConnection)) {
                        String strValueOf = String.valueOf(c3376q0);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(strValueOf);
                        throw new IllegalStateException(sb.toString());
                    }
                    serviceConnectionC3378r0.f9553j.put(serviceConnection, serviceConnection);
                    int i = serviceConnectionC3378r0.f9554k;
                    if (i == 1) {
                        ((ServiceConnectionC3364k0) serviceConnection).onServiceConnected(serviceConnectionC3378r0.f9558o, serviceConnectionC3378r0.f9556m);
                    } else if (i == 2) {
                        serviceConnectionC3378r0.m4176a(str);
                    }
                }
                z2 = serviceConnectionC3378r0.f9555l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
