package b.i.a.f.e.k;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f1385b;

    @RecentlyNonNull
    public static e a(@RecentlyNonNull Context context) {
        synchronized (a) {
            if (f1385b == null) {
                f1385b = new t0(context.getApplicationContext());
            }
        }
        return f1385b;
    }

    public final void b(@RecentlyNonNull String str, @RecentlyNonNull String str2, int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, boolean z2) {
        q0 q0Var = new q0(str, str2, i, z2);
        t0 t0Var = (t0) this;
        AnimatableValueParser.z(serviceConnection, "ServiceConnection must not be null");
        synchronized (t0Var.c) {
            r0 r0Var = t0Var.c.get(q0Var);
            if (r0Var == null) {
                String strValueOf = String.valueOf(q0Var);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(strValueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!r0Var.j.containsKey(serviceConnection)) {
                String strValueOf2 = String.valueOf(q0Var);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(strValueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            r0Var.j.remove(serviceConnection);
            if (r0Var.j.isEmpty()) {
                t0Var.e.sendMessageDelayed(t0Var.e.obtainMessage(0, q0Var), t0Var.g);
            }
        }
    }

    public abstract boolean c(q0 q0Var, ServiceConnection serviceConnection, String str);
}
