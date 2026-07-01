package b.i.c.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import b.i.c.s.d0;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.gms.tasks.Task;
import java.util.Objects;
import java.util.concurrent.Callable;
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
            final d0.a aVar = new d0.a(intent);
            ScheduledExecutorService scheduledExecutorService = d0Var.l;
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(aVar) { // from class: b.i.c.s.b0
                public final d0.a j;

                {
                    this.j = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d0.a aVar2 = this.j;
                    String action = aVar2.a.getAction();
                    StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                    sb.append("Service took too long to process intent: ");
                    sb.append(action);
                    sb.append(" App may get closed.");
                    Log.w("FirebaseInstanceId", sb.toString());
                    aVar2.a();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            b.i.a.f.n.c0<Void> c0Var2 = aVar.f1765b.a;
            c0Var2.f1592b.a(new b.i.a.f.n.r(scheduledExecutorService, new b.i.a.f.n.c(scheduledFutureSchedule) { // from class: b.i.c.s.c0
                public final ScheduledFuture a;

                {
                    this.a = scheduledFutureSchedule;
                }

                @Override // b.i.a.f.n.c
                public final void onComplete(Task task) {
                    this.a.cancel(false);
                }
            }));
            c0Var2.w();
            d0Var.m.add(aVar);
            d0Var.b();
            c0Var = aVar.f1765b.a;
        }
        Executor executor = h.a;
        return c0Var.i(g.j, d.a);
    }

    public Task<Integer> b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = this.c;
        return (!(b.i.a.f.e.o.f.A0() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? b.i.a.f.e.o.f.o(this.d, new Callable(context, intent) { // from class: b.i.c.s.b
            public final Context j;
            public final Intent k;

            {
                this.j = context;
                this.k = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i;
                ComponentName componentNameStartService;
                Context context2 = this.j;
                Intent intent2 = this.k;
                v vVarA = v.a();
                Objects.requireNonNull(vVarA);
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Starting service");
                }
                vVarA.e.offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (vVarA) {
                    str = vVarA.f1774b;
                    if (str == null) {
                        ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                        if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                        } else if (!context2.getPackageName().equals(serviceInfo.packageName) || (str2 = serviceInfo.name) == null) {
                            String str3 = serviceInfo.packageName;
                            String str4 = serviceInfo.name;
                            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
                            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                            sb.append(str3);
                            sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                            sb.append(str4);
                            Log.e("FirebaseInstanceId", sb.toString());
                        } else {
                            if (str2.startsWith(".")) {
                                String strValueOf = String.valueOf(context2.getPackageName());
                                String strValueOf2 = String.valueOf(serviceInfo.name);
                                vVarA.f1774b = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                            } else {
                                vVarA.f1774b = serviceInfo.name;
                            }
                            str = vVarA.f1774b;
                        }
                        str = null;
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", str.length() != 0 ? "Restricting intent to a specific service: ".concat(str) : new String("Restricting intent to a specific service: "));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (vVarA.c(context2)) {
                        componentNameStartService = y.a(context2, intent3);
                    } else {
                        componentNameStartService = context2.startService(intent3);
                        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                    }
                    if (componentNameStartService == null) {
                        Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                        i = 404;
                    } else {
                        i = -1;
                    }
                } catch (IllegalStateException e) {
                    String strValueOf3 = String.valueOf(e);
                    StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 45);
                    sb2.append("Failed to start service while in background: ");
                    sb2.append(strValueOf3);
                    Log.e("FirebaseInstanceId", sb2.toString());
                    i = 402;
                } catch (SecurityException e2) {
                    Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
                    i = 401;
                }
                return Integer.valueOf(i);
            }
        }).j(this.d, new b.i.a.f.n.a(context, intent) { // from class: b.i.c.s.c
            public final Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Intent f1764b;

            {
                this.a = context;
                this.f1764b = intent;
            }

            @Override // b.i.a.f.n.a
            public final Object a(Task task) {
                Context context2 = this.a;
                Intent intent2 = this.f1764b;
                if (!b.i.a.f.e.o.f.A0() || ((Integer) task.l()).intValue() != 402) {
                    return task;
                }
                Task<Integer> taskA = f.a(context2, intent2);
                Executor executor = h.a;
                return taskA.i(g.j, e.a);
            }
        }) : a(context, intent);
    }

    public f(Context context, ExecutorService executorService) {
        this.c = context;
        this.d = executorService;
    }
}
