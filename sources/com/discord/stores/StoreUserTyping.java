package com.discord.stores;

import android.content.Context;
import com.discord.api.message.Message;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private final HashMap<Long, Set<Long>> typingUsers;
    private final HashMap<Long, Map<Long, Subscription>> typingUsersRemoveCallbacks;
    private Map<Long, ? extends Set<Long>> typingUsersSnapshot;

    public /* synthetic */ StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.dispatcher;
    }

    public static final /* synthetic */ Map access$getTypingUsers(StoreUserTyping storeUserTyping) {
        return storeUserTyping.getTypingUsers();
    }

    public static final /* synthetic */ HashMap access$getTypingUsersRemoveCallbacks$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.typingUsersRemoveCallbacks;
    }

    public static final /* synthetic */ void access$handleTypingStop(StoreUserTyping storeUserTyping, TypingUser typingUser) {
        storeUserTyping.handleTypingStop(typingUser);
    }

    private final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsersSnapshot;
    }

    @StoreThread
    private final void handleTypingStop(TypingUser typing) {
        Set<Long> set = this.typingUsers.get(Long.valueOf(typing.getChannelId()));
        if (set != null) {
            m.checkNotNullExpressionValue(set, "typingUsers[typing.channelId] ?: return");
            if (set.remove(Long.valueOf(typing.getUserId()))) {
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        m.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author != null) {
            long id2 = author.getId();
            Set<Long> set = this.typingUsers.get(Long.valueOf(message.getChannelId()));
            if (set != null) {
                m.checkNotNullExpressionValue(set, "typingUsers[message.channelId] ?: return");
                if (set.remove(Long.valueOf(id2))) {
                    markChanged();
                }
            }
        }
    }

    @StoreThread
    public final void handleTypingStart(TypingUser typing) {
        m.checkNotNullParameter(typing, "typing");
        long id2 = this.stream.getUsers().getMe().getId();
        long userId = typing.getUserId();
        if (id2 == userId) {
            return;
        }
        long channelId = typing.getChannelId();
        HashMap<Long, Map<Long, Subscription>> map = this.typingUsersRemoveCallbacks;
        Long lValueOf = Long.valueOf(channelId);
        Map<Long, Subscription> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Subscription subscription = map2.get(Long.valueOf(userId));
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<T> observableQ = new k(typing).q(10L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableQ, "Observable\n        .just…lay(10, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableQ, (Context) null, "typingRemove", new StoreUserTyping$handleTypingStart$2(this, channelId, userId), new StoreUserTyping$handleTypingStart$1(this), (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
        HashMap<Long, Set<Long>> map3 = this.typingUsers;
        Long lValueOf2 = Long.valueOf(channelId);
        Set<Long> hashSet = map3.get(lValueOf2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map3.put(lValueOf2, hashSet);
        }
        if (hashSet.add(Long.valueOf(userId))) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeTypingUsers(long channelId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserTyping$observeTypingUsers$1(this), 14, null).G(new StoreUserTyping$observeTypingUsers$2(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Set<Long>>> observeTypingUsersForChannels(Set<Long> channelIds) {
        m.checkNotNullParameter(channelIds, "channelIds");
        Observable<Map<Long, Set<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserTyping$observeTypingUsersForChannels$1(this), 14, null).G(new StoreUserTyping$observeTypingUsersForChannels$2(channelIds)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setUserTyping(long channelId) {
        if (channelId == 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.setUserTyping(channelId, new RestAPIParams$EmptyBody()), false, 1, null), (Context) null, "typingEvent", (Function1) null, new StoreUserTyping$setUserTyping$1(this, channelId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map$Entry<Long, Set<Long>> map$Entry : this.typingUsers.entrySet()) {
            map.put(Long.valueOf(map$Entry.getKey().longValue()), new HashSet(map$Entry.getValue()));
        }
        this.typingUsersSnapshot = map;
    }

    public StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.typingUsersRemoveCallbacks = new HashMap<>();
        this.typingUsers = new HashMap<>();
        this.typingUsersSnapshot = h0.emptyMap();
    }
}
