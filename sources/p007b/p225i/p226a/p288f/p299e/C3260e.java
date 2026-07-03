package p007b.p225i.p226a.p288f.p299e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.e.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3260e {

    /* JADX INFO: renamed from: b */
    public static boolean f9310b = false;

    /* JADX INFO: renamed from: c */
    public static boolean f9311c = false;

    /* JADX INFO: renamed from: a */
    public static final AtomicBoolean f9309a = new AtomicBoolean();

    /* JADX INFO: renamed from: d */
    public static final AtomicBoolean f9312d = new AtomicBoolean();

    /* JADX INFO: renamed from: a */
    public static boolean m4019a(@RecentlyNonNull Context context) {
        try {
            if (!f9311c) {
                PackageInfo packageInfo = C3411b.m4376a(context).f9605a.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                C3262f.m4021a(context);
                if (packageInfo == null || C3262f.m4023d(packageInfo, false) || !C3262f.m4023d(packageInfo, true)) {
                    f9310b = false;
                } else {
                    f9310b = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
        } finally {
            f9311c = true;
        }
        return f9310b || !"user".equals(Build.TYPE);
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: b */
    public static boolean m4020b(Context context, String str) throws PackageManager.NameNotFoundException {
        boolean zEquals = str.equals("com.google.android.gms");
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (zEquals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                Object systemService = context.getSystemService("user");
                Objects.requireNonNull(systemService, "null reference");
                Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
                if (!(applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
    }
}
