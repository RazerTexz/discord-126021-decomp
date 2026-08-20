package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
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
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1 */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class C66101 extends AbstractC12240o implements Function1<TypingUser, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ TypingUser $prevTyping;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TypingUser typingUser) {
                super(0);
                this.$prevTyping = typingUser;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserTyping storeUserTyping = StoreUserTyping.this;
                TypingUser typingUser = this.$prevTyping;
                C12238m.checkNotNullExpressionValue(typingUser, "prevTyping");
                storeUserTyping.handleTypingStop(typingUser);
            }
        }

        public C66101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            StoreUserTyping.this.dispatcher.schedule(new AnonymousClass1(typingUser));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2 */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class C66112 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = (Map) StoreUserTyping.this.typingUsersRemoveCallbacks.get(Long.valueOf(C66112.this.$channelId));
                if (map != null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66112(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreUserTyping.this.dispatcher.schedule(new AnonymousClass1(subscription));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$1 */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class C66121 extends AbstractC12240o implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public C66121() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Set<? extends Long>> invoke() {
            return StoreUserTyping.this.getTypingUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$1 */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class C66141 extends AbstractC12240o implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public C66141() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Set<? extends Long>> invoke() {
            return StoreUserTyping.this.getTypingUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1 */
    /* JADX INFO: compiled from: StoreUserTyping.kt */
    public static final class C66161 extends AbstractC12240o implements Function1<ModelTypingResponse, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ long $messageSendCooldownSecs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j) {
                super(0);
                this.$messageSendCooldownSecs = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(C66161.this.$channelId, this.$messageSendCooldownSecs, StoreSlowMode.Type.MessageSend.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserTyping.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ long $threadCreateCooldown;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(long j) {
                super(0);
                this.$threadCreateCooldown = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(C66161.this.$channelId, this.$threadCreateCooldown, StoreSlowMode.Type.ThreadCreate.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66161(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelTypingResponse modelTypingResponse) {
            invoke2(modelTypingResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelTypingResponse modelTypingResponse) {
            Long threadCreateCooldownMs;
            Long messageSendCooldownMs;
            long jLongValue = (modelTypingResponse == null || (messageSendCooldownMs = modelTypingResponse.getMessageSendCooldownMs()) == null) ? 0L : messageSendCooldownMs.longValue();
            if (jLongValue > 0) {
                StoreUserTyping.this.dispatcher.schedule(new AnonymousClass1(jLongValue));
            }
            long jLongValue2 = (modelTypingResponse == null || (threadCreateCooldownMs = modelTypingResponse.getThreadCreateCooldownMs()) == null) ? 0L : threadCreateCooldownMs.longValue();
            if (jLongValue2 > 0) {
                StoreUserTyping.this.dispatcher.schedule(new AnonymousClass2(jLongValue2));
            }
        }
    }

    public /* synthetic */ StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsersSnapshot;
    }

    @StoreThread
    private final void handleTypingStop(TypingUser typing) {
        Set<Long> set = this.typingUsers.get(Long.valueOf(typing.getChannelId()));
        if (set != null) {
            C12238m.checkNotNullExpressionValue(set, "typingUsers[typing.channelId] ?: return");
            if (set.remove(Long.valueOf(typing.getUserId()))) {
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author != null) {
            long id2 = author.getId();
            Set<Long> set = this.typingUsers.get(Long.valueOf(message.getChannelId()));
            if (set != null) {
                C12238m.checkNotNullExpressionValue(set, "typingUsers[message.channelId] ?: return");
                if (set.remove(Long.valueOf(id2))) {
                    markChanged();
                }
            }
        }
    }

    @StoreThread
    public final void handleTypingStart(TypingUser typing) {
        C12238m.checkNotNullParameter(typing, "typing");
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
        Observable<T> observableM11111q = new C12721k(typing).m11111q(10L, TimeUnit.SECONDS);
        C12238m.checkNotNullExpressionValue(observableM11111q, "Observable\n        .just…lay(10, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe(observableM11111q, (117 & 1) != 0 ? null : null, "typingRemove", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new C66112(channelId, userId)), new C66101(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
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
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66121(), 14, null).m11083G(new InterfaceC12589b<Map<Long, ? extends Set<? extends Long>>, Set<? extends Long>>() { // from class: com.discord.stores.StoreUserTyping.observeTypingUsers.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Set<? extends Long>> map) {
                return call2((Map<Long, ? extends Set<Long>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Set<Long> call2(Map<Long, ? extends Set<Long>> map) {
                C12238m.checkNotNullExpressionValue(map, "typingUsersByChannel");
                Set<Long> setEmptySet = map.get(Long.valueOf(channelId));
                if (setEmptySet == null) {
                    setEmptySet = C12148n0.emptySet();
                }
                return setEmptySet;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Set<Long>>> observeTypingUsersForChannels(final Set<Long> channelIds) {
        C12238m.checkNotNullParameter(channelIds, "channelIds");
        Observable<Map<Long, Set<Long>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66141(), 14, null).m11083G(new InterfaceC12589b<Map<Long, ? extends Set<? extends Long>>, Map<Long, ? extends Set<? extends Long>>>() { // from class: com.discord.stores.StoreUserTyping.observeTypingUsersForChannels.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> call(Map<Long, ? extends Set<? extends Long>> map) {
                return call2((Map<Long, ? extends Set<Long>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Set<Long>> call2(Map<Long, ? extends Set<Long>> map) {
                C12238m.checkNotNullExpressionValue(map, "typingUsersByChannel");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, ? extends Set<Long>> entry : map.entrySet()) {
                    if (channelIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setUserTyping(long channelId) {
        if (channelId == 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.setUserTyping(channelId, new RestAPIParams.EmptyBody()), false, 1, null), (117 & 1) != 0 ? null : null, "typingEvent", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C66161(channelId), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Set<Long>> entry : this.typingUsers.entrySet()) {
            map.put(Long.valueOf(entry.getKey().longValue()), new HashSet(entry.getValue()));
        }
        this.typingUsersSnapshot = map;
    }

    public StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.typingUsersRemoveCallbacks = new HashMap<>();
        this.typingUsers = new HashMap<>();
        this.typingUsersSnapshot = C12136h0.emptyMap();
    }
}
