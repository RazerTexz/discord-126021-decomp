package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.message.Message;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.forums.ForumUtils;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessagesMostRecent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesMostRecent extends StoreV2 {
    private final HashMap<Long, Long> mostRecentIds;
    private final Persister<Map<Long, Long>> mostRecentIdsCache;
    private Map<Long, Long> mostRecentIdsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesMostRecent$observeRecentMessageIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesMostRecent.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Long> invoke() {
            return StoreMessagesMostRecent.this.getMostRecentIds();
        }
    }

    public /* synthetic */ StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannels, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void mostRecentIdsUpdateFromChannels(ModelChannelUnreadUpdate channelUnreadUpdate) {
        for (ModelReadState modelReadState : channelUnreadUpdate.getChannelReadStates()) {
            if (updateMostRecentIds(modelReadState.getChannelId(), modelReadState.getLastMessageId())) {
                markChanged();
            }
        }
    }

    @Store3
    private final void mostRecentIdsUpdateFromMessage(Message message) {
        if (updateMostRecentIds(message.getChannelId(), message.getId())) {
            markChanged();
        }
    }

    @Store3
    private final boolean updateMostRecentIds(long channelId, long messageId) {
        boolean z2 = MessageUtils.compareMessages(this.mostRecentIds.get(Long.valueOf(channelId)), Long.valueOf(messageId)) < 0;
        if (z2) {
            this.mostRecentIds.put(Long.valueOf(channelId), Long.valueOf(messageId));
        }
        return z2;
    }

    @Store3
    private final boolean updateParentChannelMostRecentIds(Channel channel) {
        Channel channel2;
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.H(channel) && !ChannelUtils.j(channel) && (channel2 = this.storeChannels.getChannel(channel.getParentId())) != null && ChannelUtils.q(channel2)) {
            return updateMostRecentIds(channel2.getId(), channel.getId());
        }
        return false;
    }

    public final Map<Long, Long> getMostRecentIds() {
        return this.mostRecentIdsSnapshot;
    }

    @Store3
    public final void handleChannelCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        mostRecentIdsUpdateFromChannels(CollectionsJVM.listOf(channel));
    }

    @Store3
    public final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelReadStateUpdate) {
        Intrinsics3.checkNotNullParameter(channelReadStateUpdate, "channelReadStateUpdate");
        mostRecentIdsUpdateFromChannels(channelReadStateUpdate);
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        Collection<Channel> privateChannels = payload.getPrivateChannels();
        Intrinsics3.checkNotNullExpressionValue(privateChannels, "payload.privateChannels");
        mostRecentIdsUpdateFromChannels(privateChannels);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Collection<Channel> collectionG = guild.g();
            if (collectionG != null) {
                mostRecentIdsUpdateFromChannels(collectionG);
            }
            List<Channel> listN = guild.N();
            if (listN != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listN) {
                    if (ChannelUtils.H((Channel) obj)) {
                        arrayList.add(obj);
                    }
                }
                mostRecentIdsUpdateFromChannels(arrayList);
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Collection<Channel> collectionG = guild.g();
        if (collectionG != null) {
            mostRecentIdsUpdateFromChannels(collectionG);
        }
        List<Channel> listN = guild.N();
        if (listN != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listN) {
                if (ChannelUtils.H((Channel) obj)) {
                    arrayList.add(obj);
                }
            }
            mostRecentIdsUpdateFromChannels(arrayList);
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        mostRecentIdsUpdateFromMessage(message);
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            mostRecentIdsUpdateFromChannels(CollectionsJVM.listOf(channel));
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Channel> threads = payload.getThreads();
        ArrayList arrayList = new ArrayList();
        for (Object obj : threads) {
            if (ChannelUtils.H((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        mostRecentIdsUpdateFromChannels(arrayList);
    }

    public final Observable<Map<Long, Long>> observeRecentMessageIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensions.snapshot$default(this.mostRecentIds, 0, 0.0f, 3, null);
        this.mostRecentIdsSnapshot = mapSnapshot$default;
        Persister.set$default(this.mostRecentIdsCache, mapSnapshot$default, false, 2, null);
    }

    public StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        HashMap<Long, Long> map = new HashMap<>();
        this.mostRecentIds = map;
        this.mostRecentIdsSnapshot = Maps6.emptyMap();
        this.mostRecentIdsCache = new Persister<>("MOST_RECENT_MESSAGE_IDS", new HashMap(map));
    }

    public final Observable<Long> observeRecentMessageIds(final long channelId) {
        Observable<Long> observableR = observeRecentMessageIds().G(new Func1<Map<Long, ? extends Long>, Long>() { // from class: com.discord.stores.StoreMessagesMostRecent.observeRecentMessageIds.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Map<Long, Long> map) {
                Long l = map.get(Long.valueOf(channelId));
                return Long.valueOf(l != null ? l.longValue() : 0L);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeRecentMessageIds(…  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    private final void mostRecentIdsUpdateFromChannels(Collection<Channel> channels) {
        for (Channel channel : channels) {
            if (ChannelUtils.G(channel)) {
                boolean zUpdateMostRecentIds = updateMostRecentIds(channel.getId(), channel.getLastMessageId());
                boolean zUpdateParentChannelMostRecentIds = updateParentChannelMostRecentIds(channel);
                if (zUpdateMostRecentIds || zUpdateParentChannelMostRecentIds) {
                    markChanged();
                }
            }
        }
    }
}
