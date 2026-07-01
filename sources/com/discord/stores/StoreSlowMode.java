package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OnSubscribeRefCount3;
import j0.l.a.OperatorTakeWhile;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action0;
import rx.subjects.BehaviorSubject;

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
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        HashMap<Long, Long> map = new HashMap<>();
        this.messageSendNextSendTimes = map;
        this.messageSendNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map));
        HashMap<Long, Long> map2 = new HashMap<>();
        this.threadCreateNextSendTimes = map2;
        this.threadCreateNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map2));
        this.channelMessageSendCooldownObservables = new HashMap<>();
        this.channelThreadCreateCooldownObservables = new HashMap<>();
    }

    private final synchronized Observable<Integer> getChannelCooldownObservable(final long channelId, final Type type) {
        Type.MessageSend messageSend = Type.MessageSend.INSTANCE;
        Observable<Integer> observable = Intrinsics3.areEqual(type, messageSend) ? this.channelMessageSendCooldownObservables.get(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.get(Long.valueOf(channelId));
        if (observable != null) {
            return observable;
        }
        Observable<Integer> observableH0 = Observable.h0(new OnSubscribeRefCount3(this.stream.getPermissions().observePermissionsForChannel(channelId).G(new Func1<Long, Boolean>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$1
            @Override // j0.k.Func1
            public final Boolean call(Long l) {
                return Boolean.valueOf(PermissionUtils.INSTANCE.hasBypassSlowmodePermissions(l, type));
            }
        }).r().Y(new Func1<Boolean, Observable<? extends Long>>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2
            @Override // j0.k.Func1
            public final Observable<? extends Long> call(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
                if (bool.booleanValue()) {
                    return new ScalarSynchronousObservable(0L);
                }
                return (Intrinsics3.areEqual(type, StoreSlowMode.Type.MessageSend.INSTANCE) ? this.this$0.messageSendNextSendTimesSubject : this.this$0.threadCreateNextSendTimesSubject).G(new Func1<HashMap<Long, Long>, Long>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2.1
                    @Override // j0.k.Func1
                    public final Long call(HashMap<Long, Long> map) {
                        return map.get(Long.valueOf(channelId));
                    }
                }).Y(new Func1<Long, Observable<? extends Long>>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2.2
                    @Override // j0.k.Func1
                    public final Observable<? extends Long> call(final Long l) {
                        final long jCurrentTimeMillis = StoreSlowMode3.this.this$0.clock.currentTimeMillis();
                        if (l == null || l.longValue() <= jCurrentTimeMillis) {
                            return new ScalarSynchronousObservable(0L);
                        }
                        Observable<R> observableG = Observable.E(0L, 1L, TimeUnit.SECONDS).G(new Func1<Long, Long>() { // from class: com.discord.stores.StoreSlowMode.getChannelCooldownObservable.newObservable.2.2.1
                            @Override // j0.k.Func1
                            public final Long call(Long l2) {
                                return Long.valueOf(l.longValue() - (jCurrentTimeMillis + (l2.longValue() * 1000)));
                            }
                        });
                        return Observable.h0(new OnSubscribeLift(observableG.j, new OperatorTakeWhile(new Func1<Long, Boolean>() { // from class: com.discord.stores.StoreSlowMode.getChannelCooldownObservable.newObservable.2.2.2
                            @Override // j0.k.Func1
                            public final Boolean call(Long l2) {
                                return Boolean.valueOf(l2.longValue() >= 0);
                            }
                        })));
                    }
                });
            }
        }).G(new Func1<Long, Integer>() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$3
            @Override // j0.k.Func1
            public final Integer call(Long l) {
                return Integer.valueOf((int) (l.longValue() / ((long) 1000)));
            }
        }).w(new Action0() { // from class: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$4
            @Override // rx.functions.Action0
            public final void call() {
                this.this$0.removeChannelCooldownObservable(channelId, type);
            }
        }).N(1)));
        if (Intrinsics3.areEqual(type, messageSend)) {
            HashMap<Long, Observable<Integer>> map = this.channelMessageSendCooldownObservables;
            Long lValueOf = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map.put(lValueOf, observableH0);
        } else {
            HashMap<Long, Observable<Integer>> map2 = this.channelThreadCreateCooldownObservables;
            Long lValueOf2 = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map2.put(lValueOf2, observableH0);
        }
        return observableH0;
    }

    @Store3
    private final void onCooldownInternal(long channelId, long cooldownMs, Type type) {
        if (Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE)) {
            this.messageSendNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.messageSendNextSendTimesSubject.onNext(new HashMap<>(this.messageSendNextSendTimes));
        } else {
            this.threadCreateNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.threadCreateNextSendTimesSubject.onNext(new HashMap<>(this.threadCreateNextSendTimes));
        }
    }

    private final synchronized Observable<Integer> removeChannelCooldownObservable(long channelId, Type type) {
        return Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE) ? this.channelMessageSendCooldownObservables.remove(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.remove(Long.valueOf(channelId));
    }

    public final Observable<Integer> observeCooldownSecs(Long channelId, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (channelId != null) {
            return getChannelCooldownObservable(channelId.longValue(), type);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(0);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(0)");
        return scalarSynchronousObservable;
    }

    @Store3
    public final void onCooldown(long channelId, long cooldownMs, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        onCooldownInternal(channelId, cooldownMs + 1000, type);
    }

    @Store3
    public final void onMessageSent(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(channelId, ((long) rateLimitPerUser) * 1000, Type.MessageSend.INSTANCE);
        }
    }

    @Store3
    public final void onThreadCreated(long parentChannelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(parentChannelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(parentChannelId, ((long) rateLimitPerUser) * 1000, Type.ThreadCreate.INSTANCE);
        }
    }
}
