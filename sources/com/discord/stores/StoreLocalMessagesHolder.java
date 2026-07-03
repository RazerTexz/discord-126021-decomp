package com.discord.stores;

import android.content.SharedPreferences;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import p007b.p008a.p017b.C0850a;
import p007b.p225i.p408d.C4901e;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: StoreLocalMessagesHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLocalMessagesHolder {
    private boolean cacheEnabled;
    private final Gson gson;
    private SharedPreferences sharedPreferences;
    private final HashMap<Long, TreeMap<Long, Message>> messages = new HashMap<>();
    private final Subject<Map<Long, List<Message>>, Map<Long, List<Message>>> messagesPublisher = new SerializedSubject(BehaviorSubject.m11129k0());
    private Map<Long, ? extends List<Message>> messagesSnapshot = C12136h0.emptyMap();
    private Map<Long, ? extends List<Message>> cacheSnapshot = C12136h0.emptyMap();
    private final Set<Long> updatedChannels = new HashSet();

    public StoreLocalMessagesHolder() {
        C4901e c4901e = new C4901e();
        C0850a.m147a(c4901e);
        this.gson = c4901e.m6851a();
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
            for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
                Long key = entry.getKey();
                Collection<Message> collectionValues = entry.getValue().values();
                C12238m.checkNotNullExpressionValue(collectionValues, "entry.value.values");
                map.put(key, C12163u.toList(collectionValues));
            }
            if (!C12238m.areEqual(this.cacheSnapshot, map)) {
                this.cacheSnapshot = map;
                String strM9209m = this.gson.m9209m(map);
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences == null) {
                    C12238m.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                sharedPreferences.edit().putString("STORE_LOCAL_MESSAGES_CACHE_V11", strM9209m).apply();
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
                    collectionEmptyList = C12147n.emptyList();
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
        C12238m.checkNotNullParameter(message, "message");
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
        for (Map.Entry<Long, TreeMap<Long, Message>> entry : this.messages.entrySet()) {
            Long key = entry.getKey();
            TreeMap<Long, Message> value = entry.getValue();
            Set<Long> set = this.updatedChannels;
            C12238m.checkNotNullExpressionValue(key, "channelId");
            set.add(key);
            value.clear();
        }
        publishIfUpdated$default(this, false, 1, null);
    }

    @StoreThread
    public final void deleteMessage(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        long id2 = message.getId();
        long channelId = message.getChannelId();
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            C12238m.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
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
        return C12149o.flatten(this.messagesSnapshot.values());
    }

    @StoreThread
    public final Message getMessage(long channelId, String nonce) {
        Collection<Message> collectionValues;
        C12238m.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        Object obj = null;
        if (treeMap == null || (collectionValues = treeMap.values()) == null) {
            return null;
        }
        for (Object obj2 : collectionValues) {
            if (C12238m.areEqual(((Message) obj2).getNonce(), nonce)) {
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
                    C12238m.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                String string = sharedPreferences.getString("STORE_LOCAL_MESSAGES_CACHE_V11", null);
                for (Map.Entry entry : (string != null ? (Map) this.gson.m9203g(string, new TypeToken<Map<Long, ? extends List<? extends Message>>>() { // from class: com.discord.stores.StoreLocalMessagesHolder$init$type$1
                }.getType()) : C12136h0.emptyMap()).entrySet()) {
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
                Logger.e$default(AppLog.f14950g, "Error restoring cached local messages", e, null, 4, null);
            }
        }
        this.cacheEnabled = cacheEnabled;
        publishIfUpdated(true);
    }

    @StoreThread
    public final void deleteMessage(long channelId, String nonce) {
        Object next;
        C12238m.checkNotNullParameter(nonce, "nonce");
        TreeMap<Long, Message> treeMap = this.messages.get(Long.valueOf(channelId));
        if (treeMap != null) {
            C12238m.checkNotNullExpressionValue(treeMap, "messages[channelId] ?: return");
            Collection<Message> collectionValues = treeMap.values();
            C12238m.checkNotNullExpressionValue(collectionValues, "messagesForChannel.values");
            Iterator<T> it = collectionValues.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!C12238m.areEqual(((Message) next).getNonce(), nonce));
            Message message = (Message) next;
            if (message != null) {
                C12238m.checkNotNullExpressionValue(message, "messagesForChannel.value…once == nonce } ?: return");
                deleteMessage(message);
            }
        }
    }
}
