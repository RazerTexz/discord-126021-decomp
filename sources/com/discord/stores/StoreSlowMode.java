package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12607c0;
import p637j0.p642l.p643a.C12633i2;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action0;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode extends Store {

    @Deprecated
    private static final long COOLDOWN_BUFFER_MS = 1000;
    private static final Companion Companion = new Companion(null);
    private final HashMap<Long, Observable<Integer>> channelMessageSendCooldownObservables;
    private final HashMap<Long, Observable<Integer>> channelThreadCreateCooldownObservables;
    private final Clock clock;
    private final HashMap<Long, Long> messageSendNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> messageSendNextSendTimesSubject;
    private final StoreStream stream;
    private final HashMap<Long, Long> threadCreateNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> threadCreateNextSendTimesSubject;

    /* JADX INFO: compiled from: StoreSlowMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreSlowMode.kt */
    public static abstract class Type {

        /* JADX INFO: compiled from: StoreSlowMode.kt */
        public static final class MessageSend extends Type {
            public static final MessageSend INSTANCE = new MessageSend();

            private MessageSend() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreSlowMode.kt */
        public static final class ThreadCreate extends Type {
            public static final ThreadCreate INSTANCE = new ThreadCreate();

            private ThreadCreate() {
                super(null);
            }
        }

        private Type() {
        }

        public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StoreSlowMode(Clock clock, StoreStream storeStream) {
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        HashMap<Long, Long> map = new HashMap<>();
        this.messageSendNextSendTimes = map;
        this.messageSendNextSendTimesSubject = BehaviorSubject.m11130l0(new HashMap(map));
        HashMap<Long, Long> map2 = new HashMap<>();
        this.threadCreateNextSendTimes = map2;
        this.threadCreateNextSendTimesSubject = BehaviorSubject.m11130l0(new HashMap(map2));
        this.channelMessageSendCooldownObservables = new HashMap<>();
        this.channelThreadCreateCooldownObservables = new HashMap<>();
    }

    private final synchronized Observable<Integer> getChannelCooldownObservable(final long channelId, final Type type) {
        Type.MessageSend messageSend = Type.MessageSend.INSTANCE;
        Observable<Integer> observable = C12238m.areEqual(type, messageSend) ? this.channelMessageSendCooldownObservables.get(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.get(Long.valueOf(channelId));
        if (observable != null) {
            return observable;
        }
        Observable<Integer> observableM11074h0 = Observable.m11074h0(new C12607c0(this.stream.getPermissions().observePermissionsForChannel(channelId).m11083G(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Long l) {
                return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, type));
            }
        }).m11112r().m11099Y(new InterfaceC12589b<Boolean, Observable<? extends Long>>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Long> call(Boolean bool) {
                C12238m.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
                if (bool.booleanValue()) {
                    return new C12721k(0L);
                }
                return (C12238m.areEqual(type, StoreSlowMode.Type.MessageSend.INSTANCE) ? this.this$0.messageSendNextSendTimesSubject : this.this$0.threadCreateNextSendTimesSubject).m11083G(new InterfaceC12589b<HashMap<Long, Long>, Long>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Long call(HashMap<Long, Long> map) {
                        return map.get(Long.valueOf(channelId));
                    }
                }).m11099Y(new InterfaceC12589b<Long, Observable<? extends Long>>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Long> call(final Long l) {
                        final long jCurrentTimeMillis = StoreSlowMode$getChannelCooldownObservable$newObservable$2.this.this$0.clock.currentTimeMillis();
                        if (l == null || l.longValue() <= jCurrentTimeMillis) {
                            return new C12721k(0L);
                        }
                        Observable<R> observableM11083G = Observable.m11061E(0L, 1L, TimeUnit.SECONDS).m11083G(new InterfaceC12589b<Long, Long>() { // from class: com.discord.stores.StoreSlowMode.getChannelCooldownObservable.newObservable.2.2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Long call(Long l2) {
                                return Long.valueOf(l.longValue() - (jCurrentTimeMillis + (l2.longValue() * 1000)));
                            }
                        });
                        return Observable.m11074h0(new C12666r(observableM11083G.f27640j, new C12633i2(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.stores.StoreSlowMode.getChannelCooldownObservable.newObservable.2.2.2
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Boolean call(Long l2) {
                                return Boolean.valueOf(l2.longValue() >= 0);
                            }
                        })));
                    }
                });
            }
        }).m11083G(new InterfaceC12589b<Long, Integer>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Integer call(Long l) {
                return Integer.valueOf((int) (l.longValue() / ((long) 1000)));
            }
        }).m11117w(new Action0() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$4
            @Override // p658rx.functions.Action0
            public final void call() {
                this.this$0.removeChannelCooldownObservable(channelId, type);
            }
        }).m11088N(1)));
        if (C12238m.areEqual(type, messageSend)) {
            HashMap<Long, Observable<Integer>> map = this.channelMessageSendCooldownObservables;
            Long lValueOf = Long.valueOf(channelId);
            C12238m.checkNotNullExpressionValue(observableM11074h0, "newObservable");
            map.put(lValueOf, observableM11074h0);
        } else {
            HashMap<Long, Observable<Integer>> map2 = this.channelThreadCreateCooldownObservables;
            Long lValueOf2 = Long.valueOf(channelId);
            C12238m.checkNotNullExpressionValue(observableM11074h0, "newObservable");
            map2.put(lValueOf2, observableM11074h0);
        }
        return observableM11074h0;
    }

    @StoreThread
    private final void onCooldownInternal(long channelId, long cooldownMs, Type type) {
        if (C12238m.areEqual(type, Type.MessageSend.INSTANCE)) {
            this.messageSendNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.messageSendNextSendTimesSubject.onNext(new HashMap<>(this.messageSendNextSendTimes));
        } else {
            this.threadCreateNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.threadCreateNextSendTimesSubject.onNext(new HashMap<>(this.threadCreateNextSendTimes));
        }
    }

    private final synchronized Observable<Integer> removeChannelCooldownObservable(long channelId, Type type) {
        return C12238m.areEqual(type, Type.MessageSend.INSTANCE) ? this.channelMessageSendCooldownObservables.remove(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.remove(Long.valueOf(channelId));
    }

    public final Observable<Integer> observeCooldownSecs(Long channelId, Type type) {
        C12238m.checkNotNullParameter(type, "type");
        if (channelId != null) {
            return getChannelCooldownObservable(channelId.longValue(), type);
        }
        C12721k c12721k = new C12721k(0);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(0)");
        return c12721k;
    }

    @StoreThread
    public final void onCooldown(long channelId, long cooldownMs, Type type) {
        C12238m.checkNotNullParameter(type, "type");
        onCooldownInternal(channelId, cooldownMs + 1000, type);
    }

    @StoreThread
    public final void onMessageSent(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(channelId, ((long) rateLimitPerUser) * 1000, Type.MessageSend.INSTANCE);
        }
    }

    @StoreThread
    public final void onThreadCreated(long parentChannelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(parentChannelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(parentChannelId, ((long) rateLimitPerUser) * 1000, Type.ThreadCreate.INSTANCE);
        }
    }
}
