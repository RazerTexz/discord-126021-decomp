package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.forum.ForumPostFirstMessages;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0._Sequences2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Subscription;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages extends StoreV2 {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$postId = j;
            this.$parentChannelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.this.hasForumPostFirstMessage(this.$postId) || StoreForumPostMessages.this.isFetchingForumPostFirstMessage(this.$postId) || StoreForumPostMessages.this.expectForumPostFirstMessageFromGateway(this.$postId)) {
                return;
            }
            Set linkedHashSet = (Set) StoreForumPostMessages.this.forumPostFetchQueue.get(Long.valueOf(this.$parentChannelId));
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            linkedHashSet.add(Long.valueOf(this.$postId));
            StoreForumPostMessages.this.forumPostFetchQueue.put(Long.valueOf(this.$parentChannelId), linkedHashSet);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $onTerminated;

        /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreForumPostMessages.kt */
        public static final class C01101 extends Lambda implements Function0<Unit> {
            public C01101() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1.this.$onTerminated.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$onTerminated = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreForumPostMessages.this.dispatcher.schedule(new C01101());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ForumPostFirstMessages, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreForumPostMessages.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ForumPostFirstMessages $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ForumPostFirstMessages forumPostFirstMessages) {
                super(0);
                this.$response = forumPostFirstMessages;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreForumPostMessages.this.bulkCreateFirstMessage(_Sequences2.toList(_Sequences2.filterNotNull(_Sequences2.map(_Collections.asSequence(this.$response.a().values()), StoreForumPostMessages2.INSTANCE))));
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ForumPostFirstMessages forumPostFirstMessages) {
            invoke2(forumPostFirstMessages);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForumPostFirstMessages forumPostFirstMessages) {
            Intrinsics3.checkNotNullParameter(forumPostFirstMessages, "response");
            StoreForumPostMessages.this.dispatcher.schedule(new AnonymousClass1(forumPostFirstMessages));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.this.forumPostRequestQueueProcessing) {
                return;
            }
            StoreForumPostMessages.this.forumPostRequestQueueProcessing = true;
            StoreForumPostMessages.this.flushForumPostFirstMessageQueueHelper(this.$parentChannelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueueHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Collection collection = (Collection) StoreForumPostMessages.this.forumPostFetchQueue.get(Long.valueOf(this.$parentChannelId));
            if (collection == null || collection.isEmpty()) {
                StoreForumPostMessages.this.forumPostRequestQueueProcessing = false;
            } else {
                StoreForumPostMessages.this.flushForumPostFirstMessageQueueHelper(this.$parentChannelId);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Message> {
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$postId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            return (Message) StoreForumPostMessages.this.forumPostFirstMessageSnapshot.get(Long.valueOf(this.$postId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreForumPostMessages.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Message>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Message> invoke() {
            return StoreForumPostMessages.this.forumPostFirstMessageSnapshot;
        }
    }

    public /* synthetic */ StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final boolean expectForumPostFirstMessageFromGateway(long postId) {
        return this.shouldGetForumPostFirstMessageFromGateway.contains(Long.valueOf(postId));
    }

    @Store3
    private final void fetchForumPosts(long parentChannelId, List<Long> postIds, Function0<Unit> onTerminated) {
        this.forumPostFirstMessageFetchSent.addAll(postIds);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, RestAPI.INSTANCE.getApi().getForumPostData(parentChannelId, new RestAPIParams.GetForumPostData(postIds)), 0L, null, null, 7, null), false, 1, null), (Class<?>) StoreForumPostMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass1(onTerminated)), new AnonymousClass2());
    }

    @Store3
    private final void flushForumPostFirstMessageQueueHelper(long parentChannelId) {
        Set<Long> set = this.forumPostFetchQueue.get(Long.valueOf(parentChannelId));
        if (set == null || set.isEmpty()) {
            this.forumPostRequestQueueProcessing = false;
            return;
        }
        List<Long> listTake = _Collections.take(set, 10);
        this.forumPostFetchQueue.put(Long.valueOf(parentChannelId), _Collections.toMutableSet(_Sets.minus((Set) set, (Iterable) listTake)));
        fetchForumPosts(parentChannelId, listTake, new AnonymousClass1(parentChannelId));
    }

    @Store3
    private final Message getFirstMessageForReactionUpdate(MessageReactionUpdate update) {
        Message message = this.forumPostFirstMessage.get(Long.valueOf(update.getChannelId()));
        if (message == null || message.getId() != update.getMessageId()) {
            return null;
        }
        return message;
    }

    @Store3
    private final boolean hasForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessage.containsKey(Long.valueOf(postId));
    }

    @Store3
    private final boolean isFetchingForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessageFetchSent.contains(Long.valueOf(postId));
    }

    private final boolean isFirstMessage(com.discord.api.message.Message message) {
        return message.getId() == message.getChannelId();
    }

    @Store3
    public final void bulkCreateFirstMessage(List<com.discord.api.message.Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
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

    @Store3
    public final void createFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (isFirstMessage(message)) {
            this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
            this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            markChanged();
        }
    }

    @Store3
    public final void deleteFirstMessage(long channelId) {
        Message messageRemove = this.forumPostFirstMessage.remove(Long.valueOf(channelId));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channelId));
        if (messageRemove != null) {
            markChanged();
        }
    }

    public final void enqueueForumPostFirstMessageFetch(long parentChannelId, long postId) {
        this.dispatcher.schedule(new AnonymousClass1(postId, parentChannelId));
    }

    public final void flushForumPostFirstMessageQueue(long parentChannelId) {
        this.dispatcher.schedule(new AnonymousClass1(parentChannelId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.forumPostFirstMessage.clear();
        this.forumPostFetchQueue.clear();
        this.shouldGetForumPostFirstMessageFromGateway.clear();
        this.forumPostFirstMessageFetchSent.clear();
        this.forumPostRequestQueueProcessing = false;
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        createFirstMessage(message);
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        Message message = this.forumPostFirstMessage.get(Long.valueOf(messageDelete.getChannelId()));
        if (message == null || !messageDelete.getMessageIds().contains(Long.valueOf(message.getId()))) {
            return;
        }
        deleteFirstMessage(message.getChannelId());
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        updateFirstMessage(message);
    }

    @Store3
    public final void handleReactionAdd(MessageReactionUpdate update) {
        List list;
        List arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            Object obj = null;
            if (reactions != null) {
                for (Object obj2 : reactions) {
                    if (Intrinsics3.areEqual(((MessageReaction) obj2).getEmoji().c(), update.getEmoji().c())) {
                        obj = obj2;
                        break;
                    }
                }
                obj = (MessageReaction) obj;
            }
            if (obj == null) {
                boolean z2 = update.getUserId() == this.storeUser.getMeSnapshot().getId();
                List<MessageReaction> reactions2 = firstMessageForReactionUpdate.getReactions();
                if (reactions2 == null || (arrayList = _Collections.toMutableList((Collection) reactions2)) == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new MessageReaction(1, update.getEmoji(), z2));
                list = _Collections.toList(arrayList);
            } else {
                List<MessageReaction> reactions3 = firstMessageForReactionUpdate.getReactions();
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(reactions3, 10));
                for (MessageReaction messageReaction : reactions3) {
                    if (Intrinsics3.areEqual(messageReaction.getEmoji().c(), update.getEmoji().c())) {
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

    @Store3
    public final void handleReactionRemove(MessageReactionUpdate update) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (MessageReaction messageReaction : reactions) {
                    if (Intrinsics3.areEqual(messageReaction.getEmoji().c(), update.getEmoji().c())) {
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

    @Store3
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : reactions) {
                    if (!Intrinsics3.areEqual(((MessageReaction) obj).getEmoji().c(), update.getEmoji().c())) {
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

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (hasForumPostFirstMessage(channel.getId()) || isFetchingForumPostFirstMessage(channel.getId())) {
            return;
        }
        this.shouldGetForumPostFirstMessageFromGateway.add(Long.valueOf(channel.getId()));
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channel.getId()));
    }

    public final Observable<Message> observeForumPostFirstMessage(long parentChannelId, long postId, boolean fetchIfMissing) {
        if (fetchIfMissing && this.forumPostFirstMessageSnapshot.get(Long.valueOf(postId)) == null) {
            enqueueForumPostFirstMessageFetch(parentChannelId, postId);
            flushForumPostFirstMessageQueue(parentChannelId);
        }
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(postId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Message>> observeForumPostFirstMessages() {
        Observable<Map<Long, Message>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.forumPostFirstMessageSnapshot = new HashMap(this.forumPostFirstMessage);
    }

    @Store3
    public final void updateFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Message message2 = this.forumPostFirstMessage.get(Long.valueOf(message.getChannelId()));
        if (message2 == null || !isFirstMessage(message)) {
            return;
        }
        this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), message2.merge(message));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
        markChanged();
    }

    public StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.forumPostFirstMessage = new HashMap();
        this.forumPostFirstMessageSnapshot = Maps6.emptyMap();
        this.shouldGetForumPostFirstMessageFromGateway = new LinkedHashSet();
        this.forumPostFirstMessageFetchSent = new HashSet();
        this.forumPostFetchQueue = new HashMap();
    }
}
