package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.UserMutualGuildsManager;
import d0.t.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion {
    private WidgetChatListModelTop$Companion() {
    }

    public static final /* synthetic */ Observable access$getWelcomeEntry(WidgetChatListModelTop$Companion widgetChatListModelTop$Companion, Channel channel) {
        return widgetChatListModelTop$Companion.getWelcomeEntry(channel);
    }

    private final Observable<ChatListEntry> getWelcomeEntry(Channel channel) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Guild> observableObserveGuild = storeStream$Companion.getGuilds().observeGuild(channel.getGuildId());
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Long> observableObservePermissionsForChannel = storeStream$Companion.getPermissions().observePermissionsForChannel(channel.getId());
        Observable observableR = storeStream$Companion.getChannels().observeDefaultChannel(channel.getGuildId()).G(WidgetChatListModelTop$Companion$getWelcomeEntry$1.INSTANCE).r();
        Observable<GuildMember> observableObserveGuildMember = observeGuildMember(channel.getGuildId(), channel.getOwnerId());
        Observable<User> observableObserveUser = storeStream$Companion.getUsers().observeUser(channel.getOwnerId());
        UserMutualGuildsManager userMutualGuildsManager = new UserMutualGuildsManager(null, null, null, 7, null);
        User userA = ChannelUtils.a(channel);
        Observable<ChatListEntry> observableC = Observable.c(observableObserveGuild, observableObserveMe$default, observableObservePermissionsForChannel, observableR, observableObserveGuildMember, observableObserveUser, userMutualGuildsManager.observeMutualGuilds(m.listOf(Long.valueOf(userA != null ? userA.getId() : 0L))), storeStream$Companion.getChannels().observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChatListModelTop$Companion$getWelcomeEntry$2(channel));
        d0.z.d.m.checkNotNullExpressionValue(observableC, "Observable.combineLatest…      )\n        }\n      }");
        return observableC;
    }

    private final Observable<GuildMember> observeGuildMember(long guildId, long userId) {
        Observable<GuildMember> observableObserveGuildMember = StoreStream.Companion.getGuilds().observeGuildMember(guildId, userId);
        d0.z.d.m.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream.getGuilds().…ldMember(guildId, userId)");
        return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMember, 1L, TimeUnit.SECONDS));
    }

    public final Observable<WidgetChatListModelTop> get(Channel channel) {
        d0.z.d.m.checkNotNullParameter(channel, "channel");
        Observable<WidgetChatListModelTop> observableR = StoreStream.Companion.getMessagesLoader().getMessagesLoadedState(channel.getId()).Y(new WidgetChatListModelTop$Companion$get$1(channel)).r();
        d0.z.d.m.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChatListModelTop$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
