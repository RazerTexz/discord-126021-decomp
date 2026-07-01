package b.i.a.f.i.b;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o4 implements Runnable {
    public final /* synthetic */ b.i.a.f.h.l.e2 j;
    public final /* synthetic */ ServiceConnection k;
    public final /* synthetic */ l4 l;

    public o4(l4 l4Var, b.i.a.f.h.l.e2 e2Var, ServiceConnection serviceConnection) {
        this.l = l4Var;
        this.j = e2Var;
        this.k = serviceConnection;
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
        Bundle bundleF;
        long j;
        String string;
        l4 l4Var = this.l;
        m4 m4Var = l4Var.k;
        String str = l4Var.j;
        b.i.a.f.h.l.e2 e2Var = this.j;
        ServiceConnection serviceConnection = this.k;
        m4Var.a.f().b();
        if (e2Var != null) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", str);
            try {
                bundleF = e2Var.f(bundle);
                if (bundleF == null) {
                    m4Var.a.g().f.a("Install Referrer Service returned a null response");
                }
            } catch (Exception e) {
                m4Var.a.g().f.b("Exception occurred while retrieving the Install Referrer", e.getMessage());
            }
            m4Var.a.f().b();
            if (bundleF != null) {
                j = bundleF.getLong("install_begin_timestamp_seconds", 0L) * 1000;
                if (j == 0) {
                    m4Var.a.g().i.a("Service response is missing Install Referrer install timestamp");
                } else {
                    string = bundleF.getString(Constants.INSTALL_REFERRER);
                    if (string != null || string.isEmpty()) {
                        m4Var.a.g().f.a("No referrer defined in Install Referrer response");
                    } else {
                        m4Var.a.g().n.b("InstallReferrer API result", string);
                        Bundle bundleX = m4Var.a.t().x(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                        if (bundleX == null) {
                            m4Var.a.g().f.a("No campaign params defined in Install Referrer result");
                        } else {
                            String string2 = bundleX.getString(Constants.MEDIUM);
                            if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                                long j2 = bundleF.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                                if (j2 == 0) {
                                    m4Var.a.g().f.a("Install Referrer is missing click timestamp for ad campaign");
                                } else {
                                    bundleX.putLong("click_timestamp", j2);
                                    if (j == m4Var.a.o().l.a()) {
                                        m4Var.a.g().n.a("Install Referrer campaign has already been logged");
                                    } else if (((b.i.a.f.h.l.j9) b.i.a.f.h.l.g9.j.a()).a() || !m4Var.a.h.o(p.t0) || m4Var.a.d()) {
                                        m4Var.a.o().l.b(j);
                                        m4Var.a.g().n.b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                        bundleX.putString("_cis", "referrer API");
                                        m4Var.a.s().H("auto", "_cmp", bundleX);
                                    }
                                }
                            } else if (j == m4Var.a.o().l.a()) {
                                m4Var.a.g().n.a("Install Referrer campaign has already been logged");
                            } else if (((b.i.a.f.h.l.j9) b.i.a.f.h.l.g9.j.a()).a()) {
                                m4Var.a.o().l.b(j);
                                m4Var.a.g().n.b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                bundleX.putString("_cis", "referrer API");
                                m4Var.a.s().H("auto", "_cmp", bundleX);
                            } else {
                                m4Var.a.o().l.b(j);
                                m4Var.a.g().n.b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                bundleX.putString("_cis", "referrer API");
                                m4Var.a.s().H("auto", "_cmp", bundleX);
                            }
                        }
                    }
                }
            }
            if (serviceConnection != null) {
                b.i.a.f.e.n.a.b().c(m4Var.a.f1570b, serviceConnection);
            }
        }
        m4Var.a.g().i.a("Attempting to use Install Referrer Service while it is not initialized");
        bundleF = null;
        m4Var.a.f().b();
        if (bundleF != null) {
            j = bundleF.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                m4Var.a.g().i.a("Service response is missing Install Referrer install timestamp");
            } else {
                string = bundleF.getString(Constants.INSTALL_REFERRER);
                if (string != null) {
                    m4Var.a.g().f.a("No referrer defined in Install Referrer response");
                } else {
                    m4Var.a.g().f.a("No referrer defined in Install Referrer response");
                }
            }
        }
        if (serviceConnection != null) {
            b.i.a.f.e.n.a.b().c(m4Var.a.f1570b, serviceConnection);
        }
    }
}
