package com.discord.stores;

import android.content.Context;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import p007b.p008a.p018d.C0853a0;
import p007b.p008a.p018d.C0855b0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12161s;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.C12588a;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12638k;
import p637j0.p642l.p647e.C12711a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func9;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates extends Store {
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> markAsRead;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadChannelIds;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadGuildIds;
    private final Persister<Unread> unreadMessageMarker;

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$clearMarker$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63412 extends AbstractC12240o implements Function1<Unread, Unit> {
        public C63412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persister = StoreReadStates.this.unreadMessageMarker;
            C12238m.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persister, unread, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final /* synthetic */ class C63421 extends C12236k implements Function9<Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends ModelNotificationSettings>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends Long>, Long, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public C63421(StoreReadStates storeReadStates) {
            super(9, storeReadStates, StoreReadStates.class, "computeUnreadIds", "computeUnreadIds(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> invoke(Map<Long, ? extends Long> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, ? extends StoreMessageAck.Ack> map5, Map<Long, ? extends Long> map6, Long l, Map<Long, ? extends Channel> map7, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            return invoke((Map<Long, Long>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3, map4, (Map<Long, StoreMessageAck.Ack>) map5, (Map<Long, Long>) map6, l.longValue(), (Map<Long, Channel>) map7, (Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map8);
        }

        public final Pair<Set<Long>, Set<Long>> invoke(Map<Long, Long> map, Map<Long, Channel> map2, Map<Long, Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, StoreMessageAck.Ack> map5, Map<Long, Long> map6, long j, Map<Long, Channel> map7, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            C12238m.checkNotNullParameter(map, "p1");
            C12238m.checkNotNullParameter(map2, "p2");
            C12238m.checkNotNullParameter(map3, "p3");
            C12238m.checkNotNullParameter(map4, "p4");
            C12238m.checkNotNullParameter(map5, "p5");
            C12238m.checkNotNullParameter(map6, "p6");
            C12238m.checkNotNullParameter(map7, "p8");
            C12238m.checkNotNullParameter(map8, "p9");
            return ((StoreReadStates) this.receiver).computeUnreadIds(map, map2, map3, map4, map5, map6, j, map7, map8);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63432 extends AbstractC12240o implements Function1<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
        public C63432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair) {
            invoke2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends Set<Long>, ? extends Set<Long>> pair) {
            Set<Long> setComponent1 = pair.component1();
            Set<Long> setComponent2 = pair.component2();
            StoreReadStates.this.unreadChannelIds.f27653k.onNext((T) setComponent1);
            StoreReadStates.this.unreadGuildIds.f27653k.onNext((T) setComponent2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63441 extends AbstractC12240o implements Function1<Long, Observable<Unread.Marker>> {
        public static final C63441 INSTANCE = new C63441();

        public C63441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(final long j) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.m11075i(companion.getMessageAck().observeAll().m11083G(new InterfaceC12589b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                    return call2((Map<Long, StoreMessageAck.Ack>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                    return map.get(Long.valueOf(j));
                }
            }).m11100Z(1), companion.getMessageAck().observeAll().m11083G(new InterfaceC12589b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.2
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                    return call2((Map<Long, StoreMessageAck.Ack>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                    return map.get(Long.valueOf(j));
                }
            }), companion.getMessagesMostRecent().observeRecentMessageIds(j).m11100Z(1), new Func3<StoreMessageAck.Ack, StoreMessageAck.Ack, Long, Unread.Marker>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.1.3
                @Override // p658rx.functions.Func3
                public final Unread.Marker call(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                    if (ack2 == null || !ack2.isLockedAck()) {
                        return ack != null ? new Unread.Marker(j, ack.getMessageId(), l) : new Unread.Marker(j, 0L, l);
                    }
                    return new Unread.Marker(j, ack2.getMessageId(), l);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63452 extends AbstractC12240o implements Function1<Long, Boolean> {
        public static final C63452 INSTANCE = new C63452();

        public C63452() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$3 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63463 extends AbstractC12240o implements Function1<Long, Observable<Unread.Marker>> {
        public static final C63463 INSTANCE = new C63463();

        public C63463() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            Observable<Unread.Marker> observableInvoke = C63441.INSTANCE.invoke(j);
            C12238m.checkNotNullExpressionValue(observableInvoke, "getMarker(channelId)");
            return observableInvoke;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$5 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63485 extends AbstractC12240o implements Function1<Unread, Unit> {
        public C63485() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persister = StoreReadStates.this.unreadMessageMarker;
            C12238m.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persister, unread, false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreReadStates(Clock clock) {
        C12238m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.unreadChannelIds = new SerializedSubject<>(BehaviorSubject.m11130l0(new HashSet()));
        this.unreadGuildIds = new SerializedSubject<>(BehaviorSubject.m11130l0(new HashSet()));
        this.markAsRead = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));
        this.unreadMessageMarker = new Persister<>("UNREAD_MESSAGE_MARKER_V3", new Unread(null, 0, 3, 0 == true ? 1 : 0));
    }

    private final void clearMarker() {
        Observable observableM11100Z = this.unreadMessageMarker.getObservable().m11083G(new InterfaceC12589b<Unread, Unread>() { // from class: com.discord.stores.StoreReadStates.clearMarker.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Unread call(Unread unread) {
                return unread.createWithEmptyCount();
            }
        }).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "unreadMessageMarker\n    …ount() }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (117 & 1) != 0 ? null : null, "unreadMessageMarker", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C63412(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
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
        final C63421 c63421 = new C63421(this);
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObservePermissionsForAllChannels, observableObserveGuildAndPrivateChannels, observableObserveJoinedAt, observableObserveGuildSettings, observableObserveAll, observableLeadingEdgeThrottle, observableObserveSelectedVoiceChannelId, observableLeadingEdgeThrottle2, observableObserveAllActiveJoinedThreadsById, new Func9() { // from class: com.discord.stores.StoreReadStates$sam$rx_functions_Func9$0
            @Override // p658rx.functions.Func9
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return c63421.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
            }
        }, 1L, timeUnit);
        C12238m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…imeUnit.SECONDS\n        )");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableCombineLatest).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (117 & 1) != 0 ? null : null, "computeUnreadChannelIds", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C63432(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final Pair<Set<Long>, Set<Long>> computeUnreadIds(Map<Long, Long> permissions, Map<Long, Channel> channels, Map<Long, Long> guildJoinedAt, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreMessageAck.Ack> acks, Map<Long, Long> mostRecent, long voiceChannelSelectedId, Map<Long, Channel> activeForumThreads, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads) {
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
            boolean z2 = channel2 != null && ChannelUtils.m7694r(channel2, channel2 != null ? channels.get(Long.valueOf(channel2.getParentId())) : null);
            if (channel2 != null && !ChannelUtils.m7667B(channel2) && ((!ChannelUtils.m7673H(channel2) || z2 || activeJoinedThread != null) && (!ChannelUtils.m7673H(channel2) || !z2 || channel != null))) {
                if (PermissionUtils.INSTANCE.hasAccess(channel2, permissions.get(Long.valueOf(jLongValue2))) && !isChannelMuted(channel2, guildSettings, activeJoinedThread) && ((!ChannelUtils.m7675J(channel2) || channel2.getId() == voiceChannelSelectedId) && (!ChannelUtils.m7675J(channel2) || channel2.getId() != voiceChannelSelectedId || wasMessageSentAfterTimestamp(new UtcDateTime(StoreStream.INSTANCE.getVoiceChannelSelected().getTimeSelectedMs()), Long.valueOf(jLongValue3))))) {
                    StoreMessageAck.Ack ack = acks.get(Long.valueOf(jLongValue2));
                    if (ack != null || !ChannelUtils.m7673H(channel2)) {
                        if (ack != null) {
                            jLongValue = ack.getMessageId();
                        } else {
                            Long l = (Long) C1643a.m843c(channel2, guildJoinedAt);
                            jLongValue = ((l != null ? l.longValue() : this.clock.currentTimeMillis()) - SnowflakeUtils.DISCORD_EPOCH) << 22;
                        }
                        if (MessageUtils.isNewer(Long.valueOf(jLongValue), Long.valueOf(jLongValue3))) {
                            hashSet.add(Long.valueOf(jLongValue2));
                            Channel channel3 = channels.get(Long.valueOf(channel2.getParentId()));
                            boolean zIsChannelMuted = isChannelMuted(channel3, guildSettings, activeJoinedThread);
                            if (!zIsChannelMuted && ChannelUtils.m7673H(channel2) && channel3 != null) {
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
        return new Pair<>(hashSet, hashSet2);
    }

    private final void computeUnreadMarker() {
        C63441 c63441 = C63441.INSTANCE;
        Observable<Long> observableObserveId = StoreStream.INSTANCE.getChannelsSelected().observeId();
        C63452 c63452 = C63452.INSTANCE;
        Unread.Marker marker = new Unread.Marker();
        C63463 c63463 = C63463.INSTANCE;
        C12238m.checkNotNullParameter(c63452, "observableCondition");
        C12238m.checkNotNullParameter(c63463, "defaultObservableFunc");
        C0855b0 c0855b0 = new C0855b0(marker);
        C12238m.checkNotNullParameter(c63452, "observableCondition");
        C12238m.checkNotNullParameter(c0855b0, "switchedObservableFunc");
        C12238m.checkNotNullParameter(c63463, "defaultObservableFunc");
        Observable observableM11099Y = observableObserveId.m11108k(new C0853a0(c63452, c0855b0, c63463)).m11099Y(new InterfaceC12589b<Unread.Marker, Observable<? extends Unread>>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Unread> call(final Unread.Marker marker2) {
                C12238m.checkNotNullParameter(marker2, "marker");
                Observable<R> observableM11102a0 = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(marker2.getChannelId()).m11083G(new InterfaceC12589b<List<? extends Message>, Unread>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Unread call(List<? extends Message> list) {
                        return call2((List<Message>) list);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Unread call2(List<Message> list) {
                        Unread.Marker marker3 = marker2;
                        C12238m.checkNotNullExpressionValue(list, "messages");
                        return new Unread(marker3, list);
                    }
                }).m11102a0(StoreReadStates.this.markAsRead.m11118y(new InterfaceC12589b<Boolean, Boolean>() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Boolean call(Boolean bool) {
                        return bool;
                    }
                }));
                Action0 action0 = new Action0() { // from class: com.discord.stores.StoreReadStates.computeUnreadMarker.4.3
                    @Override // p658rx.functions.Action0
                    public final void call() {
                        StoreReadStates.this.clearMarker();
                    }
                };
                C12588a.a aVar = C12588a.f26710a;
                return Observable.m11074h0(new C12638k(observableM11102a0, new C12711a(aVar, aVar, action0)));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "getChannelsSelected()\n  …clearMarker() }\n        }");
        ObservableExtensionsKt.appSubscribe(observableM11099Y, (117 & 1) != 0 ? null : null, "unreadMessageMarker", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C63485(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final boolean isChannelMuted(Channel channel, Map<Long, ? extends ModelNotificationSettings> guildSettings, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread) {
        if (channel == null) {
            return false;
        }
        if (ChannelUtils.m7673H(channel) && activeJoinedThread != null) {
            return activeJoinedThread.getMuted();
        }
        long id2 = channel.getId();
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) C1643a.m843c(channel, guildSettings);
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
        Observable<Boolean> observableM11112r = getUnreadGuildIds().m11083G(new InterfaceC12589b<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreReadStates.getIsUnread.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                return Boolean.valueOf(set.contains(Long.valueOf(guildId)));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "getUnreadGuildIds()\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Observable<Set<Long>> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public final Observable<Unread> getUnreadMarker(final long channelId) {
        Observable<Unread> observableM11112r = getUnreadMarkerForSelectedChannel().m11118y(new InterfaceC12589b<Unread, Boolean>() { // from class: com.discord.stores.StoreReadStates.getUnreadMarker.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Unread unread) {
                C12238m.checkNotNullParameter(unread, "marker");
                return Boolean.valueOf(unread.getMarker().getChannelId() == channelId);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "unreadMarkerForSelectedC…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Unread> getUnreadMarkerForSelectedChannel() {
        Observable<Unread> observableM11112r = ObservableExtensionsKt.computationLatest(this.unreadMessageMarker.getObservable()).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "unreadMessageMarker\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        computeUnreadChannelIds();
        computeUnreadMarker();
    }

    public final void markAsRead(Long channelId) {
        if (channelId == null) {
            return;
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.markAsRead;
        serializedSubject.f27653k.onNext(Boolean.TRUE);
        SerializedSubject<Boolean, Boolean> serializedSubject2 = this.markAsRead;
        serializedSubject2.f27653k.onNext(Boolean.FALSE);
        StoreStream.INSTANCE.getMessageAck().ack(channelId.longValue(), false, false);
    }

    public final Observable<Integer> observeUnreadCountForChannel(final long channelId, final UtcDateTime since) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Integer> observableM11076j = Observable.m11076j(companion.getMessages().observeMessagesForChannel(channelId), companion.getMessageAck().observeAll().m11083G(new InterfaceC12589b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack>() { // from class: com.discord.stores.StoreReadStates.observeUnreadCountForChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(channelId));
            }
        }), new Func2<List<? extends Message>, StoreMessageAck.Ack, Integer>() { // from class: com.discord.stores.StoreReadStates.observeUnreadCountForChannel.2
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Integer call(List<? extends Message> list, StoreMessageAck.Ack ack) {
                return call2((List<Message>) list, ack);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(List<Message> list, StoreMessageAck.Ack ack) {
                Long lValueOf = ack != null ? Long.valueOf(ack.getMessageId()) : null;
                C12238m.checkNotNullExpressionValue(list, "messages");
                int i = 0;
                if (!list.isEmpty()) {
                    for (Message message : C12161s.asReversed(list)) {
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
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…\n      messageCount\n    }");
        return observableM11076j;
    }
}
