package p007b.p008a.p058v;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.v.a */
/* JADX INFO: compiled from: AcknowledgedTooltipsCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1311a {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f1999a;

    public C1311a() {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        C12238m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.f1999a = sharedPreferences;
    }

    public C1311a(SharedPreferences sharedPreferences, int i) {
        SharedPreferences sharedPreferences2 = (i & 1) != 0 ? SharedPreferencesProvider.INSTANCE.get() : null;
        C12238m.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.f1999a = sharedPreferences2;
    }
}
