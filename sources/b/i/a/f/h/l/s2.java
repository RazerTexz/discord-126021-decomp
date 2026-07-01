package b.i.a.f.h.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import android.os.StrictMode$ThreadPolicy;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s2 implements b2 {

    @GuardedBy("SharedPreferencesLoader.class")
    public static final Map<String, s2> a = new ArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1492b;
    public final SharedPreferences$OnSharedPreferenceChangeListener c;
    public final Object d;
    public volatile Map<String, ?> e;

    public static s2 a(Context context) {
        s2 s2Var;
        if (w1.a()) {
            throw null;
        }
        synchronized (s2.class) {
            s2Var = a.get(null);
            if (s2Var == null) {
                StrictMode$ThreadPolicy strictMode$ThreadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    throw null;
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
                    throw th;
                }
            }
        }
        return s2Var;
    }

    public static synchronized void b() {
        for (s2 s2Var : a.values()) {
            s2Var.f1492b.unregisterOnSharedPreferenceChangeListener(s2Var.c);
        }
        a.clear();
    }

    @Override // b.i.a.f.h.l.b2
    public final Object g(String str) {
        Map<String, ?> map = this.e;
        if (map == null) {
            synchronized (this.d) {
                map = this.e;
                if (map == null) {
                    StrictMode$ThreadPolicy strictMode$ThreadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f1492b.getAll();
                        this.e = all;
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
