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
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.forums.ForumUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreMessagesMostRecent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesMostRecent extends StoreV2 {
    private final HashMap<Long, Long> mostRecentIds;
    private final Persister<Map<Long, Long>> mostRecentIdsCache;
    private Map<Long, Long> mostRecentIdsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesMostRecent$observeRecentMessageIds$1 */
    /* JADX INFO: compiled from: StoreMessagesMostRecent.kt */
    public static final class C62701 extends AbstractC12240o implements Function0<Map<Long, ? extends Long>> {
        public C62701() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Long> invoke() {
            return StoreMessagesMostRecent.this.getMostRecentIds();
        }
    }

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
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.m7673H(channel) && !ChannelUtils.m7686j(channel) && (channel2 = this.storeChannels.getChannel(channel.getParentId())) != null && ChannelUtils.m7693q(channel2)) {
            return updateMostRecentIds(channel2.getId(), channel.getId());
        }
        return false;
    }

    public final Map<Long, Long> getMostRecentIds() {
        return this.mostRecentIdsSnapshot;
    }

    @StoreThread
    public final void handleChannelCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        mostRecentIdsUpdateFromChannels(C12145m.listOf(channel));
    }

    @StoreThread
    public final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelReadStateUpdate) {
        C12238m.checkNotNullParameter(channelReadStateUpdate, "channelReadStateUpdate");
        mostRecentIdsUpdateFromChannels(channelReadStateUpdate);
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        Collection<Channel> privateChannels = payload.getPrivateChannels();
        C12238m.checkNotNullExpressionValue(privateChannels, "payload.privateChannels");
        mostRecentIdsUpdateFromChannels(privateChannels);
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Collection<Channel> collectionM7860g = guild.m7860g();
            if (collectionM7860g != null) {
                mostRecentIdsUpdateFromChannels(collectionM7860g);
            }
            List<Channel> listM7849N = guild.m7849N();
            if (listM7849N != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listM7849N) {
                    if (ChannelUtils.m7673H((Channel) obj)) {
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
        C12238m.checkNotNullParameter(guild, "guild");
        Collection<Channel> collectionM7860g = guild.m7860g();
        if (collectionM7860g != null) {
            mostRecentIdsUpdateFromChannels(collectionM7860g);
        }
        List<Channel> listM7849N = guild.m7849N();
        if (listM7849N != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listM7849N) {
                if (ChannelUtils.m7673H((Channel) obj)) {
                    arrayList.add(obj);
                }
            }
            mostRecentIdsUpdateFromChannels(arrayList);
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        mostRecentIdsUpdateFromMessage(message);
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.m7673H(channel)) {
            mostRecentIdsUpdateFromChannels(C12145m.listOf(channel));
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<Channel> threads = payload.getThreads();
        ArrayList arrayList = new ArrayList();
        for (Object obj : threads) {
            if (ChannelUtils.m7673H((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        mostRecentIdsUpdateFromChannels(arrayList);
    }

    public final Observable<Map<Long, Long>> observeRecentMessageIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62701(), 14, null);
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
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        HashMap<Long, Long> map = new HashMap<>();
        this.mostRecentIds = map;
        this.mostRecentIdsSnapshot = C12136h0.emptyMap();
        this.mostRecentIdsCache = new Persister<>("MOST_RECENT_MESSAGE_IDS", new HashMap(map));
    }

    public final Observable<Long> observeRecentMessageIds(final long channelId) {
        Observable<Long> observableM11112r = observeRecentMessageIds().m11083G(new InterfaceC12589b<Map<Long, ? extends Long>, Long>() { // from class: com.discord.stores.StoreMessagesMostRecent.observeRecentMessageIds.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Map<Long, Long> map) {
                Long l = map.get(Long.valueOf(channelId));
                return Long.valueOf(l != null ? l.longValue() : 0L);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeRecentMessageIds(…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @StoreThread
    private final void mostRecentIdsUpdateFromChannels(Collection<Channel> channels) {
        for (Channel channel : channels) {
            if (ChannelUtils.m7672G(channel)) {
                boolean zUpdateMostRecentIds = updateMostRecentIds(channel.getId(), channel.getLastMessageId());
                boolean zUpdateParentChannelMostRecentIds = updateParentChannelMostRecentIds(channel);
                if (zUpdateMostRecentIds || zUpdateParentChannelMostRecentIds) {
                    markChanged();
                }
            }
        }
    }
}
