package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreUserGuildSettings;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends ChannelGroupDMSettingsViewModel$StoreState>> {
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    public ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1(StoreUserGuildSettings storeUserGuildSettings) {
        this.$storeUserGuildSettings = storeUserGuildSettings;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChannelGroupDMSettingsViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChannelGroupDMSettingsViewModel$StoreState> call2(Channel channel) {
        return channel == null ? new k(ChannelGroupDMSettingsViewModel$StoreState$Invalid.INSTANCE) : Observable.j(new k(channel), this.$storeUserGuildSettings.observeGuildSettings(channel.getGuildId()), ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1.INSTANCE);
    }
}
