package b.a.v;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.v.a, reason: use source file name */
/* JADX INFO: compiled from: AcknowledgedTooltipsCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcknowledgedTooltipsCache {
    public final SharedPreferences a;

    public AcknowledgedTooltipsCache() {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    public AcknowledgedTooltipsCache(SharedPreferences sharedPreferences, int i) {
        SharedPreferences sharedPreferences2 = (i & 1) != 0 ? SharedPreferencesProvider.INSTANCE.get() : null;
        Intrinsics3.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.a = sharedPreferences2;
    }
}
