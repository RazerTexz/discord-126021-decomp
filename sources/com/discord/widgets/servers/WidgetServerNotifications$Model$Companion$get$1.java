package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$Model$Companion$get$1<T1, T2, T3, R> implements Func3<Guild, ModelNotificationSettings, StoreGuildProfiles$GuildProfileData, WidgetServerNotifications$Model> {
    public static final WidgetServerNotifications$Model$Companion$get$1 INSTANCE = new WidgetServerNotifications$Model$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerNotifications$Model call(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        return call2(guild, modelNotificationSettings, storeGuildProfiles$GuildProfileData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerNotifications$Model call2(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        if (guild == null || modelNotificationSettings == null) {
            return null;
        }
        return new WidgetServerNotifications$Model(guild, modelNotificationSettings, storeGuildProfiles$GuildProfileData);
    }
}
