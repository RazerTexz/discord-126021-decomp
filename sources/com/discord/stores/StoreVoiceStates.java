package com.discord.stores;

import b.c.a.a0.d;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceStates extends StoreV2 {
    private final HashSet<Long> dirtyGuildIds;
    private Long myUserId;
    private final Function3<Long, Long, Long, Unit> notifyVoiceStatesUpdated;
    private final ObservationDeck observationDeck;
    private String sessionId;
    private final HashMap<Long, HashMap<Long, VoiceState>> voiceStates;
    private Map<Long, ? extends Map<Long, VoiceState>> voiceStatesSnapshot;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreVoiceStates(Function3<? super Long, ? super Long, ? super Long, Unit> function3, ObservationDeck observationDeck) {
        m.checkNotNullParameter(function3, "notifyVoiceStatesUpdated");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.notifyVoiceStatesUpdated = function3;
        this.observationDeck = observationDeck;
        HashMap<Long, HashMap<Long, VoiceState>> map = new HashMap<>();
        this.voiceStates = map;
        this.voiceStatesSnapshot = new HashMap(map);
        this.dirtyGuildIds = new HashSet<>();
    }

    public static final /* synthetic */ Map access$getVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates) {
        return storeVoiceStates.voiceStatesSnapshot;
    }

    public static final /* synthetic */ void access$setVoiceStatesSnapshot$p(StoreVoiceStates storeVoiceStates, Map map) {
        storeVoiceStates.voiceStatesSnapshot = map;
    }

    @StoreThread
    private final void clear() {
        this.dirtyGuildIds.addAll(this.voiceStates.keySet());
        this.voiceStates.clear();
        markChanged();
    }

    @StoreThread
    private final void updateVoiceState(VoiceState voiceState, Long guildId) {
        Long channelId;
        Long l;
        long jLongValue = guildId != null ? guildId.longValue() : voiceState.getGuildId();
        long userId = voiceState.getUserId();
        if ((!m.areEqual(voiceState.getSessionId(), this.sessionId)) && (l = this.myUserId) != null && userId == l.longValue()) {
            HashMap<Long, VoiceState> map = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map != null && map.remove(Long.valueOf(userId)) != null) {
                this.dirtyGuildIds.add(Long.valueOf(jLongValue));
            }
        } else {
            boolean z2 = false;
            HashMap<Long, HashMap<Long, VoiceState>> map2 = this.voiceStates;
            Long lValueOf = Long.valueOf(jLongValue);
            HashMap<Long, VoiceState> map3 = this.voiceStates.get(Long.valueOf(jLongValue));
            if (map3 == null) {
                map3 = new HashMap<>();
            }
            long jLongValue2 = 0;
            if (d.X0(voiceState)) {
                VoiceState voiceStateRemove = map3.remove(Long.valueOf(userId));
                if (voiceStateRemove != null) {
                    Long channelId2 = voiceStateRemove.getChannelId();
                    if (channelId2 != null) {
                        jLongValue2 = channelId2.longValue();
                    }
                    z2 = true;
                }
            } else if (!m.areEqual(voiceState, map3.get(Long.valueOf(userId)))) {
                VoiceState voiceState2 = map3.get(Long.valueOf(userId));
                if (voiceState2 != null && (channelId = voiceState2.getChannelId()) != null) {
                    jLongValue2 = channelId.longValue();
                }
                map3.put(Long.valueOf(userId), voiceState);
                z2 = true;
            }
            map2.put(lValueOf, map3);
            if (z2) {
                this.dirtyGuildIds.add(Long.valueOf(jLongValue));
                this.notifyVoiceStatesUpdated.invoke(Long.valueOf(jLongValue), Long.valueOf(jLongValue2), Long.valueOf(userId));
            }
        }
        if (!this.dirtyGuildIds.isEmpty()) {
            markChanged();
        }
    }

    public static /* synthetic */ void updateVoiceState$default(StoreVoiceStates storeVoiceStates, VoiceState voiceState, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeVoiceStates.updateVoiceState(voiceState, l);
    }

    public final Map<Long, Map<Long, VoiceState>> get() {
        return this.voiceStatesSnapshot;
    }

    public final Map<Long, VoiceState> getForChannel(long guildId, long channelId) {
        Map<Long, VoiceState> mapEmptyMap = this.voiceStatesSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, VoiceState> map$Entry : mapEmptyMap.entrySet()) {
            Long channelId2 = map$Entry.getValue().getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @StoreThread
    public final Map<Long, Map<Long, VoiceState>> getInternal$app_productionGoogleRelease() {
        return this.voiceStates;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            clear();
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        this.myUserId = Long.valueOf(payload.getMe().getId());
        clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
                }
            }
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<VoiceState> listR = guild.R();
        if (listR != null) {
            Iterator<T> it = listR.iterator();
            while (it.hasNext()) {
                updateVoiceState((VoiceState) it.next(), Long.valueOf(guild.getId()));
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.voiceStates.remove(Long.valueOf(guild.getId()));
        this.dirtyGuildIds.add(Long.valueOf(guild.getId()));
        markChanged();
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        updateVoiceState$default(this, voiceState, null, 2, null);
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreVoiceStates$observe$1(this, guildId), 14, null);
    }

    public final Observable<Map<Long, VoiceState>> observeForPrivateChannels(long channelId) {
        return observe(0L, channelId);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.voiceStates.size());
        for (Map$Entry<Long, HashMap<Long, VoiceState>> map$Entry : this.voiceStates.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            HashMap<Long, VoiceState> value = map$Entry.getValue();
            if (this.dirtyGuildIds.contains(Long.valueOf(jLongValue))) {
                map.put(Long.valueOf(jLongValue), new HashMap(value));
            } else {
                Map<Long, VoiceState> map2 = this.voiceStatesSnapshot.get(Long.valueOf(jLongValue));
                if (map2 != null) {
                    map.put(Long.valueOf(jLongValue), map2);
                }
            }
        }
        this.voiceStatesSnapshot = map;
        this.dirtyGuildIds.clear();
    }

    public final Observable<Map<Long, VoiceState>> observe(long guildId, long channelId) {
        Observable<Map<Long, VoiceState>> observableR = observe(guildId).Y(new StoreVoiceStates$observe$2(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "observe(guildId)\n       …  .distinctUntilChanged()");
        return observableR;
    }
}
