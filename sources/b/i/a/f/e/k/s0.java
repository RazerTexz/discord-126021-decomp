package b.i.a.f.e.k;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements Handler.Callback {
    public final /* synthetic */ t0 j;

    public /* synthetic */ s0(t0 t0Var) {
        this.j = t0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.j.c) {
                q0 q0Var = (q0) message.obj;
                r0 r0Var = this.j.c.get(q0Var);
                if (r0Var != null && r0Var.j.isEmpty()) {
                    if (r0Var.l) {
                        r0Var.p.e.removeMessages(1, r0Var.n);
                        t0 t0Var = r0Var.p;
                        t0Var.f.c(t0Var.d, r0Var);
                        r0Var.l = false;
                        r0Var.k = 2;
                    }
                    this.j.c.remove(q0Var);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.j.c) {
            q0 q0Var2 = (q0) message.obj;
            r0 r0Var2 = this.j.c.get(q0Var2);
            if (r0Var2 != null && r0Var2.k == 3) {
                String strValueOf = String.valueOf(q0Var2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(strValueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName componentName = r0Var2.o;
                if (componentName == null) {
                    Objects.requireNonNull(q0Var2);
                    componentName = null;
                }
                if (componentName == null) {
                    String str = q0Var2.c;
                    Objects.requireNonNull(str, "null reference");
                    componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                }
                r0Var2.onServiceDisconnected(componentName);
            }
        }
        return true;
    }
}
