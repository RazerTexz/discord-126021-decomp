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
import com.discord.models.application.Unread;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.botuikit.ComponentChatListState;
import com.discord.widgets.chat.list.ViewThreadsFeatureFlag;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.entries.ReactionsEntry;
import com.discord.widgets.chat.list.entries.ThreadStarterDividerEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func3;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelMessages {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CONCAT_COUNT = 5;
    private static final long MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD = 420000;
    private final Map<Long, GuildMember> guildMembers;
    private final List<ChatListEntry> items;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final Long newestSentByUserMessageId;
    private final long oldestMessageId;

    /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int addBlockedMessage(Items items, Message message, int blockedContiguousMessageCount, boolean blockedChunkExpanded) {
            if (blockedContiguousMessageCount <= 0) {
                return blockedContiguousMessageCount;
            }
            C12238m.checkNotNull(message);
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

        public static /* synthetic */ List getMessageItems$default(Companion companion, Channel channel, Map map, Map map2, Map map3, Channel channel2, StoreThreadMessages.ThreadState threadState, Message message, StoreMessageState.State state, Map map4, boolean z2, boolean z3, Long l, boolean z4, boolean z5, boolean z6, long j, boolean z7, Map map5, InviteEmbedModel inviteEmbedModel, boolean z8, boolean z9, int i, Object obj) {
            return companion.getMessageItems(channel, map, map2, map3, channel2, threadState, message, state, map4, z2, z3, l, z4, z5, z6, j, z7, map5, inviteEmbedModel, (i & 524288) != 0 ? false : z8, (i & 1048576) != 0 ? false : z9);
        }

        private final Pair<Message, Channel> getThreadStarterMessageAndChannel(Channel parentChannel, Channel channel, Message message, MessagesWithMetadata messagesWithMetadata) {
            Message messageCreateThreadStarterMessageNotFoundMessage;
            Map<Long, StoreMessageReplies.MessageState> parentChannelMessageReplyState = messagesWithMetadata.getParentChannelMessageReplyState();
            MessageReference messageReference = message.getMessageReference();
            StoreMessageReplies.MessageState messageState = parentChannelMessageReplyState.get(messageReference != null ? messageReference.getMessageId() : null);
            if (parentChannel == null || !(messageState instanceof StoreMessageReplies.MessageState.Loaded)) {
                long id2 = channel.getId();
                User author = message.getAuthor();
                C12238m.checkNotNull(author);
                messageCreateThreadStarterMessageNotFoundMessage = LocalMessageCreatorsKt.createThreadStarterMessageNotFoundMessage(id2, author, ClockFactory.get());
                parentChannel = channel;
            } else {
                messageCreateThreadStarterMessageNotFoundMessage = ((StoreMessageReplies.MessageState.Loaded) messageState).getMessage();
            }
            return new Pair<>(messageCreateThreadStarterMessageNotFoundMessage, parentChannel);
        }

        private final Observable<Long> observePermissionsForChannel(StorePermissions storePermissions, Channel channel) {
            if (ChannelUtils.m7670E(channel)) {
                C12721k c12721k = new C12721k(null);
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(null)");
                return c12721k;
            }
            if (ChannelUtils.m7667B(channel)) {
                C12721k c12721k2 = new C12721k(null);
                C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(null)");
                return c12721k2;
            }
            Observable<Long> observableM11112r = storePermissions.observePermissionsForChannel(channel.getId()).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "observePermissionsForCha…  .distinctUntilChanged()");
            return observableM11112r;
        }

        private final Observable<Long> observeUnreadMarkerMessageId(StoreReadStates storeReadStates, long j) {
            Observable<R> observableM11083G = storeReadStates.getUnreadMarker(j).m11083G(new InterfaceC12589b<Unread, Long>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Long call(Unread unread) {
                    Long messageId = unread.getMarker().getMessageId();
                    return Long.valueOf(messageId != null ? messageId.longValue() : 0L);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "getUnreadMarker(channelI… marker.messageId ?: 0L }");
            return ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        }

        private final MessageEntry.CtaData parseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Integer type = message.getType();
            if (type != null && type.intValue() == 7) {
                return parseWelcomeData(message, meUserId, guildMembers, channel, permissionsForChannel);
            }
            if (type != null && type.intValue() == 25) {
                return parseRoleSubscriptionPurchaseCtaData(message, meUserId, guildMembers, channel, permissionsForChannel);
            }
            return null;
        }

        private final MessageEntry.CtaData parseRoleSubscriptionPurchaseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Guild guild;
            Boolean bot;
            Integer type = message.getType();
            if (type == null || type.intValue() != 25 || (guild = StoreStream.INSTANCE.getGuilds().getGuild(channel.getGuildId())) == null) {
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
            return new MessageEntry.CtaData(MessageUtils.INSTANCE.getRoleSubscriptionPurchaseSticker(meUserId, message.getId()), channel);
        }

        private final MessageEntry.CtaData parseWelcomeData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Guild guild;
            Boolean bot;
            Integer type = message.getType();
            if (type == null || type.intValue() != 7 || (guild = StoreStream.INSTANCE.getGuilds().getGuild(channel.getGuildId())) == null) {
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
            return new MessageEntry.CtaData(MessageUtils.INSTANCE.getWelcomeSticker(meUserId, message.getId()), channel);
        }

        private final boolean shouldConcatMessage(Items items, Message message, Message previousMessage) {
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
            if (!C12238m.areEqual(lValueOf, author2 != null ? Long.valueOf(author2.getId()) : null)) {
                return false;
            }
            UtcDateTime timestamp = message.getTimestamp();
            long dateTimeMillis = timestamp != null ? timestamp.getDateTimeMillis() : 0L;
            UtcDateTime timestamp2 = previousMessage.getTimestamp();
            if (dateTimeMillis - (timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L) >= WidgetChatListModelMessages.MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD || previousMessage.hasAttachments() || previousMessage.hasEmbeds()) {
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
                if (!C12238m.areEqual(username, author4 != null ? author4.getUsername() : null)) {
                    return false;
                }
            }
            return true;
        }

        private final boolean tryAddNewMessagesSeparator(Items items, long newMessagesMarkerMessageId, boolean messageMostRecent, long messageId, Channel channel) {
            boolean z2 = !messageMostRecent && ((newMessagesMarkerMessageId > 0L ? 1 : (newMessagesMarkerMessageId == 0L ? 0 : -1)) > 0) && MessageUtils.compareMessages(Long.valueOf(messageId), Long.valueOf(newMessagesMarkerMessageId)) == 0;
            if (z2) {
                items.addItem(new NewMessagesEntry(channel.getId(), messageId));
            }
            return z2;
        }

        private final long tryAddTimestamp(Items items, long messageId, long timestamp, long nextDayTimestamp) {
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
            C12238m.checkNotNullParameter(channel, "channel");
            Observable<MessagesWithMetadata> observable = MessagesWithMetadata.INSTANCE.get(channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(channel.getParentId());
            Observable<Map<Long, Integer>> observableObserveForType = companion.getUserRelationships().observeForType(2);
            Observable<List<Long>> observableObserveExpandedBlockedMessageIds = companion.getChat().observeExpandedBlockedMessageIds();
            Observable<Map<Long, GuildMember>> observableObserveGuildMembers = companion.getGuilds().observeGuildMembers(channel.getGuildId());
            C12238m.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
            Observable<Long> observableObserveUnreadMarkerMessageId = observeUnreadMarkerMessageId(companion.getReadStates(), channel.getId());
            C12238m.checkNotNullExpressionValue(observableObserveUnreadMarkerMessageId, "StoreStream\n            …rkerMessageId(channel.id)");
            return ObservableCombineLatestOverloadsKt.combineLatest(observable, observableObserveChannel, observableObserveForType, observableObserveExpandedBlockedMessageIds, observableObserveGuildMembers, observableObserveUnreadMarkerMessageId, companion.getGuilds().observeRoles(channel.getGuildId()), observePermissionsForChannel(companion.getPermissions(), channel), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), companion.getUserSettings().observeIsRenderEmbedsEnabled(), companion.getUsers().observeMeId(), ComponentChatListState.INSTANCE.observeChatListComponentState(), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages$Companion$get$1(channel));
        }

        /* JADX WARN: Code duplicated, block: B:78:0x01f6  */
        public final List<ChatListEntry> getMessageItems(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, Integer> blockedRelationships, Channel thread, StoreThreadMessages.ThreadState threadEmbedMetadata, Message message, StoreMessageState.State messageState, Map<Long, ? extends StoreMessageReplies.MessageState> repliedMessages, boolean blockedChunkExpanded, boolean shouldConcat, Long permissionsForChannel, boolean animateEmojis, boolean autoPlayGifs, boolean renderEmbeds, long meUserId, boolean showBotComponents, Map<Long, ComponentChatListState.ComponentStoreState> componentStoreState, InviteEmbedModel inviteEmbedModel, boolean isThreadStarterMessage, boolean showRoleSubscriptionPurchaseSystemMessage) {
            MessageEntry.ReplyData replyData;
            boolean z2;
            User user;
            User user2;
            MessageEntry messageEntry;
            StoreMessageReplies.MessageState messageState2;
            boolean zContainsKey;
            Long lValueOf;
            Integer type;
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(guildMembers, "guildMembers");
            C12238m.checkNotNullParameter(guildRoles, "guildRoles");
            C12238m.checkNotNullParameter(blockedRelationships, "blockedRelationships");
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(repliedMessages, "repliedMessages");
            C12238m.checkNotNullParameter(componentStoreState, "componentStoreState");
            C12238m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            Integer type2 = message.getType();
            if (type2 != null && type2.intValue() == 38 && !PermissionUtils.can(1L, permissionsForChannel)) {
                return C12147n.emptyList();
            }
            if (!showRoleSubscriptionPurchaseSystemMessage && (type = message.getType()) != null && type.intValue() == 25) {
                return C12147n.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            MessageReference messageReference = message.getMessageReference();
            StoreMessageReplies.MessageState messageState3 = repliedMessages.get(messageReference != null ? messageReference.getMessageId() : null);
            if (messageState3 != null) {
                boolean z3 = messageState3 instanceof StoreMessageReplies.MessageState.Loaded;
                if (z3) {
                    Object objFirstOrNull = C12163u.firstOrNull((List<? extends Object>) getMessageItems$default(this, channel, guildMembers, guildRoles, blockedRelationships, thread, threadEmbedMetadata, ((StoreMessageReplies.MessageState.Loaded) messageState3).getMessage(), messageState, repliedMessages, blockedChunkExpanded, false, null, false, autoPlayGifs, renderEmbeds, meUserId, showBotComponents, componentStoreState, inviteEmbedModel, false, showRoleSubscriptionPurchaseSystemMessage, 524288, null));
                    if (!(objFirstOrNull instanceof MessageEntry)) {
                        objFirstOrNull = null;
                    }
                    messageEntry = (MessageEntry) objFirstOrNull;
                } else {
                    messageEntry = null;
                }
                if (z3) {
                    User author = ((StoreMessageReplies.MessageState.Loaded) messageState2).getMessage().getAuthor();
                    if (author != null) {
                        messageState2 = messageState3;
                        lValueOf = Long.valueOf(author.getId());
                    } else {
                        messageState2 = messageState3;
                        lValueOf = null;
                    }
                    zContainsKey = blockedRelationships.containsKey(lValueOf);
                } else {
                    messageState2 = messageState3;
                    zContainsKey = false;
                }
                new MessageEntry.ReplyData(messageState2, messageEntry, zContainsKey);
                replyData = r13;
            } else {
                arrayList = arrayList;
                replyData = null;
            }
            User author2 = message.getAuthor();
            GuildMember guildMember = guildMembers.get(author2 != null ? Long.valueOf(author2.getId()) : null);
            List<User> mentions = message.getMentions();
            GuildMember guildMember2 = guildMembers.get((mentions == null || (user2 = (User) C12163u.firstOrNull((List) mentions)) == null) ? null : Long.valueOf(user2.getId()));
            Map<Long, GuildRole> map = RoleUtils.containsRoleMentions(message.getContent()) ? guildRoles : null;
            Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, guildMembers, channel.m7650q());
            Interaction interaction = message.getInteraction();
            GuildMember guildMember3 = guildMembers.get((interaction == null || (user = interaction.getUser()) == null) ? null : Long.valueOf(user.getId()));
            MessageEntry.CtaData ctaData = parseCtaData(message, meUserId, guildMembers, channel, permissionsForChannel);
            boolean z4 = ChannelUtils.m7694r(channel, (1 & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null) && channel.getId() == message.getId() && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null);
            if (ChannelUtils.m7694r(channel, (1 & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null)) {
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
            list.add(new MessageEntry(message, messageState, guildMember, guildMember2, map, nickOrUsernames, shouldConcat, blockedChunkExpanded, animateEmojis, replyData, guildMember3, isThreadStarterMessage, z4, z2, ctaData, permissionsForChannel));
            int size = list.size();
            ChatListEntry.Companion companion = ChatListEntry.INSTANCE;
            User author4 = message.getAuthor();
            list.addAll(companion.createEmbedEntries(message, messageState, blockedChunkExpanded, animateEmojis, autoPlayGifs, renderEmbeds, isThreadStarterMessage, channel, guildMembers.get(author4 != null ? Long.valueOf(author4.getId()) : null), RoleUtils.containsRoleMentions(message.getContent()) ? guildRoles : null, MessageUtils.getNickOrUsernames(message, channel, guildMembers, channel.m7650q())));
            list.addAll(companion.createStickerEntries(message));
            list.addAll(companion.createGameInviteEntries(message));
            list.addAll(companion.createSpotifyListenTogetherEntries(message));
            list.addAll(companion.createInviteEntries(message, inviteEmbedModel));
            list.addAll(companion.createGuildTemplateEntries(message));
            list.addAll(companion.createGiftEntries(message));
            if (isThreadStarterMessage) {
                list.add(new ThreadStarterDividerEntry(channel.getId(), message.getId()));
                return list;
            }
            if (showBotComponents) {
                list.addAll(companion.createBotComponentEntries(message, channel.getGuildId(), componentStoreState.get(Long.valueOf(message.getId())), animateEmojis));
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
            if (ViewThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled() && message.hasThread() && thread != null) {
                enableThreadSpine(list, size);
                list.addAll(companion.createThreadEmbedEntries(channel, guildMembers, message, thread, threadEmbedMetadata, guildRoles, animateEmojis, renderEmbeds));
            }
            if (message.isEphemeralMessage() || (message.isInteraction() && message.isFailed())) {
                list.add(new EphemeralMessageEntry(message));
            }
            return list;
        }

        public final Observable<List<ChatListEntry>> getSingleMessage(Channel channel, long messageId) {
            C12238m.checkNotNullParameter(channel, "channel");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Message> observableObserveMessagesForChannel = companion.getMessages().observeMessagesForChannel(channel.getId(), messageId);
            Observable<MessagesWithMetadata> observable = MessagesWithMetadata.INSTANCE.get(channel);
            Observable<Map<Long, GuildMember>> observableObserveGuildMembers = companion.getGuilds().observeGuildMembers(channel.getGuildId());
            C12238m.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
            return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMessagesForChannel, observable, observableObserveGuildMembers, companion.getGuilds().observeRoles(channel.getGuildId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), companion.getUsers().observeMeId(), companion.getUserSettings().observeIsRenderEmbedsEnabled(), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages$Companion$getSingleMessage$1(channel, messageId));
        }

        public final List<ChatListEntry> getThreadStarterMessageItems(Channel parentChannel, Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, Integer> blockedRelationships, Message message, MessagesWithMetadata messagesWithMetadata, boolean animateEmojis, boolean autoPlayGifs, boolean renderEmbeds, long meUserId, boolean showBotComponents, Map<Long, ComponentChatListState.ComponentStoreState> componentStoreState, InviteEmbedModel inviteEmbedModel) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(guildMembers, "guildMembers");
            C12238m.checkNotNullParameter(guildRoles, "guildRoles");
            C12238m.checkNotNullParameter(blockedRelationships, "blockedRelationships");
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            C12238m.checkNotNullParameter(componentStoreState, "componentStoreState");
            C12238m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            Pair<Message, Channel> threadStarterMessageAndChannel = getThreadStarterMessageAndChannel(parentChannel, channel, message, messagesWithMetadata);
            Message first = threadStarterMessageAndChannel.getFirst();
            return getMessageItems$default(this, threadStarterMessageAndChannel.getSecond(), guildMembers, guildRoles, blockedRelationships, null, null, first, messagesWithMetadata.getMessageState().get(Long.valueOf(first.getId())), messagesWithMetadata.getParentChannelMessageReplyState(), false, false, null, animateEmojis, autoPlayGifs, renderEmbeds, meUserId, showBotComponents, componentStoreState, inviteEmbedModel, true, false, 1048576, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
    public static final class Items {
        private static final Companion Companion = new Companion(null);

        @Deprecated
        private static final int LIST_CAPACITY_BUFFER = 10;
        private int concatCount;
        private List<ChatListEntry> items;
        private MGRecyclerDataPayload listItemMostRecentlyAdded;

        /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Items(int i) {
            this.items = new ArrayList(i + 10);
        }

        public final void addItem(ChatListEntry item) {
            C12238m.checkNotNullParameter(item, "item");
            this.items.add(item);
            this.listItemMostRecentlyAdded = item;
        }

        public final void addItems(List<? extends ChatListEntry> itemList) {
            C12238m.checkNotNullParameter(itemList, "itemList");
            if (itemList.isEmpty()) {
                return;
            }
            this.items.addAll(itemList);
            this.listItemMostRecentlyAdded = itemList.get(itemList.size() - 1);
        }

        public final int getConcatCount() {
            return this.concatCount;
        }

        public final List<ChatListEntry> getItems() {
            return this.items;
        }

        public final MGRecyclerDataPayload getListItemMostRecentlyAdded() {
            return this.listItemMostRecentlyAdded;
        }

        public final void setConcatCount(int i) {
            this.concatCount = i;
        }

        public final void setItems(List<ChatListEntry> list) {
            C12238m.checkNotNullParameter(list, "<set-?>");
            this.items = list;
        }

        public final void setListItemMostRecentlyAdded(MGRecyclerDataPayload mGRecyclerDataPayload) {
            this.listItemMostRecentlyAdded = mGRecyclerDataPayload;
        }
    }

    /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
    public static final /* data */ class MessagesWithMetadata {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, StoreMessageReplies.MessageState> messageReplyState;
        private final Map<Long, StoreMessageState.State> messageState;
        private final Map<Long, Channel> messageThreads;
        private final List<Message> messages;
        private final Map<Long, StoreMessageReplies.MessageState> parentChannelMessageReplyState;
        private final Map<Long, StoreThreadMessages.ThreadState> threadCountsAndLatestMessages;

        /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<MessagesWithMetadata> get(final List<Message> messages) {
                C12238m.checkNotNullParameter(messages, "messages");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<MessagesWithMetadata> observableM11075i = Observable.m11075i(companion.getMessageState().getMessageState(), companion.getChannels().observeThreadsFromMessages(messages), companion.getThreadMessages().observeThreadCountAndLatestMessage(), new Func3<Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, MessagesWithMetadata>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1
                    @Override // p658rx.functions.Func3
                    public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata call(Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3) {
                        return call2((Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetChatListModelMessages.MessagesWithMetadata call2(Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3) {
                        List list = messages;
                        C12238m.checkNotNullExpressionValue(map, "messageState");
                        C12238m.checkNotNullExpressionValue(map2, "messageThreads");
                        C12238m.checkNotNullExpressionValue(map3, "threadCountsAndLatestMessages");
                        return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, C12136h0.emptyMap(), C12136h0.emptyMap());
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11075i, "Observable\n            .…          )\n            }");
                return observableM11075i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Observable<MessagesWithMetadata> get(final Channel channel) {
                C12238m.checkNotNullParameter(channel, "channel");
                Observable observableM11099Y = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(channel.getId()).m11099Y(new InterfaceC12589b<List<? extends Message>, Observable<? extends MessagesWithMetadata>>() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2

                    /* JADX INFO: renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 */
                    /* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
                    public static final /* synthetic */ class C81611 extends C12236k implements Function6<List<? extends Message>, Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends StoreMessageReplies.MessageState>, Map<Long, ? extends StoreMessageReplies.MessageState>, WidgetChatListModelMessages.MessagesWithMetadata> {
                        public static final C81611 INSTANCE = new C81611();

                        public C81611() {
                            super(6, WidgetChatListModelMessages.MessagesWithMetadata.class, "<init>", "<init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
                        }

                        @Override // kotlin.jvm.functions.Function6
                        public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata invoke(List<? extends Message> list, Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
                            return invoke2((List<Message>) list, (Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3, map4, map5);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final WidgetChatListModelMessages.MessagesWithMetadata invoke2(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
                            C12238m.checkNotNullParameter(list, "p1");
                            C12238m.checkNotNullParameter(map, "p2");
                            C12238m.checkNotNullParameter(map2, "p3");
                            C12238m.checkNotNullParameter(map3, "p4");
                            C12238m.checkNotNullParameter(map4, "p5");
                            C12238m.checkNotNullParameter(map5, "p6");
                            return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, map4, map5);
                        }
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call2(List<Message> list) {
                        C12721k c12721k = new C12721k(list);
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        Observable<Map<Long, StoreMessageState.State>> messageState = companion.getMessageState().getMessageState();
                        StoreChannels channels = companion.getChannels();
                        C12238m.checkNotNullExpressionValue(list, "messages");
                        Observable<Map<Long, Channel>> observableObserveThreadsFromMessages = channels.observeThreadsFromMessages(list);
                        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = companion.getThreadMessages().observeThreadCountAndLatestMessage();
                        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel = companion.getRepliedMessages().observeMessageReferencesForChannel(channel.getId());
                        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel2 = companion.getRepliedMessages().observeMessageReferencesForChannel(channel.getParentId());
                        final C81611 c81611 = C81611.INSTANCE;
                        Object obj = c81611;
                        if (c81611 != null) {
                            obj = new Func6() { // from class: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$sam$rx_functions_Func6$0
                                @Override // p658rx.functions.Func6
                                public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                                    return c81611.invoke(obj2, obj3, obj4, obj5, obj6, obj7);
                                }
                            };
                        }
                        return Observable.m11071f(c12721k, messageState, observableObserveThreadsFromMessages, observableObserveThreadCountAndLatestMessage, observableObserveMessageReferencesForChannel, observableObserveMessageReferencesForChannel2, (Func6) obj);
                    }

                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call(List<? extends Message> list) {
                        return call2((List<Message>) list);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        )\n              }");
                return observableM11099Y;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MessagesWithMetadata(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            C12238m.checkNotNullParameter(list, "messages");
            C12238m.checkNotNullParameter(map, "messageState");
            C12238m.checkNotNullParameter(map2, "messageThreads");
            C12238m.checkNotNullParameter(map3, "threadCountsAndLatestMessages");
            C12238m.checkNotNullParameter(map4, "messageReplyState");
            C12238m.checkNotNullParameter(map5, "parentChannelMessageReplyState");
            this.messages = list;
            this.messageState = map;
            this.messageThreads = map2;
            this.threadCountsAndLatestMessages = map3;
            this.messageReplyState = map4;
            this.parentChannelMessageReplyState = map5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MessagesWithMetadata copy$default(MessagesWithMetadata messagesWithMetadata, List list, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
            if ((i & 1) != 0) {
                list = messagesWithMetadata.messages;
            }
            if ((i & 2) != 0) {
                map = messagesWithMetadata.messageState;
            }
            Map map6 = map;
            if ((i & 4) != 0) {
                map2 = messagesWithMetadata.messageThreads;
            }
            Map map7 = map2;
            if ((i & 8) != 0) {
                map3 = messagesWithMetadata.threadCountsAndLatestMessages;
            }
            Map map8 = map3;
            if ((i & 16) != 0) {
                map4 = messagesWithMetadata.messageReplyState;
            }
            Map map9 = map4;
            if ((i & 32) != 0) {
                map5 = messagesWithMetadata.parentChannelMessageReplyState;
            }
            return messagesWithMetadata.copy(list, map6, map7, map8, map9, map5);
        }

        public final List<Message> component1() {
            return this.messages;
        }

        public final Map<Long, StoreMessageState.State> component2() {
            return this.messageState;
        }

        public final Map<Long, Channel> component3() {
            return this.messageThreads;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> component4() {
            return this.threadCountsAndLatestMessages;
        }

        public final Map<Long, StoreMessageReplies.MessageState> component5() {
            return this.messageReplyState;
        }

        public final Map<Long, StoreMessageReplies.MessageState> component6() {
            return this.parentChannelMessageReplyState;
        }

        public final MessagesWithMetadata copy(List<Message> messages, Map<Long, StoreMessageState.State> messageState, Map<Long, Channel> messageThreads, Map<Long, StoreThreadMessages.ThreadState> threadCountsAndLatestMessages, Map<Long, ? extends StoreMessageReplies.MessageState> messageReplyState, Map<Long, ? extends StoreMessageReplies.MessageState> parentChannelMessageReplyState) {
            C12238m.checkNotNullParameter(messages, "messages");
            C12238m.checkNotNullParameter(messageState, "messageState");
            C12238m.checkNotNullParameter(messageThreads, "messageThreads");
            C12238m.checkNotNullParameter(threadCountsAndLatestMessages, "threadCountsAndLatestMessages");
            C12238m.checkNotNullParameter(messageReplyState, "messageReplyState");
            C12238m.checkNotNullParameter(parentChannelMessageReplyState, "parentChannelMessageReplyState");
            return new MessagesWithMetadata(messages, messageState, messageThreads, threadCountsAndLatestMessages, messageReplyState, parentChannelMessageReplyState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessagesWithMetadata)) {
                return false;
            }
            MessagesWithMetadata messagesWithMetadata = (MessagesWithMetadata) other;
            return C12238m.areEqual(this.messages, messagesWithMetadata.messages) && C12238m.areEqual(this.messageState, messagesWithMetadata.messageState) && C12238m.areEqual(this.messageThreads, messagesWithMetadata.messageThreads) && C12238m.areEqual(this.threadCountsAndLatestMessages, messagesWithMetadata.threadCountsAndLatestMessages) && C12238m.areEqual(this.messageReplyState, messagesWithMetadata.messageReplyState) && C12238m.areEqual(this.parentChannelMessageReplyState, messagesWithMetadata.parentChannelMessageReplyState);
        }

        public final Map<Long, StoreMessageReplies.MessageState> getMessageReplyState() {
            return this.messageReplyState;
        }

        public final Map<Long, StoreMessageState.State> getMessageState() {
            return this.messageState;
        }

        public final Map<Long, Channel> getMessageThreads() {
            return this.messageThreads;
        }

        public final List<Message> getMessages() {
            return this.messages;
        }

        public final Map<Long, StoreMessageReplies.MessageState> getParentChannelMessageReplyState() {
            return this.parentChannelMessageReplyState;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> getThreadCountsAndLatestMessages() {
            return this.threadCountsAndLatestMessages;
        }

        public int hashCode() {
            List<Message> list = this.messages;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, StoreMessageState.State> map = this.messageState;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Channel> map2 = this.messageThreads;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, StoreThreadMessages.ThreadState> map3 = this.threadCountsAndLatestMessages;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, StoreMessageReplies.MessageState> map4 = this.messageReplyState;
            int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, StoreMessageReplies.MessageState> map5 = this.parentChannelMessageReplyState;
            return iHashCode5 + (map5 != null ? map5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("MessagesWithMetadata(messages=");
            sbM833U.append(this.messages);
            sbM833U.append(", messageState=");
            sbM833U.append(this.messageState);
            sbM833U.append(", messageThreads=");
            sbM833U.append(this.messageThreads);
            sbM833U.append(", threadCountsAndLatestMessages=");
            sbM833U.append(this.threadCountsAndLatestMessages);
            sbM833U.append(", messageReplyState=");
            sbM833U.append(this.messageReplyState);
            sbM833U.append(", parentChannelMessageReplyState=");
            return C1643a.m825M(sbM833U, this.parentChannelMessageReplyState, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModelMessages(List<? extends ChatListEntry> list, long j, long j2, Map<Long, GuildMember> map, long j3, Long l) {
        C12238m.checkNotNullParameter(list, "items");
        this.items = list;
        this.oldestMessageId = j;
        this.newestKnownMessageId = j2;
        this.guildMembers = map;
        this.newMessagesMarkerMessageId = j3;
        this.newestSentByUserMessageId = l;
    }

    public final List<ChatListEntry> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Map<Long, GuildMember> component4() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final WidgetChatListModelMessages copy(List<? extends ChatListEntry> items, long oldestMessageId, long newestKnownMessageId, Map<Long, GuildMember> guildMembers, long newMessagesMarkerMessageId, Long newestSentByUserMessageId) {
        C12238m.checkNotNullParameter(items, "items");
        return new WidgetChatListModelMessages(items, oldestMessageId, newestKnownMessageId, guildMembers, newMessagesMarkerMessageId, newestSentByUserMessageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModelMessages)) {
            return false;
        }
        WidgetChatListModelMessages widgetChatListModelMessages = (WidgetChatListModelMessages) other;
        return C12238m.areEqual(this.items, widgetChatListModelMessages.items) && this.oldestMessageId == widgetChatListModelMessages.oldestMessageId && this.newestKnownMessageId == widgetChatListModelMessages.newestKnownMessageId && C12238m.areEqual(this.guildMembers, widgetChatListModelMessages.guildMembers) && this.newMessagesMarkerMessageId == widgetChatListModelMessages.newMessagesMarkerMessageId && C12238m.areEqual(this.newestSentByUserMessageId, widgetChatListModelMessages.newestSentByUserMessageId);
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final List<ChatListEntry> getItems() {
        return this.items;
    }

    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    public int hashCode() {
        List<ChatListEntry> list = this.items;
        int iM3a = (C0002b.m3a(this.newestKnownMessageId) + ((C0002b.m3a(this.oldestMessageId) + ((list != null ? list.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iM3a2 = (C0002b.m3a(this.newMessagesMarkerMessageId) + ((iM3a + (map != null ? map.hashCode() : 0)) * 31)) * 31;
        Long l = this.newestSentByUserMessageId;
        return iM3a2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("WidgetChatListModelMessages(items=");
        sbM833U.append(this.items);
        sbM833U.append(", oldestMessageId=");
        sbM833U.append(this.oldestMessageId);
        sbM833U.append(", newestKnownMessageId=");
        sbM833U.append(this.newestKnownMessageId);
        sbM833U.append(", guildMembers=");
        sbM833U.append(this.guildMembers);
        sbM833U.append(", newMessagesMarkerMessageId=");
        sbM833U.append(this.newMessagesMarkerMessageId);
        sbM833U.append(", newestSentByUserMessageId=");
        return C1643a.m819G(sbM833U, this.newestSentByUserMessageId, ")");
    }
}
