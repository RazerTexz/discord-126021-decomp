package b.i.c.w;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class z implements Runnable {
    public static final Object j = new Object();

    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    public static Boolean k;

    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    public static Boolean l;
    public final Context m;
    public final b.i.c.s.q n;
    public final PowerManager.WakeLock o;
    public final y p;
    public final long q;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public class a extends BroadcastReceiver {

        @Nullable
        @GuardedBy("this")
        public z a;

        public a(z zVar) {
            this.a = zVar;
        }

        public void a() {
            if (z.a()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            z.this.m.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            z zVar = this.a;
            if (zVar == null) {
                return;
            }
            if (zVar.e()) {
                if (z.a()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                z zVar2 = this.a;
                zVar2.p.h.schedule(zVar2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    public z(y yVar, Context context, b.i.c.s.q qVar, long j2) {
        this.p = yVar;
        this.m = context;
        this.q = j2;
        this.n = qVar;
        this.o = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    public static boolean b(Context context) {
        boolean zBooleanValue;
        synchronized (j) {
            Boolean bool = l;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? c(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            l = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    public static boolean c(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z2 && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(str.length() + Opcodes.D2I);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z2;
    }

    public static boolean d(Context context) {
        boolean zBooleanValue;
        synchronized (j) {
            Boolean bool = k;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? c(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            k = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    public final synchronized boolean e() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.m.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (d(this.m)) {
            this.o.acquire(b.a);
        }
        try {
            this.p.e(true);
            if (!this.n.d()) {
                this.p.e(false);
            } else if (b(this.m) && !e()) {
                new a(this).a();
            } else {
                if (this.p.f()) {
                    this.p.e(false);
                } else {
                    this.p.g(this.q);
                }
            }
        } catch (IOException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", strValueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(strValueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.p.e(false);
        } finally {
            if (d(this.m)) {
                try {
                    this.o.release();
                } catch (RuntimeException unused) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        }
    }
}
