package b.i.a.f.e.h.j;

import android.util.Log;
import b.i.a.f.e.h.a$f;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ ConnectionResult j;
    public final /* synthetic */ g$b k;

    public z(g$b g_b, ConnectionResult connectionResult) {
        this.k = g_b;
        this.j = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.i.a.f.e.k.g gVar;
        g$b g_b = this.k;
        g$a<?> g_a = g_b.f.t.get(g_b.f1362b);
        if (g_a == null) {
            return;
        }
        if (!this.j.x0()) {
            g_a.e(this.j, null);
            return;
        }
        g$b g_b2 = this.k;
        g_b2.e = true;
        if (g_b2.a.o()) {
            g$b g_b3 = this.k;
            if (!g_b3.e || (gVar = g_b3.c) == null) {
                return;
            }
            g_b3.a.b(gVar, g_b3.d);
            return;
        }
        try {
            a$f a_f = this.k.a;
            a_f.b(null, a_f.a());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.k.a.c("Failed to get service from broker.");
            g_a.e(new ConnectionResult(10), null);
        }
    }
}
