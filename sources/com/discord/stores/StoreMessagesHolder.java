package com.discord.stores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessagesLoader;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.ClockFactory;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/* JADX INFO: loaded from: classes2.dex */
public class StoreMessagesHolder {
    private static final int CACHE_MAX_CHANNELS = 8;
    private static final int CACHE_MAX_MESSAGES = 10;
    private static final int CACHE_PERSIST_INTERVAL = 60000;
    private static final int MAX_MESSAGES_PER_CHANNEL = 200;
    private static final int MAX_MESSAGES_PER_CHANNEL_TRIM = 100;
    private boolean cacheEnabled;
    private Subscription cachePersistSubscription;
    private final Set<Long> detachedChannels;
    private final Subject<Set<Long>, Set<Long>> detachedChannelsSubject;
    private long myUserId;
    private long selectedChannelId;
    private final Set<Long> staleMessages = new HashSet();
    private final LinkedHashMap<Long, TreeMap<Long, Message>> messages = new LinkedHashMap<>();
    private final Subject<Map<Long, List<Message>>, Map<Long, List<Message>>> messagesPublisher = new SerializedSubject(BehaviorSubject.k0());
    private Map<Long, List<Message>> messagesSnapshot = Collections.emptyMap();
    private final Map<String, Long> messageNonceIds = new HashMap();
    private final Persister<Map<Long, List<Message>>> cache = new Persister<>("STORE_MESSAGES_CACHE_V38", new HashMap());
    private Map<Long, List<Message>> cacheSnapshot = Collections.emptyMap();
    private long cachePersistedAt = ClockFactory.get().currentTimeMillis();
    private final Set<Long> updatedChannels = new HashSet();
    private final Set<Long> activeChannels = new HashSet();

    public StoreMessagesHolder() {
        HashSet hashSet = new HashSet();
        this.detachedChannels = hashSet;
        this.detachedChannelsSubject = new SerializedSubject(BehaviorSubject.l0(new HashSet(hashSet)));
    }

    private static Message addReaction(Message message, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        MessageReaction messageReaction;
        Map<String, MessageReaction> reactionsMap = message.getReactionsMap();
        String strC = messageReactionEmoji.c();
        if (z2 && reactionsMap.containsKey(strC) && reactionsMap.get(strC).getMe()) {
            return message;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(reactionsMap);
        boolean z3 = true;
        if (reactionsMap.containsKey(strC)) {
            MessageReaction messageReaction2 = (MessageReaction) linkedHashMap.get(messageReactionEmoji.c());
            int count = messageReaction2.getCount() + 1;
            MessageReactionEmoji emoji = messageReaction2.getEmoji();
            if (!messageReaction2.getMe() && !z2) {
                z3 = false;
            }
            messageReaction = new MessageReaction(count, emoji, z3);
        } else {
            messageReaction = new MessageReaction(1, messageReactionEmoji, z2);
        }
        linkedHashMap.put(strC, messageReaction);
        return LocalMessageCreators.createWithReactions(message, linkedHashMap);
    }

    private Map<Long, List<Message>> computeMessagesCache() {
        HashMap map = new HashMap();
        ListIterator listIterator = new ArrayList(this.messages.entrySet()).listIterator(this.messages.size());
        int i = 8;
        while (listIterator.hasPrevious() && i > 0) {
            Map.Entry entry = (Map.Entry) listIterator.previous();
            long jLongValue = ((Long) entry.getKey()).longValue();
            Map<?, Message> map2 = (Map) entry.getValue();
            if (map2.size() > 0) {
                map.put(Long.valueOf(jLongValue), computeMessagesCacheSubList(jLongValue, map2));
                i--;
            }
        }
        return map;
    }

    private List<Message> computeMessagesCacheSubList(long j, @NonNull Map<?, Message> map) {
        return new ArrayList(new ArrayList(map.values()).subList(Math.max(0, map.size() - (j == this.selectedChannelId ? 20 : 10)), map.size()));
    }

    private boolean isChannelActive(long j) {
        return this.activeChannels.contains(Long.valueOf(j));
    }

    private boolean isChannelDetached(long j) {
        return this.detachedChannels.contains(Long.valueOf(j));
    }

    private synchronized void messageCacheTryPersist() {
        if (this.cacheEnabled) {
            long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
            long j = this.cachePersistedAt + 60000;
            if (j < jCurrentTimeMillis) {
                this.cachePersistedAt = jCurrentTimeMillis;
                Map<Long, List<Message>> mapComputeMessagesCache = computeMessagesCache();
                if (!this.cacheSnapshot.equals(mapComputeMessagesCache)) {
                    this.cacheSnapshot = mapComputeMessagesCache;
                    this.cache.set(mapComputeMessagesCache);
                }
            } else {
                long j2 = (j - jCurrentTimeMillis) + 1000;
                Subscription subscription = this.cachePersistSubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.cachePersistSubscription = new ScalarSynchronousObservable(null).q(j2, TimeUnit.MILLISECONDS).W(new Action1() { // from class: b.a.u.b
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        this.j.a(obj);
                    }
                }, new Action1() { // from class: b.a.u.a
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                    }
                });
            }
        }
    }

    private void publishIfUpdated(boolean z2) {
        if (!this.updatedChannels.isEmpty() || z2) {
            HashMap map = new HashMap();
            Iterator<Long> it = this.updatedChannels.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                map.put(Long.valueOf(jLongValue), new ArrayList(this.messages.get(Long.valueOf(jLongValue)).values()));
            }
            for (Map.Entry<Long, List<Message>> entry : this.messagesSnapshot.entrySet()) {
                long jLongValue2 = entry.getKey().longValue();
                if (!this.updatedChannels.contains(Long.valueOf(jLongValue2))) {
                    map.put(Long.valueOf(jLongValue2), entry.getValue());
                }
            }
            this.updatedChannels.clear();
            this.messagesSnapshot = map;
            this.messagesPublisher.onNext(map);
            messageCacheTryPersist();
        }
    }

    private static Message removeReaction(Message message, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        Map<String, MessageReaction> reactionsMap = message.getReactionsMap();
        String strC = messageReactionEmoji.c();
        if (!reactionsMap.containsKey(strC)) {
            return message;
        }
        if (z2 && !reactionsMap.get(strC).getMe()) {
            return message;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(reactionsMap);
        MessageReaction messageReaction = (MessageReaction) linkedHashMap.get(strC);
        if (messageReaction.getCount() == 1) {
            linkedHashMap.remove(strC);
        } else {
            linkedHashMap.put(strC, new MessageReaction(messageReaction.getCount() - 1, messageReaction.getEmoji(), messageReaction.getMe() && !z2));
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        return LocalMessageCreators.createWithReactions(message, linkedHashMap);
    }

    private boolean updateDetachedState(long j, Map<Long, Message> map, boolean z2, boolean z3, boolean z4) {
        int size = map.size();
        boolean z5 = size >= 200;
        if (z5) {
            int i = z2 ? 100 : size - 100;
            Iterator<Map.Entry<Long, Message>> it = map.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                if ((z2 && i2 >= i) || (!z2 && i2 < i)) {
                    it.remove();
                }
                i2++;
            }
        }
        boolean zIsChannelDetached = isChannelDetached(j);
        boolean z6 = z5 && z2 && !z3;
        if (!zIsChannelDetached && (z6 || z4)) {
            this.detachedChannels.add(Long.valueOf(j));
            this.detachedChannelsSubject.onNext(new HashSet(this.detachedChannels));
        } else if (zIsChannelDetached && z3) {
            this.detachedChannels.remove(Long.valueOf(j));
            this.detachedChannelsSubject.onNext(new HashSet(this.detachedChannels));
        }
        return z5;
    }

    public /* synthetic */ void a(Object obj) {
        messageCacheTryPersist();
    }

    public synchronized void addMessages(@NonNull List<Message> list) {
        boolean z2;
        for (Message message : list) {
            long channelId = message.getChannelId();
            TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
            if (isChannelActive(channelId) && !isChannelDetached(channelId)) {
                String nonce = message.getNonce();
                if (message.isLocal()) {
                    this.messageNonceIds.put(nonce, Long.valueOf(message.getId()));
                } else {
                    Long l = this.messageNonceIds.get(nonce);
                    if (l != null) {
                        this.messageNonceIds.remove(nonce);
                        if (treeMap.containsKey(l)) {
                            treeMap.remove(l);
                            z2 = true;
                        }
                    }
                    treeMap.put(Long.valueOf(message.getId()), message);
                    if (!updateDetachedState(channelId, treeMap, false, true, false) || !z2) {
                        this.updatedChannels.add(Long.valueOf(channelId));
                    }
                }
                z2 = false;
                treeMap.put(Long.valueOf(message.getId()), message);
                if (!updateDetachedState(channelId, treeMap, false, true, false)) {
                }
                this.updatedChannels.add(Long.valueOf(channelId));
            }
        }
        publishIfUpdated();
    }

    public synchronized void deleteMessages(long j, @Nullable List<Long> list) {
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(j));
        if (isChannelActive(j) && list != null && !list.isEmpty()) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (treeMap.containsKey(Long.valueOf(jLongValue))) {
                    treeMap.remove(Long.valueOf(jLongValue));
                    this.updatedChannels.add(Long.valueOf(j));
                }
            }
            publishIfUpdated();
        }
    }

    public Observable<Set<Long>> getDetachedChannelsSubject() {
        return this.detachedChannelsSubject;
    }

    @Nullable
    public synchronized TreeMap<Long, Message> getMessagesForChannel(Long l) {
        return this.messages.get(l);
    }

    public Observable<Map<Long, List<Message>>> getMessagesPublisher() {
        return this.messagesPublisher;
    }

    public synchronized void init(boolean z2) {
        if (z2) {
            for (Map.Entry<Long, List<Message>> entry : this.cache.get().entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    long jLongValue = entry.getKey().longValue();
                    this.messages.put(Long.valueOf(jLongValue), new TreeMap<>(MessageUtils.getSORT_BY_IDS_COMPARATOR()));
                    TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                    for (Message message : entry.getValue()) {
                        this.staleMessages.add(Long.valueOf(message.getId()));
                        treeMap.put(Long.valueOf(message.getId()), message);
                    }
                    this.updatedChannels.add(Long.valueOf(jLongValue));
                }
            }
        }
        this.cacheEnabled = z2;
        publishIfUpdated(true);
    }

    public synchronized void invalidate() {
        Iterator<Map.Entry<Long, TreeMap<Long, Message>>> it = this.messages.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<Map.Entry<Long, Message>> it2 = it.next().getValue().entrySet().iterator();
            while (it2.hasNext()) {
                this.staleMessages.add(Long.valueOf(it2.next().getValue().getId()));
            }
        }
        this.activeChannels.clear();
        this.activeChannels.add(Long.valueOf(this.selectedChannelId));
    }

    public synchronized void loadMessageChunks(@NonNull List<StoreMessagesLoader.ChannelChunk> list) {
        for (StoreMessagesLoader.ChannelChunk channelChunk : list) {
            List<Message> messages = channelChunk.getMessages();
            long channelId = channelChunk.getChannelId();
            if (this.activeChannels.contains(Long.valueOf(channelId))) {
                TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
                boolean zIsChannelDetached = isChannelDetached(channelId);
                boolean zIsJump = channelChunk.isJump();
                boolean zIsInitial = channelChunk.isInitial();
                boolean zIsPresent = channelChunk.isPresent();
                if (zIsInitial || zIsJump) {
                    Iterator<Map.Entry<Long, Message>> it = treeMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Long lValueOf = Long.valueOf(it.next().getValue().getId());
                        if (this.staleMessages.contains(lValueOf) || zIsChannelDetached || zIsJump) {
                            it.remove();
                            this.staleMessages.remove(lValueOf);
                        }
                    }
                }
                for (Message message : messages) {
                    treeMap.put(Long.valueOf(message.getId()), message);
                }
                updateDetachedState(channelId, treeMap, channelChunk.isAppendingTop(), zIsPresent, zIsJump);
                this.updatedChannels.add(Long.valueOf(channelId));
            }
        }
        publishIfUpdated();
    }

    public synchronized void removeAllReactions(@NonNull MessageReactionUpdate messageReactionUpdate) {
        long channelId = messageReactionUpdate.getChannelId();
        if (isChannelActive(channelId)) {
            long messageId = messageReactionUpdate.getMessageId();
            TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
            Message message = treeMap.get(Long.valueOf(messageId));
            if (message == null) {
                return;
            }
            treeMap.put(Long.valueOf(messageId), LocalMessageCreators.createWithReactions(message, null));
            this.updatedChannels.add(Long.valueOf(channelId));
            publishIfUpdated();
        }
    }

    public synchronized void removeEmojiReactions(@NonNull MessageReactionUpdate messageReactionUpdate) {
        long channelId = messageReactionUpdate.getChannelId();
        if (isChannelActive(channelId)) {
            long messageId = messageReactionUpdate.getMessageId();
            TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
            Message message = treeMap.get(Long.valueOf(messageId));
            if (message == null) {
                return;
            }
            String strC = messageReactionUpdate.getEmoji().c();
            Map<String, MessageReaction> reactionsMap = message.getReactionsMap();
            if (reactionsMap.containsKey(strC)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, MessageReaction> entry : reactionsMap.entrySet()) {
                    String key = entry.getKey();
                    if (!key.equals(strC)) {
                        linkedHashMap.put(key, entry.getValue());
                    }
                }
                treeMap.put(Long.valueOf(messageId), LocalMessageCreators.createWithReactions(message, linkedHashMap));
                this.updatedChannels.add(Long.valueOf(channelId));
                publishIfUpdated();
            }
        }
    }

    public void setMyUserId(long j) {
        this.myUserId = j;
    }

    public synchronized void setSelectedChannelId(long j) {
        this.selectedChannelId = j;
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(j));
        if (treeMap != null) {
            this.messages.remove(Long.valueOf(j));
            this.messages.put(Long.valueOf(j), treeMap);
        } else {
            this.messages.put(Long.valueOf(j), new TreeMap<>(MessageUtils.getSORT_BY_IDS_COMPARATOR()));
        }
        this.activeChannels.add(Long.valueOf(j));
    }

    public synchronized void updateMessages(@NonNull com.discord.api.message.Message message) {
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (isChannelActive(channelId)) {
            Message message2 = treeMap.get(Long.valueOf(message.getId()));
            if (!isChannelDetached(channelId) && message2 != null) {
                treeMap.put(Long.valueOf(message.getId()), message2.merge(message));
                this.updatedChannels.add(Long.valueOf(channelId));
            }
            return;
        }
        publishIfUpdated();
    }

    public synchronized void updateReactions(@NonNull List<MessageReactionUpdate> list, boolean z2) {
        for (MessageReactionUpdate messageReactionUpdate : list) {
            long channelId = messageReactionUpdate.getChannelId();
            if (isChannelActive(channelId)) {
                long messageId = messageReactionUpdate.getMessageId();
                MessageReactionEmoji emoji = messageReactionUpdate.getEmoji();
                boolean z3 = messageReactionUpdate.getUserId() == this.myUserId;
                TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
                Message message = treeMap.get(Long.valueOf(messageId));
                if (message != null) {
                    treeMap.put(Long.valueOf(messageId), z2 ? addReaction(message, emoji, z3) : removeReaction(message, emoji, z3));
                    this.updatedChannels.add(Long.valueOf(channelId));
                }
            }
        }
        publishIfUpdated();
    }

    private void publishIfUpdated() {
        publishIfUpdated(false);
    }
}
