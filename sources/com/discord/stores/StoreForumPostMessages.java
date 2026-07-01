package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams$GetForumPostData;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.t.o;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages extends StoreV2 {
    public static final StoreForumPostMessages$Companion Companion = new StoreForumPostMessages$Companion(null);
    public static final int MAX_REQUEST_BODY_POST_IDS = 10;
    private final Dispatcher dispatcher;
    private Map<Long, Set<Long>> forumPostFetchQueue;
    private final Map<Long, Message> forumPostFirstMessage;
    private Set<Long> forumPostFirstMessageFetchSent;
    private Map<Long, Message> forumPostFirstMessageSnapshot;
    private boolean forumPostRequestQueueProcessing;
    private final ObservationDeck observationDeck;
    private Set<Long> shouldGetForumPostFirstMessageFromGateway;
    private final StoreUser storeUser;

    public /* synthetic */ StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ boolean access$expectForumPostFirstMessageFromGateway(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.expectForumPostFirstMessageFromGateway(j);
    }

    public static final /* synthetic */ void access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages storeForumPostMessages, long j) {
        storeForumPostMessages.flushForumPostFirstMessageQueueHelper(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.dispatcher;
    }

    public static final /* synthetic */ Map access$getForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFetchQueue;
    }

    public static final /* synthetic */ Map access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFirstMessageSnapshot;
    }

    public static final /* synthetic */ boolean access$getForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostRequestQueueProcessing;
    }

    public static final /* synthetic */ boolean access$hasForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.hasForumPostFirstMessage(j);
    }

    public static final /* synthetic */ boolean access$isFetchingForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.isFetchingForumPostFirstMessage(j);
    }

    public static final /* synthetic */ void access$setForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFetchQueue = map;
    }

    public static final /* synthetic */ void access$setForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFirstMessageSnapshot = map;
    }

    public static final /* synthetic */ void access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages, boolean z2) {
        storeForumPostMessages.forumPostRequestQueueProcessing = z2;
    }

    @StoreThread
    private final boolean expectForumPostFirstMessageFromGateway(long postId) {
        return this.shouldGetForumPostFirstMessageFromGateway.contains(Long.valueOf(postId));
    }

    @StoreThread
    private final void fetchForumPosts(long parentChannelId, List<Long> postIds, Function0<Unit> onTerminated) {
        this.forumPostFirstMessageFetchSent.addAll(postIds);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, RestAPI.Companion.getApi().getForumPostData(parentChannelId, new RestAPIParams$GetForumPostData(postIds)), 0L, null, null, 7, null), false, 1, null), StoreForumPostMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new StoreForumPostMessages$fetchForumPosts$1(this, onTerminated), new StoreForumPostMessages$fetchForumPosts$2(this), 30, (Object) null);
    }

    @StoreThread
    private final void flushForumPostFirstMessageQueueHelper(long parentChannelId) {
        Set<Long> set = this.forumPostFetchQueue.get(Long.valueOf(parentChannelId));
        if (set == null || set.isEmpty()) {
            this.forumPostRequestQueueProcessing = false;
            return;
        }
        List<Long> listTake = u.take(set, 10);
        this.forumPostFetchQueue.put(Long.valueOf(parentChannelId), u.toMutableSet(o0.minus((Set) set, (Iterable) listTake)));
        fetchForumPosts(parentChannelId, listTake, new StoreForumPostMessages$flushForumPostFirstMessageQueueHelper$1(this, parentChannelId));
    }

    @StoreThread
    private final Message getFirstMessageForReactionUpdate(MessageReactionUpdate update) {
        Message message = this.forumPostFirstMessage.get(Long.valueOf(update.getChannelId()));
        if (message == null || message.getId() != update.getMessageId()) {
            return null;
        }
        return message;
    }

    @StoreThread
    private final boolean hasForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessage.containsKey(Long.valueOf(postId));
    }

    @StoreThread
    private final boolean isFetchingForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessageFetchSent.contains(Long.valueOf(postId));
    }

    private final boolean isFirstMessage(com.discord.api.message.Message message) {
        return message.getId() == message.getChannelId();
    }

    public static /* synthetic */ Observable observeForumPostFirstMessage$default(StoreForumPostMessages storeForumPostMessages, long j, long j2, boolean z2, int i, Object obj) {
        return storeForumPostMessages.observeForumPostFirstMessage(j, j2, (i & 4) != 0 ? false : z2);
    }

    @StoreThread
    public final void bulkCreateFirstMessage(List<com.discord.api.message.Message> messages) {
        m.checkNotNullParameter(messages, "messages");
        ArrayList<com.discord.api.message.Message> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (isFirstMessage((com.discord.api.message.Message) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            for (com.discord.api.message.Message message : arrayList) {
                this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
                this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            }
            markChanged();
        }
    }

    @StoreThread
    public final void createFirstMessage(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        if (isFirstMessage(message)) {
            this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
            this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            markChanged();
        }
    }

    @StoreThread
    public final void deleteFirstMessage(long channelId) {
        Message messageRemove = this.forumPostFirstMessage.remove(Long.valueOf(channelId));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channelId));
        if (messageRemove != null) {
            markChanged();
        }
    }

    public final void enqueueForumPostFirstMessageFetch(long parentChannelId, long postId) {
        this.dispatcher.schedule(new StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1(this, postId, parentChannelId));
    }

    public final void flushForumPostFirstMessageQueue(long parentChannelId) {
        this.dispatcher.schedule(new StoreForumPostMessages$flushForumPostFirstMessageQueue$1(this, parentChannelId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.forumPostFirstMessage.clear();
        this.forumPostFetchQueue.clear();
        this.shouldGetForumPostFirstMessageFromGateway.clear();
        this.forumPostFirstMessageFetchSent.clear();
        this.forumPostRequestQueueProcessing = false;
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        createFirstMessage(message);
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        m.checkNotNullParameter(messageDelete, "messageDelete");
        Message message = this.forumPostFirstMessage.get(Long.valueOf(messageDelete.getChannelId()));
        if (message == null || !messageDelete.getMessageIds().contains(Long.valueOf(message.getId()))) {
            return;
        }
        deleteFirstMessage(message.getChannelId());
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        updateFirstMessage(message);
    }

    @StoreThread
    public final void handleReactionAdd(MessageReactionUpdate update) {
        List list;
        List arrayList;
        m.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            Object obj = null;
            if (reactions != null) {
                for (Object obj2 : reactions) {
                    if (m.areEqual(((MessageReaction) obj2).getEmoji().c(), update.getEmoji().c())) {
                        obj = obj2;
                        break;
                    }
                }
                obj = (MessageReaction) obj;
            }
            if (obj == null) {
                boolean z2 = update.getUserId() == this.storeUser.getMeSnapshot().getId();
                List<MessageReaction> reactions2 = firstMessageForReactionUpdate.getReactions();
                if (reactions2 == null || (arrayList = u.toMutableList((Collection) reactions2)) == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new MessageReaction(1, update.getEmoji(), z2));
                list = u.toList(arrayList);
            } else {
                List<MessageReaction> reactions3 = firstMessageForReactionUpdate.getReactions();
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(reactions3, 10));
                for (MessageReaction messageReaction : reactions3) {
                    if (m.areEqual(messageReaction.getEmoji().c(), update.getEmoji().c())) {
                        messageReaction = new MessageReaction(messageReaction.getCount() + 1, messageReaction.getEmoji(), update.getUserId() == this.storeUser.getMeSnapshot().getId() ? true : messageReaction.getMe());
                    }
                    arrayList2.add(messageReaction);
                }
                list = arrayList2;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, list, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionRemove(MessageReactionUpdate update) {
        ArrayList arrayList;
        m.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (MessageReaction messageReaction : reactions) {
                    if (m.areEqual(messageReaction.getEmoji().c(), update.getEmoji().c())) {
                        boolean me2 = update.getUserId() == this.storeUser.getMeSnapshot().getId() ? false : messageReaction.getMe();
                        int count = messageReaction.getCount() - 1;
                        messageReaction = count > 0 ? new MessageReaction(count, messageReaction.getEmoji(), me2) : null;
                    }
                    if (messageReaction != null) {
                        arrayList2.add(messageReaction);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        ArrayList arrayList;
        m.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : reactions) {
                    if (!m.areEqual(((MessageReaction) obj).getEmoji().c(), update.getEmoji().c())) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (hasForumPostFirstMessage(channel.getId()) || isFetchingForumPostFirstMessage(channel.getId())) {
            return;
        }
        this.shouldGetForumPostFirstMessageFromGateway.add(Long.valueOf(channel.getId()));
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channel.getId()));
    }

    public final Observable<Message> observeForumPostFirstMessage(long parentChannelId, long postId, boolean fetchIfMissing) {
        if (fetchIfMissing && this.forumPostFirstMessageSnapshot.get(Long.valueOf(postId)) == null) {
            enqueueForumPostFirstMessageFetch(parentChannelId, postId);
            flushForumPostFirstMessageQueue(parentChannelId);
        }
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreForumPostMessages$observeForumPostFirstMessage$1(this, postId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Message>> observeForumPostFirstMessages() {
        Observable<Map<Long, Message>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreForumPostMessages$observeForumPostFirstMessages$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.forumPostFirstMessageSnapshot = new HashMap(this.forumPostFirstMessage);
    }

    @StoreThread
    public final void updateFirstMessage(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        Message message2 = this.forumPostFirstMessage.get(Long.valueOf(message.getChannelId()));
        if (message2 == null || !isFirstMessage(message)) {
            return;
        }
        this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), message2.merge(message));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
        markChanged();
    }

    public StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.forumPostFirstMessage = new HashMap();
        this.forumPostFirstMessageSnapshot = h0.emptyMap();
        this.shouldGetForumPostFirstMessageFromGateway = new LinkedHashSet();
        this.forumPostFirstMessageFetchSent = new HashSet();
        this.forumPostFetchQueue = new HashMap();
    }
}
