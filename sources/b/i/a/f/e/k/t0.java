package b.i.a.f.e.k;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import b.c.a.a0.AnimatableValueParser;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends e {
    public final Context d;
    public final Handler e;
    public final HashMap<q0, r0> c = new HashMap<>();
    public final b.i.a.f.e.n.a f = b.i.a.f.e.n.a.b();
    public final long g = 5000;
    public final long h = 300000;

    public t0(Context context) {
        this.d = context.getApplicationContext();
        this.e = new b.i.a.f.h.g.d(context.getMainLooper(), new s0(this));
    }

    @Override // b.i.a.f.e.k.e
    public final boolean c(q0 q0Var, ServiceConnection serviceConnection, String str) {
        boolean z2;
        AnimatableValueParser.z(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.c) {
            try {
                r0 r0Var = this.c.get(q0Var);
                if (r0Var == null) {
                    r0Var = new r0(this, q0Var);
                    r0Var.j.put(serviceConnection, serviceConnection);
                    r0Var.a(str);
                    this.c.put(q0Var, r0Var);
                } else {
                    this.e.removeMessages(0, q0Var);
                    if (r0Var.j.containsKey(serviceConnection)) {
                        String strValueOf = String.valueOf(q0Var);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(strValueOf);
                        throw new IllegalStateException(sb.toString());
                    }
                    r0Var.j.put(serviceConnection, serviceConnection);
                    int i = r0Var.k;
                    if (i == 1) {
                        ((k0) serviceConnection).onServiceConnected(r0Var.o, r0Var.m);
                    } else if (i == 2) {
                        r0Var.a(str);
                    }
                }
                z2 = r0Var.l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
