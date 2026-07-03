package com.discord.stores;

import com.discord.BuildConfig;
import com.discord.api.embeddedactivities.EmbeddedActivityInGuild;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreEmbeddedActivities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmbeddedActivities extends StoreV2 {
    private final Map<Long, Map<Long, EmbeddedActivity>> embeddedActivitiesByChannel;
    private Map<Long, ? extends Map<Long, EmbeddedActivity>> embeddedActivitiesByChannelSnapshot;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreEmbeddedActivities$observeEmbeddedActivities$1 */
    /* JADX INFO: compiled from: StoreEmbeddedActivities.kt */
    public static final class C58861 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>> {
        public C58861() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke() {
            return StoreEmbeddedActivities.this.getEmbeddedActivities();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreEmbeddedActivities() {
        this(null, 1, 0 == true ? 1 : 0);
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
        List<EmbeddedActivityInGuild> listM7863j = guild.m7863j();
        if (listM7863j == null) {
            listM7863j = C12147n.emptyList();
        }
        for (EmbeddedActivityInGuild embeddedActivityInGuild : listM7863j) {
            handleEmbeddedActivityForChannel(embeddedActivityInGuild.getChannelId(), embeddedActivityInGuild.m7804c(), embeddedActivityInGuild.getEmbeddedActivity(), guild.getId());
        }
    }

    @StoreThread
    private final void handleEmbeddedActivityForChannel(long channelId, List<Long> userIds, com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, long guildId) {
        String urlForApplication = getUrlForApplication(apiEmbeddedActivity.getApplicationId());
        if (urlForApplication != null) {
            EmbeddedActivity embeddedActivityFromApiEmbeddedActivity = EmbeddedActivity.INSTANCE.fromApiEmbeddedActivity(apiEmbeddedActivity, userIds, urlForApplication, guildId);
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
        C12238m.checkNotNullParameter(payload, "payload");
        this.embeddedActivitiesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            C12238m.checkNotNullExpressionValue(guild, "guild");
            handleEmbeddedActivitiesForGuild(guild);
        }
        markChanged();
    }

    @StoreThread
    public final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        C12238m.checkNotNullParameter(embeddedActivityInboundUpdate, "embeddedActivityInboundUpdate");
        handleEmbeddedActivityForChannel(embeddedActivityInboundUpdate.getChannelId(), embeddedActivityInboundUpdate.m7808d(), embeddedActivityInboundUpdate.getEmbeddedActivity(), embeddedActivityInboundUpdate.getGuildId());
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        handleEmbeddedActivitiesForGuild(guild);
    }

    public final Observable<Map<Long, Map<Long, EmbeddedActivity>>> observeEmbeddedActivities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58861(), 14, null);
    }

    public final Observable<Map<Long, EmbeddedActivity>> observeEmbeddedActivitiesForChannel(final long channelId) {
        Observable observableM11083G = observeEmbeddedActivities().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>, Map<Long, ? extends EmbeddedActivity>>() { // from class: com.discord.stores.StoreEmbeddedActivities.observeEmbeddedActivitiesForChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends EmbeddedActivity> call(Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> map) {
                return call2((Map<Long, ? extends Map<Long, EmbeddedActivity>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, EmbeddedActivity> call2(Map<Long, ? extends Map<Long, EmbeddedActivity>> map) {
                Map<Long, EmbeddedActivity> map2 = map.get(Long.valueOf(channelId));
                return map2 != null ? map2 : C12136h0.emptyMap();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeEmbeddedActivitie…] ?: emptyMap()\n        }");
        return observableM11083G;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Map<Long, EmbeddedActivity>> entry : this.embeddedActivitiesByChannel.entrySet()) {
            map.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        this.embeddedActivitiesByChannelSnapshot = map;
    }

    public StoreEmbeddedActivities(ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.embeddedActivitiesByChannelSnapshot = C12136h0.emptyMap();
        this.embeddedActivitiesByChannel = new LinkedHashMap();
    }
}
