package p007b.p225i.p226a.p288f.p298d;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;

/* JADX INFO: renamed from: b.i.a.f.d.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3231f {

    /* JADX INFO: renamed from: a */
    @Nullable
    public static C3231f f9258a;

    /* JADX INFO: renamed from: b */
    public final Context f9259b;

    /* JADX INFO: renamed from: c */
    public final ScheduledExecutorService f9260c;

    /* JADX INFO: renamed from: d */
    public ServiceConnectionC3232g f9261d = new ServiceConnectionC3232g(this, null);

    /* JADX INFO: renamed from: e */
    public int f9262e = 1;

    @VisibleForTesting
    public C3231f(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f9260c = scheduledExecutorService;
        this.f9259b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C3231f m4001a(Context context) {
        if (f9258a == null) {
            f9258a = new C3231f(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new ThreadFactoryC3408a("MessengerIpcClient"))));
        }
        return f9258a;
    }

    /* JADX INFO: renamed from: b */
    public final synchronized <T> Task<T> m4002b(AbstractC3242q<T> abstractC3242q) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(abstractC3242q);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(strValueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f9261d.m4004b(abstractC3242q)) {
            ServiceConnectionC3232g serviceConnectionC3232g = new ServiceConnectionC3232g(this, null);
            this.f9261d = serviceConnectionC3232g;
            serviceConnectionC3232g.m4004b(abstractC3242q);
        }
        return abstractC3242q.f9280b.f20845a;
    }
}
