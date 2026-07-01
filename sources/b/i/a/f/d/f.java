package b.i.a.f.d;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    @Nullable
    public static f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1339b;
    public final ScheduledExecutorService c;
    public g d = new g(this, null);
    public int e = 1;

    @VisibleForTesting
    public f(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
        this.f1339b = context.getApplicationContext();
    }

    public static synchronized f a(Context context) {
        if (a == null) {
            a = new f(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new b.i.a.f.e.o.j.a("MessengerIpcClient"))));
        }
        return a;
    }

    public final synchronized <T> Task<T> b(q<T> qVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(qVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(strValueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.d.b(qVar)) {
            g gVar = new g(this, null);
            this.d = gVar;
            gVar.b(qVar);
        }
        return qVar.f1341b.a;
    }
}
