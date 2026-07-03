package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreStageInstances.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageInstances extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstance> stageInstancesByChannel;
    private Map<Long, StageInstance> stageInstancesByChannelSnapshot;
    private final Map<Long, Map<Long, StageInstance>> stageInstancesByGuild;
    private Map<Long, ? extends Map<Long, StageInstance>> stageInstancesByGuildSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreStageInstances$observeStageInstanceForChannel$1 */
    /* JADX INFO: compiled from: StoreStageInstances.kt */
    public static final class C64201 extends AbstractC12240o implements Function0<StageInstance> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64201(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StageInstance invoke() {
            return StoreStageInstances.this.getStageInstanceForChannel(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageInstances$observeStageInstances$1 */
    /* JADX INFO: compiled from: StoreStageInstances.kt */
    public static final class C64211 extends AbstractC12240o implements Function0<Map<Long, ? extends StageInstance>> {
        public C64211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageInstance> invoke() {
            return StoreStageInstances.this.getStageInstances();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStageInstances$observeStageInstancesForGuild$1 */
    /* JADX INFO: compiled from: StoreStageInstances.kt */
    public static final class C64221 extends AbstractC12240o implements Function0<Map<Long, ? extends StageInstance>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64221(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends StageInstance> invoke() {
            return StoreStageInstances.this.getStageInstancesForGuild(this.$guildId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreStageInstances() {
        this(null, 1, 0 == true ? 1 : 0);
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
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, StageInstance> getStageInstancesForGuildInternal(long guildId) {
        Map<Long, StageInstance> map = this.stageInstancesByGuild.get(Long.valueOf(guildId));
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final void handleChannelDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        handleDelete(Long.valueOf(channel.getGuildId()), channel.getId());
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.stageInstancesByGuild.clear();
        this.stageInstancesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            C12238m.checkNotNullExpressionValue(guild, "it");
            handleGuildAdd(guild);
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        List<StageInstance> listM7845J = guild.m7845J();
        if (listM7845J != null) {
            Iterator<T> it = listM7845J.iterator();
            while (it.hasNext()) {
                handleStageInstanceCreateOrUpdate((StageInstance) it.next());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        Set<Long> setEmptySet;
        C12238m.checkNotNullParameter(guild, "guild");
        Map<Long, StageInstance> mapRemove = this.stageInstancesByGuild.remove(Long.valueOf(guild.getId()));
        if (mapRemove == null || (setEmptySet = mapRemove.keySet()) == null) {
            setEmptySet = C12148n0.emptySet();
        }
        if (setEmptySet.isEmpty()) {
            return;
        }
        this.stageInstancesByChannel.keySet().removeAll(setEmptySet);
        markChanged();
    }

    @StoreThread
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        handleDelete(Long.valueOf(stageInstance.getGuildId()), stageInstance.getChannelId());
    }

    @StoreThread
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        handleStageInstanceCreateOrUpdate(stageInstance);
    }

    public final Observable<StageInstance> observeStageInstanceForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64201(channelId), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstances() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64211(), 14, null);
    }

    public final Observable<Map<Long, StageInstance>> observeStageInstancesForGuild(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C64221(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.stageInstancesByChannelSnapshot = new HashMap(this.stageInstancesByChannel);
        HashMap map = new HashMap();
        for (Map.Entry<Long, Map<Long, StageInstance>> entry : this.stageInstancesByGuild.entrySet()) {
            map.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        this.stageInstancesByGuildSnapshot = map;
    }

    public StoreStageInstances(ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.stageInstancesByChannel = new LinkedHashMap();
        this.stageInstancesByChannelSnapshot = new HashMap();
        this.stageInstancesByGuild = new LinkedHashMap();
        this.stageInstancesByGuildSnapshot = new HashMap();
    }
}
