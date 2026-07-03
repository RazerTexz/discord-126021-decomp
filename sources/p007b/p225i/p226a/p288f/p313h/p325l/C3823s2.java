package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.h.l.s2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3823s2 implements InterfaceC3594b2 {

    /* JADX INFO: renamed from: a */
    @GuardedBy("SharedPreferencesLoader.class")
    public static final Map<String, C3823s2> f10302a = new ArrayMap();

    /* JADX INFO: renamed from: b */
    public final SharedPreferences f10303b;

    /* JADX INFO: renamed from: c */
    public final SharedPreferences.OnSharedPreferenceChangeListener f10304c;

    /* JADX INFO: renamed from: d */
    public final Object f10305d;

    /* JADX INFO: renamed from: e */
    public volatile Map<String, ?> f10306e;

    /* JADX INFO: renamed from: a */
    public static C3823s2 m5213a(Context context) {
        C3823s2 c3823s2;
        if (C3874w1.m5341a()) {
            throw null;
        }
        synchronized (C3823s2.class) {
            c3823s2 = f10302a.get(null);
            if (c3823s2 == null) {
                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    throw null;
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    throw th;
                }
            }
        }
        return c3823s2;
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m5214b() {
        for (C3823s2 c3823s2 : f10302a.values()) {
            c3823s2.f10303b.unregisterOnSharedPreferenceChangeListener(c3823s2.f10304c);
        }
        f10302a.clear();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3594b2
    /* JADX INFO: renamed from: g */
    public final Object mo4567g(String str) {
        Map<String, ?> map = this.f10306e;
        if (map == null) {
            synchronized (this.f10305d) {
                map = this.f10306e;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f10303b.getAll();
                        this.f10306e = all;
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
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
