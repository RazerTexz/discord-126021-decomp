package b.i.a.f.i.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m4 {
    public final u4 a;

    public m4(u4 u4Var) {
        this.a = u4Var;
    }

    @WorkerThread
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.a.g().j.a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.a.f().b();
        if (!b()) {
            this.a.g().l.a("Install Referrer Reporter is not available");
            return;
        }
        l4 l4Var = new l4(this, str);
        this.a.f().b();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.a.f1570b.getPackageManager();
        if (packageManager == null) {
            this.a.g().j.a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.a.g().l.a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !b()) {
                this.a.g().i.a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.a.g().n.b("Install Referrer Service is", b.i.a.f.e.n.a.b().a(this.a.f1570b, new Intent(intent), l4Var, 1) ? ModelAuditLogEntry.CHANGE_KEY_AVAILABLE : "not available");
            } catch (Exception e) {
                this.a.g().f.b("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    public final boolean b() {
        try {
            b.i.a.f.e.p.a aVarA = b.i.a.f.e.p.b.a(this.a.f1570b);
            if (aVarA != null) {
                return aVarA.a.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.g().n.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.a.g().n.b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
