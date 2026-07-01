package com.discord.stores;

import android.content.Context;
import b.a.d.a0;
import b.a.d.b0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.application.Unread;
import com.discord.models.application.Unread$Marker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
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

    public StoreReadStates(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.unreadChannelIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.unreadGuildIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.markAsRead = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.unreadMessageMarker = new Persister<>("UNREAD_MESSAGE_MARKER_V3", new Unread(null, 0, 3, null));
    }

    public static final /* synthetic */ void access$clearMarker(StoreReadStates storeReadStates) {
        storeReadStates.clearMarker();
    }

    public static final /* synthetic */ Pair access$computeUnreadIds(StoreReadStates storeReadStates, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, long j, Map map7, Map map8) {
        return storeReadStates.computeUnreadIds(map, map2, map3, map4, map5, map6, j, map7, map8);
    }

    public static final /* synthetic */ SerializedSubject access$getMarkAsRead$p(StoreReadStates storeReadStates) {
        return storeReadStates.markAsRead;
    }

    public static final /* synthetic */ SerializedSubject access$getUnreadChannelIds$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadChannelIds;
    }

    public static final /* synthetic */ SerializedSubject access$getUnreadGuildIds$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadGuildIds;
    }

    public static final /* synthetic */ Persister access$getUnreadMessageMarker$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadMessageMarker;
    }

    public static final /* synthetic */ boolean access$wasMessageSentAfterTimestamp(StoreReadStates storeReadStates, UtcDateTime utcDateTime, Long l) {
        return storeReadStates.wasMessageSentAfterTimestamp(utcDateTime, l);
    }

    private final void clearMarker() {
        Observable observableZ = this.unreadMessageMarker.getObservable().G(StoreReadStates$clearMarker$1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "unreadMessageMarker\n    …ount() }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, (Context) null, "unreadMessageMarker", (Function1) null, new StoreReadStates$clearMarker$2(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final void computeUnreadChannelIds() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = storeStream$Companion.getPermissions().observePermissionsForAllChannels();
        Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = storeStream$Companion.getChannels().observeGuildAndPrivateChannels();
        Observable<Map<Long, Long>> observableObserveJoinedAt = storeStream$Companion.getGuilds().observeJoinedAt();
        Observable<Map<Long, ModelNotificationSettings>> observableObserveGuildSettings = storeStream$Companion.getUserGuildSettings().observeGuildSettings();
        Observable<Map<Long, StoreMessageAck$Ack>> observableObserveAll = storeStream$Companion.getMessageAck().observeAll();
        Observable<Map<Long, Long>> observableObserveRecentMessageIds = storeStream$Companion.getMessagesMostRecent().observeRecentMessageIds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObservePermissionsForAllChannels, observableObserveGuildAndPrivateChannels, observableObserveJoinedAt, observableObserveGuildSettings, observableObserveAll, ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 3L, timeUnit), storeStream$Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getThreadsActive().observeAllActiveForumThreadsById(), 3L, timeUnit), storeStream$Companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), new StoreReadStates$sam$rx_functions_Func9$0(new StoreReadStates$computeUnreadChannelIds$1(this)), 1L, timeUnit);
        m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…imeUnit.SECONDS\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
        m.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, (Context) null, "computeUnreadChannelIds", (Function1) null, new StoreReadStates$computeUnreadChannelIds$2(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final Pair<Set<Long>, Set<Long>> computeUnreadIds(Map<Long, Long> permissions, Map<Long, Channel> channels, Map<Long, Long> guildJoinedAt, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreMessageAck$Ack> acks, Map<Long, Long> mostRecent, long voiceChannelSelectedId, Map<Long, Channel> activeForumThreads, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeAndJoinedThreads) {
        long jLongValue;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<Map$Entry<Long, Long>> it = mostRecent.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry<Long, Long> next = it.next();
            long jLongValue2 = next.getKey().longValue();
            long jLongValue3 = next.getValue().longValue();
            StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread = activeAndJoinedThreads.get(Long.valueOf(jLongValue2));
            Channel channel = activeForumThreads.get(Long.valueOf(jLongValue2));
            Channel channel2 = channels.get(Long.valueOf(jLongValue2));
            if (channel2 == null) {
                channel2 = storeThreadsActiveJoined$ActiveJoinedThread != null ? storeThreadsActiveJoined$ActiveJoinedThread.getChannel() : null;
            }
            if (channel2 == null) {
                channel2 = channel;
            }
            Iterator<Map$Entry<Long, Long>> it2 = it;
            boolean z2 = channel2 != null && ChannelUtils.r(channel2, channel2 != null ? channels.get(Long.valueOf(channel2.getParentId())) : null);
            if (channel2 != null && !ChannelUtils.B(channel2) && ((!ChannelUtils.H(channel2) || z2 || storeThreadsActiveJoined$ActiveJoinedThread != null) && (!ChannelUtils.H(channel2) || !z2 || channel != null))) {
                if (PermissionUtils.INSTANCE.hasAccess(channel2, permissions.get(Long.valueOf(jLongValue2))) && !isChannelMuted(channel2, guildSettings, storeThreadsActiveJoined$ActiveJoinedThread) && ((!ChannelUtils.J(channel2) || channel2.getId() == voiceChannelSelectedId) && (!ChannelUtils.J(channel2) || channel2.getId() != voiceChannelSelectedId || wasMessageSentAfterTimestamp(new UtcDateTime(StoreStream.Companion.getVoiceChannelSelected().getTimeSelectedMs()), Long.valueOf(jLongValue3))))) {
                    StoreMessageAck$Ack storeMessageAck$Ack = acks.get(Long.valueOf(jLongValue2));
                    if (storeMessageAck$Ack != null || !ChannelUtils.H(channel2)) {
                        if (storeMessageAck$Ack != null) {
                            jLongValue = storeMessageAck$Ack.getMessageId();
                        } else {
                            Long l = (Long) a.c(channel2, guildJoinedAt);
                            jLongValue = ((l != null ? l.longValue() : this.clock.currentTimeMillis()) - SnowflakeUtils.DISCORD_EPOCH) << 22;
                        }
                        if (MessageUtils.isNewer(Long.valueOf(jLongValue), Long.valueOf(jLongValue3))) {
                            hashSet.add(Long.valueOf(jLongValue2));
                            Channel channel3 = channels.get(Long.valueOf(channel2.getParentId()));
                            boolean zIsChannelMuted = isChannelMuted(channel3, guildSettings, storeThreadsActiveJoined$ActiveJoinedThread);
                            if (!zIsChannelMuted && ChannelUtils.H(channel2) && channel3 != null) {
                                zIsChannelMuted = isChannelMuted(channels.get(Long.valueOf(channel3.getParentId())), guildSettings, storeThreadsActiveJoined$ActiveJoinedThread);
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
        StoreReadStates$computeUnreadMarker$1 storeReadStates$computeUnreadMarker$1 = StoreReadStates$computeUnreadMarker$1.INSTANCE;
        Observable<Long> observableObserveId = StoreStream.Companion.getChannelsSelected().observeId();
        StoreReadStates$computeUnreadMarker$2 storeReadStates$computeUnreadMarker$2 = StoreReadStates$computeUnreadMarker$2.INSTANCE;
        Unread$Marker unread$Marker = new Unread$Marker();
        StoreReadStates$computeUnreadMarker$3 storeReadStates$computeUnreadMarker$3 = StoreReadStates$computeUnreadMarker$3.INSTANCE;
        m.checkNotNullParameter(storeReadStates$computeUnreadMarker$2, "observableCondition");
        m.checkNotNullParameter(storeReadStates$computeUnreadMarker$3, "defaultObservableFunc");
        b0 b0Var = new b0(unread$Marker);
        m.checkNotNullParameter(storeReadStates$computeUnreadMarker$2, "observableCondition");
        m.checkNotNullParameter(b0Var, "switchedObservableFunc");
        m.checkNotNullParameter(storeReadStates$computeUnreadMarker$3, "defaultObservableFunc");
        Observable observableY = observableObserveId.k(new a0(storeReadStates$computeUnreadMarker$2, b0Var, storeReadStates$computeUnreadMarker$3)).Y(new StoreReadStates$computeUnreadMarker$4(this));
        m.checkNotNullExpressionValue(observableY, "getChannelsSelected()\n  …clearMarker() }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableY, (Context) null, "unreadMessageMarker", (Function1) null, new StoreReadStates$computeUnreadMarker$5(this), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final boolean isChannelMuted(Channel channel, Map<Long, ? extends ModelNotificationSettings> guildSettings, StoreThreadsActiveJoined$ActiveJoinedThread activeJoinedThread) {
        if (channel == null) {
            return false;
        }
        if (ChannelUtils.H(channel) && activeJoinedThread != null) {
            return activeJoinedThread.getMuted();
        }
        long id2 = channel.getId();
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) a.c(channel, guildSettings);
        ModelNotificationSettings$ChannelOverride channelOverride = modelNotificationSettings != null ? modelNotificationSettings.getChannelOverride(id2) : null;
        return channelOverride != null && channelOverride.isMuted();
    }

    public static /* synthetic */ Observable observeUnreadCountForChannel$default(StoreReadStates storeReadStates, long j, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        return storeReadStates.observeUnreadCountForChannel(j, utcDateTime);
    }

    private final boolean wasMessageSentAfterTimestamp(UtcDateTime since, Long messageId) {
        return since == null || (messageId != null && new UtcDateTime((messageId.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).f(since) >= 0);
    }

    public final Observable<Boolean> getIsUnread(long guildId) {
        Observable<Boolean> observableR = getUnreadGuildIds().G(new StoreReadStates$getIsUnread$1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "getUnreadGuildIds()\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Observable<Set<Long>> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public final Observable<Unread> getUnreadMarker(long channelId) {
        Observable<Unread> observableR = getUnreadMarkerForSelectedChannel().y(new StoreReadStates$getUnreadMarker$1(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "unreadMarkerForSelectedC…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Unread> getUnreadMarkerForSelectedChannel() {
        Observable<Unread> observableR = ObservableExtensionsKt.computationLatest(this.unreadMessageMarker.getObservable()).r();
        m.checkNotNullExpressionValue(observableR, "unreadMessageMarker\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
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
        StoreStream.Companion.getMessageAck().ack(channelId.longValue(), false, false);
    }

    public final Observable<Integer> observeUnreadCountForChannel(long channelId, UtcDateTime since) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Integer> observableJ = Observable.j(storeStream$Companion.getMessages().observeMessagesForChannel(channelId), storeStream$Companion.getMessageAck().observeAll().G(new StoreReadStates$observeUnreadCountForChannel$1(channelId)), new StoreReadStates$observeUnreadCountForChannel$2(this, since));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…\n      messageCount\n    }");
        return observableJ;
    }
}
