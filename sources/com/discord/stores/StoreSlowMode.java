package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import j0.l.a.c0;
import j0.l.e.k;
import java.util.HashMap;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode extends Store {

    @Deprecated
    private static final long COOLDOWN_BUFFER_MS = 1000;
    private static final StoreSlowMode$Companion Companion = new StoreSlowMode$Companion(null);
    private final HashMap<Long, Observable<Integer>> channelMessageSendCooldownObservables;
    private final HashMap<Long, Observable<Integer>> channelThreadCreateCooldownObservables;
    private final Clock clock;
    private final HashMap<Long, Long> messageSendNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> messageSendNextSendTimesSubject;
    private final StoreStream stream;
    private final HashMap<Long, Long> threadCreateNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> threadCreateNextSendTimesSubject;

    public StoreSlowMode(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
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

    public static final /* synthetic */ Clock access$getClock$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getMessageSendNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.messageSendNextSendTimesSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getThreadCreateNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.threadCreateNextSendTimesSubject;
    }

    public static final /* synthetic */ Observable access$removeChannelCooldownObservable(StoreSlowMode storeSlowMode, long j, StoreSlowMode$Type storeSlowMode$Type) {
        return storeSlowMode.removeChannelCooldownObservable(j, storeSlowMode$Type);
    }

    private final synchronized Observable<Integer> getChannelCooldownObservable(long channelId, StoreSlowMode$Type type) {
        StoreSlowMode$Type$MessageSend storeSlowMode$Type$MessageSend = StoreSlowMode$Type$MessageSend.INSTANCE;
        Observable<Integer> observable = m.areEqual(type, storeSlowMode$Type$MessageSend) ? this.channelMessageSendCooldownObservables.get(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.get(Long.valueOf(channelId));
        if (observable != null) {
            return observable;
        }
        Observable<Integer> observableH0 = Observable.h0(new c0(this.stream.getPermissions().observePermissionsForChannel(channelId).G(new StoreSlowMode$getChannelCooldownObservable$newObservable$1(type)).r().Y(new StoreSlowMode$getChannelCooldownObservable$newObservable$2(this, type, channelId)).G(StoreSlowMode$getChannelCooldownObservable$newObservable$3.INSTANCE).w(new StoreSlowMode$getChannelCooldownObservable$newObservable$4(this, channelId, type)).N(1)));
        if (m.areEqual(type, storeSlowMode$Type$MessageSend)) {
            HashMap<Long, Observable<Integer>> map = this.channelMessageSendCooldownObservables;
            Long lValueOf = Long.valueOf(channelId);
            m.checkNotNullExpressionValue(observableH0, "newObservable");
            map.put(lValueOf, observableH0);
        } else {
            HashMap<Long, Observable<Integer>> map2 = this.channelThreadCreateCooldownObservables;
            Long lValueOf2 = Long.valueOf(channelId);
            m.checkNotNullExpressionValue(observableH0, "newObservable");
            map2.put(lValueOf2, observableH0);
        }
        return observableH0;
    }

    @StoreThread
    private final void onCooldownInternal(long channelId, long cooldownMs, StoreSlowMode$Type type) {
        if (m.areEqual(type, StoreSlowMode$Type$MessageSend.INSTANCE)) {
            this.messageSendNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.messageSendNextSendTimesSubject.onNext(new HashMap<>(this.messageSendNextSendTimes));
        } else {
            this.threadCreateNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.threadCreateNextSendTimesSubject.onNext(new HashMap<>(this.threadCreateNextSendTimes));
        }
    }

    private final synchronized Observable<Integer> removeChannelCooldownObservable(long channelId, StoreSlowMode$Type type) {
        return m.areEqual(type, StoreSlowMode$Type$MessageSend.INSTANCE) ? this.channelMessageSendCooldownObservables.remove(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.remove(Long.valueOf(channelId));
    }

    public final Observable<Integer> observeCooldownSecs(Long channelId, StoreSlowMode$Type type) {
        m.checkNotNullParameter(type, "type");
        if (channelId != null) {
            return getChannelCooldownObservable(channelId.longValue(), type);
        }
        k kVar = new k(0);
        m.checkNotNullExpressionValue(kVar, "Observable.just(0)");
        return kVar;
    }

    @StoreThread
    public final void onCooldown(long channelId, long cooldownMs, StoreSlowMode$Type type) {
        m.checkNotNullParameter(type, "type");
        onCooldownInternal(channelId, cooldownMs + 1000, type);
    }

    @StoreThread
    public final void onMessageSent(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(channelId, ((long) rateLimitPerUser) * 1000, StoreSlowMode$Type$MessageSend.INSTANCE);
        }
    }

    @StoreThread
    public final void onThreadCreated(long parentChannelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(parentChannelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(parentChannelId, ((long) rateLimitPerUser) * 1000, StoreSlowMode$Type$ThreadCreate.INSTANCE);
        }
    }
}
