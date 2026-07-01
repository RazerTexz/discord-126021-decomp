package b.m.a.g;

import android.content.SharedPreferences;
import b.m.a.SyncResponseCache;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.c, reason: use source file name */
/* JADX INFO: compiled from: SharedPreferenceSyncResponseCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferenceSyncResponseCache implements SyncResponseCache {
    public final SharedPreferences a;

    public SharedPreferenceSyncResponseCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkParameterIsNotNull(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    @Override // b.m.a.SyncResponseCache
    public void a(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_elapsed_time", j).apply();
    }

    @Override // b.m.a.SyncResponseCache
    public void b(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_offset", j).apply();
    }

    @Override // b.m.a.SyncResponseCache
    public long c() {
        return this.a.getLong("com.lyft.kronos.cached_elapsed_time", 0L);
    }

    @Override // b.m.a.SyncResponseCache
    public void clear() {
        this.a.edit().clear().apply();
    }

    @Override // b.m.a.SyncResponseCache
    public long d() {
        return this.a.getLong("com.lyft.kronos.cached_offset", 0L);
    }

    @Override // b.m.a.SyncResponseCache
    public long e() {
        return this.a.getLong("com.lyft.kronos.cached_current_time", 0L);
    }

    @Override // b.m.a.SyncResponseCache
    public void f(long j) {
        this.a.edit().putLong("com.lyft.kronos.cached_current_time", j).apply();
    }
}
