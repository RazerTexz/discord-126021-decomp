package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.m0;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReplies extends StoreV2 {
    public static final StoreMessageReplies$Companion Companion = new StoreMessageReplies$Companion(null);
    private static final Map<Long, StoreMessageReplies$MessageState> NO_RESULTS = h0.emptyMap();
    private final HashMap<Long, Set<Long>> channelMap;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends Map<Long, ? extends StoreMessageReplies$MessageState>> repliedChannelMessagesCacheSnapshot;
    private final StoreMessageReplies$MessageCache<Long, StoreMessageReplies$MessageState> repliedMessagesCache;
    private Map<Long, ? extends StoreMessageReplies$MessageState> repliedMessagesCacheSnapshot;
    private final StoreMessages storeMessages;

    public /* synthetic */ StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeMessages, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getCachedChannelMessages(StoreMessageReplies storeMessageReplies, long j) {
        return storeMessageReplies.getCachedChannelMessages(j);
    }

    @StoreThread
    private final boolean deleteMessage(long messageId, long channelId) {
        if (!this.repliedMessagesCache.containsKey(Long.valueOf(messageId))) {
            return false;
        }
        updateCache(messageId, channelId, StoreMessageReplies$MessageState$Deleted.INSTANCE);
        return true;
    }

    private final Map<Long, StoreMessageReplies$MessageState> getCachedChannelMessages(long channelId) {
        Map<Long, StoreMessageReplies$MessageState> map = (Map) this.repliedChannelMessagesCacheSnapshot.get(Long.valueOf(channelId));
        return map != null ? map : NO_RESULTS;
    }

    @StoreThread
    private final boolean processMessage(Message message) {
        return processMessage(new com.discord.models.message.Message(message));
    }

    private final void processReferencedMessage(com.discord.models.message.Message referencedMessage) {
        updateCache(referencedMessage.getId(), referencedMessage.getChannelId(), new StoreMessageReplies$MessageState$Loaded(referencedMessage));
        Integer type = referencedMessage.getType();
        if (type != null && type.intValue() == 19) {
            processMessage(referencedMessage);
        }
    }

    private final void snapShotAllMessages() {
        this.repliedMessagesCacheSnapshot = new HashMap(this.repliedMessagesCache);
    }

    @StoreThread
    private final void snapShotChannelMessages() {
        HashMap<Long, Set<Long>> map = this.channelMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            Set set = (Set) map$Entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(set, 10)), 16));
            for (Object obj : set) {
                Object obj2 = (StoreMessageReplies$MessageState) this.repliedMessagesCache.get(Long.valueOf(((Number) obj).longValue()));
                if (obj2 == null) {
                    obj2 = StoreMessageReplies$MessageState$Unloaded.INSTANCE;
                }
                linkedHashMap2.put(obj, obj2);
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.repliedChannelMessagesCacheSnapshot = linkedHashMap;
    }

    @StoreThread
    private final void updateCache(long messageId, long channelId, StoreMessageReplies$MessageState messageState) {
        this.repliedMessagesCache.put(Long.valueOf(messageId), messageState);
        HashMap<Long, Set<Long>> map = this.channelMap;
        Long lValueOf = Long.valueOf(channelId);
        Set of = m0.setOf(Long.valueOf(messageId));
        Set<Long> setEmptySet = this.channelMap.get(Long.valueOf(channelId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        map.put(lValueOf, u.union(of, setEmptySet));
    }

    public final Map<Long, StoreMessageReplies$MessageState> getAllMessageReferences() {
        return this.repliedMessagesCacheSnapshot;
    }

    @StoreThread
    public final void handleLoadMessages(Collection<com.discord.models.message.Message> messages) {
        m.checkNotNullParameter(messages, "messages");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(processMessage((com.discord.models.message.Message) it.next())));
        }
        if (arrayList.contains(Boolean.TRUE)) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        m.checkNotNullParameter(message, "message");
        if (processMessage(message)) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        boolean z2;
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        List<Long> messageIds = messageDeleteBulk.getMessageIds();
        m.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
        Iterator<T> it = messageIds.iterator();
        loop0: while (true) {
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                Long l = (Long) it.next();
                m.checkNotNullExpressionValue(l, "messageId");
                z2 = deleteMessage(l.longValue(), messageDeleteBulk.getChannelId()) || z2;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageUpdate(Message message) {
        StoreMessageReplies$MessageState storeMessageReplies$MessageState;
        m.checkNotNullParameter(message, "message");
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId())) && (storeMessageReplies$MessageState = this.repliedMessagesCache.get(Long.valueOf(message.getId()))) != null && (storeMessageReplies$MessageState instanceof StoreMessageReplies$MessageState$Loaded)) {
            com.discord.models.message.Message messageMerge = ((StoreMessageReplies$MessageState$Loaded) storeMessageReplies$MessageState).getMessage().merge(message);
            updateCache(messageMerge.getId(), messageMerge.getChannelId(), new StoreMessageReplies$MessageState$Loaded(messageMerge));
            markChanged();
        }
    }

    public final Observable<Map<Long, StoreMessageReplies$MessageState>> observeMessageReferencesForChannel(long channelId) {
        Observable<Map<Long, StoreMessageReplies$MessageState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMessageReplies$observeMessageReferencesForChannel$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        snapShotChannelMessages();
        snapShotAllMessages();
    }

    public StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeMessages = storeMessages;
        this.observationDeck = observationDeck;
        this.repliedMessagesCache = new StoreMessageReplies$MessageCache<>();
        this.channelMap = new HashMap<>();
        this.repliedChannelMessagesCacheSnapshot = h0.emptyMap();
        this.repliedMessagesCacheSnapshot = h0.emptyMap();
    }

    @StoreThread
    private final boolean processMessage(com.discord.models.message.Message message) {
        boolean z2;
        MessageReference messageReference;
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId()))) {
            updateCache(message.getId(), message.getChannelId(), new StoreMessageReplies$MessageState$Loaded(message));
            z2 = true;
        } else {
            z2 = false;
        }
        if (!message.isEmbeddedMessageType() || (messageReference = message.getMessageReference()) == null) {
            return z2;
        }
        Message referencedMessage = message.getReferencedMessage();
        Long channelId = messageReference.getChannelId();
        Long messageId = messageReference.getMessageId();
        if (referencedMessage != null) {
            processReferencedMessage(new com.discord.models.message.Message(referencedMessage));
            return true;
        }
        if (channelId == null || messageId == null) {
            return true;
        }
        com.discord.models.message.Message message2 = this.storeMessages.getMessage(channelId.longValue(), messageId.longValue());
        if (message2 != null) {
            processReferencedMessage(message2);
            return true;
        }
        updateCache(messageId.longValue(), channelId.longValue(), StoreMessageReplies$MessageState$Unloaded.INSTANCE);
        return true;
    }
}
