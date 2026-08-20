package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.forum.ForumUnread;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.message.Message;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.widgets.forums.ForumUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreForumPostReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostReadStates extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> processedForumUnreadRequests;
    private final StoreChannels storeChannels;
    private final StoreGatewayConnection storeGatewayConnection;
    private final StoreMessageAck storeMessageAck;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreUser storeUser;
    private final Set<Long> threadIdsWithPersistedAcks;
    private Set<Long> threadIdsWithPersistedAcksSnapshot;
    private final Map<Long, Integer> threadUnreadCounts;
    private Map<Long, Integer> threadUnreadCountsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadIdsWithPersistedReadStates$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59381 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public C59381() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreForumPostReadStates.this.threadIdsWithPersistedAcksSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$observeThreadUnreadCounts$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59391 extends AbstractC12240o implements Function0<Map<Long, ? extends Integer>> {
        public C59391() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Integer> invoke() {
            return StoreForumPostReadStates.this.threadUnreadCountsSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreForumPostReadStates$requestForumUnreads$1 */
    /* JADX INFO: compiled from: StoreForumPostReadStates.kt */
    public static final class C59401 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59401(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, this.$guildId, null, 2, null) || StoreForumPostReadStates.this.processedForumUnreadRequests.contains(Long.valueOf(this.$channelId))) {
                return;
            }
            StoreForumPostReadStates.this.processedForumUnreadRequests.add(Long.valueOf(this.$channelId));
            Map<Long, Channel> mapEmptyMap = StoreForumPostReadStates.this.storeThreadsActive.getAllActiveThreadsInternal$app_productionGoogleRelease().get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = C12136h0.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Channel> entry : mapEmptyMap.entrySet()) {
                if (entry.getValue().getParentId() == this.$channelId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<Long, StoreMessageAck.Ack> all = StoreForumPostReadStates.this.storeMessageAck.getAll();
            Set setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                StoreMessageAck.Ack ack = all.get(Long.valueOf(jLongValue));
                Pair pairM10073to = ack != null ? C12116o.m10073to(Long.valueOf(jLongValue), Long.valueOf(ack.getMessageId())) : null;
                if (pairM10073to != null) {
                    arrayList.add(pairM10073to);
                }
            }
            StoreForumPostReadStates.this.storeGatewayConnection.requestForumUnreads(this.$guildId, this.$channelId, arrayList);
        }
    }

    public StoreForumPostReadStates(Dispatcher dispatcher, StoreGatewayConnection storeGatewayConnection, StoreThreadsActive storeThreadsActive, StoreMessageAck storeMessageAck, StoreChannels storeChannels, StoreUser storeUser, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        C12238m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        C12238m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeGatewayConnection = storeGatewayConnection;
        this.storeThreadsActive = storeThreadsActive;
        this.storeMessageAck = storeMessageAck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.threadIdsWithPersistedAcks = new LinkedHashSet();
        this.threadIdsWithPersistedAcksSnapshot = C12148n0.emptySet();
        this.threadUnreadCounts = new LinkedHashMap();
        this.threadUnreadCountsSnapshot = C12136h0.emptyMap();
        this.processedForumUnreadRequests = new LinkedHashSet();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.threadIdsWithPersistedAcks.clear();
        }
        this.processedForumUnreadRequests.clear();
        this.threadUnreadCounts.clear();
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        C12238m.checkNotNullExpressionValue(entries, "payload.readState.entries");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelReadState) it.next()).getChannelId()));
        }
        this.threadIdsWithPersistedAcks.addAll(arrayList);
        markChanged();
    }

    @StoreThread
    public final void handleForumUnreads(ForumUnreads forumUnreads) {
        C12238m.checkNotNullParameter(forumUnreads, "forumUnreads");
        if (forumUnreads.getPermissionDenied()) {
            return;
        }
        for (ForumUnread forumUnread : forumUnreads.m7825b()) {
            Map<Long, Integer> map = this.threadUnreadCounts;
            Long lValueOf = Long.valueOf(forumUnread.getThreadId());
            Integer count = forumUnread.getCount();
            map.put(lValueOf, Integer.valueOf(count != null ? count.intValue() : 0));
        }
        markChanged();
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        C12238m.checkNotNullParameter(readState, "readState");
        long channelId = readState.getChannelId();
        if (this.threadUnreadCounts.containsKey(Long.valueOf(channelId))) {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        Channel channel;
        C12238m.checkNotNullParameter(message, "message");
        long channelId = message.getChannelId();
        Channel channel2 = this.storeChannels.getChannel(channelId);
        if (channel2 == null || (channel = this.storeChannels.getChannel(channel2.getParentId())) == null || !ChannelUtils.m7694r(channel2, channel)) {
            return;
        }
        User author = message.getAuthor();
        if (author == null || author.getId() != this.storeUser.getMeSnapshot().getId()) {
            Integer num = this.threadUnreadCounts.get(Long.valueOf(channelId));
            this.threadUnreadCounts.put(Long.valueOf(channelId), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        } else {
            this.threadUnreadCounts.put(Long.valueOf(channelId), 0);
        }
        markChanged();
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (!ChannelUtils.m7686j(channel) || this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) == null) {
            return;
        }
        markChanged();
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (this.threadUnreadCounts.remove(Long.valueOf(channel.getId())) != null) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeThreadIdsWithPersistedReadStates() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59381(), 14, null);
    }

    public final Observable<Map<Long, Integer>> observeThreadUnreadCounts() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59391(), 14, null);
    }

    public final void requestForumUnreads(long guildId, long channelId) {
        this.dispatcher.schedule(new C59401(guildId, channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.threadIdsWithPersistedAcksSnapshot = new HashSet(this.threadIdsWithPersistedAcks);
        this.threadUnreadCountsSnapshot = new HashMap(this.threadUnreadCounts);
    }
}
