package p007b.p225i.p226a.p288f.p299e.p310p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.RecentlyNonNull;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.e.p.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3410a {

    /* JADX INFO: renamed from: a */
    @RecentlyNonNull
    public final Context f9605a;

    public C3410a(@RecentlyNonNull Context context) {
        this.f9605a = context;
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public ApplicationInfo m4373a(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f9605a.getPackageManager().getApplicationInfo(str, i);
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: b */
    public PackageInfo m4374b(@RecentlyNonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f9605a.getPackageManager().getPackageInfo(str, i);
    }

    /* JADX INFO: renamed from: c */
    public boolean m4375c() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return C3404f.m4202E0(this.f9605a);
        }
        if (!C3404f.m4190A0() || (nameForUid = this.f9605a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f9605a.getPackageManager().isInstantApp(nameForUid);
    }
}
