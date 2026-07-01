package b.i.c.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class d0 implements ServiceConnection {
    public final Context j;
    public final Intent k;
    public final ScheduledExecutorService l;
    public final Queue<d0$a> m;

    @Nullable
    public a0 n;

    @GuardedBy("this")
    public boolean o;

    public d0(Context context, String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new b.i.a.f.e.o.j.a("Firebase-FirebaseInstanceIdServiceConnection"));
        this.m = new ArrayDeque();
        this.o = false;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.k = new Intent(str).setPackage(applicationContext.getPackageName());
        this.l = scheduledThreadPoolExecutor;
    }

    @GuardedBy("this")
    public final void a() {
        while (!this.m.isEmpty()) {
            this.m.poll().a();
        }
    }

    public final synchronized void b() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.m.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            a0 a0Var = this.n;
            if (a0Var == null || !a0Var.isBinderAlive()) {
                c();
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
            }
            this.n.a(this.m.poll());
        }
    }

    @GuardedBy("this")
    public final void c() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            boolean z2 = !this.o;
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(z2);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        if (this.o) {
            return;
        }
        this.o = true;
        try {
            if (b.i.a.f.e.n.a.b().a(this.j, this.k, this, 65)) {
                return;
            } else {
                Log.e("FirebaseInstanceId", "binding to the service failed");
            }
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Exception while binding the service", e);
        }
        this.o = false;
        a();
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
        this.o = false;
        if (iBinder instanceof a0) {
            this.n = (a0) iBinder;
            b();
            return;
        }
        String strValueOf2 = String.valueOf(iBinder);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 28);
        sb2.append("Invalid service connection: ");
        sb2.append(strValueOf2);
        Log.e("FirebaseInstanceId", sb2.toString());
        a();
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
        b();
    }
}
