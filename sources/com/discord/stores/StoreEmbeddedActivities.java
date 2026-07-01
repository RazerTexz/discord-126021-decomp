package com.discord.stores;

import com.discord.BuildConfig;
import com.discord.api.embeddedactivities.EmbeddedActivityInGuild;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreEmbeddedActivities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmbeddedActivities extends StoreV2 {
    private final Map<Long, Map<Long, EmbeddedActivity>> embeddedActivitiesByChannel;
    private Map<Long, ? extends Map<Long, EmbeddedActivity>> embeddedActivitiesByChannelSnapshot;
    private final ObservationDeck observationDeck;

    public StoreEmbeddedActivities() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreEmbeddedActivities(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final String getUrlForApplication(long applicationId) {
        if (BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST.length() == 0) {
            return null;
        }
        return "https://" + applicationId + '.' + BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST;
    }

    @StoreThread
    private final void handleEmbeddedActivitiesForGuild(Guild guild) {
        List<EmbeddedActivityInGuild> listJ = guild.j();
        if (listJ == null) {
            listJ = n.emptyList();
        }
        for (EmbeddedActivityInGuild embeddedActivityInGuild : listJ) {
            handleEmbeddedActivityForChannel(embeddedActivityInGuild.getChannelId(), embeddedActivityInGuild.c(), embeddedActivityInGuild.getEmbeddedActivity(), guild.getId());
        }
    }

    @StoreThread
    private final void handleEmbeddedActivityForChannel(long channelId, List<Long> userIds, com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, long guildId) {
        String urlForApplication = getUrlForApplication(apiEmbeddedActivity.getApplicationId());
        if (urlForApplication != null) {
            EmbeddedActivity embeddedActivityFromApiEmbeddedActivity = EmbeddedActivity.Companion.fromApiEmbeddedActivity(apiEmbeddedActivity, userIds, urlForApplication, guildId);
            Map<Long, EmbeddedActivity> linkedHashMap = this.embeddedActivitiesByChannel.get(Long.valueOf(channelId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            long applicationId = embeddedActivityFromApiEmbeddedActivity.getApplicationId();
            if (!userIds.isEmpty()) {
                linkedHashMap.put(Long.valueOf(applicationId), embeddedActivityFromApiEmbeddedActivity);
            } else {
                linkedHashMap.remove(Long.valueOf(applicationId));
            }
            this.embeddedActivitiesByChannel.put(Long.valueOf(channelId), linkedHashMap);
            markChanged();
        }
    }

    public final Map<Long, Map<Long, EmbeddedActivity>> getEmbeddedActivities() {
        return this.embeddedActivitiesByChannelSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.embeddedActivitiesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            m.checkNotNullExpressionValue(guild, "guild");
            handleEmbeddedActivitiesForGuild(guild);
        }
        markChanged();
    }

    @StoreThread
    public final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        m.checkNotNullParameter(embeddedActivityInboundUpdate, "embeddedActivityInboundUpdate");
        handleEmbeddedActivityForChannel(embeddedActivityInboundUpdate.getChannelId(), embeddedActivityInboundUpdate.d(), embeddedActivityInboundUpdate.getEmbeddedActivity(), embeddedActivityInboundUpdate.getGuildId());
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        handleEmbeddedActivitiesForGuild(guild);
    }

    public final Observable<Map<Long, Map<Long, EmbeddedActivity>>> observeEmbeddedActivities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreEmbeddedActivities$observeEmbeddedActivities$1(this), 14, null);
    }

    public final Observable<Map<Long, EmbeddedActivity>> observeEmbeddedActivitiesForChannel(long channelId) {
        Observable observableG = observeEmbeddedActivities().G(new StoreEmbeddedActivities$observeEmbeddedActivitiesForChannel$1(channelId));
        m.checkNotNullExpressionValue(observableG, "observeEmbeddedActivitie…] ?: emptyMap()\n        }");
        return observableG;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map$Entry<Long, Map<Long, EmbeddedActivity>> map$Entry : this.embeddedActivitiesByChannel.entrySet()) {
            map.put(map$Entry.getKey(), new HashMap(map$Entry.getValue()));
        }
        this.embeddedActivitiesByChannelSnapshot = map;
    }

    public StoreEmbeddedActivities(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.embeddedActivitiesByChannelSnapshot = h0.emptyMap();
        this.embeddedActivitiesByChannel = new LinkedHashMap();
    }
}
