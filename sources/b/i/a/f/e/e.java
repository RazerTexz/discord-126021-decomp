package b.i.a.f.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller$SessionInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1347b = false;
    public static boolean c = false;
    public static final AtomicBoolean a = new AtomicBoolean();
    public static final AtomicBoolean d = new AtomicBoolean();

    public static boolean a(@RecentlyNonNull Context context) {
        try {
            if (!c) {
                PackageInfo packageInfo = b.i.a.f.e.p.b.a(context).a.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                f.a(context);
                if (packageInfo == null || f.d(packageInfo, false) || !f.d(packageInfo, true)) {
                    f1347b = false;
                } else {
                    f1347b = true;
                }
            }
        } catch (PackageManager$NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
        } finally {
            c = true;
        }
        return f1347b || !"user".equals(Build.TYPE);
    }

    @TargetApi(21)
    public static boolean b(Context context, String str) throws PackageManager$NameNotFoundException {
        boolean zEquals = str.equals("com.google.android.gms");
        try {
            Iterator<PackageInstaller$SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
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
        } catch (PackageManager$NameNotFoundException | Exception unused) {
        }
    }
}
