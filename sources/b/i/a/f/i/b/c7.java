package b.i.a.f.i.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c7 implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ Uri k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ y6 n;

    public c7(y6 y6Var, boolean z2, Uri uri, String str, String str2) {
        this.n = y6Var;
        this.j = z2;
        this.k = uri;
        this.l = str;
        this.m = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleX;
        Bundle bundleX2;
        y6 y6Var = this.n;
        boolean z2 = this.j;
        Uri uri = this.k;
        String str = this.l;
        String str2 = this.m;
        y6Var.j.b();
        try {
            if (y6Var.j.a.h.o(p.f1556e0) || y6Var.j.a.h.o(p.f1558g0) || y6Var.j.a.h.o(p.f1557f0)) {
                t9 t9VarE = y6Var.j.e();
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium")) {
                        bundleX = t9VarE.x(Uri.parse(str2.length() != 0 ? "https://google.com/search?".concat(str2) : new String("https://google.com/search?")));
                        if (bundleX != null) {
                            bundleX.putString("_cis", Constants.REFERRER);
                        }
                    } else {
                        t9VarE.g().m.a("Activity created with data 'referrer' without required params");
                    }
                }
                bundleX = null;
            } else {
                bundleX = null;
            }
            boolean z3 = true;
            if (z2) {
                bundleX2 = y6Var.j.e().x(uri);
                if (bundleX2 != null) {
                    bundleX2.putString("_cis", "intent");
                    if (y6Var.j.a.h.o(p.f1556e0) && !bundleX2.containsKey("gclid") && bundleX != null && bundleX.containsKey("gclid")) {
                        bundleX2.putString("_cer", String.format("gclid=%s", bundleX.getString("gclid")));
                    }
                    y6Var.j.H(str, "_cmp", bundleX2);
                    if (y6Var.j.a.h.o(p.D0)) {
                        y6Var.j.n.a(str, bundleX2);
                    }
                }
            } else {
                bundleX2 = null;
            }
            if (y6Var.j.a.h.o(p.f1558g0) && !y6Var.j.a.h.o(p.f1557f0) && bundleX != null && bundleX.containsKey("gclid") && (bundleX2 == null || !bundleX2.containsKey("gclid"))) {
                y6Var.j.J("auto", "_lgclid", bundleX.getString("gclid"));
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            y6Var.j.g().m.b("Activity created with referrer", str2);
            if (y6Var.j.a.h.o(p.f1557f0)) {
                if (bundleX != null) {
                    y6Var.j.H(str, "_cmp", bundleX);
                    if (y6Var.j.a.h.o(p.D0)) {
                        y6Var.j.n.a(str, bundleX);
                    }
                } else {
                    y6Var.j.g().m.b("Referrer does not contain valid parameters", str2);
                }
                y6Var.j.J("auto", "_ldl", null);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                z3 = false;
            }
            if (!z3) {
                y6Var.j.g().m.a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                y6Var.j.J("auto", "_ldl", str2);
            }
        } catch (Exception e) {
            y6Var.j.g().f.b("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
