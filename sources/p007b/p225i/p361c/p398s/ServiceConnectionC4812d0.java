package p007b.p225i.p361c.p398s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;

/* JADX INFO: renamed from: b.i.c.s.d0 */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceConnectionC4812d0 implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public final Context f12852j;

    /* JADX INFO: renamed from: k */
    public final Intent f12853k;

    /* JADX INFO: renamed from: l */
    public final ScheduledExecutorService f12854l;

    /* JADX INFO: renamed from: m */
    public final Queue<a> f12855m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public BinderC4806a0 f12856n;

    /* JADX INFO: renamed from: o */
    @GuardedBy("this")
    public boolean f12857o;

    /* JADX INFO: renamed from: b.i.c.s.d0$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final Intent f12858a;

        /* JADX INFO: renamed from: b */
        public final TaskCompletionSource<Void> f12859b = new TaskCompletionSource<>();

        public a(Intent intent) {
            this.f12858a = intent;
        }

        /* JADX INFO: renamed from: a */
        public void m6723a() {
            this.f12859b.m9126b(null);
        }
    }

    public ServiceConnectionC4812d0(Context context, String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new ThreadFactoryC3408a("Firebase-FirebaseInstanceIdServiceConnection"));
        this.f12855m = new ArrayDeque();
        this.f12857o = false;
        Context applicationContext = context.getApplicationContext();
        this.f12852j = applicationContext;
        this.f12853k = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f12854l = scheduledThreadPoolExecutor;
    }

    @GuardedBy("this")
    /* JADX INFO: renamed from: a */
    public final void m6720a() {
        while (!this.f12855m.isEmpty()) {
            this.f12855m.poll().m6723a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m6721b() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.f12855m.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            BinderC4806a0 binderC4806a0 = this.f12856n;
            if (binderC4806a0 == null || !binderC4806a0.isBinderAlive()) {
                m6722c();
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
            }
            this.f12856n.m6719a(this.f12855m.poll());
        }
    }

    @GuardedBy("this")
    /* JADX INFO: renamed from: c */
    public final void m6722c() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            boolean z2 = !this.f12857o;
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(z2);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        if (this.f12857o) {
            return;
        }
        this.f12857o = true;
        try {
            if (C3398a.m4181b().m4182a(this.f12852j, this.f12853k, this, 65)) {
                return;
            } else {
                Log.e("FirebaseInstanceId", "binding to the service failed");
            }
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Exception while binding the service", e);
        }
        this.f12857o = false;
        m6720a();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(strValueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f12857o = false;
        if (iBinder instanceof BinderC4806a0) {
            this.f12856n = (BinderC4806a0) iBinder;
            m6721b();
            return;
        }
        String strValueOf2 = String.valueOf(iBinder);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 28);
        sb2.append("Invalid service connection: ");
        sb2.append(strValueOf2);
        Log.e("FirebaseInstanceId", sb2.toString());
        m6720a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(strValueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        m6721b();
    }
}
