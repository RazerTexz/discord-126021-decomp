package com.discord.widgets.chat.list.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.UserMutualGuildsManager;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelTop {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChatListEntry item;

    /* JADX INFO: compiled from: WidgetChatListModelTop.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<ChatListEntry> getWelcomeEntry(final Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel.getGuildId());
            Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel.getId());
            Observable observableR = companion.getChannels().observeDefaultChannel(channel.getGuildId()).G(new Func1<Channel, Long>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$1
                @Override // j0.k.Func1
                public final Long call(Channel channel2) {
                    return Long.valueOf(channel2 != null ? channel2.getId() : 0L);
                }
            }).r();
            Observable<GuildMember> observableObserveGuildMember = observeGuildMember(channel.getGuildId(), channel.getOwnerId());
            Observable<User> observableObserveUser = companion.getUsers().observeUser(channel.getOwnerId());
            UserMutualGuildsManager userMutualGuildsManager = new UserMutualGuildsManager(null, null, null, 7, null);
            User userA = ChannelUtils.a(channel);
            Observable<ChatListEntry> observableC = Observable.c(observableObserveGuild, observableObserveMe$default, observableObservePermissionsForChannel, observableR, observableObserveGuildMember, observableObserveUser, userMutualGuildsManager.observeMutualGuilds(CollectionsJVM.listOf(Long.valueOf(userA != null ? userA.getId() : 0L))), companion.getChannels().observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new Func9<Guild, MeUser, Long, Long, GuildMember, User, Map<Long, ? extends List<? extends Guild>>, Channel, Boolean, ChatListEntry>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$2
                @Override // rx.functions.Func9
                public /* bridge */ /* synthetic */ ChatListEntry call(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<? extends Guild>> map, Channel channel2, Boolean bool) {
                    return call2(guild, meUser, l, l2, guildMember, user, (Map<Long, ? extends List<Guild>>) map, channel2, bool);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final ChatListEntry call2(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<Guild>> map, Channel channel2, Boolean bool) {
                    boolean z2 = l2 != null && channel.getId() == l2.longValue();
                    boolean z3 = guild != null && guild.hasIcon();
                    boolean zCan = PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, l);
                    boolean zCan2 = PermissionUtils.can(1L, l);
                    boolean zCan3 = PermissionUtils.can(16L, l);
                    ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    boolean zCanManageThread = threadUtils.canManageThread(meUser, channel, l);
                    User userA2 = ChannelUtils.a(channel);
                    List<Guild> listEmptyList = map.get(Long.valueOf(userA2 != null ? userA2.getId() : 0L));
                    if (listEmptyList == null) {
                        listEmptyList = Collections2.emptyList();
                    }
                    boolean zIsOwner = guild != null ? guild.isOwner(meUser.getId()) : false;
                    if (ChannelUtils.v(channel) && guild != null && z2 && zCan && (zCan2 || !z3)) {
                        long id2 = guild.getId();
                        String name = guild.getName();
                        return new GuildWelcomeEntry(zIsOwner, z3, zCan2, id2, name != null ? name : "");
                    }
                    if (ChannelUtils.B(channel)) {
                        return new StartOfPrivateChatEntry(channel.getId(), ChannelUtils.c(channel), channel.getType(), IconUtils.getForChannel$default(channel, null, 2, null), ChannelUtils.E(channel), listEmptyList);
                    }
                    long id3 = channel.getId();
                    String strC = ChannelUtils.c(channel);
                    boolean zJ = ChannelUtils.J(channel);
                    boolean zH = ChannelUtils.H(channel);
                    ThreadMetadata threadMetadata = channel.getThreadMetadata();
                    Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
                    String nickOrUsername = user != null ? GuildMember.INSTANCE.getNickOrUsername(guildMember, user) : "";
                    boolean z4 = channel2 != null && ChannelUtils.q(channel2);
                    Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
                    return new StartOfChatEntry(id3, strC, zCan, zCan3, zCanManageThread, zH, numValueOf, guildMember, nickOrUsername, zJ, z4, bool.booleanValue(), channel2 != null ? channel2.d() : null, channel.c());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…      )\n        }\n      }");
            return observableC;
        }

        private final Observable<GuildMember> observeGuildMember(long guildId, long userId) {
            Observable<GuildMember> observableObserveGuildMember = StoreStream.INSTANCE.getGuilds().observeGuildMember(guildId, userId);
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream.getGuilds().…ldMember(guildId, userId)");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMember, 1L, TimeUnit.SECONDS));
        }

        public final Observable<WidgetChatListModelTop> get(final Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Observable<WidgetChatListModelTop> observableR = StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channel.getId()).Y(new Func1<StoreMessagesLoader.ChannelLoadedState, Observable<? extends WidgetChatListModelTop>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                    Observable scalarSynchronousObservable;
                    if (channelLoadedState.isOldestMessagesLoaded()) {
                        scalarSynchronousObservable = WidgetChatListModelTop.INSTANCE.getWelcomeEntry(channel);
                    } else {
                        scalarSynchronousObservable = (channelLoadedState.isTouchedSinceLastJump() || !channelLoadedState.isInitialMessagesLoaded()) ? new ScalarSynchronousObservable(new LoadingEntry()) : new ScalarSynchronousObservable(new SpacerEntry(channel.getId()));
                    }
                    return scalarSynchronousObservable.G(new Func1<ChatListEntry, WidgetChatListModelTop>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1.1
                        @Override // j0.k.Func1
                        public final WidgetChatListModelTop call(ChatListEntry chatListEntry) {
                            Intrinsics3.checkNotNullExpressionValue(chatListEntry, "it");
                            return new WidgetChatListModelTop(chatListEntry);
                        }
                    });
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChatListModelTop(ChatListEntry chatListEntry) {
        Intrinsics3.checkNotNullParameter(chatListEntry, "item");
        this.item = chatListEntry;
    }

    public static /* synthetic */ WidgetChatListModelTop copy$default(WidgetChatListModelTop widgetChatListModelTop, ChatListEntry chatListEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            chatListEntry = widgetChatListModelTop.item;
        }
        return widgetChatListModelTop.copy(chatListEntry);
    }

    public static final Observable<WidgetChatListModelTop> get(Channel channel) {
        return INSTANCE.get(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ChatListEntry getItem() {
        return this.item;
    }

    public final WidgetChatListModelTop copy(ChatListEntry item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        return new WidgetChatListModelTop(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListModelTop) && Intrinsics3.areEqual(this.item, ((WidgetChatListModelTop) other).item);
        }
        return true;
    }

    public final ChatListEntry getItem() {
        return this.item;
    }

    public int hashCode() {
        ChatListEntry chatListEntry = this.item;
        if (chatListEntry != null) {
            return chatListEntry.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatListModelTop(item=");
        sbU.append(this.item);
        sbU.append(")");
        return sbU.toString();
    }
}
