package com.discord.utilities.locale;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LocaleManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LocaleManager {
    public final Locale getPrimaryLocale(Context context) {
        if (context == null) {
            Locale locale = Locale.getDefault();
            C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            return locale;
        }
        Resources resources = context.getResources();
        C12238m.checkNotNullExpressionValue(resources, "context.resources");
        Locale locale2 = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
        C12238m.checkNotNullExpressionValue(locale2, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale2;
    }
}
