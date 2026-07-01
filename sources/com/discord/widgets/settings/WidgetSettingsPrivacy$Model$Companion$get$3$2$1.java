package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.RestAPI$HarvestState;
import com.discord.utilities.rest.RestAPI$HarvestState$NeverRequested;
import j0.k.b;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3$2$1<T, R> implements b<Throwable, RestAPI$HarvestState> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3$2$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3$2$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ RestAPI$HarvestState call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final RestAPI$HarvestState call2(Throwable th) {
        return new RestAPI$HarvestState$NeverRequested();
    }
}
