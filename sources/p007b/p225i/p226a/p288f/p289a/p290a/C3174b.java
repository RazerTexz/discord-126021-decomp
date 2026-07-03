package p007b.p225i.p226a.p288f.p289a.p290a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p225i.p226a.p288f.p299e.C3260e;

/* JADX INFO: renamed from: b.i.a.f.a.a.b */
/* JADX INFO: loaded from: classes3.dex */
public final class C3174b {

    /* JADX INFO: renamed from: a */
    public SharedPreferences f9191a;

    public C3174b(Context context) {
        Context contextCreatePackageContext;
        try {
            AtomicBoolean atomicBoolean = C3260e.f9309a;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            this.f9191a = contextCreatePackageContext == null ? null : contextCreatePackageContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f9191a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3965a(String str) {
        try {
            SharedPreferences sharedPreferences = this.f9191a;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
