package b.i.c.s;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d0 f1766b;
    public final Context c;
    public final Executor d;

    public f(Context context) {
        this.c = context;
        this.d = a.j;
    }

    public static Task<Integer> a(Context context, Intent intent) {
        d0 d0Var;
        b.i.a.f.n.c0<Void> c0Var;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        synchronized (a) {
            if (f1766b == null) {
                f1766b = new d0(context, "com.google.firebase.MESSAGING_EVENT");
            }
            d0Var = f1766b;
        }
        synchronized (d0Var) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
            }
            d0$a d0_a = new d0$a(intent);
            ScheduledExecutorService scheduledExecutorService = d0Var.l;
            ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new b0(d0_a), 9000L, TimeUnit.MILLISECONDS);
            b.i.a.f.n.c0<Void> c0Var2 = d0_a.f1765b.a;
            c0Var2.f1592b.a(new b.i.a.f.n.r(scheduledExecutorService, new c0(scheduledFutureSchedule)));
            c0Var2.w();
            d0Var.m.add(d0_a);
            d0Var.b();
            c0Var = d0_a.f1765b.a;
        }
        Executor executor = h.a;
        return c0Var.i(g.j, d.a);
    }

    public Task<Integer> b(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.c;
        return (!(b.i.a.f.e.o.f.A0() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? b.i.a.f.e.o.f.o(this.d, new b(context, intent)).j(this.d, new c(context, intent)) : a(context, intent);
    }

    public f(Context context, ExecutorService executorService) {
        this.c = context;
        this.d = executorService;
    }
}
