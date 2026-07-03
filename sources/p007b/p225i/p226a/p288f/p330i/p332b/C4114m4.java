package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p299e.p310p.C3410a;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.i.b.m4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4114m4 {

    /* JADX INFO: renamed from: a */
    public final C4202u4 f10963a;

    public C4114m4(C4202u4 c4202u4) {
        this.f10963a = c4202u4;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5758a(String str) {
        if (str == null || str.isEmpty()) {
            this.f10963a.mo5726g().f11145j.m5860a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f10963a.mo5725f().mo5848b();
        if (!m5759b()) {
            this.f10963a.mo5726g().f11147l.m5860a("Install Referrer Reporter is not available");
            return;
        }
        ServiceConnectionC4103l4 serviceConnectionC4103l4 = new ServiceConnectionC4103l4(this, str);
        this.f10963a.mo5725f().mo5848b();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f10963a.f11254b.getPackageManager();
        if (packageManager == null) {
            this.f10963a.mo5726g().f11145j.m5860a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.f10963a.mo5726g().f11147l.m5860a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !m5759b()) {
                this.f10963a.mo5726g().f11144i.m5860a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f10963a.mo5726g().f11149n.m5861b("Install Referrer Service is", C3398a.m4181b().m4182a(this.f10963a.f11254b, new Intent(intent), serviceConnectionC4103l4, 1) ? ModelAuditLogEntry.CHANGE_KEY_AVAILABLE : "not available");
            } catch (Exception e) {
                this.f10963a.mo5726g().f11141f.m5861b("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m5759b() {
        try {
            C3410a c3410aM4376a = C3411b.m4376a(this.f10963a.f11254b);
            if (c3410aM4376a != null) {
                return c3410aM4376a.f9605a.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f10963a.mo5726g().f11149n.m5860a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.f10963a.mo5726g().f11149n.m5861b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
