package b.i.a.f.h.j;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class n0 extends BroadcastReceiver {
    public static final String a = n0.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1423b;
    public boolean c;
    public boolean d;

    public n0(g gVar) {
        Objects.requireNonNull(gVar, "null reference");
        this.f1423b = gVar;
    }

    public final void a() {
        if (this.c) {
            this.f1423b.c().C("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                this.f1423b.f1417b.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f1423b.c().A("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final boolean b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1423b.f1417b.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1423b.c();
        this.f1423b.e();
        String action = intent.getAction();
        this.f1423b.c().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zB = b();
            if (this.d != zB) {
                this.d = zB;
                a aVarE = this.f1423b.e();
                aVarE.b("Network connectivity status changed", Boolean.valueOf(zB));
                aVarE.q().a(new b(aVarE, zB));
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f1423b.c().x("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        if (intent.hasExtra(a)) {
            return;
        }
        a aVarE2 = this.f1423b.e();
        aVarE2.C("Radio powered up");
        aVarE2.N();
        Context context2 = aVarE2.j.f1417b;
        if (!s0.a(context2) || !t0.c(context2)) {
            aVarE2.N();
            aVarE2.q().a(new c(aVarE2, null));
        } else {
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context2, "com.google.android.gms.analytics.AnalyticsService"));
            context2.startService(intent2);
        }
    }
}
