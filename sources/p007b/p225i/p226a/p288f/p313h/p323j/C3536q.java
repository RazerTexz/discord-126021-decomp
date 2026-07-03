package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: renamed from: b.i.a.f.h.j.q */
/* JADX INFO: loaded from: classes3.dex */
public final class C3536q extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public final C3514f1 f9781l;

    public C3536q(C3515g c3515g) {
        super(c3515g);
        this.f9781l = new C3514f1();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        C3180f c3180fM4435q = m4435q();
        if (c3180fM4435q.f9198d == null) {
            synchronized (c3180fM4435q) {
                if (c3180fM4435q.f9198d == null) {
                    C3514f1 c3514f1 = new C3514f1();
                    PackageManager packageManager = c3180fM4435q.f9196b.getPackageManager();
                    String packageName = c3180fM4435q.f9196b.getPackageName();
                    c3514f1.f9719c = packageName;
                    c3514f1.f9720d = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(c3180fM4435q.f9196b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String strValueOf = String.valueOf(packageName);
                        Log.e("GAv4", strValueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(strValueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    c3514f1.f9717a = packageName;
                    c3514f1.f9718b = str;
                    c3180fM4435q.f9198d = c3514f1;
                }
            }
        }
        C3514f1 c3514f2 = c3180fM4435q.f9198d;
        C3514f1 c3514f3 = this.f9781l;
        if (!TextUtils.isEmpty(c3514f2.f9717a)) {
            c3514f3.f9717a = c3514f2.f9717a;
        }
        if (!TextUtils.isEmpty(c3514f2.f9718b)) {
            c3514f3.f9718b = c3514f2.f9718b;
        }
        if (!TextUtils.isEmpty(c3514f2.f9719c)) {
            c3514f3.f9719c = c3514f2.f9719c;
        }
        if (!TextUtils.isEmpty(c3514f2.f9720d)) {
            c3514f3.f9720d = c3514f2.f9720d;
        }
        C3499a1 c3499a1M4437t = m4437t();
        c3499a1M4437t.m4444N();
        String str2 = c3499a1M4437t.f9667m;
        if (str2 != null) {
            this.f9781l.f9717a = str2;
        }
        c3499a1M4437t.m4444N();
        String str3 = c3499a1M4437t.f9666l;
        if (str3 != null) {
            this.f9781l.f9718b = str3;
        }
    }
}
