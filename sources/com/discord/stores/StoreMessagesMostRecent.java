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
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.forums.ForumUtils;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public /* synthetic */ StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeChannels, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void mostRecentIdsUpdateFromChannels(ModelChannelUnreadUpdate channelUnreadUpdate) {
        for (ModelReadState modelReadState : channelUnreadUpdate.getChannelReadStates()) {
            if (updateMostRecentIds(modelReadState.getChannelId(), modelReadState.getLastMessageId())) {
                markChanged();
            }
        }
    }

    @StoreThread
    private final void mostRecentIdsUpdateFromMessage(Message message) {
        if (updateMostRecentIds(message.getChannelId(), message.getId())) {
            markChanged();
        }
    }

    @StoreThread
    private final boolean updateMostRecentIds(long channelId, long messageId) {
        boolean z2 = MessageUtils.compareMessages(this.mostRecentIds.get(Long.valueOf(channelId)), Long.valueOf(messageId)) < 0;
        if (z2) {
            this.mostRecentIds.put(Long.valueOf(channelId), Long.valueOf(messageId));
        }
        return z2;
    }

    @StoreThread
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

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        mostRecentIdsUpdateFromChannels(d0.t.m.listOf(channel));
    }

    @StoreThread
    public final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelReadStateUpdate) {
        m.checkNotNullParameter(channelReadStateUpdate, "channelReadStateUpdate");
        mostRecentIdsUpdateFromChannels(channelReadStateUpdate);
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        Collection<Channel> privateChannels = payload.getPrivateChannels();
        m.checkNotNullExpressionValue(privateChannels, "payload.privateChannels");
        mostRecentIdsUpdateFromChannels(privateChannels);
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
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

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
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

    @StoreThread
    public final void handleMessageCreate(Message message) {
        m.checkNotNullParameter(message, "message");
        mostRecentIdsUpdateFromMessage(message);
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            mostRecentIdsUpdateFromChannels(d0.t.m.listOf(channel));
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
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
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMessagesMostRecent$observeRecentMessageIds$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensionsKt.snapshot$default(this.mostRecentIds, 0, 0.0f, 3, null);
        this.mostRecentIdsSnapshot = mapSnapshot$default;
        Persister.set$default(this.mostRecentIdsCache, mapSnapshot$default, false, 2, null);
    }

    public StoreMessagesMostRecent(StoreChannels storeChannels, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        HashMap<Long, Long> map = new HashMap<>();
        this.mostRecentIds = map;
        this.mostRecentIdsSnapshot = h0.emptyMap();
        this.mostRecentIdsCache = new Persister<>("MOST_RECENT_MESSAGE_IDS", new HashMap(map));
    }

    public final Observable<Long> observeRecentMessageIds(long channelId) {
        Observable<Long> observableR = observeRecentMessageIds().G(new StoreMessagesMostRecent$observeRecentMessageIds$2(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "observeRecentMessageIds(…  .distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
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
