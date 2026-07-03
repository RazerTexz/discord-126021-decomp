package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.j.n0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3531n0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final String f9764a = C3531n0.class.getName();

    /* JADX INFO: renamed from: b */
    public final C3515g f9765b;

    /* JADX INFO: renamed from: c */
    public boolean f9766c;

    /* JADX INFO: renamed from: d */
    public boolean f9767d;

    public C3531n0(C3515g c3515g) {
        Objects.requireNonNull(c3515g, "null reference");
        this.f9765b = c3515g;
    }

    /* JADX INFO: renamed from: a */
    public final void m4466a() {
        if (this.f9766c) {
            this.f9765b.m4451c().m4427C("Unregistering connectivity change receiver");
            this.f9766c = false;
            this.f9767d = false;
            try {
                this.f9765b.f9722b.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f9765b.m4451c().m4426A("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4467b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f9765b.f9722b.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f9765b.m4451c();
        this.f9765b.m4453e();
        String action = intent.getAction();
        this.f9765b.m4451c().m4431b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zM4467b = m4467b();
            if (this.f9767d != zM4467b) {
                this.f9767d = zM4467b;
                C3497a c3497aM4453e = this.f9765b.m4453e();
                c3497aM4453e.m4431b("Network connectivity status changed", Boolean.valueOf(zM4467b));
                c3497aM4453e.m4435q().m3968a(new RunnableC3500b(c3497aM4453e, zM4467b));
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f9765b.m4451c().m4439x("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        if (intent.hasExtra(f9764a)) {
            return;
        }
        C3497a c3497aM4453e2 = this.f9765b.m4453e();
        c3497aM4453e2.m4427C("Radio powered up");
        c3497aM4453e2.m4444N();
        Context context2 = c3497aM4453e2.f9684j.f9722b;
        if (!C3541s0.m4499a(context2) || !C3543t0.m4500c(context2)) {
            c3497aM4453e2.m4444N();
            c3497aM4453e2.m4435q().m3968a(new RunnableC3503c(c3497aM4453e2, null));
        } else {
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context2, "com.google.android.gms.analytics.AnalyticsService"));
            context2.startService(intent2);
        }
    }
}
