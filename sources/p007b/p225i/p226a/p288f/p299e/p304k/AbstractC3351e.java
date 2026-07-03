package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3351e {

    /* JADX INFO: renamed from: a */
    public static final Object f9517a = new Object();

    /* JADX INFO: renamed from: b */
    public static AbstractC3351e f9518b;

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public static AbstractC3351e m4152a(@RecentlyNonNull Context context) {
        synchronized (f9517a) {
            if (f9518b == null) {
                f9518b = new C3382t0(context.getApplicationContext());
            }
        }
        return f9518b;
    }

    /* JADX INFO: renamed from: b */
    public final void m4153b(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, boolean z2) {
        C3376q0 c3376q0 = new C3376q0(str, str2, i, z2);
        C3382t0 c3382t0 = (C3382t0) this;
        C1460d.m595z(serviceConnection, "ServiceConnection must not be null");
        synchronized (c3382t0.f9564c) {
            ServiceConnectionC3378r0 serviceConnectionC3378r0 = c3382t0.f9564c.get(c3376q0);
            if (serviceConnectionC3378r0 == null) {
                String strValueOf = String.valueOf(c3376q0);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(strValueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!serviceConnectionC3378r0.f9553j.containsKey(serviceConnection)) {
                String strValueOf2 = String.valueOf(c3376q0);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(strValueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            serviceConnectionC3378r0.f9553j.remove(serviceConnection);
            if (serviceConnectionC3378r0.f9553j.isEmpty()) {
                c3382t0.f9566e.sendMessageDelayed(c3382t0.f9566e.obtainMessage(0, c3376q0), c3382t0.f9568g);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract boolean mo4154c(C3376q0 c3376q0, ServiceConnection serviceConnection, String str);
}
