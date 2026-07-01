package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreStageInstances.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageInstances extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstance> stageInstancesByChannel;
    private Map<Long, StageInstance> stageInstancesByChannelSnapshot;
    private final Map<Long, Map<Long, StageInstance>> stageInstancesByGuild;
    private Map<Long, ? extends Map<Long, StageInstance>> stageInstancesByGuildSnapshot;

    public StoreStageInstances() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreStageInstances(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final void handleDelete(Long guildId, long channelId) {
        this.stageInstancesByChannel.remove(Long.valueOf(channelId));
        Map<Long, StageInstance> map = this.stageInstancesByGuild.get(guildId);
        if (map != null) {
            map.remove(Long.valueOf(channelId));
        }
        markChanged();
    }

    private final void handleStageInstanceCreateOrUpdate(StageInstance stageInstance) {
        this.stageInstancesByChannel.put(Long.valueOf(stageInstance.getChannelId()), stageInstance);
        Map<Long, Map<Long, StageInstance>> map = this.stageInstancesByGuild;
        Long lValueOf = Long.valueOf(stageInstance.getGuildId());
        Map<Long, StageInstance> linkedHashMap = map.get(lValueOf);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            map.put(lValueOf, linkedHashMap);
        }
        linkedHashMap.put(Long.valueOf(stageInstance.getChannelId()), stageInstance);
        markChanged();
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        return this.stageInstancesByChannelSnapshot.get(Long.valueOf(channelId));
    }

    public final StageInstance getStageInstanceForChannelInternal(long channelId) {
        return this.stageInstancesByChannel.get(Long.valueOf(channelId));
    }

    public final Map<Long, StageInstance> getStageInstances() {
        return this.stageInstancesByChannelSnapshot;
    }

    public final Map<Long, Map<Long, StageInstance>> getStageInstancesByGuild() {
        return this.stageInstancesByGuildSnapshot;
    }

    public final Map<Long, StageInstance> getStageInstancesForGuild(long guildId) {
        Map<Long, StageInstance> map = this.stageInstancesByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, StageInstance> getStageInstancesForGuildInternal(long guildId) {
        Map<Long, StageInstance> map = this.stageInstancesByGuild.get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    @StoreThread
    public final void handleChannelDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        handleDelete(Long.valueOf(channel.getGuildId()), channel.getId());
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.stageInstancesByGuild.clear();
        this.stageInstancesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            m.checkNotNullExpressionValue(guild, "it");
            handleGuildAdd(guild);
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<StageInstance> listJ = guild.J();
        if (listJ != null) {
            Iterator<T> it = listJ.iterator();
            while (it.hasNext()) {
                handleStageInstanceCreateOrUpdate((StageInstance) it.next());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        Set<Long> setEmptySet;
        m.checkNotNullParameter(guild, "guild");
        Map<Long, StageInstance> mapRemove = this.stageInstancesByGuild.remove(Long.valueOf(guild.getId()));
        if (mapRemove == null || (setEmptySet = mapRemove.keySet()) == null) {
            setEmptySet = n0.emptySet();
        }
        if (setEmptySet.isEmpty()) {
            return;
        }
        this.stageInstancesByChannel.keySet().removeAll(setEmptySet);
        markChanged();
    }

    @StoreThread
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        handleDelete(Long.valueOf(stageInstance.getGuildId()), stageInstance.getChannelId());
    }

    @StoreThread
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    public final Observable<StageInstance> observeStageInstanceForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStageInstances$observeStageInstanceForChannel$1(this, channelId), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstances() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStageInstances$observeStageInstances$1(this), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstancesForGuild(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStageInstances$observeStageInstancesForGuild$1(this, guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.stageInstancesByChannelSnapshot = new HashMap(this.stageInstancesByChannel);
        HashMap map = new HashMap();
        for (Map$Entry<Long, Map<Long, StageInstance>> map$Entry : this.stageInstancesByGuild.entrySet()) {
            map.put(map$Entry.getKey(), new HashMap(map$Entry.getValue()));
        }
        this.stageInstancesByGuildSnapshot = map;
    }

    public StoreStageInstances(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.stageInstancesByChannel = new LinkedHashMap();
        this.stageInstancesByChannelSnapshot = new HashMap();
        this.stageInstancesByGuild = new LinkedHashMap();
        this.stageInstancesByGuildSnapshot = new HashMap();
    }
}
