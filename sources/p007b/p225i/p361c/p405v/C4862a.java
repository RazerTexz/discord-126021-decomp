package p007b.p225i.p361c.p405v;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import p007b.p225i.p361c.p396q.InterfaceC4798c;

/* JADX INFO: renamed from: b.i.c.v.a */
/* JADX INFO: compiled from: DataCollectionConfigStorage.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4862a {

    /* JADX INFO: renamed from: a */
    public final Context f13008a;

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f13009b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC4798c f13010c;

    /* JADX INFO: renamed from: d */
    public boolean f13011d;

    public C4862a(Context context, String str, InterfaceC4798c interfaceC4798c) {
        boolean z2;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        context = Build.VERSION.SDK_INT >= 24 ? ContextCompat.createDeviceProtectedStorageContext(context) : context;
        this.f13008a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f13009b = sharedPreferences;
        this.f13010c = interfaceC4798c;
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
        this.f13011d = z2;
    }
}
