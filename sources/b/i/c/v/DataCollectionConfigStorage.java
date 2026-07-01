package b.i.c.v;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import b.i.c.q.Publisher;

/* JADX INFO: renamed from: b.i.c.v.a, reason: use source file name */
/* JADX INFO: compiled from: DataCollectionConfigStorage.java */
/* JADX INFO: loaded from: classes3.dex */
public class DataCollectionConfigStorage {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1793b;
    public final Publisher c;
    public boolean d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        boolean z2;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        context = Build.VERSION.SDK_INT >= 24 ? ContextCompat.createDeviceProtectedStorageContext(context) : context;
        this.a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f1793b = sharedPreferences;
        this.c = publisher;
        boolean z3 = true;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z2 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                    z3 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z2 = z3;
        }
        this.d = z2;
    }
}
