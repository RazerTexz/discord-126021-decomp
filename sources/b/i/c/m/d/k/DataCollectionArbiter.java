package b.i.c.m.d.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.c.FirebaseApp2;
import b.i.c.m.d.Logger3;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;

/* JADX INFO: renamed from: b.i.c.m.d.k.q0, reason: use source file name */
/* JADX INFO: compiled from: DataCollectionArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public class DataCollectionArbiter {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseApp2 f1693b;
    public final Object c;
    public TaskCompletionSource<Void> d;
    public boolean e;
    public boolean f;

    @Nullable
    public Boolean g;
    public TaskCompletionSource<Void> h;

    public DataCollectionArbiter(FirebaseApp2 firebaseApp2) {
        Boolean boolValueOf;
        Object obj = new Object();
        this.c = obj;
        this.d = new TaskCompletionSource<>();
        this.e = false;
        this.f = false;
        this.h = new TaskCompletionSource<>();
        firebaseApp2.a();
        Context context = firebaseApp2.d;
        this.f1693b = firebaseApp2;
        SharedPreferences sharedPreferencesO = CommonUtils.o(context);
        this.a = sharedPreferencesO;
        if (sharedPreferencesO.contains("firebase_crashlytics_collection_enabled")) {
            this.f = false;
            boolValueOf = Boolean.valueOf(sharedPreferencesO.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        this.g = boolValueOf == null ? a(context) : boolValueOf;
        synchronized (obj) {
            if (b()) {
                this.d.b(null);
                this.e = true;
            }
        }
    }

    @Nullable
    public final Boolean a(Context context) {
        Boolean boolValueOf;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            boolValueOf = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e) {
            if (Logger3.a.a(3)) {
                Log.d("FirebaseCrashlytics", "Unable to get PackageManager. Falling through", e);
            }
        }
        if (boolValueOf == null) {
            this.f = false;
            return null;
        }
        this.f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolValueOf));
    }

    public synchronized boolean b() {
        boolean zBooleanValue;
        String str;
        Boolean bool = this.g;
        zBooleanValue = bool != null ? bool.booleanValue() : this.f1693b.g();
        String str2 = zBooleanValue ? "ENABLED" : "DISABLED";
        if (this.g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        Logger3.a.b(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
        return zBooleanValue;
    }

    public Task<Void> c() {
        b.i.a.f.n.c0<Void> c0Var;
        b.i.a.f.n.c0<Void> c0Var2 = this.h.a;
        synchronized (this.c) {
            c0Var = this.d.a;
        }
        FilenameFilter filenameFilter = Utils3.a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Utils4 utils4 = new Utils4(taskCompletionSource);
        c0Var2.h(utils4);
        c0Var.h(utils4);
        return taskCompletionSource.a;
    }
}
