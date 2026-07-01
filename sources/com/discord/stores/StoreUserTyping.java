package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TypingUser, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class C01921 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ TypingUser $prevTyping;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01921(TypingUser typingUser) {
                super(0);
                this.$prevTyping = typingUser;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserTyping storeUserTyping = StoreUserTyping.this;
                TypingUser typingUser = this.$prevTyping;
                Intrinsics3.checkNotNullExpressionValue(typingUser, "prevTyping");
                storeUserTyping.handleTypingStop(typingUser);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            StoreUserTyping.this.dispatcher.schedule(new C01921(typingUser));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = (Map) StoreUserTyping.this.typingUsersRemoveCallbacks.get(Long.valueOf(AnonymousClass2.this.$channelId));
                if (map != null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreUserTyping.this.dispatcher.schedule(new AnonymousClass1(subscription));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Set<? extends Long>> invoke() {
            return StoreUserTyping.this.getTypingUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Set<? extends Long>> invoke() {
            return StoreUserTyping.this.getTypingUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelTypingResponse, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class C01931 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $messageSendCooldownSecs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01931(long j) {
                super(0);
                this.$messageSendCooldownSecs = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(AnonymousClass1.this.$channelId, this.$messageSendCooldownSecs, StoreSlowMode.Type.MessageSend.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $threadCreateCooldown;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(long j) {
                super(0);
                this.$threadCreateCooldown = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(AnonymousClass1.this.$channelId, this.$threadCreateCooldown, StoreSlowMode.Type.ThreadCreate.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelTypingResponse modelTypingResponse) {
            invoke2(modelTypingResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelTypingResponse modelTypingResponse) {
            Long threadCreateCooldownMs;
            Long messageSendCooldownMs;
            long jLongValue = (modelTypingResponse == null || (messageSendCooldownMs = modelTypingResponse.getMessageSendCooldownMs()) == null) ? 0L : messageSendCooldownMs.longValue();
            if (jLongValue > 0) {
                StoreUserTyping.this.dispatcher.schedule(new C01931(jLongValue));
            }
            long jLongValue2 = (modelTypingResponse == null || (threadCreateCooldownMs = modelTypingResponse.getThreadCreateCooldownMs()) == null) ? 0L : threadCreateCooldownMs.longValue();
            if (jLongValue2 > 0) {
                StoreUserTyping.this.dispatcher.schedule(new AnonymousClass2(jLongValue2));
            }
        }
    }

    public /* synthetic */ StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsersSnapshot;
    }

    @Store3
    private final void handleTypingStop(TypingUser typing) {
        Set<Long> set = this.typingUsers.get(Long.valueOf(typing.getChannelId()));
        if (set != null) {
            Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[typing.channelId] ?: return");
            if (set.remove(Long.valueOf(typing.getUserId()))) {
                markChanged();
            }
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author != null) {
            long id2 = author.getId();
            Set<Long> set = this.typingUsers.get(Long.valueOf(message.getChannelId()));
            if (set != null) {
                Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[message.channelId] ?: return");
                if (set.remove(Long.valueOf(id2))) {
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleTypingStart(TypingUser typing) {
        Intrinsics3.checkNotNullParameter(typing, "typing");
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
        Observable<T> observableQ = new ScalarSynchronousObservable(typing).q(10L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable\n        .just…lay(10, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe(observableQ, (117 & 1) != 0 ? null : null, "typingRemove", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new AnonymousClass2(channelId, userId)), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
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

    public final Observable<Set<Long>> observeTypingUsers(final long channelId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new Func1<Map<Long, ? extends Set<? extends Long>>, Set<? extends Long>>() { // from class: com.discord.stores.StoreUserTyping.observeTypingUsers.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Set<? extends Long>> map) {
                return call2((Map<Long, ? extends Set<Long>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, ? extends Set<Long>> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
                Set<Long> setEmptySet = map.get(Long.valueOf(channelId));
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                return setEmptySet;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Set<Long>>> observeTypingUsersForChannels(final Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        Observable<Map<Long, Set<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new Func1<Map<Long, ? extends Set<? extends Long>>, Map<Long, ? extends Set<? extends Long>>>() { // from class: com.discord.stores.StoreUserTyping.observeTypingUsersForChannels.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> call(Map<Long, ? extends Set<? extends Long>> map) {
                return call2((Map<Long, ? extends Set<Long>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Set<Long>> call2(Map<Long, ? extends Set<Long>> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, ? extends Set<Long>> entry : map.entrySet()) {
                    if (channelIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setUserTyping(long channelId) {
        if (channelId == 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.setUserTyping(channelId, new RestAPIParams.EmptyBody()), false, 1, null), (117 & 1) != 0 ? null : null, "typingEvent", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(channelId), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Set<Long>> entry : this.typingUsers.entrySet()) {
            map.put(Long.valueOf(entry.getKey().longValue()), new HashSet(entry.getValue()));
        }
        this.typingUsersSnapshot = map;
    }

    public StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.typingUsersRemoveCallbacks = new HashMap<>();
        this.typingUsers = new HashMap<>();
        this.typingUsersSnapshot = Maps6.emptyMap();
    }
}
