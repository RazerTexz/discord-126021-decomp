package com.discord.stores;

import android.content.Context;
import b.a.d.a0;
import b.a.d.b0;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.application.Unread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.time.Clock;
import d0.t.ReversedViews3;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Actions2;
import j0.k.Func1;
import j0.l.a.OnSubscribeDoOnEach;
import j0.l.e.ActionObserver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func9;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates extends Store {
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> markAsRead;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadChannelIds;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadGuildIds;
    private final Persister<Unread> unreadMessageMarker;

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$clearMarker$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unread, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persister = StoreReadStates.this.unreadMessageMarker;
            Intrinsics3.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persister, unread, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function9<Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends ModelNotificationSettings>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends Long>, Long, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public AnonymousClass1(StoreReadStates storeReadStates) {
            super(9, storeReadStates, StoreReadStates.class, "computeUnreadIds", "computeUnreadIds(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> invoke(Map<Long, ? extends Long> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, ? extends StoreMessageAck.Ack> map5, Map<Long, ? extends Long> map6, Long l, Map<Long, ? extends Channel> map7, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            return invoke((Map<Long, Long>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3, map4, (Map<Long, StoreMessageAck.Ack>) map5, (Map<Long, Long>) map6, l.longValue(), (Map<Long, Channel>) map7, (Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map8);
        }

        public final Tuples2<Set<Long>, Set<Long>> invoke(Map<Long, Long> map, Map<Long, Channel> map2, Map<Long, Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, StoreMessageAck.Ack> map5, Map<Long, Long> map6, long j, Map<Long, Channel> map7, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            Intrinsics3.checkNotNullParameter(map, "p1");
            Intrinsics3.checkNotNullParameter(map2, "p2");
            Intrinsics3.checkNotNullParameter(map3, "p3");
            Intrinsics3.checkNotNullParameter(map4, "p4");
            Intrinsics3.checkNotNullParameter(map5, "p5");
            Intrinsics3.checkNotNullParameter(map6, "p6");
            Intrinsics3.checkNotNullParameter(map7, "p8");
            Intrinsics3.checkNotNullParameter(map8, "p9");
            return ((StoreReadStates) this.receiver).computeUnreadIds(map, map2, map3, map4, map5, map6, j, map7, map8);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2) {
            invoke2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2) {
            Set<Long> setComponent1 = tuples2.component1();
            Set<Long> setComponent2 = tuples2.component2();
            StoreReadStates.this.unreadChannelIds.k.onNext((T) setComponent1);
            StoreReadStates.this.unreadGuildIds.k.onNext((T) setComponent2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Observable<Unread.Marker>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(final long j) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getMessageAck().observeAll().G(new Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                    return call2((Map<Long, StoreMessageAck.Ack>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                    return map.get(Long.valueOf(j));
                }
            }).Z(1), companion.getMessageAck().observeAll().G(new Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                    return call2((Map<Long, StoreMessageAck.Ack>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                    return map.get(Long.valueOf(j));
                }
            }), companion.getMessagesMostRecent().observeRecentMessageIds(j).Z(1), new Func3<StoreMessageAck.Ack, StoreMessageAck.Ack, Long, Unread.Marker>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.3
                @Override // rx.functions.Func3
                public final Unread.Marker call(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                    if (ack2 == null || !ack2.isLockedAck()) {
                        return ack != null ? new Unread.Marker(j, ack.getMessageId(), l) : new Unread.Marker(j, 0L, l);
                    }
                    return new Unread.Marker(j, ack2.getMessageId(), l);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            return j <= 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Observable<Unread.Marker>> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            Observable<Unread.Marker> observableInvoke = AnonymousClass1.INSTANCE.invoke(j);
            Intrinsics3.checkNotNullExpressionValue(observableInvoke, "getMarker(channelId)");
            return observableInvoke;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Unread, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persister = StoreReadStates.this.unreadMessageMarker;
            Intrinsics3.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persister, unread, false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreReadStates(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.unreadChannelIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.unreadGuildIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.markAsRead = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.unreadMessageMarker = new Persister<>("UNREAD_MESSAGE_MARKER_V3", new Unread(null, 0, 3, 0 == true ? 1 : 0));
    }

    private final void clearMarker() {
        Observable observableZ = this.unreadMessageMarker.getObservable().G(new Func1<Unread, Unread>() { // from class: com.discord.stores.StoreReadStates.clearMarker.1
            @Override // j0.k.Func1
            public final Unread call(Unread unread) {
                return unread.createWithEmptyCount();
            }
        }).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "unreadMessageMarker\n    …ount() }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (117 & 1) != 0 ? null : null, "unreadMessageMarker", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    private final void computeUnreadChannelIds() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = companion.getPermissions().observePermissionsForAllChannels();
        Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = companion.getChannels().observeGuildAndPrivateChannels();
        Observable<Map<Long, Long>> observableObserveJoinedAt = companion.getGuilds().observeJoinedAt();
        Observable<Map<Long, ModelNotificationSettings>> observableObserveGuildSettings = companion.getUserGuildSettings().observeGuildSettings();
        Observable<Map<Long, StoreMessageAck.Ack>> observableObserveAll = companion.getMessageAck().observeAll();
        Observable<Map<Long, Long>> observableObserveRecentMessageIds = companion.getMessagesMostRecent().observeRecentMessageIds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 3L, timeUnit);
        Observable<Long> observableObserveSelectedVoiceChannelId = companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
        Observable observableLeadingEdgeThrottle2 = ObservableExtensionsKt.leadingEdgeThrottle(companion.getThreadsActive().observeAllActiveForumThreadsById(), 3L, timeUnit);
        Observable<Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> observableObserveAllActiveJoinedThreadsById = companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsById();
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObservePermissionsForAllChannels, observableObserveGuildAndPrivateChannels, observableObserveJoinedAt, observableObserveGuildSettings, observableObserveAll, observableLeadingEdgeThrottle, observableObserveSelectedVoiceChannelId, observableLeadingEdgeThrottle2, observableObserveAllActiveJoinedThreadsById, new Func9() { // from class: com.discord.stores.StoreReadStates$sam$rx_functions_Func9$0
            @Override // rx.functions.Func9
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return anonymousClass1.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
            }
        }, 1L, timeUnit);
        Intrinsics3.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…imeUnit.SECONDS\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (117 & 1) != 0 ? null : null, "computeUnreadChannelIds", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass2(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    private final Tuples2<Set<Long>, Set<Long>> computeUnreadIds(Map<Long, Long> permissions, Map<Long, Channel> channels, Map<Long, Long> guildJoinedAt, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreMessageAck.Ack> acks, Map<Long, Long> mostRecent, long voiceChannelSelectedId, Map<Long, Channel> activeForumThreads, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads) {
        long jLongValue;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<Map.Entry<Long, Long>> it = mostRecent.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Long> next = it.next();
            long jLongValue2 = next.getKey().longValue();
            long jLongValue3 = next.getValue().longValue();
            StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = activeAndJoinedThreads.get(Long.valueOf(jLongValue2));
            Channel channel = activeForumThreads.get(Long.valueOf(jLongValue2));
            Channel channel2 = channels.get(Long.valueOf(jLongValue2));
            if (channel2 == null) {
                channel2 = activeJoinedThread != null ? activeJoinedThread.getChannel() : null;
            }
            if (channel2 == null) {
                channel2 = channel;
            }
            Iterator<Map.Entry<Long, Long>> it2 = it;
            boolean z2 = channel2 != null && ChannelUtils.r(channel2, channel2 != null ? channels.get(Long.valueOf(channel2.getParentId())) : null);
            if (channel2 != null && !ChannelUtils.B(channel2) && ((!ChannelUtils.H(channel2) || z2 || activeJoinedThread != null) && (!ChannelUtils.H(channel2) || !z2 || channel != null))) {
                if (PermissionUtils.INSTANCE.hasAccess(channel2, permissions.get(Long.valueOf(jLongValue2))) && !isChannelMuted(channel2, guildSettings, activeJoinedThread) && ((!ChannelUtils.J(channel2) || channel2.getId() == voiceChannelSelectedId) && (!ChannelUtils.J(channel2) || channel2.getId() != voiceChannelSelectedId || wasMessageSentAfterTimestamp(new UtcDateTime(StoreStream.INSTANCE.getVoiceChannelSelected().getTimeSelectedMs()), Long.valueOf(jLongValue3))))) {
                    StoreMessageAck.Ack ack = acks.get(Long.valueOf(jLongValue2));
                    if (ack != null || !ChannelUtils.H(channel2)) {
                        if (ack != null) {
                            jLongValue = ack.getMessageId();
                        } else {
                            Long l = (Long) outline.c(channel2, guildJoinedAt);
                            jLongValue = ((l != null ? l.longValue() : this.clock.currentTimeMillis()) - SnowflakeUtils.DISCORD_EPOCH) << 22;
                        }
                        if (MessageUtils.isNewer(Long.valueOf(jLongValue), Long.valueOf(jLongValue3))) {
                            hashSet.add(Long.valueOf(jLongValue2));
                            Channel channel3 = channels.get(Long.valueOf(channel2.getParentId()));
                            boolean zIsChannelMuted = isChannelMuted(channel3, guildSettings, activeJoinedThread);
                            if (!zIsChannelMuted && ChannelUtils.H(channel2) && channel3 != null) {
                                zIsChannelMuted = isChannelMuted(channels.get(Long.valueOf(channel3.getParentId())), guildSettings, activeJoinedThread);
                            }
                            if (!zIsChannelMuted) {
                                hashSet2.add(Long.valueOf(channel2.getGuildId()));
                            }
                        }
                    }
                }
                it = it2;
            }
            it = it2;
        }
        return new Tuples2<>(hashSet, hashSet2);
    }

    private final void computeUnreadMarker() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Observable<Long> observableObserveId = StoreStream.INSTANCE.getChannelsSelected().observeId();
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Unread.Marker marker = new Unread.Marker();
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        Intrinsics3.checkNotNullParameter(anonymousClass2, "observableCondition");
        Intrinsics3.checkNotNullParameter(anonymousClass3, "defaultObservableFunc");
        b0 b0Var = new b0(marker);
        Intrinsics3.checkNotNullParameter(anonymousClass2, "observableCondition");
        Intrinsics3.checkNotNullParameter(b0Var, "switchedObservableFunc");
        Intrinsics3.checkNotNullParameter(anonymousClass3, "defaultObservableFunc");
        Observable observableY = observableObserveId.k(new a0(anonymousClass2, b0Var, anonymousClass3)).Y(new Func1<Unread.Marker, Observable<? extends Unread>>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4
            @Override // j0.k.Func1
            public final Observable<? extends Unread> call(final Unread.Marker marker2) {
                Intrinsics3.checkNotNullParameter(marker2, "marker");
                Observable<R> observableA0 = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(marker2.getChannelId()).G(new Func1<List<? extends Message>, Unread>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Unread call(List<? extends Message> list) {
                        return call2((List<Message>) list);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Unread call2(List<Message> list) {
                        Unread.Marker marker3 = marker2;
                        Intrinsics3.checkNotNullExpressionValue(list, "messages");
                        return new Unread(marker3, list);
                    }
                }).a0(StoreReadStates.this.markAsRead.y(new Func1<Boolean, Boolean>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.2
                    @Override // j0.k.Func1
                    public final Boolean call(Boolean bool) {
                        return bool;
                    }
                }));
                Action0 action0 = new Action0() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.3
                    @Override // rx.functions.Action0
                    public final void call() {
                        StoreReadStates.this.clearMarker();
                    }
                };
                Actions2.a aVar = Actions2.a;
                return Observable.h0(new OnSubscribeDoOnEach(observableA0, new ActionObserver(aVar, aVar, action0)));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "getChannelsSelected()\n  …clearMarker() }\n        }");
        ObservableExtensionsKt.appSubscribe(observableY, (117 & 1) != 0 ? null : null, "unreadMessageMarker", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass5(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    private final boolean isChannelMuted(Channel channel, Map<Long, ? extends ModelNotificationSettings> guildSettings, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread) {
        if (channel == null) {
            return false;
        }
        if (ChannelUtils.H(channel) && activeJoinedThread != null) {
            return activeJoinedThread.getMuted();
        }
        long id2 = channel.getId();
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.c(channel, guildSettings);
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings != null ? modelNotificationSettings.getChannelOverride(id2) : null;
        return channelOverride != null && channelOverride.isMuted();
    }

    public static /* synthetic */ Observable observeUnreadCountForChannel$default(StoreReadStates storeReadStates, long j, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        return storeReadStates.observeUnreadCountForChannel(j, utcDateTime);
    }

    private final boolean wasMessageSentAfterTimestamp(UtcDateTime since, Long messageId) {
        return since == null || (messageId != null && new UtcDateTime((messageId.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).compareTo(since) >= 0);
    }

    public final Observable<Boolean> getIsUnread(final long guildId) {
        Observable<Boolean> observableR = getUnreadGuildIds().G(new Func1<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreReadStates.getIsUnread.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                return Boolean.valueOf(set.contains(Long.valueOf(guildId)));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "getUnreadGuildIds()\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Observable<Set<Long>> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public final Observable<Unread> getUnreadMarker(final long channelId) {
        Observable<Unread> observableR = getUnreadMarkerForSelectedChannel().y(new Func1<Unread, Boolean>() { // from class: com.discord.stores.StoreReadStates.getUnreadMarker.1
            @Override // j0.k.Func1
            public final Boolean call(Unread unread) {
                Intrinsics3.checkNotNullParameter(unread, "marker");
                return Boolean.valueOf(unread.getMarker().getChannelId() == channelId);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "unreadMarkerForSelectedC…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Unread> getUnreadMarkerForSelectedChannel() {
        Observable<Unread> observableR = ObservableExtensionsKt.computationLatest(this.unreadMessageMarker.getObservable()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "unreadMessageMarker\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        computeUnreadChannelIds();
        computeUnreadMarker();
    }

    public final void markAsRead(Long channelId) {
        if (channelId == null) {
            return;
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.markAsRead;
        serializedSubject.k.onNext(Boolean.TRUE);
        SerializedSubject<Boolean, Boolean> serializedSubject2 = this.markAsRead;
        serializedSubject2.k.onNext(Boolean.FALSE);
        StoreStream.INSTANCE.getMessageAck().ack(channelId.longValue(), false, false);
    }

    public final Observable<Integer> observeUnreadCountForChannel(final long channelId, final UtcDateTime since) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Integer> observableJ = Observable.j(companion.getMessages().observeMessagesForChannel(channelId), companion.getMessageAck().observeAll().G(new Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.observeUnreadCountForChannel.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(channelId));
            }
        }), new Func2<List<? extends Message>, StoreMessageAck.Ack, Integer>() { // from class: com.discord.stores.StoreReadStates.observeUnreadCountForChannel.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Integer call(List<? extends Message> list, StoreMessageAck.Ack ack) {
                return call2((List<Message>) list, ack);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(List<Message> list, StoreMessageAck.Ack ack) {
                Long lValueOf = ack != null ? Long.valueOf(ack.getMessageId()) : null;
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
                int i = 0;
                if (!list.isEmpty()) {
                    for (Message message : ReversedViews3.asReversed(list)) {
                        if (lValueOf != null && message.getId() == ack.getMessageId()) {
                            break;
                        }
                        if (StoreReadStates.this.wasMessageSentAfterTimestamp(since, Long.valueOf(message.getId()))) {
                            i++;
                        }
                    }
                }
                return Integer.valueOf(i);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…\n      messageCount\n    }");
        return observableJ;
    }
}
