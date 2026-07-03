package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.e.k.s0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3380s0 implements Handler.Callback {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3382t0 f9563j;

    public /* synthetic */ C3380s0(C3382t0 c3382t0) {
        this.f9563j = c3382t0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f9563j.f9564c) {
                C3376q0 c3376q0 = (C3376q0) message.obj;
                ServiceConnectionC3378r0 serviceConnectionC3378r0 = this.f9563j.f9564c.get(c3376q0);
                if (serviceConnectionC3378r0 != null && serviceConnectionC3378r0.f9553j.isEmpty()) {
                    if (serviceConnectionC3378r0.f9555l) {
                        serviceConnectionC3378r0.f9559p.f9566e.removeMessages(1, serviceConnectionC3378r0.f9557n);
                        C3382t0 c3382t0 = serviceConnectionC3378r0.f9559p;
                        c3382t0.f9567f.m4183c(c3382t0.f9565d, serviceConnectionC3378r0);
                        serviceConnectionC3378r0.f9555l = false;
                        serviceConnectionC3378r0.f9554k = 2;
                    }
                    this.f9563j.f9564c.remove(c3376q0);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f9563j.f9564c) {
            C3376q0 c3376q1 = (C3376q0) message.obj;
            ServiceConnectionC3378r0 serviceConnectionC3378r1 = this.f9563j.f9564c.get(c3376q1);
            if (serviceConnectionC3378r1 != null && serviceConnectionC3378r1.f9554k == 3) {
                String strValueOf = String.valueOf(c3376q1);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(strValueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName componentName = serviceConnectionC3378r1.f9558o;
                if (componentName == null) {
                    Objects.requireNonNull(c3376q1);
                    componentName = null;
                }
                if (componentName == null) {
                    String str = c3376q1.f9548c;
                    Objects.requireNonNull(str, "null reference");
                    componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                }
                serviceConnectionC3378r1.onServiceDisconnected(componentName);
            }
        }
        return true;
    }
}
