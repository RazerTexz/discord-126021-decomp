package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel$StoreState>> {
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreUser $userStore;

    public WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1(StoreGuilds storeGuilds, StoreUser storeUser) {
        this.$guildsStore = storeGuilds;
        this.$userStore = storeUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> call2(Channel channel) {
        return Observable.h(this.$guildsStore.observeGuild(channel.getGuildId()), this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$userStore.observeAllUsers(), new WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1$1(channel));
    }
}
