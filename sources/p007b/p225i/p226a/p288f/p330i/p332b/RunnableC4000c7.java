package p007b.p225i.p226a.p288f.p330i.p332b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;

/* JADX INFO: renamed from: b.i.a.f.i.b.c7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4000c7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f10608j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Uri f10609k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10610l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ String f10611m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4248y6 f10612n;

    public RunnableC4000c7(C4248y6 c4248y6, boolean z2, Uri uri, String str, String str2) {
        this.f10612n = c4248y6;
        this.f10608j = z2;
        this.f10609k = uri;
        this.f10610l = str;
        this.f10611m = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleM5926x;
        Bundle bundleM5926x2;
        C4248y6 c4248y6 = this.f10612n;
        boolean z2 = this.f10608j;
        Uri uri = this.f10609k;
        String str = this.f10610l;
        String str2 = this.f10611m;
        c4248y6.f11379j.mo5848b();
        try {
            if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11070e0) || c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11074g0) || c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11072f0)) {
                C4196t9 c4196t9M5866e = c4248y6.f11379j.m5866e();
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium")) {
                        bundleM5926x = c4196t9M5866e.m5926x(Uri.parse(str2.length() != 0 ? "https://google.com/search?".concat(str2) : new String("https://google.com/search?")));
                        if (bundleM5926x != null) {
                            bundleM5926x.putString("_cis", Constants.REFERRER);
                        }
                    } else {
                        c4196t9M5866e.mo5726g().f11148m.m5860a("Activity created with data 'referrer' without required params");
                    }
                }
                bundleM5926x = null;
            } else {
                bundleM5926x = null;
            }
            boolean z3 = true;
            if (z2) {
                bundleM5926x2 = c4248y6.f11379j.m5866e().m5926x(uri);
                if (bundleM5926x2 != null) {
                    bundleM5926x2.putString("_cis", "intent");
                    if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11070e0) && !bundleM5926x2.containsKey("gclid") && bundleM5926x != null && bundleM5926x.containsKey("gclid")) {
                        bundleM5926x2.putString("_cer", String.format("gclid=%s", bundleM5926x.getString("gclid")));
                    }
                    c4248y6.f11379j.m5545H(str, "_cmp", bundleM5926x2);
                    if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11027D0)) {
                        c4248y6.f11379j.f10605n.m5965a(str, bundleM5926x2);
                    }
                }
            } else {
                bundleM5926x2 = null;
            }
            if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11074g0) && !c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11072f0) && bundleM5926x != null && bundleM5926x.containsKey("gclid") && (bundleM5926x2 == null || !bundleM5926x2.containsKey("gclid"))) {
                c4248y6.f11379j.m5547J("auto", "_lgclid", bundleM5926x.getString("gclid"));
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c4248y6.f11379j.mo5726g().f11148m.m5861b("Activity created with referrer", str2);
            if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11072f0)) {
                if (bundleM5926x != null) {
                    c4248y6.f11379j.m5545H(str, "_cmp", bundleM5926x);
                    if (c4248y6.f11379j.f11202a.f11260h.m5526o(C4142p.f11027D0)) {
                        c4248y6.f11379j.f10605n.m5965a(str, bundleM5926x);
                    }
                } else {
                    c4248y6.f11379j.mo5726g().f11148m.m5861b("Referrer does not contain valid parameters", str2);
                }
                c4248y6.f11379j.m5547J("auto", "_ldl", null);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                z3 = false;
            }
            if (!z3) {
                c4248y6.f11379j.mo5726g().f11148m.m5860a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                c4248y6.f11379j.m5547J("auto", "_ldl", str2);
            }
        } catch (Exception e) {
            c4248y6.f11379j.mo5726g().f11141f.m5861b("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
