package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.widgets.forums.ForumUtils;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetThreadStatusViewModel$StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadsActiveJoined $storeThreadsActiveJoined;

    public WidgetThreadStatusViewModel$Companion$observeStoreState$1(StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions, StoreChannels storeChannels, StoreExperiments storeExperiments) {
        this.$storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.$storePermissions = storePermissions;
        this.$storeChannels = storeChannels;
        this.$storeExperiments = storeExperiments;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadStatusViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadStatusViewModel$StoreState> call2(Channel channel) {
        return Observable.h(this.$storeThreadsActiveJoined.observeActiveJoinedThreadsForGuild(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannels.observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), this.$storeExperiments, null, 4, null), new WidgetThreadStatusViewModel$Companion$observeStoreState$1$1(channel)).r();
    }
}
