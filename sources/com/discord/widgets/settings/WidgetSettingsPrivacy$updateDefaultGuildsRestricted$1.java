package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1<T, R> implements b<Map<Long, ? extends Guild>, Set<? extends Long>> {
    public static final WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1 INSTANCE = new WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
        return call2((Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, Guild> map) {
        return map.keySet();
    }
}
