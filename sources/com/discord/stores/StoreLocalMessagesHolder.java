package com.discord.stores;

import android.content.SharedPreferences;
import b.a.b.TypeAdapterRegistrar;
import b.i.d.GsonBuilder;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    private Map<Long, ? extends List<Message>> messagesSnapshot = Maps6.emptyMap();
    private Map<Long, ? extends List<Message>> cacheSnapshot = Maps6.emptyMap();
    private final Set<Long> updatedChannels = new HashSet();

    public StoreLocalMessagesHolder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterRegistrar.a(gsonBuilder);
        this.gson = gsonBuilder.a();
    }

    public static /* synthetic */ void init$default(StoreLocalMessagesHolder storeLocalMessagesHolder, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeLocalMessagesHolder.init(z2);
    }

    @Store3
    private final void messageCacheTryPersist() {
        if (this.cacheEnabled) {
            HashMap map = new HashMap();
            for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
                Long key = entry.getKey();
                Collection<Message> collectionValues = entry.getValue().values();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "entry.value.values");
                map.put(key, _Collections.toList(collectionValues));
            }
            if (!Intrinsics3.areEqual(this.cacheSnapshot, map)) {
                this.cacheSnapshot = map;
                String strM = this.gson.m(map);
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
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
                    collectionEmptyList = Collections2.emptyList();
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

    @Store3
    public final void addMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
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

    @Store3
    public final void clearCache() {
        for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
            Long key = entry.getKey();
            TreeMap<Long, Message> value = entry.getValue();
            Set<Long> set = this.updatedChannels;
            Intrinsics3.checkNotNullExpressionValue(key, "channelId");
            set.add(key);
            value.clear();
        }
        publishIfUpdated$default(this, false, 1, null);
    }

    @Store3
    public final void deleteMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        long id2 = message.getId();
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            Intrinsics3.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
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

    @Store3
    public final List<Message> getFlattenedMessages() {
        return Iterables2.flatten(this.messagesSnapshot.values());
    }

    @Store3
    public final Message getMessage(long channelId, String nonce) {
        Collection<Message> collectionValues;
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        Object obj = null;
        if (treeMap == null || (collectionValues = treeMap.values()) == null) {
            return null;
        }
        for (Object obj2 : collectionValues) {
            if (Intrinsics3.areEqual(((Message) obj2).getNonce(), nonce)) {
                obj = obj2;
                break;
            }
        }
        return (Message) obj;
    }

    public final Observable<Map<Long, List<Message>>> getMessagesPublisher() {
        return this.messagesPublisher;
    }

    @Store3
    public final void init(boolean cacheEnabled) {
        if (cacheEnabled) {
            try {
                SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
                this.sharedPreferences = sharedPreferences;
                if (sharedPreferences == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                String string = sharedPreferences.getString("STORE_LOCAL_MESSAGES_CACHE_V11", null);
                for (Map.Entry entry : (string != null ? (Map) this.gson.g(string, new TypeToken<Map<Long, ? extends List<? extends Message>>>() { // from class: com.discord.stores.StoreLocalMessagesHolder$init$type$1
                }.getType()) : Maps6.emptyMap()).entrySet()) {
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    this.messages.put(Long.valueOf(jLongValue), new TreeMap<>(MessageUtils.getSORT_BY_IDS_COMPARATOR()));
                    TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(jLongValue));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    for (Message message : (List) entry.getValue()) {
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

    @Store3
    public final void deleteMessage(long channelId, String nonce) {
        Object next;
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            Intrinsics3.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            Collection<Message> collectionValues = treeMap.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "messagesForChannel.values");
            Iterator<T> it = collectionValues.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((Message) next).getNonce(), nonce));
            Message message = (Message) next;
            if (message != null) {
                Intrinsics3.checkNotNullExpressionValue(message, "messagesForChannel.value…once == nonce } ?: return");
                deleteMessage(message);
            }
        }
    }
}
