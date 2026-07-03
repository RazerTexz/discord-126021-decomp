package p007b.p225i.p361c.p398s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.gms.tasks.Task;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4374r;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* JADX INFO: renamed from: b.i.c.s.f */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4815f {

    /* JADX INFO: renamed from: a */
    public static final Object f12861a = new Object();

    /* JADX INFO: renamed from: b */
    public static ServiceConnectionC4812d0 f12862b;

    /* JADX INFO: renamed from: c */
    public final Context f12863c;

    /* JADX INFO: renamed from: d */
    public final Executor f12864d;

    public C4815f(Context context) {
        this.f12863c = context;
        this.f12864d = ExecutorC4805a.f12843j;
    }

    /* JADX INFO: renamed from: a */
    public static Task<Integer> m6724a(Context context, Intent intent) {
        ServiceConnectionC4812d0 serviceConnectionC4812d0;
        C4358c0<Void> c4358c0;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        synchronized (f12861a) {
            if (f12862b == null) {
                f12862b = new ServiceConnectionC4812d0(context, "com.google.firebase.MESSAGING_EVENT");
            }
            serviceConnectionC4812d0 = f12862b;
        }
        synchronized (serviceConnectionC4812d0) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
            }
            final ServiceConnectionC4812d0.a aVar = new ServiceConnectionC4812d0.a(intent);
            ScheduledExecutorService scheduledExecutorService = serviceConnectionC4812d0.f12854l;
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(aVar) { // from class: b.i.c.s.b0

                /* JADX INFO: renamed from: j */
                public final ServiceConnectionC4812d0.a f12847j;

                {
                    this.f12847j = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ServiceConnectionC4812d0.a aVar2 = this.f12847j;
                    String action = aVar2.f12858a.getAction();
                    StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                    sb.append("Service took too long to process intent: ");
                    sb.append(action);
                    sb.append(" App may get closed.");
                    Log.w("FirebaseInstanceId", sb.toString());
                    aVar2.m6723a();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            C4358c0<Void> c4358c1 = aVar.f12859b.f20845a;
            c4358c1.f11472b.m6031a(new C4374r(scheduledExecutorService, new InterfaceC4357c(scheduledFutureSchedule) { // from class: b.i.c.s.c0

                /* JADX INFO: renamed from: a */
                public final ScheduledFuture f12850a;

                {
                    this.f12850a = scheduledFutureSchedule;
                }

                @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
                public final void onComplete(Task task) {
                    this.f12850a.cancel(false);
                }
            }));
            c4358c1.m6028w();
            serviceConnectionC4812d0.f12855m.add(aVar);
            serviceConnectionC4812d0.m6721b();
            c4358c0 = aVar.f12859b.f20845a;
        }
        Executor executor = C4817h.f12866a;
        return c4358c0.mo6014i(ExecutorC4816g.f12865j, C4811d.f12851a);
    }

    /* JADX INFO: renamed from: b */
    public Task<Integer> m6725b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = this.f12863c;
        return (!(C3404f.m4190A0() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? C3404f.m4323o(this.f12864d, new Callable(context, intent) { // from class: b.i.c.s.b

            /* JADX INFO: renamed from: j */
            public final Context f12845j;

            /* JADX INFO: renamed from: k */
            public final Intent f12846k;

            {
                this.f12845j = context;
                this.f12846k = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i;
                ComponentName componentNameStartService;
                Context context2 = this.f12845j;
                Intent intent2 = this.f12846k;
                C4831v c4831vM6735a = C4831v.m6735a();
                Objects.requireNonNull(c4831vM6735a);
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Starting service");
                }
                c4831vM6735a.f12900e.offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (c4831vM6735a) {
                    str = c4831vM6735a.f12897b;
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
                                c4831vM6735a.f12897b = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                            } else {
                                c4831vM6735a.f12897b = serviceInfo.name;
                            }
                            str = c4831vM6735a.f12897b;
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
                    if (c4831vM6735a.m6737c(context2)) {
                        componentNameStartService = C4834y.m6749a(context2, intent3);
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
        }).mo6015j(this.f12864d, new InterfaceC4353a(context, intent) { // from class: b.i.c.s.c

            /* JADX INFO: renamed from: a */
            public final Context f12848a;

            /* JADX INFO: renamed from: b */
            public final Intent f12849b;

            {
                this.f12848a = context;
                this.f12849b = intent;
            }

            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
            /* JADX INFO: renamed from: a */
            public final Object mo4012a(Task task) {
                Context context2 = this.f12848a;
                Intent intent2 = this.f12849b;
                if (!C3404f.m4190A0() || ((Integer) task.mo6017l()).intValue() != 402) {
                    return task;
                }
                Task<Integer> taskM6724a = C4815f.m6724a(context2, intent2);
                Executor executor = C4817h.f12866a;
                return taskM6724a.mo6014i(ExecutorC4816g.f12865j, C4813e.f12860a);
            }
        }) : m6724a(context, intent);
    }

    public C4815f(Context context, ExecutorService executorService) {
        this.f12863c = context;
        this.f12864d = executorService;
    }
}
