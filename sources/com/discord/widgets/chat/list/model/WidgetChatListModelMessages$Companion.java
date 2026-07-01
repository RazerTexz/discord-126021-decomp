package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.MessageReference;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies$MessageState;
import com.discord.stores.StoreMessageReplies$MessageState$Loaded;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.embed.InviteEmbedModel$Companion;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.botuikit.ComponentChatListState;
import com.discord.widgets.botuikit.ComponentChatListState$ComponentStoreState;
import com.discord.widgets.chat.list.ViewThreadsFeatureFlag;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry$Companion;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.MessageEntry$CtaData;
import com.discord.widgets.chat.list.entries.MessageEntry$ReplyData;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.entries.ReactionsEntry;
import com.discord.widgets.chat.list.entries.ThreadStarterDividerEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$Companion {
    private WidgetChatListModelMessages$Companion() {
    }

    public static final /* synthetic */ int access$addBlockedMessage(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, WidgetChatListModelMessages$Items widgetChatListModelMessages$Items, Message message, int i, boolean z2) {
        return widgetChatListModelMessages$Companion.addBlockedMessage(widgetChatListModelMessages$Items, message, i, z2);
    }

    public static final /* synthetic */ Pair access$getThreadStarterMessageAndChannel(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, Channel channel, Channel channel2, Message message, WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata) {
        return widgetChatListModelMessages$Companion.getThreadStarterMessageAndChannel(channel, channel2, message, widgetChatListModelMessages$MessagesWithMetadata);
    }

    public static final /* synthetic */ boolean access$shouldConcatMessage(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, WidgetChatListModelMessages$Items widgetChatListModelMessages$Items, Message message, Message message2) {
        return widgetChatListModelMessages$Companion.shouldConcatMessage(widgetChatListModelMessages$Items, message, message2);
    }

    public static final /* synthetic */ boolean access$tryAddNewMessagesSeparator(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, WidgetChatListModelMessages$Items widgetChatListModelMessages$Items, long j, boolean z2, long j2, Channel channel) {
        return widgetChatListModelMessages$Companion.tryAddNewMessagesSeparator(widgetChatListModelMessages$Items, j, z2, j2, channel);
    }

    public static final /* synthetic */ long access$tryAddTimestamp(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, WidgetChatListModelMessages$Items widgetChatListModelMessages$Items, long j, long j2, long j3) {
        return widgetChatListModelMessages$Companion.tryAddTimestamp(widgetChatListModelMessages$Items, j, j2, j3);
    }

    public static final /* synthetic */ boolean access$willAddTimestamp(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, long j, long j2) {
        return widgetChatListModelMessages$Companion.willAddTimestamp(j, j2);
    }

    private final int addBlockedMessage(WidgetChatListModelMessages$Items items, Message message, int blockedContiguousMessageCount, boolean blockedChunkExpanded) {
        if (blockedContiguousMessageCount <= 0) {
            return blockedContiguousMessageCount;
        }
        m.checkNotNull(message);
        items.addItem(new BlockedMessagesEntry(message, blockedContiguousMessageCount, blockedChunkExpanded));
        return 0;
    }

    private final void enableThreadSpine(List<ChatListEntry> messageItems, int threadSpineStartIndex) {
        int size = messageItems.size();
        while (threadSpineStartIndex < size) {
            messageItems.get(threadSpineStartIndex).setShouldShowThreadSpine(true);
            threadSpineStartIndex++;
        }
    }

    public static /* synthetic */ List getMessageItems$default(WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion, Channel channel, Map map, Map map2, Map map3, Channel channel2, StoreThreadMessages$ThreadState storeThreadMessages$ThreadState, Message message, StoreMessageState$State storeMessageState$State, Map map4, boolean z2, boolean z3, Long l, boolean z4, boolean z5, boolean z6, long j, boolean z7, Map map5, InviteEmbedModel inviteEmbedModel, boolean z8, boolean z9, int i, Object obj) {
        return widgetChatListModelMessages$Companion.getMessageItems(channel, map, map2, map3, channel2, storeThreadMessages$ThreadState, message, storeMessageState$State, map4, z2, z3, l, z4, z5, z6, j, z7, map5, inviteEmbedModel, (i & 524288) != 0 ? false : z8, (i & 1048576) != 0 ? false : z9);
    }

    private final Pair<Message, Channel> getThreadStarterMessageAndChannel(Channel parentChannel, Channel channel, Message message, WidgetChatListModelMessages$MessagesWithMetadata messagesWithMetadata) {
        Message messageCreateThreadStarterMessageNotFoundMessage;
        Map<Long, StoreMessageReplies$MessageState> parentChannelMessageReplyState = messagesWithMetadata.getParentChannelMessageReplyState();
        MessageReference messageReference = message.getMessageReference();
        StoreMessageReplies$MessageState storeMessageReplies$MessageState = parentChannelMessageReplyState.get(messageReference != null ? messageReference.getMessageId() : null);
        if (parentChannel == null || !(storeMessageReplies$MessageState instanceof StoreMessageReplies$MessageState$Loaded)) {
            long id2 = channel.getId();
            User author = message.getAuthor();
            m.checkNotNull(author);
            messageCreateThreadStarterMessageNotFoundMessage = LocalMessageCreatorsKt.createThreadStarterMessageNotFoundMessage(id2, author, ClockFactory.get());
            parentChannel = channel;
        } else {
            messageCreateThreadStarterMessageNotFoundMessage = ((StoreMessageReplies$MessageState$Loaded) storeMessageReplies$MessageState).getMessage();
        }
        return new Pair<>(messageCreateThreadStarterMessageNotFoundMessage, parentChannel);
    }

    private final Observable<Long> observePermissionsForChannel(StorePermissions storePermissions, Channel channel) {
        if (ChannelUtils.E(channel)) {
            k kVar = new k(null);
            m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
            return kVar;
        }
        if (ChannelUtils.B(channel)) {
            k kVar2 = new k(null);
            m.checkNotNullExpressionValue(kVar2, "Observable.just(null)");
            return kVar2;
        }
        Observable<Long> observableR = storePermissions.observePermissionsForChannel(channel.getId()).r();
        m.checkNotNullExpressionValue(observableR, "observePermissionsForCha…  .distinctUntilChanged()");
        return observableR;
    }

    private final Observable<Long> observeUnreadMarkerMessageId(StoreReadStates storeReadStates, long j) {
        Observable<R> observableG = storeReadStates.getUnreadMarker(j).G(WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getUnreadMarker(channelI… marker.messageId ?: 0L }");
        return ObservableExtensionsKt.computationLatest(observableG).r();
    }

    private final MessageEntry$CtaData parseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
        Integer type = message.getType();
        if (type != null && type.intValue() == 7) {
            return parseWelcomeData(message, meUserId, guildMembers, channel, permissionsForChannel);
        }
        if (type != null && type.intValue() == 25) {
            return parseRoleSubscriptionPurchaseCtaData(message, meUserId, guildMembers, channel, permissionsForChannel);
        }
        return null;
    }

    private final MessageEntry$CtaData parseRoleSubscriptionPurchaseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
        Guild guild;
        Boolean bot;
        Integer type = message.getType();
        if (type == null || type.intValue() != 25 || (guild = StoreStream.Companion.getGuilds().getGuild(channel.getGuildId())) == null) {
            return null;
        }
        boolean zBooleanValue = false;
        if (!((guild.getSystemChannelFlags() & 32) == 0)) {
            return null;
        }
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUserId));
        if ((guildMember != null ? guildMember.getPending() : true) || !PermissionUtils.can(Permission.SEND_MESSAGES, permissionsForChannel)) {
            return null;
        }
        User author = message.getAuthor();
        if (author != null && (bot = author.getBot()) != null) {
            zBooleanValue = bot.booleanValue();
        }
        if (zBooleanValue) {
            return null;
        }
        return new MessageEntry$CtaData(MessageUtils.INSTANCE.getRoleSubscriptionPurchaseSticker(meUserId, message.getId()), channel);
    }

    private final MessageEntry$CtaData parseWelcomeData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
        Guild guild;
        Boolean bot;
        Integer type = message.getType();
        if (type == null || type.intValue() != 7 || (guild = StoreStream.Companion.getGuilds().getGuild(channel.getGuildId())) == null) {
            return null;
        }
        boolean zBooleanValue = false;
        if (!((guild.getSystemChannelFlags() & 8) == 0)) {
            return null;
        }
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUserId));
        if ((guildMember != null ? guildMember.getPending() : true) || !PermissionUtils.can(Permission.SEND_MESSAGES, permissionsForChannel)) {
            return null;
        }
        User author = message.getAuthor();
        if (author != null && (bot = author.getBot()) != null) {
            zBooleanValue = bot.booleanValue();
        }
        if (zBooleanValue) {
            return null;
        }
        return new MessageEntry$CtaData(MessageUtils.INSTANCE.getWelcomeSticker(meUserId, message.getId()), channel);
    }

    private final boolean shouldConcatMessage(WidgetChatListModelMessages$Items items, Message message, Message previousMessage) {
        Integer type;
        MGRecyclerDataPayload listItemMostRecentlyAdded;
        MGRecyclerDataPayload listItemMostRecentlyAdded2;
        MGRecyclerDataPayload listItemMostRecentlyAdded3;
        if (previousMessage == null || previousMessage.isSystemMessage() || message.hasThread() || previousMessage.hasThread()) {
            return false;
        }
        Integer type2 = message.getType();
        if ((type2 == null || type2.intValue() != 0) && ((type = message.getType()) == null || type.intValue() != -1)) {
            return false;
        }
        MGRecyclerDataPayload listItemMostRecentlyAdded4 = items.getListItemMostRecentlyAdded();
        if ((listItemMostRecentlyAdded4 == null || listItemMostRecentlyAdded4.getType() != 0) && (((listItemMostRecentlyAdded = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded.getType() != 1) && (((listItemMostRecentlyAdded2 = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded2.getType() != 21) && ((listItemMostRecentlyAdded3 = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded3.getType() != 4)))) {
            return false;
        }
        User author = previousMessage.getAuthor();
        Long lValueOf = author != null ? Long.valueOf(author.getId()) : null;
        User author2 = message.getAuthor();
        if (!m.areEqual(lValueOf, author2 != null ? Long.valueOf(author2.getId()) : null)) {
            return false;
        }
        UtcDateTime timestamp = message.getTimestamp();
        long dateTimeMillis = timestamp != null ? timestamp.getDateTimeMillis() : 0L;
        UtcDateTime timestamp2 = previousMessage.getTimestamp();
        if (dateTimeMillis - (timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L) >= 420000 || previousMessage.hasAttachments() || previousMessage.hasEmbeds()) {
            return false;
        }
        List<User> mentions = previousMessage.getMentions();
        if (!(mentions == null || mentions.isEmpty()) || message.hasAttachments() || message.hasEmbeds()) {
            return false;
        }
        List<User> mentions2 = message.getMentions();
        if (!(mentions2 == null || mentions2.isEmpty()) || items.getConcatCount() >= 5) {
            return false;
        }
        if (message.isWebhook()) {
            User author3 = previousMessage.getAuthor();
            String username = author3 != null ? author3.getUsername() : null;
            User author4 = message.getAuthor();
            if (!m.areEqual(username, author4 != null ? author4.getUsername() : null)) {
                return false;
            }
        }
        return true;
    }

    private final boolean tryAddNewMessagesSeparator(WidgetChatListModelMessages$Items items, long newMessagesMarkerMessageId, boolean messageMostRecent, long messageId, Channel channel) {
        boolean z2 = !messageMostRecent && ((newMessagesMarkerMessageId > 0L ? 1 : (newMessagesMarkerMessageId == 0L ? 0 : -1)) > 0) && MessageUtils.compareMessages(Long.valueOf(messageId), Long.valueOf(newMessagesMarkerMessageId)) == 0;
        if (z2) {
            items.addItem(new NewMessagesEntry(channel.getId(), messageId));
        }
        return z2;
    }

    private final long tryAddTimestamp(WidgetChatListModelMessages$Items items, long messageId, long timestamp, long nextDayTimestamp) {
        if (!willAddTimestamp(timestamp, nextDayTimestamp)) {
            return nextDayTimestamp;
        }
        items.addItem(new TimestampEntry(messageId, timestamp));
        Calendar calendar = TimeUtils.toCalendar(timestamp);
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    private final boolean willAddTimestamp(long timestamp, long nextDayTimestamp) {
        return timestamp > nextDayTimestamp;
    }

    public final Observable<WidgetChatListModelMessages> get(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Observable<WidgetChatListModelMessages$MessagesWithMetadata> observable = WidgetChatListModelMessages$MessagesWithMetadata.Companion.get(channel);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Channel> observableObserveChannel = storeStream$Companion.getChannels().observeChannel(channel.getParentId());
        Observable<Map<Long, Integer>> observableObserveForType = storeStream$Companion.getUserRelationships().observeForType(2);
        Observable<List<Long>> observableObserveExpandedBlockedMessageIds = storeStream$Companion.getChat().observeExpandedBlockedMessageIds();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = storeStream$Companion.getGuilds().observeGuildMembers(channel.getGuildId());
        m.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
        Observable<Long> observableObserveUnreadMarkerMessageId = observeUnreadMarkerMessageId(storeStream$Companion.getReadStates(), channel.getId());
        m.checkNotNullExpressionValue(observableObserveUnreadMarkerMessageId, "StoreStream\n            …rkerMessageId(channel.id)");
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, observableObserveChannel, observableObserveForType, observableObserveExpandedBlockedMessageIds, observableObserveGuildMembers, observableObserveUnreadMarkerMessageId, storeStream$Companion.getGuilds().observeRoles(channel.getGuildId()), observePermissionsForChannel(storeStream$Companion.getPermissions(), channel), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), storeStream$Companion.getUserSettings().observeIsRenderEmbedsEnabled(), storeStream$Companion.getUsers().observeMeId(), ComponentChatListState.INSTANCE.observeChatListComponentState(), InviteEmbedModel$Companion.observe$default(InviteEmbedModel.Companion, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages$Companion$get$1(channel));
    }

    /* JADX WARN: Code duplicated, block: B:78:0x01f6  */
    public final List<ChatListEntry> getMessageItems(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, Integer> blockedRelationships, Channel thread, StoreThreadMessages$ThreadState threadEmbedMetadata, Message message, StoreMessageState$State messageState, Map<Long, ? extends StoreMessageReplies$MessageState> repliedMessages, boolean blockedChunkExpanded, boolean shouldConcat, Long permissionsForChannel, boolean animateEmojis, boolean autoPlayGifs, boolean renderEmbeds, long meUserId, boolean showBotComponents, Map<Long, ComponentChatListState$ComponentStoreState> componentStoreState, InviteEmbedModel inviteEmbedModel, boolean isThreadStarterMessage, boolean showRoleSubscriptionPurchaseSystemMessage) {
        MessageEntry$ReplyData messageEntry$ReplyData;
        boolean z2;
        User user;
        User user2;
        MessageEntry messageEntry;
        StoreMessageReplies$MessageState storeMessageReplies$MessageState;
        boolean zContainsKey;
        Long lValueOf;
        Integer type;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(blockedRelationships, "blockedRelationships");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(repliedMessages, "repliedMessages");
        m.checkNotNullParameter(componentStoreState, "componentStoreState");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        Integer type2 = message.getType();
        if (type2 != null && type2.intValue() == 38 && !PermissionUtils.can(1L, permissionsForChannel)) {
            return n.emptyList();
        }
        if (!showRoleSubscriptionPurchaseSystemMessage && (type = message.getType()) != null && type.intValue() == 25) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        MessageReference messageReference = message.getMessageReference();
        StoreMessageReplies$MessageState storeMessageReplies$MessageState2 = repliedMessages.get(messageReference != null ? messageReference.getMessageId() : null);
        if (storeMessageReplies$MessageState2 != null) {
            boolean z3 = storeMessageReplies$MessageState2 instanceof StoreMessageReplies$MessageState$Loaded;
            if (z3) {
                Object objFirstOrNull = u.firstOrNull((List<? extends Object>) getMessageItems$default(this, channel, guildMembers, guildRoles, blockedRelationships, thread, threadEmbedMetadata, ((StoreMessageReplies$MessageState$Loaded) storeMessageReplies$MessageState2).getMessage(), messageState, repliedMessages, blockedChunkExpanded, false, null, false, autoPlayGifs, renderEmbeds, meUserId, showBotComponents, componentStoreState, inviteEmbedModel, false, showRoleSubscriptionPurchaseSystemMessage, 524288, null));
                if (!(objFirstOrNull instanceof MessageEntry)) {
                    objFirstOrNull = null;
                }
                messageEntry = (MessageEntry) objFirstOrNull;
            } else {
                messageEntry = null;
            }
            if (z3) {
                User author = ((StoreMessageReplies$MessageState$Loaded) storeMessageReplies$MessageState).getMessage().getAuthor();
                if (author != null) {
                    storeMessageReplies$MessageState = storeMessageReplies$MessageState2;
                    lValueOf = Long.valueOf(author.getId());
                } else {
                    storeMessageReplies$MessageState = storeMessageReplies$MessageState2;
                    lValueOf = null;
                }
                zContainsKey = blockedRelationships.containsKey(lValueOf);
            } else {
                storeMessageReplies$MessageState = storeMessageReplies$MessageState2;
                zContainsKey = false;
            }
            new MessageEntry$ReplyData(storeMessageReplies$MessageState, messageEntry, zContainsKey);
            messageEntry$ReplyData = r13;
        } else {
            arrayList = arrayList;
            messageEntry$ReplyData = null;
        }
        User author2 = message.getAuthor();
        GuildMember guildMember = guildMembers.get(author2 != null ? Long.valueOf(author2.getId()) : null);
        List<User> mentions = message.getMentions();
        GuildMember guildMember2 = guildMembers.get((mentions == null || (user2 = (User) u.firstOrNull((List) mentions)) == null) ? null : Long.valueOf(user2.getId()));
        Map<Long, GuildRole> map = RoleUtils.containsRoleMentions(message.getContent()) ? guildRoles : null;
        Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, guildMembers, channel.q());
        Interaction interaction = message.getInteraction();
        GuildMember guildMember3 = guildMembers.get((interaction == null || (user = interaction.getUser()) == null) ? null : Long.valueOf(user.getId()));
        MessageEntry$CtaData ctaData = parseCtaData(message, meUserId, guildMembers, channel, permissionsForChannel);
        boolean z4 = ChannelUtils.s(channel, null, 1) && channel.getId() == message.getId() && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null);
        if (ChannelUtils.s(channel, null, 1)) {
            long ownerId = channel.getOwnerId();
            User author3 = message.getAuthor();
            if (author3 != null && ownerId == author3.getId() && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        List<ChatListEntry> list = arrayList;
        list.add(new MessageEntry(message, messageState, guildMember, guildMember2, map, nickOrUsernames, shouldConcat, blockedChunkExpanded, animateEmojis, messageEntry$ReplyData, guildMember3, isThreadStarterMessage, z4, z2, ctaData, permissionsForChannel));
        int size = list.size();
        ChatListEntry$Companion chatListEntry$Companion = ChatListEntry.Companion;
        User author4 = message.getAuthor();
        list.addAll(chatListEntry$Companion.createEmbedEntries(message, messageState, blockedChunkExpanded, animateEmojis, autoPlayGifs, renderEmbeds, isThreadStarterMessage, channel, guildMembers.get(author4 != null ? Long.valueOf(author4.getId()) : null), RoleUtils.containsRoleMentions(message.getContent()) ? guildRoles : null, MessageUtils.getNickOrUsernames(message, channel, guildMembers, channel.q())));
        list.addAll(chatListEntry$Companion.createStickerEntries(message));
        list.addAll(chatListEntry$Companion.createGameInviteEntries(message));
        list.addAll(chatListEntry$Companion.createSpotifyListenTogetherEntries(message));
        list.addAll(chatListEntry$Companion.createInviteEntries(message, inviteEmbedModel));
        list.addAll(chatListEntry$Companion.createGuildTemplateEntries(message));
        list.addAll(chatListEntry$Companion.createGiftEntries(message));
        if (isThreadStarterMessage) {
            list.add(new ThreadStarterDividerEntry(channel.getId(), message.getId()));
            return list;
        }
        if (showBotComponents) {
            list.addAll(chatListEntry$Companion.createBotComponentEntries(message, channel.getGuildId(), componentStoreState.get(Long.valueOf(message.getId())), animateEmojis));
        }
        if (!message.getReactionsMap().isEmpty()) {
            ThreadMetadata threadMetadata = channel.getThreadMetadata();
            boolean z5 = threadMetadata == null || !threadMetadata.getArchived();
            list.add(new ReactionsEntry(message, z5, PermissionUtils.can(64L, permissionsForChannel) && z5, animateEmojis));
        }
        if (message.getHasLocalUploads() && !message.isFailed()) {
            String nonce = message.getNonce();
            if (nonce == null) {
                nonce = "";
            }
            list.add(new UploadProgressEntry(nonce, message.getChannelId()));
        }
        if (ViewThreadsFeatureFlag.Companion.getINSTANCE().isEnabled() && message.hasThread() && thread != null) {
            enableThreadSpine(list, size);
            list.addAll(chatListEntry$Companion.createThreadEmbedEntries(channel, guildMembers, message, thread, threadEmbedMetadata, guildRoles, animateEmojis, renderEmbeds));
        }
        if (message.isEphemeralMessage() || (message.isInteraction() && message.isFailed())) {
            list.add(new EphemeralMessageEntry(message));
        }
        return list;
    }

    public final Observable<List<ChatListEntry>> getSingleMessage(Channel channel, long messageId) {
        m.checkNotNullParameter(channel, "channel");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Message> observableObserveMessagesForChannel = storeStream$Companion.getMessages().observeMessagesForChannel(channel.getId(), messageId);
        Observable<WidgetChatListModelMessages$MessagesWithMetadata> observable = WidgetChatListModelMessages$MessagesWithMetadata.Companion.get(channel);
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = storeStream$Companion.getGuilds().observeGuildMembers(channel.getGuildId());
        m.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMessagesForChannel, observable, observableObserveGuildMembers, storeStream$Companion.getGuilds().observeRoles(channel.getGuildId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getUserSettings().observeIsRenderEmbedsEnabled(), InviteEmbedModel$Companion.observe$default(InviteEmbedModel.Companion, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages$Companion$getSingleMessage$1(channel, messageId));
    }

    public final List<ChatListEntry> getThreadStarterMessageItems(Channel parentChannel, Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, Integer> blockedRelationships, Message message, WidgetChatListModelMessages$MessagesWithMetadata messagesWithMetadata, boolean animateEmojis, boolean autoPlayGifs, boolean renderEmbeds, long meUserId, boolean showBotComponents, Map<Long, ComponentChatListState$ComponentStoreState> componentStoreState, InviteEmbedModel inviteEmbedModel) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(blockedRelationships, "blockedRelationships");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
        m.checkNotNullParameter(componentStoreState, "componentStoreState");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        Pair<Message, Channel> threadStarterMessageAndChannel = getThreadStarterMessageAndChannel(parentChannel, channel, message, messagesWithMetadata);
        Message first = threadStarterMessageAndChannel.getFirst();
        return getMessageItems$default(this, threadStarterMessageAndChannel.getSecond(), guildMembers, guildRoles, blockedRelationships, null, null, first, messagesWithMetadata.getMessageState().get(Long.valueOf(first.getId())), messagesWithMetadata.getParentChannelMessageReplyState(), false, false, null, animateEmojis, autoPlayGifs, renderEmbeds, meUserId, showBotComponents, componentStoreState, inviteEmbedModel, true, false, 1048576, null);
    }

    public /* synthetic */ WidgetChatListModelMessages$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
