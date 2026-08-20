package p007b.p225i.p361c.p398s;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.C4542c;

/* JADX INFO: renamed from: b.i.c.s.x */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4833x implements Runnable {

    /* JADX INFO: renamed from: j */
    public final long f12909j;

    /* JADX INFO: renamed from: k */
    public final PowerManager.WakeLock f12910k;

    /* JADX INFO: renamed from: l */
    public final FirebaseInstanceId f12911l;

    /* JADX INFO: renamed from: m */
    public ExecutorService f12912m = C4817h.m6726a();

    /* JADX INFO: renamed from: b.i.c.s.x$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        public RunnableC4833x f12913a;

        public a(RunnableC4833x runnableC4833x) {
            this.f12913a = runnableC4833x;
        }

        /* JADX INFO: renamed from: a */
        public void m6748a() {
            if (FirebaseInstanceId.m9179l()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.f12913a.m6744a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RunnableC4833x runnableC4833x = this.f12913a;
            if (runnableC4833x != null && runnableC4833x.m6746c()) {
                if (FirebaseInstanceId.m9179l()) {
                    Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
                }
                RunnableC4833x runnableC4833x2 = this.f12913a;
                runnableC4833x2.f12911l.m9181d(runnableC4833x2, 0L);
                this.f12913a.m6744a().unregisterReceiver(this);
                this.f12913a = null;
            }
        }
    }

    public RunnableC4833x(FirebaseInstanceId firebaseInstanceId, long j) {
        this.f12911l = firebaseInstanceId;
        this.f12909j = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) m6744a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f12910k = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    /* JADX INFO: renamed from: a */
    public Context m6744a() {
        C4542c c4542c = this.f12911l.f21437f;
        c4542c.m6330a();
        return c4542c.f12118d;
    }

    /* JADX INFO: renamed from: b */
    public final void m6745b(String str) {
        C4542c c4542c = this.f12911l.f21437f;
        c4542c.m6330a();
        if ("[DEFAULT]".equals(c4542c.f12119e)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                C4542c c4542c2 = this.f12911l.f21437f;
                c4542c2.m6330a();
                String strValueOf = String.valueOf(c4542c2.f12119e);
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(strValueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C4815f(m6744a(), this.f12912m).m6725b(intent);
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m6746c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) m6744a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: renamed from: d */
    public boolean m6747d() throws IOException {
        C4832w.a aVarM9187j = this.f12911l.m9187j();
        boolean z2 = true;
        if (!this.f12911l.m9192p(aVarM9187j)) {
            return true;
        }
        try {
            String strM9180b = this.f12911l.m9180b();
            if (strM9180b == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (aVarM9187j == null || !strM9180b.equals(aVarM9187j.f12906c)) {
                m6745b(strM9180b);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z2 = false;
            }
            if (z2) {
                String message2 = e.getMessage();
                C1643a.m856i0(C1643a.m841b(message2, 52), "Token retrieval failed: ", message2, ". Will retry token retrieval", "FirebaseInstanceId");
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
        if (C4831v.m6735a().m6737c(m6744a())) {
            this.f12910k.acquire();
        }
        try {
            this.f12911l.m9190n(true);
            if (!this.f12911l.f21438g.m6733d()) {
                this.f12911l.m9190n(false);
            } else if (C4831v.m6735a().m6736b(m6744a()) && !m6746c()) {
                new a(this).m6748a();
            } else {
                if (m6747d()) {
                    this.f12911l.m9190n(false);
                } else {
                    this.f12911l.m9191o(this.f12909j);
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.f12911l.m9190n(false);
        } finally {
            if (C4831v.m6735a().m6737c(m6744a())) {
                this.f12910k.release();
            }
        }
    }
}
