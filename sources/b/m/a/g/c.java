package b.m.a.g;

import android.content.SharedPreferences;
import b.m.a.f;
import d0.z.d.m;

/* JADX INFO: compiled from: SharedPreferenceSyncResponseCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements f {
    public final SharedPreferences a;

    public c(SharedPreferences sharedPreferences) {
        m.checkParameterIsNotNull(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    @Override // b.m.a.f
    public void a(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_elapsed_time", j).apply();
    }

    @Override // b.m.a.f
    public void b(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_offset", j).apply();
    }

    @Override // b.m.a.f
    public long c() {
        return this.a.getLong("com.lyft.kronos.cached_elapsed_time", 0L);
    }

    @Override // b.m.a.f
    public void clear() {
        this.a.edit().clear().apply();
    }

    @Override // b.m.a.f
    public long d() {
        return this.a.getLong("com.lyft.kronos.cached_offset", 0L);
    }

    @Override // b.m.a.f
    public long e() {
        return this.a.getLong("com.lyft.kronos.cached_current_time", 0L);
    }

    @Override // b.m.a.f
    public void f(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_current_time", j).apply();
    }
}
