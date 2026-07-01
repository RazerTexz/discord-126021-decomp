package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1<T1, T2, R> implements Func2<Channel, ModelNotificationSettings, ChannelGroupDMSettingsViewModel$StoreState$Valid> {
    public static final ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1 INSTANCE = new ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ChannelGroupDMSettingsViewModel$StoreState$Valid call(Channel channel, ModelNotificationSettings modelNotificationSettings) {
        return call2(channel, modelNotificationSettings);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChannelGroupDMSettingsViewModel$StoreState$Valid call2(Channel channel, ModelNotificationSettings modelNotificationSettings) {
        m.checkNotNullExpressionValue(channel, "channel");
        m.checkNotNullExpressionValue(modelNotificationSettings, "notificationSettings");
        return new ChannelGroupDMSettingsViewModel$StoreState$Valid(channel, modelNotificationSettings);
    }
}
