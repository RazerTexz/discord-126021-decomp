package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import j0.k.b;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3<T, R> implements b<Channel, Observable<? extends WidgetChannelMembersListViewModel$StoreState>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelMembersListViewModel$Companion$observeStoreState$1 this$0;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3(WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$1, Channel channel) {
        this.this$0 = widgetChannelMembersListViewModel$Companion$observeStoreState$1;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelMembersListViewModel$StoreState> call2(Channel channel) {
        if (channel == null) {
            return this.this$0.$isPanelOpenObservable.G(WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1.INSTANCE);
        }
        if (!ChannelUtils.i(channel)) {
            Observable<Set<Long>> observableObserveThreadMembers = this.this$0.$storeThreadMembers.observeThreadMembers(this.$channel.getId());
            WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$1 = this.this$0;
            return Observable.c(observableObserveThreadMembers, widgetChannelMembersListViewModel$Companion$observeStoreState$1.$isPanelOpenObservable, widgetChannelMembersListViewModel$Companion$observeStoreState$1.$storeGuilds.observeRoles(this.$channel.getGuildId()), this.this$0.$storeGuilds.observeGuildMembers(this.$channel.getGuildId()), this.this$0.$storeGuilds.observeGuild(this.$channel.getGuildId()), this.this$0.$storeUser.observeAllUsers(), this.this$0.$storePresence.observeAllPresences(), this.this$0.$storeApplicationStreaming.observeStreamsByUser(), this.this$0.$storeThreadsJoined.observeJoinedThread(this.$channel.getId()), new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$3(this, channel));
        }
        Observable<Long> observableObservePermissionsForChannel = this.this$0.$storePermissions.observePermissionsForChannel(channel.getId());
        Observable<ChannelMemberList> observableObserveChannelMemberList = this.this$0.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId());
        WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$2 = this.this$0;
        return Observable.g(observableObservePermissionsForChannel, observableObserveChannelMemberList, widgetChannelMembersListViewModel$Companion$observeStoreState$2.$isPanelOpenObservable, widgetChannelMembersListViewModel$Companion$observeStoreState$2.$storeGuilds.observeRoles(this.$channel.getGuildId()), this.this$0.$storeGuilds.observeGuild(this.$channel.getGuildId()), new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$2(channel));
    }
}
