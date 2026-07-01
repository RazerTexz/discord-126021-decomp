package b.i.c.s;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import b.i.c.s.w;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class x implements Runnable {
    public final long j;
    public final PowerManager.WakeLock k;
    public final FirebaseInstanceId l;
    public ExecutorService m = h.a();

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a extends BroadcastReceiver {
        public x a;

        public a(x xVar) {
            this.a = xVar;
        }

        public void a() {
            if (FirebaseInstanceId.l()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            x xVar = this.a;
            if (xVar != null && xVar.c()) {
                if (FirebaseInstanceId.l()) {
                    Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
                }
                x xVar2 = this.a;
                xVar2.l.d(xVar2, 0L);
                this.a.a().unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    public x(FirebaseInstanceId firebaseInstanceId, long j) {
        this.l = firebaseInstanceId;
        this.j = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.k = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public Context a() {
        FirebaseApp2 firebaseApp2 = this.l.f;
        firebaseApp2.a();
        return firebaseApp2.d;
    }

    public final void b(String str) {
        FirebaseApp2 firebaseApp2 = this.l.f;
        firebaseApp2.a();
        if ("[DEFAULT]".equals(firebaseApp2.e)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                FirebaseApp2 firebaseApp3 = this.l.f;
                firebaseApp3.a();
                String strValueOf = String.valueOf(firebaseApp3.e);
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(strValueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new f(a(), this.m).b(intent);
        }
    }

    public boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean d() throws IOException {
        w.a aVarJ = this.l.j();
        boolean z2 = true;
        if (!this.l.p(aVarJ)) {
            return true;
        }
        try {
            String strB = this.l.b();
            if (strB == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (aVarJ == null || !strB.equals(aVarJ.c)) {
                b(strB);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z2 = false;
            }
            if (z2) {
                String message2 = e.getMessage();
                outline.i0(outline.b(message2, 52), "Token retrieval failed: ", message2, ". Will retry token retrieval", "FirebaseInstanceId");
                return false;
            }
            if (e.getMessage() != null) {
                throw e;
            }
            Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (v.a().c(a())) {
            this.k.acquire();
        }
        try {
            this.l.n(true);
            if (!this.l.g.d()) {
                this.l.n(false);
            } else if (v.a().b(a()) && !c()) {
                new a(this).a();
            } else {
                if (d()) {
                    this.l.n(false);
                } else {
                    this.l.o(this.j);
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.l.n(false);
        } finally {
            if (v.a().c(a())) {
                this.k.release();
            }
        }
    }
}
