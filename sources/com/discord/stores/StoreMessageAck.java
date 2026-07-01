package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.message.Message;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$VersionedReadStates;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.d0.f;
import d0.t.g0;
import d0.t.n0;
import d0.t.o;
import d0.t.o0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck extends StoreV2 {
    public static final StoreMessageAck$Companion Companion = new StoreMessageAck$Companion(null);
    private final Map<Long, StoreMessageAck$Ack> acks;
    private final Persister<Map<Long, StoreMessageAck$Ack>> acksPersister;
    private Map<Long, StoreMessageAck$Ack> acksSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private Subscription threadSyncSubscription;

    public StoreMessageAck(StoreStream storeStream, ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        Persister<Map<Long, StoreMessageAck$Ack>> persister = new Persister<>("MOST_RECENT_ACKS_V3", new HashMap());
        this.acksPersister = persister;
        this.acksSnapshot = persister.get();
        this.acks = new HashMap(this.acksSnapshot);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.stream;
    }

    public static final /* synthetic */ Subscription access$getThreadSyncSubscription$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.threadSyncSubscription;
    }

    public static final /* synthetic */ void access$internalAck(StoreMessageAck storeMessageAck, Channel channel, boolean z2, boolean z3) {
        storeMessageAck.internalAck(channel, z2, z3);
    }

    public static final /* synthetic */ Observable access$observeThreadAckState(StoreMessageAck storeMessageAck, long j) {
        return storeMessageAck.observeThreadAckState(j);
    }

    public static final /* synthetic */ void access$postPendingAck(StoreMessageAck storeMessageAck, Observable observable, int i) {
        storeMessageAck.postPendingAck(observable, i);
    }

    public static final /* synthetic */ void access$setThreadSyncSubscription$p(StoreMessageAck storeMessageAck, Subscription subscription) {
        storeMessageAck.threadSyncSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateAcks(StoreMessageAck storeMessageAck, long j, StoreMessageAck$Ack storeMessageAck$Ack) {
        storeMessageAck.updateAcks(j, storeMessageAck$Ack);
    }

    public static final /* synthetic */ void access$updateThreadAcks(StoreMessageAck storeMessageAck, Set set, Set set2) {
        storeMessageAck.updateThreadAcks(set, set2);
    }

    public static /* synthetic */ void ack$default(StoreMessageAck storeMessageAck, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessageAck.ack(j, z2, z3);
    }

    private final Observable<StoreMessageAck$PendingAck> getPendingAck(Observable<Long> observable, boolean z2, boolean z3) {
        Observable observableY = observable.Y(new StoreMessageAck$getPendingAck$2(this, z2, new StoreMessageAck$getPendingAck$1(z3)));
        m.checkNotNullExpressionValue(observableY, "switchMap { channelId ->…gAck.EMPTY)\n      }\n    }");
        return observableY;
    }

    @StoreThread
    private final StoreMessageAck$Companion$ThreadAckState getThreadAckStateInternal(long channelId, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeAndJoinedThreads, Map<Long, Channel> activeForumThreads, StoreChannels storeChannels) {
        Channel channel = storeChannels.getChannel(channelId);
        if (channel == null) {
            return null;
        }
        if (ChannelUtils.H(channel)) {
            return (activeAndJoinedThreads.containsKey(Long.valueOf(channelId)) || activeForumThreads.containsKey(Long.valueOf(channelId))) ? new StoreMessageAck$Companion$ThreadAckState$Thread(true) : new StoreMessageAck$Companion$ThreadAckState$Thread(false);
        }
        return StoreMessageAck$Companion$ThreadAckState$NotThread.INSTANCE;
    }

    public static /* synthetic */ StoreMessageAck$Companion$ThreadAckState getThreadAckStateInternal$default(StoreMessageAck storeMessageAck, long j, Map map, Map map2, StoreChannels storeChannels, int i, Object obj) {
        if ((i & 8) != 0) {
            storeChannels = storeMessageAck.stream.getChannels();
        }
        return storeMessageAck.getThreadAckStateInternal(j, map, map2, storeChannels);
    }

    private final void internalAck(Channel channel, boolean isLockedAck, boolean clearLock) {
        k kVar = new k(Long.valueOf(channel.getId()));
        m.checkNotNullExpressionValue(kVar, "Observable.just(channel.id)");
        postPendingAck$default(this, ObservableExtensionsKt.takeSingleUntilTimeout$default(getPendingAck(kVar, isLockedAck, clearLock), 0L, false, 1, null), 0, 1, null);
    }

    private final Observable<Pair<Set<Long>, Set<Long>>> observeActiveThreadIdsWithPrevious() {
        Observable observableJ = Observable.j(this.stream.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), this.stream.getThreadsActive().observeAllActiveForumThreadsById(), StoreMessageAck$observeActiveThreadIdsWithPrevious$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…veForumThreads.keys\n    }");
        Observable<Pair<Set<Long>, Set<Long>>> observableQ = ObservableExtensionsKt.leadingEdgeThrottle(observableJ, 1L, TimeUnit.SECONDS).r().Q(new Pair(n0.emptySet(), n0.emptySet()), StoreMessageAck$observeActiveThreadIdsWithPrevious$2.INSTANCE);
        m.checkNotNullExpressionValue(observableQ, "Observable.combineLatest…ond, threadIds)\n        }");
        return observableQ;
    }

    private final Observable<StoreMessageAck$Companion$ThreadAckState> observeThreadAckState(long channelId) {
        Observable<StoreMessageAck$Companion$ThreadAckState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.stream.getThreadsActiveJoined(), this.stream.getThreadsActive()}, false, null, null, new StoreMessageAck$observeThreadAckState$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    private final void postPendingAck(Observable<StoreMessageAck$PendingAck> observable, int i) {
        StoreMessageAck$postPendingAck$1 storeMessageAck$postPendingAck$1 = new StoreMessageAck$postPendingAck$1(this, i);
        Observable<StoreMessageAck$PendingAck> observableY = observable.y(StoreMessageAck$postPendingAck$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "filter { it != PendingAck.EMPTY }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableY), observable.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMessageAck$postPendingAck$3(storeMessageAck$postPendingAck$1), 62, (Object) null);
    }

    public static /* synthetic */ void postPendingAck$default(StoreMessageAck storeMessageAck, Observable observable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        storeMessageAck.postPendingAck(observable, i);
    }

    @StoreThread
    private final void pruneAcks() {
        if (!this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            return;
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByIdInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator<Long> it = this.acks.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!channelsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !activeJoinedThreadsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !allForumThreadsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue))) {
                it.remove();
                markChanged();
            }
        }
    }

    @StoreThread
    private final void updateAcks(long channelId, StoreMessageAck$Ack ackNewer) {
        if (Companion.isThreadAndUnableToAck(getThreadAckStateInternal$default(this, channelId, this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null))) {
            return;
        }
        StoreMessageAck$Ack storeMessageAck$Ack = this.acks.get(Long.valueOf(channelId));
        if (storeMessageAck$Ack == null || MessageUtils.compareMessages(Long.valueOf(storeMessageAck$Ack.getMessageId()), Long.valueOf(ackNewer.getMessageId())) != 0 || (ackNewer.isLockedAck() && !storeMessageAck$Ack.isLockedAck())) {
            this.acks.put(Long.valueOf(channelId), ackNewer);
            markChanged();
        }
    }

    @StoreThread
    private final void updateThreadAcks(Set<Long> oldThreadIds, Set<Long> newThreadIds) {
        Channel channel;
        UtcDateTime joinTimestamp;
        if (this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            Iterator it = o0.minus((Set) oldThreadIds, (Iterable) newThreadIds).iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (this.acks.containsKey(Long.valueOf(jLongValue)) && this.acks.remove(Long.valueOf(jLongValue)) != null) {
                    markChanged();
                }
            }
        }
        Map<Long, Long> guildsJoinedAtInternal$app_productionGoogleRelease = this.stream.getGuilds().getGuildsJoinedAtInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator it2 = o0.minus((Set) newThreadIds, (Iterable) oldThreadIds).iterator();
        while (it2.hasNext()) {
            long jLongValue2 = ((Number) it2.next()).longValue();
            if (!this.acks.containsKey(Long.valueOf(jLongValue2))) {
                if (Companion.isThreadAndAbleToAck(getThreadAckStateInternal$default(this, jLongValue2, activeJoinedThreadsInternal$app_productionGoogleRelease, allForumThreadsByIdInternal$app_productionGoogleRelease, null, 8, null))) {
                    StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread = activeJoinedThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    if (storeThreadsActiveJoined$ActiveJoinedThread == null || (channel = storeThreadsActiveJoined$ActiveJoinedThread.getChannel()) == null) {
                        channel = allForumThreadsByIdInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    }
                    Channel channel2 = channel;
                    if (channel2 != null) {
                        this.acks.put(Long.valueOf(jLongValue2), new StoreMessageAck$Ack((ThreadUtils.getThreadAckMessageTimestamp$default(ThreadUtils.INSTANCE, channel2, (Long) a.c(channel2, guildsJoinedAtInternal$app_productionGoogleRelease), (storeThreadsActiveJoined$ActiveJoinedThread == null || (joinTimestamp = storeThreadsActiveJoined$ActiveJoinedThread.getJoinTimestamp()) == null) ? null : Long.valueOf(joinTimestamp.getDateTimeMillis()), null, 4, null) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, false));
                        markChanged();
                    }
                }
            }
        }
    }

    public final void ack(long channelId, boolean isLockedAck, boolean clearLock) {
        this.dispatcher.schedule(new StoreMessageAck$ack$1(this, channelId, isLockedAck, clearLock));
    }

    public final Map<Long, StoreMessageAck$Ack> getAll() {
        return this.acksSnapshot;
    }

    @StoreThread
    public final Map<Long, StoreMessageAck$Ack> getAllInternal() {
        return this.acks;
    }

    public final StoreMessageAck$Ack getForChannel(long channelId) {
        return getAll().get(Long.valueOf(channelId));
    }

    @StoreThread
    public final void handleChannelSelected() {
        for (Map$Entry<Long, StoreMessageAck$Ack> map$Entry : this.acks.entrySet()) {
            this.acks.put(Long.valueOf(map$Entry.getKey().longValue()), StoreMessageAck$Ack.copy$default(map$Entry.getValue(), 0L, false, false, 3, null));
        }
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        long dateTimeMillis;
        Object next;
        UtcDateTime joinedAt;
        m.checkNotNullParameter(payload, "payload");
        ModelPayload$VersionedReadStates readState = payload.getReadState();
        m.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.acks.clear();
        }
        Map<Long, StoreMessageAck$Ack> map = this.acks;
        ModelPayload$VersionedReadStates readState2 = payload.getReadState();
        m.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        m.checkNotNullExpressionValue(entries, "payload.readState.entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(entries, 10)), 16));
        for (ModelReadState modelReadState : entries) {
            Pair pair = d0.o.to(Long.valueOf(modelReadState.getChannelId()), new StoreMessageAck$Ack(modelReadState, false, false));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        map.putAll(linkedHashMap);
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<GuildMember> listV = guild.v();
            if (listV != null) {
                Iterator<T> it = listV.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(((GuildMember) next).getUser().getId() == payload.getMe().getId()));
                GuildMember guildMember = (GuildMember) next;
                if (guildMember == null || (joinedAt = guildMember.getJoinedAt()) == null) {
                    dateTimeMillis = 0;
                } else {
                    dateTimeMillis = joinedAt.getDateTimeMillis();
                }
            } else {
                dateTimeMillis = 0;
            }
            List<Channel> listG = guild.g();
            if (listG != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listG) {
                    Channel channel = (Channel) obj;
                    m.checkNotNullParameter(channel, "$this$isTextyOrVoiceChannel");
                    if ((ChannelUtils.v(channel) || ChannelUtils.J(channel)) && !this.acks.containsKey(Long.valueOf(channel.getId()))) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Channel> arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if ((((Channel) obj2).getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < dateTimeMillis) {
                        arrayList2.add(obj2);
                    }
                }
                for (Channel channel2 : arrayList2) {
                    this.acks.put(Long.valueOf(channel2.getId()), new StoreMessageAck$Ack(channel2.getLastMessageId(), false, false));
                }
            }
        }
        pruneAcks();
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observeActiveThreadIdsWithPrevious()), StoreMessageAck.class, (Context) null, new StoreMessageAck$handleConnectionOpen$3(this), (Function1) null, (Function0) null, (Function0) null, new StoreMessageAck$handleConnectionOpen$4(this), 58, (Object) null);
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate() {
        pruneAcks();
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        m.checkNotNullParameter(readState, "readState");
        updateAcks(readState.getChannelId(), new StoreMessageAck$Ack(readState, false, false));
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        m.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author == null || author.getId() != this.stream.getUsers().getMe().getId()) {
            return;
        }
        updateAcks(message.getChannelId(), new StoreMessageAck$Ack(message.getId(), false, false));
    }

    @StoreThread
    public final void handlePreLogout() {
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.threadSyncSubscription = null;
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Channel channelFindChannelById;
        m.checkNotNullParameter(channel, "channel");
        boolean z2 = channel.getOwnerId() == this.stream.getUsers().getMe().getId();
        if (ChannelUtils.H(channel) && !ChannelUtils.j(channel) && z2 && (channelFindChannelById = this.stream.getChannels().findChannelById(channel.getParentId())) != null && ChannelUtils.q(channelFindChannelById)) {
            updateAcks(channelFindChannelById.getId(), new StoreMessageAck$Ack(channel.getId(), false, false));
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Observable<R> observableY = StoreStream.Companion.getChannelsSelected().observeResolvedSelectedChannel().r().Y(new StoreMessageAck$init$1(this));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get… 0L\n          }\n        }");
        Observable<Long> observableP = ObservableExtensionsKt.computationLatest(observableY).p(500L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "StoreStream\n        .get…0, TimeUnit.MILLISECONDS)");
        postPendingAck$default(this, getPendingAck(observableP, false, false), 0, 1, null);
    }

    public final void markUnread(long channelId, long messageId) {
        Observable observableJ = Observable.j(this.stream.getMessages().observeMessagesForChannel(channelId).y(StoreMessageAck$markUnread$1.INSTANCE), observeThreadAckState(channelId), StoreMessageAck$markUnread$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…lMessages, threadState) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 10L, false), StoreMessageAck.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMessageAck$markUnread$3(this, messageId, channelId), 62, (Object) null);
    }

    public final Observable<Map<Long, StoreMessageAck$Ack>> observeAll() {
        Observable<Map<Long, StoreMessageAck$Ack>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMessageAck$observeAll$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreMessageAck$Ack> observeForChannel(long channelId) {
        Observable<StoreMessageAck$Ack> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMessageAck$observeForChannel$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensionsKt.snapshot$default(this.acks, 0, 0.0f, 3, null);
        this.acksSnapshot = mapSnapshot$default;
        Persister.set$default(this.acksPersister, mapSnapshot$default, false, 2, null);
    }
}
