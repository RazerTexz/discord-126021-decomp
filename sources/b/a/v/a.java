package b.a.v;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.m;

/* JADX INFO: compiled from: AcknowledgedTooltipsCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final SharedPreferences a;

    public a() {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    public a(SharedPreferences sharedPreferences, int i) {
        SharedPreferences sharedPreferences2 = (i & 1) != 0 ? SharedPreferencesProvider.INSTANCE.get() : null;
        m.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.a = sharedPreferences2;
    }
}
