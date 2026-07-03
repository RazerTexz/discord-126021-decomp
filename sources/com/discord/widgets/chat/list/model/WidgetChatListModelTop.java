package com.discord.widgets.chat.list.model;

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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.UserMutualGuildsManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func9;

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
            Observable observableM11112r = companion.getChannels().observeDefaultChannel(channel.getGuildId()).m11083G(new InterfaceC12589b<Channel, Long>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Long call(Channel channel2) {
                    return Long.valueOf(channel2 != null ? channel2.getId() : 0L);
                }
            }).m11112r();
            Observable<GuildMember> observableObserveGuildMember = observeGuildMember(channel.getGuildId(), channel.getOwnerId());
            Observable<User> observableObserveUser = companion.getUsers().observeUser(channel.getOwnerId());
            UserMutualGuildsManager userMutualGuildsManager = new UserMutualGuildsManager(null, null, null, 7, null);
            User userM7677a = ChannelUtils.m7677a(channel);
            Observable<ChatListEntry> observableM11066c = Observable.m11066c(observableObserveGuild, observableObserveMe$default, observableObservePermissionsForChannel, observableM11112r, observableObserveGuildMember, observableObserveUser, userMutualGuildsManager.observeMutualGuilds(C12145m.listOf(Long.valueOf(userM7677a != null ? userM7677a.getId() : 0L))), companion.getChannels().observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new Func9<Guild, MeUser, Long, Long, GuildMember, User, Map<Long, ? extends List<? extends Guild>>, Channel, Boolean, ChatListEntry>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$2
                @Override // p658rx.functions.Func9
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
                    C12238m.checkNotNullExpressionValue(meUser, "me");
                    boolean zCanManageThread = threadUtils.canManageThread(meUser, channel, l);
                    User userM7677a2 = ChannelUtils.m7677a(channel);
                    List<Guild> listEmptyList = map.get(Long.valueOf(userM7677a2 != null ? userM7677a2.getId() : 0L));
                    if (listEmptyList == null) {
                        listEmptyList = C12147n.emptyList();
                    }
                    boolean zIsOwner = guild != null ? guild.isOwner(meUser.getId()) : false;
                    if (ChannelUtils.m7698v(channel) && guild != null && z2 && zCan && (zCan2 || !z3)) {
                        long id2 = guild.getId();
                        String name = guild.getName();
                        return new GuildWelcomeEntry(zIsOwner, z3, zCan2, id2, name != null ? name : "");
                    }
                    if (ChannelUtils.m7667B(channel)) {
                        return new StartOfPrivateChatEntry(channel.getId(), ChannelUtils.m7679c(channel), channel.getType(), IconUtils.getForChannel$default(channel, null, 2, null), ChannelUtils.m7670E(channel), listEmptyList);
                    }
                    long id3 = channel.getId();
                    String strM7679c = ChannelUtils.m7679c(channel);
                    boolean zM7675J = ChannelUtils.m7675J(channel);
                    boolean zM7673H = ChannelUtils.m7673H(channel);
                    ThreadMetadata threadMetadata = channel.getThreadMetadata();
                    Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
                    String nickOrUsername = user != null ? GuildMember.INSTANCE.getNickOrUsername(guildMember, user) : "";
                    boolean z4 = channel2 != null && ChannelUtils.m7693q(channel2);
                    C12238m.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
                    return new StartOfChatEntry(id3, strM7679c, zCan, zCan3, zCanManageThread, zM7673H, numValueOf, guildMember, nickOrUsername, zM7675J, z4, bool.booleanValue(), channel2 != null ? channel2.m7637d() : null, channel.m7636c());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11066c, "Observable.combineLatest…      )\n        }\n      }");
            return observableM11066c;
        }

        private final Observable<GuildMember> observeGuildMember(long guildId, long userId) {
            Observable<GuildMember> observableObserveGuildMember = StoreStream.INSTANCE.getGuilds().observeGuildMember(guildId, userId);
            C12238m.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream.getGuilds().…ldMember(guildId, userId)");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMember, 1L, TimeUnit.SECONDS));
        }

        public final Observable<WidgetChatListModelTop> get(final Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            Observable<WidgetChatListModelTop> observableM11112r = StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channel.getId()).m11099Y(new InterfaceC12589b<StoreMessagesLoader.ChannelLoadedState, Observable<? extends WidgetChatListModelTop>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                    Observable c12721k;
                    if (channelLoadedState.isOldestMessagesLoaded()) {
                        c12721k = WidgetChatListModelTop.INSTANCE.getWelcomeEntry(channel);
                    } else {
                        c12721k = (channelLoadedState.isTouchedSinceLastJump() || !channelLoadedState.isInitialMessagesLoaded()) ? new C12721k(new LoadingEntry()) : new C12721k(new SpacerEntry(channel.getId()));
                    }
                    return c12721k.m11083G(new InterfaceC12589b<ChatListEntry, WidgetChatListModelTop>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final WidgetChatListModelTop call(ChatListEntry chatListEntry) {
                            C12238m.checkNotNullExpressionValue(chatListEntry, "it");
                            return new WidgetChatListModelTop(chatListEntry);
                        }
                    });
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChatListModelTop(ChatListEntry chatListEntry) {
        C12238m.checkNotNullParameter(chatListEntry, "item");
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
        C12238m.checkNotNullParameter(item, "item");
        return new WidgetChatListModelTop(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListModelTop) && C12238m.areEqual(this.item, ((WidgetChatListModelTop) other).item);
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
        StringBuilder sbM833U = C1643a.m833U("WidgetChatListModelTop(item=");
        sbM833U.append(this.item);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
