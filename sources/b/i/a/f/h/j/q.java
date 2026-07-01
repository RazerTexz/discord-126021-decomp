package b.i.a.f.h.j;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends e {
    public final f1 l;

    public q(g gVar) {
        super(gVar);
        this.l = new f1();
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        b.i.a.f.b.f fVarQ = q();
        if (fVarQ.d == null) {
            synchronized (fVarQ) {
                if (fVarQ.d == null) {
                    f1 f1Var = new f1();
                    PackageManager packageManager = fVarQ.f1331b.getPackageManager();
                    String packageName = fVarQ.f1331b.getPackageName();
                    f1Var.c = packageName;
                    f1Var.d = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(fVarQ.f1331b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager$NameNotFoundException unused) {
                        String strValueOf = String.valueOf(packageName);
                        Log.e("GAv4", strValueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(strValueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    f1Var.a = packageName;
                    f1Var.f1416b = str;
                    fVarQ.d = f1Var;
                }
            }
        }
        f1 f1Var2 = fVarQ.d;
        f1 f1Var3 = this.l;
        if (!TextUtils.isEmpty(f1Var2.a)) {
            f1Var3.a = f1Var2.a;
        }
        if (!TextUtils.isEmpty(f1Var2.f1416b)) {
            f1Var3.f1416b = f1Var2.f1416b;
        }
        if (!TextUtils.isEmpty(f1Var2.c)) {
            f1Var3.c = f1Var2.c;
        }
        if (!TextUtils.isEmpty(f1Var2.d)) {
            f1Var3.d = f1Var2.d;
        }
        a1 a1VarT = t();
        a1VarT.N();
        String str2 = a1VarT.m;
        if (str2 != null) {
            this.l.a = str2;
        }
        a1VarT.N();
        String str3 = a1VarT.l;
        if (str3 != null) {
            this.l.f1416b = str3;
        }
    }
}
