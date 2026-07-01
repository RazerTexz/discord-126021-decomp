package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.message.MessageReference;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReplies extends StoreV2 {
    private static final Map<Long, MessageState> NO_RESULTS = Maps6.emptyMap();
    private final HashMap<Long, Set<Long>> channelMap;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends Map<Long, ? extends MessageState>> repliedChannelMessagesCacheSnapshot;
    private final MessageCache<Long, MessageState> repliedMessagesCache;
    private Map<Long, ? extends MessageState> repliedMessagesCacheSnapshot;
    private final StoreMessages storeMessages;

    /* JADX INFO: compiled from: StoreMessageReplies.kt */
    public static final class MessageCache<K, V> extends LinkedHashMap<K, V> {
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > 1000;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }
    }

    /* JADX INFO: compiled from: StoreMessageReplies.kt */
    public static abstract class MessageState {

        /* JADX INFO: compiled from: StoreMessageReplies.kt */
        public static final class Deleted extends MessageState {
            public static final Deleted INSTANCE = new Deleted();

            private Deleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreMessageReplies.kt */
        public static final /* data */ class Loaded extends MessageState {
            private final Message message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Message message) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = loaded.message;
                }
                return loaded.copy(message);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            public final Loaded copy(Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
                return new Loaded(message);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.message, ((Loaded) other).message);
                }
                return true;
            }

            public final Message getMessage() {
                return this.message;
            }

            public int hashCode() {
                Message message = this.message;
                if (message != null) {
                    return message.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(message=");
                sbU.append(this.message);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: StoreMessageReplies.kt */
        public static final class Unloaded extends MessageState {
            public static final Unloaded INSTANCE = new Unloaded();

            private Unloaded() {
                super(null);
            }
        }

        private MessageState() {
        }

        public /* synthetic */ MessageState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReplies$observeMessageReferencesForChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReplies.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends MessageState>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends MessageState> invoke() {
            return StoreMessageReplies.this.getCachedChannelMessages(this.$channelId);
        }
    }

    public /* synthetic */ StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeMessages, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final boolean deleteMessage(long messageId, long channelId) {
        if (!this.repliedMessagesCache.containsKey(Long.valueOf(messageId))) {
            return false;
        }
        updateCache(messageId, channelId, MessageState.Deleted.INSTANCE);
        return true;
    }

    private final Map<Long, MessageState> getCachedChannelMessages(long channelId) {
        Map<Long, MessageState> map = (Map) this.repliedChannelMessagesCacheSnapshot.get(Long.valueOf(channelId));
        return map != null ? map : NO_RESULTS;
    }

    @Store3
    private final boolean processMessage(com.discord.api.message.Message message) {
        return processMessage(new Message(message));
    }

    private final void processReferencedMessage(Message referencedMessage) {
        updateCache(referencedMessage.getId(), referencedMessage.getChannelId(), new MessageState.Loaded(referencedMessage));
        Integer type = referencedMessage.getType();
        if (type != null && type.intValue() == 19) {
            processMessage(referencedMessage);
        }
    }

    private final void snapShotAllMessages() {
        this.repliedMessagesCacheSnapshot = new HashMap(this.repliedMessagesCache);
    }

    @Store3
    private final void snapShotChannelMessages() {
        HashMap<Long, Set<Long>> map = this.channelMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Set set = (Set) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(set, 10)), 16));
            for (Object obj : set) {
                Object obj2 = (MessageState) this.repliedMessagesCache.get(Long.valueOf(((Number) obj).longValue()));
                if (obj2 == null) {
                    obj2 = MessageState.Unloaded.INSTANCE;
                }
                linkedHashMap2.put(obj, obj2);
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.repliedChannelMessagesCacheSnapshot = linkedHashMap;
    }

    @Store3
    private final void updateCache(long messageId, long channelId, MessageState messageState) {
        this.repliedMessagesCache.put(Long.valueOf(messageId), messageState);
        HashMap<Long, Set<Long>> map = this.channelMap;
        Long lValueOf = Long.valueOf(channelId);
        Set of = SetsJVM.setOf(Long.valueOf(messageId));
        Set<Long> setEmptySet = this.channelMap.get(Long.valueOf(channelId));
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        map.put(lValueOf, _Collections.union(of, setEmptySet));
    }

    public final Map<Long, MessageState> getAllMessageReferences() {
        return this.repliedMessagesCacheSnapshot;
    }

    @Store3
    public final void handleLoadMessages(Collection<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(processMessage((Message) it.next())));
        }
        if (arrayList.contains(Boolean.TRUE)) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (processMessage(message)) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        List<Long> messageIds = messageDeleteBulk.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
        Iterator<T> it = messageIds.iterator();
        loop0: while (true) {
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                Long l = (Long) it.next();
                Intrinsics3.checkNotNullExpressionValue(l, "messageId");
                z2 = deleteMessage(l.longValue(), messageDeleteBulk.getChannelId()) || z2;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        MessageState messageState;
        Intrinsics3.checkNotNullParameter(message, "message");
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId())) && (messageState = this.repliedMessagesCache.get(Long.valueOf(message.getId()))) != null && (messageState instanceof MessageState.Loaded)) {
            Message messageMerge = ((MessageState.Loaded) messageState).getMessage().merge(message);
            updateCache(messageMerge.getId(), messageMerge.getChannelId(), new MessageState.Loaded(messageMerge));
            markChanged();
        }
    }

    public final Observable<Map<Long, MessageState>> observeMessageReferencesForChannel(long channelId) {
        Observable<Map<Long, MessageState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        snapShotChannelMessages();
        snapShotAllMessages();
    }

    public StoreMessageReplies(Dispatcher dispatcher, StoreMessages storeMessages, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeMessages = storeMessages;
        this.observationDeck = observationDeck;
        this.repliedMessagesCache = new MessageCache<>();
        this.channelMap = new HashMap<>();
        this.repliedChannelMessagesCacheSnapshot = Maps6.emptyMap();
        this.repliedMessagesCacheSnapshot = Maps6.emptyMap();
    }

    @Store3
    private final boolean processMessage(Message message) {
        boolean z2;
        MessageReference messageReference;
        if (this.repliedMessagesCache.containsKey(Long.valueOf(message.getId()))) {
            updateCache(message.getId(), message.getChannelId(), new MessageState.Loaded(message));
            z2 = true;
        } else {
            z2 = false;
        }
        if (!message.isEmbeddedMessageType() || (messageReference = message.getMessageReference()) == null) {
            return z2;
        }
        com.discord.api.message.Message referencedMessage = message.getReferencedMessage();
        Long channelId = messageReference.getChannelId();
        Long messageId = messageReference.getMessageId();
        if (referencedMessage != null) {
            processReferencedMessage(new Message(referencedMessage));
            return true;
        }
        if (channelId == null || messageId == null) {
            return true;
        }
        Message message2 = this.storeMessages.getMessage(channelId.longValue(), messageId.longValue());
        if (message2 != null) {
            processReferencedMessage(message2);
            return true;
        }
        updateCache(messageId.longValue(), channelId.longValue(), MessageState.Unloaded.INSTANCE);
        return true;
    }
}
