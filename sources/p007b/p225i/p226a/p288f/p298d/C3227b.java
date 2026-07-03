package p007b.p225i.p226a.p288f.p298d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4374r;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: renamed from: b.i.a.f.d.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3227b {

    /* JADX INFO: renamed from: a */
    public static int f9243a;

    /* JADX INFO: renamed from: b */
    public static PendingIntent f9244b;

    /* JADX INFO: renamed from: c */
    public static final Executor f9245c = ExecutorC3251z.f9295j;

    /* JADX INFO: renamed from: e */
    public final Context f9247e;

    /* JADX INFO: renamed from: f */
    public final C3243r f9248f;

    /* JADX INFO: renamed from: g */
    public final ScheduledExecutorService f9249g;

    /* JADX INFO: renamed from: i */
    public Messenger f9251i;

    /* JADX INFO: renamed from: j */
    public zza f9252j;

    /* JADX INFO: renamed from: d */
    public final SimpleArrayMap<String, TaskCompletionSource<Bundle>> f9246d = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: h */
    public Messenger f9250h = new Messenger(new HandlerC3250y(this, Looper.getMainLooper()));

    public C3227b(@NonNull Context context) {
        this.f9247e = context;
        this.f9248f = new C3243r(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9249g = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: renamed from: a */
    public final void m3999a(String str, @Nullable Bundle bundle) {
        synchronized (this.f9246d) {
            TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.f9246d.remove(str);
            if (taskCompletionSourceRemove != null) {
                taskCompletionSourceRemove.f20845a.m6024s(bundle);
            } else {
                String strValueOf = String.valueOf(str);
                Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00de  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    @AnyThread
    /* JADX INFO: renamed from: b */
    public final Task<Bundle> m4000b(Bundle bundle) {
        final String string;
        synchronized (C3227b.class) {
            int i = f9243a;
            f9243a = i + 1;
            string = Integer.toString(i);
        }
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.f9246d) {
            this.f9246d.put(string, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f9248f.m4010a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.f9247e;
        synchronized (C3227b.class) {
            if (f9244b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f9244b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f9244b);
        }
        intent.putExtra("kid", C1643a.m859k(C1643a.m841b(string, 5), "|ID|", string, "|"));
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
            sb.append("Sending ");
            sb.append(strValueOf);
            Log.d("Rpc", sb.toString());
        }
        intent.putExtra("google.messenger", this.f9250h);
        if (this.f9251i != null || this.f9252j != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f9251i;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    Messenger messenger2 = this.f9252j.f20471j;
                    Objects.requireNonNull(messenger2);
                    messenger2.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                if (this.f9248f.m4010a() == 2) {
                    this.f9247e.sendBroadcast(intent);
                } else {
                    this.f9247e.startService(intent);
                }
            }
        } else if (this.f9248f.m4010a() == 2) {
            this.f9247e.sendBroadcast(intent);
        } else {
            this.f9247e.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.f9249g.schedule(new Runnable(taskCompletionSource) { // from class: b.i.a.f.d.u

            /* JADX INFO: renamed from: j */
            public final TaskCompletionSource f9287j;

            {
                this.f9287j = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f9287j.m9125a(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        C4358c0<Bundle> c4358c0 = taskCompletionSource.f20845a;
        c4358c0.f11472b.m6031a(new C4374r(ExecutorC3251z.f9295j, new InterfaceC4357c(this, string, scheduledFutureSchedule) { // from class: b.i.a.f.d.x

            /* JADX INFO: renamed from: a */
            public final C3227b f9291a;

            /* JADX INFO: renamed from: b */
            public final String f9292b;

            /* JADX INFO: renamed from: c */
            public final ScheduledFuture f9293c;

            {
                this.f9291a = this;
                this.f9292b = string;
                this.f9293c = scheduledFutureSchedule;
            }

            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
            public final void onComplete(Task task) {
                C3227b c3227b = this.f9291a;
                String str = this.f9292b;
                ScheduledFuture scheduledFuture = this.f9293c;
                synchronized (c3227b.f9246d) {
                    c3227b.f9246d.remove(str);
                }
                scheduledFuture.cancel(false);
            }
        }));
        c4358c0.m6028w();
        return taskCompletionSource.f20845a;
    }
}
