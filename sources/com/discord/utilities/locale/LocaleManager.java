package com.discord.utilities.locale;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import d0.z.d.Intrinsics3;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LocaleManager {
    public final Locale getPrimaryLocale(Context context) {
        if (context == null) {
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            return locale;
        }
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        Locale locale2 = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
        Intrinsics3.checkNotNullExpressionValue(locale2, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale2;
    }
}
