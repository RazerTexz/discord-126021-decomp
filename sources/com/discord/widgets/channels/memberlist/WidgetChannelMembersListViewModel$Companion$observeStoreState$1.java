package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetChannelMembersListViewModel$StoreState>> {
    public final /* synthetic */ Observable $isPanelOpenObservable;
    public final /* synthetic */ PrivateChannelMemberListService $privateChannelMemberListService;
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannelMembers $storeChannelMembers;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUserPresence $storePresence;
    public final /* synthetic */ StoreThreadMembers $storeThreadMembers;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1(Observable observable, PrivateChannelMemberListService privateChannelMemberListService, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StorePermissions storePermissions, StoreChannelMembers storeChannelMembers, StoreGuilds storeGuilds, StoreThreadMembers storeThreadMembers, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
        this.$isPanelOpenObservable = observable;
        this.$privateChannelMemberListService = privateChannelMemberListService;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$storeChannelMembers = storeChannelMembers;
        this.$storeGuilds = storeGuilds;
        this.$storeThreadMembers = storeThreadMembers;
        this.$storeUser = storeUser;
        this.$storePresence = storeUserPresence;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeThreadsJoined = storeThreadsJoined;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelMembersListViewModel$StoreState> call2(Channel channel) {
        if (channel == null) {
            return this.$isPanelOpenObservable.G(WidgetChannelMembersListViewModel$Companion$observeStoreState$1$1.INSTANCE);
        }
        if (ChannelUtils.B(channel)) {
            return Observable.j(this.$privateChannelMemberListService.observeStateForGroupDm(channel), this.$isPanelOpenObservable, new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$2(this));
        }
        return ChannelUtils.H(channel) ? this.$storeChannels.observeChannel(channel.getParentId()).Y(new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3(this, channel)) : Observable.g(this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeGuilds.observeRoles(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId()), this.$isPanelOpenObservable, new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$4(channel));
    }
}
