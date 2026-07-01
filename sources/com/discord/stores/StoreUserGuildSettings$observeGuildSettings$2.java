package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$observeGuildSettings$2<T, R> implements b<Map<Long, ? extends ModelNotificationSettings>, ModelNotificationSettings> {
    public final /* synthetic */ long $guildId;

    public StoreUserGuildSettings$observeGuildSettings$2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ModelNotificationSettings call(Map<Long, ? extends ModelNotificationSettings> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelNotificationSettings call2(Map<Long, ? extends ModelNotificationSettings> map) {
        ModelNotificationSettings modelNotificationSettings = map.get(Long.valueOf(this.$guildId));
        return modelNotificationSettings != null ? modelNotificationSettings : new ModelNotificationSettings();
    }
}
