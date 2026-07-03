package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p313h.p325l.C3671g9;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3636e2;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3713j9;

/* JADX INFO: renamed from: b.i.a.f.i.b.o4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4136o4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3636e2 f11004j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ServiceConnection f11005k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ ServiceConnectionC4103l4 f11006l;

    public RunnableC4136o4(ServiceConnectionC4103l4 serviceConnectionC4103l4, InterfaceC3636e2 interfaceC3636e2, ServiceConnection serviceConnection) {
        this.f11006l = serviceConnectionC4103l4;
        this.f11004j = interfaceC3636e2;
        this.f11005k = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005f  */
    /* JADX WARN: Code duplicated, block: B:17:0x006f  */
    /* JADX WARN: Code duplicated, block: B:18:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0119  */
    /* JADX WARN: Code duplicated, block: B:46:0x0127  */
    /* JADX WARN: Code duplicated, block: B:52:0x0149  */
    /* JADX WARN: Code duplicated, block: B:53:0x0176  */
    /* JADX WARN: Code duplicated, block: B:55:0x0185  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleMo4629f;
        long j;
        String string;
        ServiceConnectionC4103l4 serviceConnectionC4103l4 = this.f11006l;
        C4114m4 c4114m4 = serviceConnectionC4103l4.f10941k;
        String str = serviceConnectionC4103l4.f10940j;
        InterfaceC3636e2 interfaceC3636e2 = this.f11004j;
        ServiceConnection serviceConnection = this.f11005k;
        c4114m4.f10963a.mo5725f().mo5848b();
        if (interfaceC3636e2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", str);
            try {
                bundleMo4629f = interfaceC3636e2.mo4629f(bundle);
                if (bundleMo4629f == null) {
                    c4114m4.f10963a.mo5726g().f11141f.m5860a("Install Referrer Service returned a null response");
                }
            } catch (Exception e) {
                c4114m4.f10963a.mo5726g().f11141f.m5861b("Exception occurred while retrieving the Install Referrer", e.getMessage());
            }
            c4114m4.f10963a.mo5725f().mo5848b();
            if (bundleMo4629f != null) {
                j = bundleMo4629f.getLong("install_begin_timestamp_seconds", 0L) * 1000;
                if (j == 0) {
                    c4114m4.f10963a.mo5726g().f11144i.m5860a("Service response is missing Install Referrer install timestamp");
                } else {
                    string = bundleMo4629f.getString(Constants.INSTALL_REFERRER);
                    if (string != null || string.isEmpty()) {
                        c4114m4.f10963a.mo5726g().f11141f.m5860a("No referrer defined in Install Referrer response");
                    } else {
                        c4114m4.f10963a.mo5726g().f11149n.m5861b("InstallReferrer API result", string);
                        Bundle bundleM5926x = c4114m4.f10963a.m5949t().m5926x(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                        if (bundleM5926x == null) {
                            c4114m4.f10963a.mo5726g().f11141f.m5860a("No campaign params defined in Install Referrer result");
                        } else {
                            String string2 = bundleM5926x.getString(Constants.MEDIUM);
                            if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                                long j2 = bundleMo4629f.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                                if (j2 == 0) {
                                    c4114m4.f10963a.mo5726g().f11141f.m5860a("Install Referrer is missing click timestamp for ad campaign");
                                } else {
                                    bundleM5926x.putLong("click_timestamp", j2);
                                    if (j == c4114m4.f10963a.m5946o().f10642l.m5648a()) {
                                        c4114m4.f10963a.mo5726g().f11149n.m5860a("Install Referrer campaign has already been logged");
                                    } else if (((InterfaceC3713j9) C3671g9.f9974j.mo4555a()).mo4962a() || !c4114m4.f10963a.f11260h.m5526o(C4142p.f11100t0) || c4114m4.f10963a.m5940d()) {
                                        c4114m4.f10963a.m5946o().f10642l.m5649b(j);
                                        c4114m4.f10963a.mo5726g().f11149n.m5861b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                        bundleM5926x.putString("_cis", "referrer API");
                                        c4114m4.f10963a.m5948s().m5545H("auto", "_cmp", bundleM5926x);
                                    }
                                }
                            } else if (j == c4114m4.f10963a.m5946o().f10642l.m5648a()) {
                                c4114m4.f10963a.mo5726g().f11149n.m5860a("Install Referrer campaign has already been logged");
                            } else if (((InterfaceC3713j9) C3671g9.f9974j.mo4555a()).mo4962a()) {
                                c4114m4.f10963a.m5946o().f10642l.m5649b(j);
                                c4114m4.f10963a.mo5726g().f11149n.m5861b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                bundleM5926x.putString("_cis", "referrer API");
                                c4114m4.f10963a.m5948s().m5545H("auto", "_cmp", bundleM5926x);
                            } else {
                                c4114m4.f10963a.m5946o().f10642l.m5649b(j);
                                c4114m4.f10963a.mo5726g().f11149n.m5861b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                bundleM5926x.putString("_cis", "referrer API");
                                c4114m4.f10963a.m5948s().m5545H("auto", "_cmp", bundleM5926x);
                            }
                        }
                    }
                }
            }
            if (serviceConnection != null) {
                C3398a.m4181b().m4183c(c4114m4.f10963a.f11254b, serviceConnection);
            }
        }
        c4114m4.f10963a.mo5726g().f11144i.m5860a("Attempting to use Install Referrer Service while it is not initialized");
        bundleMo4629f = null;
        c4114m4.f10963a.mo5725f().mo5848b();
        if (bundleMo4629f != null) {
            j = bundleMo4629f.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                c4114m4.f10963a.mo5726g().f11144i.m5860a("Service response is missing Install Referrer install timestamp");
            } else {
                string = bundleMo4629f.getString(Constants.INSTALL_REFERRER);
                if (string != null) {
                    c4114m4.f10963a.mo5726g().f11141f.m5860a("No referrer defined in Install Referrer response");
                } else {
                    c4114m4.f10963a.mo5726g().f11141f.m5860a("No referrer defined in Install Referrer response");
                }
            }
        }
        if (serviceConnection != null) {
            C3398a.m4181b().m4183c(c4114m4.f10963a.f11254b, serviceConnection);
        }
    }
}
