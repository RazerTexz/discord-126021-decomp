package b.i.a.f.d;

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
import b.i.a.f.n.c0;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PendingIntent f1338b;
    public static final Executor c = z.j;
    public final Context e;
    public final r f;
    public final ScheduledExecutorService g;
    public Messenger i;
    public zza j;
    public final SimpleArrayMap<String, TaskCompletionSource<Bundle>> d = new SimpleArrayMap<>();
    public Messenger h = new Messenger(new y(this, Looper.getMainLooper()));

    public b(@NonNull Context context) {
        this.e = context;
        this.f = new r(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.g = scheduledThreadPoolExecutor;
    }

    public final void a(String str, @Nullable Bundle bundle) {
        synchronized (this.d) {
            TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.d.remove(str);
            if (taskCompletionSourceRemove != null) {
                taskCompletionSourceRemove.a.s(bundle);
            } else {
                String strValueOf = String.valueOf(str);
                Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00de  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    @AnyThread
    public final Task<Bundle> b(Bundle bundle) {
        String string;
        synchronized (b.class) {
            int i = a;
            a = i + 1;
            string = Integer.toString(i);
        }
        TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.d) {
            this.d.put(string, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f.a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.e;
        synchronized (b.class) {
            if (f1338b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f1338b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f1338b);
        }
        intent.putExtra("kid", b.d.b.a.a.k(b.d.b.a.a.b(string, 5), "|ID|", string, "|"));
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
            sb.append("Sending ");
            sb.append(strValueOf);
            Log.d("Rpc", sb.toString());
        }
        intent.putExtra("google.messenger", this.h);
        if (this.i != null || this.j != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.i;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    Messenger messenger2 = this.j.j;
                    Objects.requireNonNull(messenger2);
                    messenger2.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                if (this.f.a() == 2) {
                    this.e.sendBroadcast(intent);
                } else {
                    this.e.startService(intent);
                }
            }
        } else if (this.f.a() == 2) {
            this.e.sendBroadcast(intent);
        } else {
            this.e.startService(intent);
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.g.schedule(new u(taskCompletionSource), 30L, TimeUnit.SECONDS);
        c0<Bundle> c0Var = taskCompletionSource.a;
        c0Var.f1592b.a(new b.i.a.f.n.r(z.j, new x(this, string, scheduledFutureSchedule)));
        c0Var.w();
        return taskCompletionSource.a;
    }
}
