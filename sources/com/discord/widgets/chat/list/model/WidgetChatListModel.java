package com.discord.widgets.chat.list.model;

import a0.a.a.b;
import b.d.b.a.outline;
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
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func7;
import rx.functions.Func9;

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
                Observable observableY = StoreStream.INSTANCE.getMessages().observeIsDetached(channelId).Y(new Func1<Boolean, Observable<? extends ChatListState>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel.ChatListState> call(Boolean bool) {
                        return call(bool.booleanValue());
                    }

                    public final Observable<? extends WidgetChatListModel.ChatListState> call(boolean z2) {
                        return z2 ? StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channelId).G(new Func1<StoreMessagesLoader.ChannelLoadedState, WidgetChatListModel.ChatListState>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1.1
                            @Override // j0.k.Func1
                            public final WidgetChatListModel.ChatListState call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                                return channelLoadedState.getIsTouchedSinceLastJump() ? WidgetChatListModel.ChatListState.DETACHED : WidgetChatListModel.ChatListState.DETACHED_UNTOUCHED;
                            }
                        }).r() : new ScalarSynchronousObservable(WidgetChatListModel.ChatListState.ATTACHED);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                return observableY;
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
            Observable<WidgetChatListModel> observableC = Observable.c(observable, observable2, observeIsLoadingMessages(companion.getMessagesLoader(), channel.getId()), companion.getChannels().observeNames(), companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observe(), ChatListState.INSTANCE.get(channel.getId()), new Func9<WidgetChatListModelTop, WidgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState, Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends Integer>, ChatListState, WidgetChatListModel>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getChannel$1
                @Override // rx.functions.Func9
                public /* bridge */ /* synthetic */ WidgetChatListModel call(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends Integer> map3, WidgetChatListModel.ChatListState chatListState) {
                    return call2(widgetChatListModelTop, widgetChatListModelMessages, channelLoadedState, (Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, (Map<Long, Integer>) map3, chatListState);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListModel call2(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, Map<Long, Integer> map3, WidgetChatListModel.ChatListState chatListState) {
                    ChatListEntry greetMessageItem;
                    List<Long> roles;
                    WidgetChatListModel.Companion companion2 = WidgetChatListModel.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "loadingState");
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListModelMessages, "messages");
                    Channel channel2 = channel;
                    Intrinsics3.checkNotNullExpressionValue(map3, "relationships");
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
                    Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
                    Intrinsics3.checkNotNullExpressionValue(l, "myId");
                    long jLongValue = l.longValue();
                    long id2 = channel.getId();
                    long guildId = channel.getGuildId();
                    Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
                    return new WidgetChatListModel(jLongValue, id2, guild, guildId, map, widgetChatListModelMessages.getOldestMessageId(), arrayList, setEmptySet, widgetChatListModelMessages.getNewMessagesMarkerMessageId(), widgetChatListModelMessages.getNewestKnownMessageId(), channelLoadedState.isLoadingMessages());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n            .…          )\n            }");
            return observableC;
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
                    return new StickerGreetEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
                }
                if (messages.getItems().size() < 25) {
                    return new StickerGreetCompactEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
                }
            }
            return null;
        }

        private final Observable<WidgetChatListModel> getThreadDraft(final Channel parentChannel, final Long parentMessageId) {
            Object obj;
            Observable observableJ;
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
                final WidgetChatListModel5 widgetChatListModel5 = WidgetChatListModel5.INSTANCE;
                if (widgetChatListModel5 != null) {
                    obj2 = widgetChatListModel5;
                    obj2 = new Func2() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$sam$rx_functions_Func2$0
                        @Override // rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj3, Object obj4) {
                            return widgetChatListModel5.invoke(obj3, obj4);
                        }
                    };
                }
                obj2 = widgetChatListModel5;
                observableJ = Observable.j(observableObserveMessagesForChannel, singleMessage, (Func2) obj2);
            } else {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new ArrayList());
                final WidgetChatListModel6 widgetChatListModel6 = WidgetChatListModel6.INSTANCE;
                if (widgetChatListModel6 != null) {
                    obj = widgetChatListModel6;
                    obj = new Func2() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$sam$rx_functions_Func2$0
                        @Override // rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj3, Object obj4) {
                            return widgetChatListModel6.invoke(obj3, obj4);
                        }
                    };
                }
                obj = widgetChatListModel6;
                observableJ = Observable.j(scalarSynchronousObservable, scalarSynchronousObservable2, (Func2) obj);
            }
            Observable<WidgetChatListModel> observableE = Observable.e(observableObserveNames, observableObserveMeId, observableObserveComputed, observableObserveGuild, observableObserveDraftState, observableObservePermissionsForChannel, observableJ, new Func7<Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, StoreThreadDraft.ThreadDraftState, Long, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>>, WidgetChatListModel>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$3
                @Override // rx.functions.Func7
                public /* bridge */ /* synthetic */ WidgetChatListModel call(Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>> tuples2) {
                    return call2((Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, threadDraftState, l2, (Tuples2<Message, ? extends List<? extends ChatListEntry>>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetChatListModel call2(Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<Message, ? extends List<? extends ChatListEntry>> tuples2) {
                    List<Long> roles;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new SpacerEntry(parentChannel.getId()));
                    if (threadDraftState.isSending()) {
                        arrayList.add(new LoadingEntry());
                    }
                    arrayList.addAll(tuples2.getSecond());
                    Channel channel = parentChannel;
                    Long l3 = parentMessageId;
                    long guildId2 = channel.getGuildId();
                    Integer defaultAutoArchiveDuration = parentChannel.getDefaultAutoArchiveDuration();
                    Intrinsics3.checkNotNullExpressionValue(threadDraftState, "threadDraft");
                    ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                    arrayList.add(new ThreadDraftFormEntry(channel, l3, guildId2, guild, defaultAutoArchiveDuration, threadDraftState, ThreadUtils.canCreatePrivateThread$default(threadUtils, l2, parentChannel, guild, false, 8, null), threadUtils.canCreatePrivateThread(l2, parentChannel, guild, false), threadUtils.canCreatePublicThread(l2, parentChannel, tuples2.getFirst(), guild)));
                    GuildMember guildMember = map2.get(l);
                    Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
                    Intrinsics3.checkNotNullExpressionValue(l, "myId");
                    long j = guildId;
                    Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
                    return new WidgetChatListModel(l.longValue(), -3L, guild, j, map, 0L, arrayList, setEmptySet, 0L, 0L, false, 800, null);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n          .co…            )\n          }");
            return observableE;
        }

        private final Observable<StoreMessagesLoader.ChannelLoadedState> observeIsLoadingMessages(StoreMessagesLoader storeMessagesLoader, long j) {
            return storeMessagesLoader.getMessagesLoadedState(j).r();
        }

        private final boolean shouldShowStickerGreet(StoreMessagesLoader.ChannelLoadedState loadingState, WidgetChatListModelMessages messages, Channel channel, Map<Long, Integer> relationships) {
            if (loadingState.isOldestMessagesLoaded() && loadingState.isInitialMessagesLoaded() && loadingState.getNewestSentByUserMessageId() == null && messages.getNewestSentByUserMessageId() == null && messages.getItems().size() < 25 && ChannelUtils.m(channel) && !ChannelUtils.E(channel)) {
                User userA = ChannelUtils.a(channel);
                Integer num = relationships.get(userA != null ? Long.valueOf(userA.getId()) : null);
                if (num == null || num.intValue() != 2) {
                    return true;
                }
            }
            return false;
        }

        public final Observable<WidgetChatListModel> get() {
            Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(new Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends WidgetChatListModel>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$get$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChatListModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                        StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
                        return ChannelUtils.o(channel.getChannel()) ? new ScalarSynchronousObservable(null) : WidgetChatListModel.INSTANCE.getChannel(channel.getChannel());
                    }
                    if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                        return new ScalarSynchronousObservable(null);
                    }
                    StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
                    return WidgetChatListModel.INSTANCE.getThreadDraft(threadDraft.getParentChannel(), threadDraft.getStarterMessageId());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModel(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<? extends ChatListEntry> list, Set<Long> set, long j5, long j6, boolean z2) {
        Intrinsics3.checkNotNullParameter(map, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(set, "myRoleIds");
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
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
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
        return getUserId() == widgetChatListModel.getUserId() && getChannelId() == widgetChatListModel.getChannelId() && Intrinsics3.areEqual(getGuild(), widgetChatListModel.getGuild()) && getGuildId() == widgetChatListModel.getGuildId() && Intrinsics3.areEqual(getChannelNames(), widgetChatListModel.getChannelNames()) && getOldestMessageId() == widgetChatListModel.getOldestMessageId() && Intrinsics3.areEqual(getList(), widgetChatListModel.getList()) && Intrinsics3.areEqual(getMyRoleIds(), widgetChatListModel.getMyRoleIds()) && getNewMessagesMarkerMessageId() == widgetChatListModel.getNewMessagesMarkerMessageId() && this.newestKnownMessageId == widgetChatListModel.newestKnownMessageId && this.isLoadingMessages == widgetChatListModel.isLoadingMessages;
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
        int iA = (b.a(getChannelId()) + (b.a(getUserId()) * 31)) * 31;
        Guild guild = getGuild();
        int iA2 = (b.a(getGuildId()) + ((iA + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iA3 = (b.a(getOldestMessageId()) + ((iA2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode = (iA3 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iA4 = (b.a(this.newestKnownMessageId) + ((b.a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z2 = this.isLoadingMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iA4 + r0;
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
        StringBuilder sbU = outline.U("WidgetChatListModel(userId=");
        sbU.append(getUserId());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", oldestMessageId=");
        sbU.append(getOldestMessageId());
        sbU.append(", list=");
        sbU.append(getList());
        sbU.append(", myRoleIds=");
        sbU.append(getMyRoleIds());
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(getNewMessagesMarkerMessageId());
        sbU.append(", newestKnownMessageId=");
        sbU.append(this.newestKnownMessageId);
        sbU.append(", isLoadingMessages=");
        return outline.O(sbU, this.isLoadingMessages, ")");
    }

    public /* synthetic */ WidgetChatListModel(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, guild, j3, map, (i & 32) != 0 ? 0L : j4, list, set, (i & 256) != 0 ? 0L : j5, (i & 512) != 0 ? 0L : j6, z2);
    }
}
