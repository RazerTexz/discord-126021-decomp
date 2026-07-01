package com.discord.stores;

import android.content.SharedPreferences;
import b.a.b.a;
import b.i.d.e;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.google.gson.Gson;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.TreeMap;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: StoreLocalMessagesHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalMessagesHolder {
    private boolean cacheEnabled;
    private final Gson gson;
    private SharedPreferences sharedPreferences;
    private final HashMap<Long, TreeMap<Long, Message>> messages = new HashMap<>();
    private final Subject<Map<Long, List<Message>>, Map<Long, List<Message>>> messagesPublisher = new SerializedSubject(BehaviorSubject.k0());
    private Map<Long, ? extends List<Message>> messagesSnapshot = h0.emptyMap();
    private Map<Long, ? extends List<Message>> cacheSnapshot = h0.emptyMap();
    private final Set<Long> updatedChannels = new HashSet();

    public StoreLocalMessagesHolder() {
        e eVar = new e();
        a.a(eVar);
        this.gson = eVar.a();
    }

    public static /* synthetic */ void init$default(StoreLocalMessagesHolder storeLocalMessagesHolder, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeLocalMessagesHolder.init(z2);
    }

    @StoreThread
    private final void messageCacheTryPersist() {
        if (this.cacheEnabled) {
            HashMap map = new HashMap();
            for (Map$Entry<Long, TreeMap<Long, Message>> map$Entry : this.messages.entrySet()) {
                Long key = map$Entry.getKey();
                Collection<Message> collectionValues = map$Entry.getValue().values();
                m.checkNotNullExpressionValue(collectionValues, "entry.value.values");
                map.put(key, u.toList(collectionValues));
            }
            if (!m.areEqual(this.cacheSnapshot, map)) {
                this.cacheSnapshot = map;
                String strM = this.gson.m(map);
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences == null) {
                    m.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                sharedPreferences.edit().putString("STORE_LOCAL_MESSAGES_CACHE_V11", strM).apply();
            }
        }
    }

    private final void publishIfUpdated(boolean force) {
        Collection<Message> collectionEmptyList;
        if (!this.updatedChannels.isEmpty() || force) {
            HashMap map = new HashMap(this.messagesSnapshot);
            Iterator<Long> it = this.updatedChannels.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Long lValueOf = Long.valueOf(jLongValue);
                TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                if (treeMap == null || (collectionEmptyList = treeMap.values()) == null) {
                    collectionEmptyList = n.emptyList();
                }
                map.put(lValueOf, new ArrayList(collectionEmptyList));
            }
            this.updatedChannels.clear();
            this.messagesSnapshot = map;
            this.messagesPublisher.onNext(map);
            messageCacheTryPersist();
        }
    }

    public static /* synthetic */ void publishIfUpdated$default(StoreLocalMessagesHolder storeLocalMessagesHolder, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        storeLocalMessagesHolder.publishIfUpdated(z2);
    }

    @StoreThread
    public final void addMessage(Message message) {
        m.checkNotNullParameter(message, "message");
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap == null) {
            treeMap = new TreeMap<>();
        }
        treeMap.put(Long.valueOf(message.getId()), message);
        this.messages.put(Long.valueOf(channelId), treeMap);
        this.updatedChannels.add(Long.valueOf(channelId));
        publishIfUpdated$default(this, false, 1, null);
    }

    @StoreThread
    public final void clearCache() {
        for (Map$Entry<Long, TreeMap<Long, Message>> map$Entry : this.messages.entrySet()) {
            Long key = map$Entry.getKey();
            TreeMap<Long, Message> value = map$Entry.getValue();
            Set<Long> set = this.updatedChannels;
            m.checkNotNullExpressionValue(key, "channelId");
            set.add(key);
            value.clear();
        }
        publishIfUpdated$default(this, false, 1, null);
    }

    @StoreThread
    public final void deleteMessage(Message message) {
        m.checkNotNullParameter(message, "message");
        long id2 = message.getId();
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            m.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            if (treeMap.containsKey(Long.valueOf(id2))) {
                treeMap.remove(Long.valueOf(id2));
                this.updatedChannels.add(Long.valueOf(channelId));
                if (treeMap.isEmpty()) {
                    this.messages.remove(Long.valueOf(channelId));
                }
            }
            publishIfUpdated$default(this, false, 1, null);
        }
    }

    @StoreThread
    public final List<Message> getFlattenedMessages() {
        return o.flatten(this.messagesSnapshot.values());
    }

    @StoreThread
    public final Message getMessage(long channelId, String nonce) {
        Collection<Message> collectionValues;
        m.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        Object obj = null;
        if (treeMap == null || (collectionValues = treeMap.values()) == null) {
            return null;
        }
        for (Object obj2 : collectionValues) {
            if (m.areEqual(((Message) obj2).getNonce(), nonce)) {
                obj = obj2;
                break;
            }
        }
        return (Message) obj;
    }

    public final Observable<Map<Long, List<Message>>> getMessagesPublisher() {
        return this.messagesPublisher;
    }

    @StoreThread
    public final void init(boolean cacheEnabled) {
        if (cacheEnabled) {
            try {
                SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
                this.sharedPreferences = sharedPreferences;
                if (sharedPreferences == null) {
                    m.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                String string = sharedPreferences.getString("STORE_LOCAL_MESSAGES_CACHE_V11", null);
                for (Map$Entry map$Entry : (string != null ? (Map) this.gson.g(string, new StoreLocalMessagesHolder$init$type$1().getType()) : h0.emptyMap()).entrySet()) {
                    long jLongValue = ((Number) map$Entry.getKey()).longValue();
                    this.messages.put(Long.valueOf(jLongValue), new TreeMap<>(MessageUtils.getSORT_BY_IDS_COMPARATOR()));
                    TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    for (Message message : (List) map$Entry.getValue()) {
                        treeMap.put(Long.valueOf(message.getId()), message);
                    }
                    this.messages.put(Long.valueOf(jLongValue), treeMap);
                    this.updatedChannels.add(Long.valueOf(jLongValue));
                }
            } catch (Exception e) {
                clearCache();
                Logger.e$default(AppLog.g, "Error restoring cached local messages", e, null, 4, null);
            }
        }
        this.cacheEnabled = cacheEnabled;
        publishIfUpdated(true);
    }

    @StoreThread
    public final void deleteMessage(long channelId, String nonce) {
        Object next;
        m.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            m.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            Collection<Message> collectionValues = treeMap.values();
            m.checkNotNullExpressionValue(collectionValues, "messagesForChannel.values");
            Iterator<T> it = collectionValues.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!m.areEqual(((Message) next).getNonce(), nonce));
            Message message = (Message) next;
            if (message != null) {
                m.checkNotNullExpressionValue(message, "messagesForChannel.value…once == nonce } ?: return");
                deleteMessage(message);
            }
        }
    }
}
