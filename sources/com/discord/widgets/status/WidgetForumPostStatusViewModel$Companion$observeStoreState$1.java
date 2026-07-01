package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetForumPostStatusViewModel$StoreState>> {
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreForumPostMessages $storeForumPostMessages;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;

    public WidgetForumPostStatusViewModel$Companion$observeStoreState$1(StoreUser storeUser, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StorePermissions storePermissions, StoreEmoji storeEmoji) {
        this.$storeUser = storeUser;
        this.$storeThreadsJoined = storeThreadsJoined;
        this.$storeForumPostMessages = storeForumPostMessages;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storePermissions = storePermissions;
        this.$storeEmoji = storeEmoji;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumPostStatusViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumPostStatusViewModel$StoreState> call2(Channel channel) {
        return channel == null ? new k(WidgetForumPostStatusViewModel$StoreState$Invalid.INSTANCE) : Observable.g(this.$storeUser.observeMeId(), this.$storeThreadsJoined.observeJoinedThread(channel.getId()), this.$storeForumPostMessages.observeForumPostFirstMessage(channel.getParentId(), channel.getId(), true), this.$storeThreadMessages.observeThreadCountAndLatestMessage(channel.getId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), new WidgetForumPostStatusViewModel$Companion$observeStoreState$1$1(this, channel));
    }
}
