package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func7;
import p658rx.functions.Func9;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModel implements WidgetChatListAdapter.Data {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_MESSAGES_PER_CHANNEL = 25;
    private static final long WUMPUS_PACK_ID = 847199849233514549L;
    private static final long WUMPUS_WAVE_STICKER_ID = 749054660769218631L;
    private final long channelId;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final long guildId;
    private final boolean isLoadingMessages;
    private final boolean isSpoilerClickAllowed;
    private final List<ChatListEntry> list;
    private final Set<Long> myRoleIds;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final long oldestMessageId;
    private final long userId;

    /* JADX INFO: compiled from: WidgetChatListModel.kt */
    public enum ChatListState {
        DETACHED,
        DETACHED_UNTOUCHED,
        ATTACHED;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetChatListModel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<ChatListState> get(final long channelId) {
                Observable observableM11099Y = StoreStream.INSTANCE.getMessages().observeIsDetached(channelId).m11099Y(new InterfaceC12589b<Boolean, Observable<? extends ChatListState>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel.ChatListState> call(Boolean bool) {
                        return call(bool.booleanValue());
                    }

                    public final Observable<? extends WidgetChatListModel.ChatListState> call(boolean z2) {
                        return z2 ? StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channelId).m11083G(new InterfaceC12589b<StoreMessagesLoader.ChannelLoadedState, WidgetChatListModel.ChatListState>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final WidgetChatListModel.ChatListState call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                                return channelLoadedState.getIsTouchedSinceLastJump() ? WidgetChatListModel.ChatListState.DETACHED : WidgetChatListModel.ChatListState.DETACHED_UNTOUCHED;
                            }
                        }).m11112r() : new C12721k(WidgetChatListModel.ChatListState.ATTACHED);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                return observableM11099Y;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* JADX INFO: compiled from: WidgetChatListModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<WidgetChatListModel> getChannel(final Channel channel) {
            Observable<WidgetChatListModelTop> observable = WidgetChatListModelTop.INSTANCE.get(channel);
            Observable<WidgetChatListModelMessages> observable2 = WidgetChatListModelMessages.INSTANCE.get(channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<WidgetChatListModel> observableM11066c = Observable.m11066c(observable, observable2, observeIsLoadingMessages(companion.getMessagesLoader(), channel.getId()), companion.getChannels().observeNames(), companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observe(), ChatListState.INSTANCE.get(channel.getId()), new Func9<WidgetChatListModelTop, WidgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState, Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends Integer>, ChatListState, WidgetChatListModel>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getChannel$1
                @Override // p658rx.functions.Func9
                public /* bridge */ /* synthetic */ WidgetChatListModel call(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends Integer> map3, WidgetChatListModel.ChatListState chatListState) {
                    return call2(widgetChatListModelTop, widgetChatListModelMessages, channelLoadedState, (Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, (Map<Long, Integer>) map3, chatListState);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListModel call2(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, Map<Long, Integer> map3, WidgetChatListModel.ChatListState chatListState) {
                    ChatListEntry greetMessageItem;
                    List<Long> roles;
                    WidgetChatListModel.Companion companion2 = WidgetChatListModel.INSTANCE;
                    C12238m.checkNotNullExpressionValue(channelLoadedState, "loadingState");
                    C12238m.checkNotNullExpressionValue(widgetChatListModelMessages, "messages");
                    Channel channel2 = channel;
                    C12238m.checkNotNullExpressionValue(map3, "relationships");
                    boolean zShouldShowStickerGreet = companion2.shouldShowStickerGreet(channelLoadedState, widgetChatListModelMessages, channel2, map3);
                    int size = widgetChatListModelMessages.getItems().size() + 2;
                    if (zShouldShowStickerGreet) {
                        size++;
                    }
                    ArrayList arrayList = new ArrayList(size);
                    if (chatListState == WidgetChatListModel.ChatListState.DETACHED) {
                        arrayList.add(new LoadingEntry());
                    } else {
                        arrayList.add(new SpacerEntry(channel.getId()));
                        if (zShouldShowStickerGreet && (greetMessageItem = companion2.getGreetMessageItem(widgetChatListModelMessages, channel)) != null) {
                            arrayList.add(greetMessageItem);
                        }
                    }
                    arrayList.addAll(widgetChatListModelMessages.getItems());
                    arrayList.add(widgetChatListModelTop.getItem());
                    GuildMember guildMember = map2.get(l);
                    Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? C12148n0.emptySet() : new HashSet(roles);
                    C12238m.checkNotNullExpressionValue(l, "myId");
                    long jLongValue = l.longValue();
                    long id2 = channel.getId();
                    long guildId = channel.getGuildId();
                    C12238m.checkNotNullExpressionValue(map, "channelNames");
                    return new WidgetChatListModel(jLongValue, id2, guild, guildId, map, widgetChatListModelMessages.getOldestMessageId(), arrayList, setEmptySet, widgetChatListModelMessages.getNewMessagesMarkerMessageId(), widgetChatListModelMessages.getNewestKnownMessageId(), channelLoadedState.isLoadingMessages());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11066c, "Observable\n            .…          )\n            }");
            return observableM11066c;
        }

        private final ChatListEntry getGreetMessageItem(WidgetChatListModelMessages messages, Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreStickers stickers = companion.getStickers();
            Map<Long, Sticker> stickers2 = stickers.getStickers();
            Long lValueOf = Long.valueOf(WidgetChatListModel.WUMPUS_WAVE_STICKER_ID);
            if (stickers2.get(lValueOf) == null) {
                stickers.fetchStickerPack(WidgetChatListModel.WUMPUS_PACK_ID);
            }
            Sticker sticker = stickers.getStickers().get(lValueOf);
            if (sticker != null) {
                Guild guild = companion.getGuilds().getGuild(channel.getGuildId());
                if (!(((guild != null ? guild.getSystemChannelFlags() : 0) & 8) == 0)) {
                    return null;
                }
                if (messages.getItems().isEmpty()) {
                    return new StickerGreetEntry(sticker, channel.getId(), ChannelUtils.m7679c(channel), channel.getType());
                }
                if (messages.getItems().size() < 25) {
                    return new StickerGreetCompactEntry(sticker, channel.getId(), ChannelUtils.m7679c(channel), channel.getType());
                }
            }
            return null;
        }

        private final Observable<WidgetChatListModel> getThreadDraft(final Channel parentChannel, final Long parentMessageId) {
            Object obj;
            Observable observableM11076j;
            Object obj2;
            final long guildId = parentChannel.getGuildId();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Map<Long, String>> observableObserveNames = companion.getChannels().observeNames();
            Observable<Long> observableObserveMeId = companion.getUsers().observeMeId();
            Observable<Map<Long, GuildMember>> observableObserveComputed = companion.getGuilds().observeComputed(guildId);
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
            Observable<StoreThreadDraft.ThreadDraftState> observableObserveDraftState = companion.getThreadDraft().observeDraftState();
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(parentChannel.getId());
            if (parentMessageId != null) {
                Observable<Message> observableObserveMessagesForChannel = companion.getMessages().observeMessagesForChannel(parentChannel.getId(), parentMessageId.longValue());
                Observable<List<ChatListEntry>> singleMessage = WidgetChatListModelMessages.INSTANCE.getSingleMessage(parentChannel, parentMessageId.longValue());
                final WidgetChatListModel$Companion$getThreadDraft$1 widgetChatListModel$Companion$getThreadDraft$1 = WidgetChatListModel$Companion$getThreadDraft$1.INSTANCE;
                if (widgetChatListModel$Companion$getThreadDraft$1 != null) {
                    obj2 = widgetChatListModel$Companion$getThreadDraft$1;
                    obj2 = new Func2() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$sam$rx_functions_Func2$0
                        @Override // p658rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj3, Object obj4) {
                            return widgetChatListModel$Companion$getThreadDraft$1.invoke(obj3, obj4);
                        }
                    };
                }
                obj2 = widgetChatListModel$Companion$getThreadDraft$1;
                observableM11076j = Observable.m11076j(observableObserveMessagesForChannel, singleMessage, (Func2) obj2);
            } else {
                C12721k c12721k = new C12721k(null);
                C12721k c12721k2 = new C12721k(new ArrayList());
                final WidgetChatListModel$Companion$getThreadDraft$2 widgetChatListModel$Companion$getThreadDraft$2 = WidgetChatListModel$Companion$getThreadDraft$2.INSTANCE;
                if (widgetChatListModel$Companion$getThreadDraft$2 != null) {
                    obj = widgetChatListModel$Companion$getThreadDraft$2;
                    obj = new Func2() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$sam$rx_functions_Func2$0
                        @Override // p658rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj3, Object obj4) {
                            return widgetChatListModel$Companion$getThreadDraft$2.invoke(obj3, obj4);
                        }
                    };
                }
                obj = widgetChatListModel$Companion$getThreadDraft$2;
                observableM11076j = Observable.m11076j(c12721k, c12721k2, (Func2) obj);
            }
            Observable<WidgetChatListModel> observableM11069e = Observable.m11069e(observableObserveNames, observableObserveMeId, observableObserveComputed, observableObserveGuild, observableObserveDraftState, observableObservePermissionsForChannel, observableM11076j, new Func7<Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, StoreThreadDraft.ThreadDraftState, Long, Pair<? extends Message, ? extends List<? extends ChatListEntry>>, WidgetChatListModel>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$3
                @Override // p658rx.functions.Func7
                public /* bridge */ /* synthetic */ WidgetChatListModel call(Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Pair<? extends Message, ? extends List<? extends ChatListEntry>> pair) {
                    return call2((Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, threadDraftState, l2, (Pair<Message, ? extends List<? extends ChatListEntry>>) pair);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListModel call2(Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Pair<Message, ? extends List<? extends ChatListEntry>> pair) {
                    List<Long> roles;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new SpacerEntry(parentChannel.getId()));
                    if (threadDraftState.isSending()) {
                        arrayList.add(new LoadingEntry());
                    }
                    arrayList.addAll(pair.getSecond());
                    Channel channel = parentChannel;
                    Long l3 = parentMessageId;
                    long guildId2 = channel.getGuildId();
                    Integer defaultAutoArchiveDuration = parentChannel.getDefaultAutoArchiveDuration();
                    C12238m.checkNotNullExpressionValue(threadDraftState, "threadDraft");
                    ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                    arrayList.add(new ThreadDraftFormEntry(channel, l3, guildId2, guild, defaultAutoArchiveDuration, threadDraftState, ThreadUtils.canCreatePrivateThread$default(threadUtils, l2, parentChannel, guild, false, 8, null), threadUtils.canCreatePrivateThread(l2, parentChannel, guild, false), threadUtils.canCreatePublicThread(l2, parentChannel, pair.getFirst(), guild)));
                    GuildMember guildMember = map2.get(l);
                    Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? C12148n0.emptySet() : new HashSet(roles);
                    C12238m.checkNotNullExpressionValue(l, "myId");
                    long j = guildId;
                    C12238m.checkNotNullExpressionValue(map, "channelNames");
                    return new WidgetChatListModel(l.longValue(), -3L, guild, j, map, 0L, arrayList, setEmptySet, 0L, 0L, false, 800, null);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11069e, "Observable\n          .co…            )\n          }");
            return observableM11069e;
        }

        private final Observable<StoreMessagesLoader.ChannelLoadedState> observeIsLoadingMessages(StoreMessagesLoader storeMessagesLoader, long j) {
            return storeMessagesLoader.getMessagesLoadedState(j).m11112r();
        }

        private final boolean shouldShowStickerGreet(StoreMessagesLoader.ChannelLoadedState loadingState, WidgetChatListModelMessages messages, Channel channel, Map<Long, Integer> relationships) {
            if (loadingState.isOldestMessagesLoaded() && loadingState.isInitialMessagesLoaded() && loadingState.getNewestSentByUserMessageId() == null && messages.getNewestSentByUserMessageId() == null && messages.getItems().size() < 25 && ChannelUtils.m7689m(channel) && !ChannelUtils.m7670E(channel)) {
                User userM7677a = ChannelUtils.m7677a(channel);
                Integer num = relationships.get(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null);
                if (num == null || num.intValue() != 2) {
                    return true;
                }
            }
            return false;
        }

        public final Observable<WidgetChatListModel> get() {
            Observable observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends WidgetChatListModel>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetChatListModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                        StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
                        return ChannelUtils.m7691o(channel.getChannel()) ? new C12721k(null) : WidgetChatListModel.INSTANCE.getChannel(channel.getChannel());
                    }
                    if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                        return new C12721k(null);
                    }
                    StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
                    return WidgetChatListModel.INSTANCE.getThreadDraft(threadDraft.getParentChannel(), threadDraft.getStarterMessageId());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModel(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<? extends ChatListEntry> list, Set<Long> set, long j5, long j6, boolean z2) {
        C12238m.checkNotNullParameter(map, "channelNames");
        C12238m.checkNotNullParameter(list, "list");
        C12238m.checkNotNullParameter(set, "myRoleIds");
        this.userId = j;
        this.channelId = j2;
        this.guild = guild;
        this.guildId = j3;
        this.channelNames = map;
        this.oldestMessageId = j4;
        this.list = list;
        this.myRoleIds = set;
        this.newMessagesMarkerMessageId = j5;
        this.newestKnownMessageId = j6;
        this.isLoadingMessages = z2;
        this.isSpoilerClickAllowed = true;
    }

    public final long component1() {
        return getUserId();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsLoadingMessages() {
        return this.isLoadingMessages;
    }

    public final long component2() {
        return getChannelId();
    }

    public final Guild component3() {
        return getGuild();
    }

    public final long component4() {
        return getGuildId();
    }

    public final Map<Long, String> component5() {
        return getChannelNames();
    }

    public final long component6() {
        return getOldestMessageId();
    }

    public final List<ChatListEntry> component7() {
        return getList();
    }

    public final Set<Long> component8() {
        return getMyRoleIds();
    }

    public final long component9() {
        return getNewMessagesMarkerMessageId();
    }

    public final WidgetChatListModel copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, long newestKnownMessageId, boolean isLoadingMessages) {
        C12238m.checkNotNullParameter(channelNames, "channelNames");
        C12238m.checkNotNullParameter(list, "list");
        C12238m.checkNotNullParameter(myRoleIds, "myRoleIds");
        return new WidgetChatListModel(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, newestKnownMessageId, isLoadingMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModel)) {
            return false;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) other;
        return getUserId() == widgetChatListModel.getUserId() && getChannelId() == widgetChatListModel.getChannelId() && C12238m.areEqual(getGuild(), widgetChatListModel.getGuild()) && getGuildId() == widgetChatListModel.getGuildId() && C12238m.areEqual(getChannelNames(), widgetChatListModel.getChannelNames()) && getOldestMessageId() == widgetChatListModel.getOldestMessageId() && C12238m.areEqual(getList(), widgetChatListModel.getList()) && C12238m.areEqual(getMyRoleIds(), widgetChatListModel.getMyRoleIds()) && getNewMessagesMarkerMessageId() == widgetChatListModel.getNewMessagesMarkerMessageId() && this.newestKnownMessageId == widgetChatListModel.newestKnownMessageId && this.isLoadingMessages == widgetChatListModel.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public List<ChatListEntry> getList() {
        return this.list;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Set<Long> getMyRoleIds() {
        return this.myRoleIds;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getOldestMessageId() {
        return this.oldestMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    public int hashCode() {
        int iM3a = (C0002b.m3a(getChannelId()) + (C0002b.m3a(getUserId()) * 31)) * 31;
        Guild guild = getGuild();
        int iM3a2 = (C0002b.m3a(getGuildId()) + ((iM3a + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iM3a3 = (C0002b.m3a(getOldestMessageId()) + ((iM3a2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode = (iM3a3 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iM3a4 = (C0002b.m3a(this.newestKnownMessageId) + ((C0002b.m3a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z2 = this.isLoadingMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iM3a4 + r0;
    }

    public final boolean isLoadingMessages() {
        return this.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("WidgetChatListModel(userId=");
        sbM833U.append(getUserId());
        sbM833U.append(", channelId=");
        sbM833U.append(getChannelId());
        sbM833U.append(", guild=");
        sbM833U.append(getGuild());
        sbM833U.append(", guildId=");
        sbM833U.append(getGuildId());
        sbM833U.append(", channelNames=");
        sbM833U.append(getChannelNames());
        sbM833U.append(", oldestMessageId=");
        sbM833U.append(getOldestMessageId());
        sbM833U.append(", list=");
        sbM833U.append(getList());
        sbM833U.append(", myRoleIds=");
        sbM833U.append(getMyRoleIds());
        sbM833U.append(", newMessagesMarkerMessageId=");
        sbM833U.append(getNewMessagesMarkerMessageId());
        sbM833U.append(", newestKnownMessageId=");
        sbM833U.append(this.newestKnownMessageId);
        sbM833U.append(", isLoadingMessages=");
        return C1643a.m827O(sbM833U, this.isLoadingMessages, ")");
    }

    public /* synthetic */ WidgetChatListModel(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, guild, j3, map, (i & 32) != 0 ? 0L : j4, list, set, (i & 256) != 0 ? 0L : j5, (i & 512) != 0 ? 0L : j6, z2);
    }
}
