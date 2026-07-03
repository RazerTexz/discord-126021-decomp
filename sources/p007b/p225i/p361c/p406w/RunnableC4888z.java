package p007b.p225i.p361c.p406w;

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
import p007b.p225i.p361c.p398s.C4826q;

/* JADX INFO: renamed from: b.i.c.w.z */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4888z implements Runnable {

    /* JADX INFO: renamed from: j */
    public static final Object f13069j = new Object();

    /* JADX INFO: renamed from: k */
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    public static Boolean f13070k;

    /* JADX INFO: renamed from: l */
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    public static Boolean f13071l;

    /* JADX INFO: renamed from: m */
    public final Context f13072m;

    /* JADX INFO: renamed from: n */
    public final C4826q f13073n;

    /* JADX INFO: renamed from: o */
    public final PowerManager.WakeLock f13074o;

    /* JADX INFO: renamed from: p */
    public final C4887y f13075p;

    /* JADX INFO: renamed from: q */
    public final long f13076q;

    /* JADX INFO: renamed from: b.i.c.w.z$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        @Nullable
        @GuardedBy("this")
        public RunnableC4888z f13077a;

        public a(RunnableC4888z runnableC4888z) {
            this.f13077a = runnableC4888z;
        }

        /* JADX INFO: renamed from: a */
        public void m6842a() {
            if (RunnableC4888z.m6837a()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            RunnableC4888z.this.f13072m.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            RunnableC4888z runnableC4888z = this.f13077a;
            if (runnableC4888z == null) {
                return;
            }
            if (runnableC4888z.m6841e()) {
                if (RunnableC4888z.m6837a()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                RunnableC4888z runnableC4888z2 = this.f13077a;
                runnableC4888z2.f13075p.f13066h.schedule(runnableC4888z2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.f13077a = null;
            }
        }
    }

    public RunnableC4888z(C4887y c4887y, Context context, C4826q c4826q, long j) {
        this.f13075p = c4887y;
        this.f13072m = context;
        this.f13076q = j;
        this.f13073n = c4826q;
        this.f13074o = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6837a() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: renamed from: b */
    public static boolean m6838b(Context context) {
        boolean zBooleanValue;
        synchronized (f13069j) {
            Boolean bool = f13071l;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? m6839c(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            f13071l = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m6839c(Context context, String str, Boolean bool) {
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

    /* JADX INFO: renamed from: d */
    public static boolean m6840d(Context context) {
        boolean zBooleanValue;
        synchronized (f13069j) {
            Boolean bool = f13070k;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? m6839c(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            f13070k = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: e */
    public final synchronized boolean m6841e() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f13072m.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (m6840d(this.f13072m)) {
            this.f13074o.acquire(C4864b.f13013a);
        }
        try {
            this.f13075p.m6834e(true);
            if (!this.f13073n.m6733d()) {
                this.f13075p.m6834e(false);
            } else if (m6838b(this.f13072m) && !m6841e()) {
                new a(this).m6842a();
            } else {
                if (this.f13075p.m6835f()) {
                    this.f13075p.m6834e(false);
                } else {
                    this.f13075p.m6836g(this.f13076q);
                }
            }
        } catch (IOException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", strValueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(strValueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.f13075p.m6834e(false);
        } finally {
            if (m6840d(this.f13072m)) {
                try {
                    this.f13074o.release();
                } catch (RuntimeException unused) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        }
    }
}
