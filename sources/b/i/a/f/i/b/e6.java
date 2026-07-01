package b.i.a.f.i.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e6 implements Runnable {
    public final c6 j;

    public e6(c6 c6Var) {
        this.j = c6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pair pair;
        NetworkInfo activeNetworkInfo;
        URL url;
        c6 c6Var = this.j;
        c6Var.b();
        if (c6Var.l().f1526y.b()) {
            c6Var.g().m.a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jA = c6Var.l().f1527z.a();
        c6Var.l().f1527z.b(jA + 1);
        if (jA >= 5) {
            c6Var.g().i.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            c6Var.l().f1526y.a(true);
            return;
        }
        u4 u4Var = c6Var.a;
        u4Var.f().b();
        u4.q(u4Var.n());
        n3 n3VarZ = u4Var.z();
        n3VarZ.t();
        String str = n3VarZ.c;
        d4 d4VarO = u4Var.o();
        d4VarO.b();
        Objects.requireNonNull((b.i.a.f.e.o.c) d4VarO.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (d4VarO.n == null || jElapsedRealtime >= d4VarO.p) {
            c cVar = d4VarO.a.h;
            Objects.requireNonNull(cVar);
            d4VarO.p = cVar.n(str, p.f1552b) + jElapsedRealtime;
            try {
                AdvertisingIdClient$Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(d4VarO.a.f1570b);
                if (advertisingIdInfo != null) {
                    d4VarO.n = advertisingIdInfo.getId();
                    d4VarO.o = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (d4VarO.n == null) {
                    d4VarO.n = "";
                }
            } catch (Exception e) {
                d4VarO.g().m.b("Unable to get advertising id", e);
                d4VarO.n = "";
            }
            pair = new Pair(d4VarO.n, Boolean.valueOf(d4VarO.o));
        } else {
            pair = new Pair(d4VarO.n, Boolean.valueOf(d4VarO.o));
        }
        if (!u4Var.h.y().booleanValue() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
            u4Var.g().m.a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        d7 d7VarN = u4Var.n();
        d7VarN.o();
        try {
            activeNetworkInfo = ((ConnectivityManager) d7VarN.a.f1570b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
            u4Var.g().i.a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        t9 t9VarT = u4Var.t();
        u4Var.z();
        String str2 = (String) pair.first;
        long jA2 = u4Var.o().f1527z.a() - 1;
        Objects.requireNonNull(t9VarT);
        try {
            b.c.a.a0.d.w(str2);
            b.c.a.a0.d.w(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 33025L, Integer.valueOf(t9VarT.y0())), str2, str, Long.valueOf(jA2));
            if (str.equals(t9VarT.a.h.h("debug.deferred.deeplink", ""))) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            url = new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            t9VarT.g().f.b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            url = null;
        }
        d7 d7VarN2 = u4Var.n();
        x4 x4Var = new x4(u4Var);
        d7VarN2.b();
        d7VarN2.o();
        Objects.requireNonNull(url, "null reference");
        d7VarN2.f().x(new f7(d7VarN2, str, url, x4Var));
    }
}
