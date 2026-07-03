package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.q0 */
/* JADX INFO: compiled from: DataCollectionArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4650q0 {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f12371a;

    /* JADX INFO: renamed from: b */
    public final C4542c f12372b;

    /* JADX INFO: renamed from: c */
    public final Object f12373c;

    /* JADX INFO: renamed from: d */
    public TaskCompletionSource<Void> f12374d;

    /* JADX INFO: renamed from: e */
    public boolean f12375e;

    /* JADX INFO: renamed from: f */
    public boolean f12376f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public Boolean f12377g;

    /* JADX INFO: renamed from: h */
    public TaskCompletionSource<Void> f12378h;

    public C4650q0(C4542c c4542c) {
        Boolean boolValueOf;
        Object obj = new Object();
        this.f12373c = obj;
        this.f12374d = new TaskCompletionSource<>();
        this.f12375e = false;
        this.f12376f = false;
        this.f12378h = new TaskCompletionSource<>();
        c4542c.m6330a();
        Context context = c4542c.f12118d;
        this.f12372b = c4542c;
        SharedPreferences sharedPreferencesM6421o = C4628h.m6421o(context);
        this.f12371a = sharedPreferencesM6421o;
        if (sharedPreferencesM6421o.contains("firebase_crashlytics_collection_enabled")) {
            this.f12376f = false;
            boolValueOf = Boolean.valueOf(sharedPreferencesM6421o.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        this.f12377g = boolValueOf == null ? m6449a(context) : boolValueOf;
        synchronized (obj) {
            if (m6450b()) {
                this.f12374d.m9126b(null);
                this.f12375e = true;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final Boolean m6449a(Context context) {
        Boolean boolValueOf;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            boolValueOf = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e) {
            if (C4592b.f12227a.m6370a(3)) {
                Log.d("FirebaseCrashlytics", "Unable to get PackageManager. Falling through", e);
            }
        }
        if (boolValueOf == null) {
            this.f12376f = false;
            return null;
        }
        this.f12376f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolValueOf));
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m6450b() {
        boolean zBooleanValue;
        String str;
        Boolean bool = this.f12377g;
        zBooleanValue = bool != null ? bool.booleanValue() : this.f12372b.m6333g();
        String str2 = zBooleanValue ? "ENABLED" : "DISABLED";
        if (this.f12377g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f12376f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        C4592b.f12227a.m6371b(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: c */
    public Task<Void> m6451c() {
        C4358c0<Void> c4358c0;
        C4358c0<Void> c4358c1 = this.f12378h.f20845a;
        synchronized (this.f12373c) {
            c4358c0 = this.f12374d.f20845a;
        }
        FilenameFilter filenameFilter = C4630h1.f12313a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C4633i1 c4633i1 = new C4633i1(taskCompletionSource);
        c4358c1.mo6013h(c4633i1);
        c4358c0.mo6013h(c4633i1);
        return taskCompletionSource.f20845a;
    }
}
