package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.persister.Persister;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSelected extends StoreV2 {
    public static final StoreGuildSelected$Companion Companion = new StoreGuildSelected$Companion(null);
    private static final int MAX_SAVED_GUILD_IDS = 5;
    public static final long UNSELECTED = 0;
    private final StoreAnalytics analyticsStore;
    private final Dispatcher dispatcher;
    private final StoreGuilds guildStore;
    private final ObservationDeck observationDeck;
    private final LeastRecentlyAddedSet<Long> selectedGuildIds;
    private final Persister<LeastRecentlyAddedSet<Long>> selectedGuildIdsCache;
    private List<Long> selectedGuildIdsSnapshot;
    private final StoreStream stream;

    public /* synthetic */ StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeGuilds, storeAnalytics, (i & 16) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.guildStore;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.stream;
    }

    public final void dispatchSampleGuildIdSelected(long guildId) {
        this.dispatcher.schedule(new StoreGuildSelected$dispatchSampleGuildIdSelected$1(this, guildId));
    }

    public final List<Long> getRecentlySelectedGuildIds() {
        return this.selectedGuildIdsSnapshot;
    }

    public final long getSelectedGuildId() {
        Long l = (Long) u.firstOrNull((List) this.selectedGuildIdsSnapshot);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @StoreThread
    public final long getSelectedGuildIdInternal$app_productionGoogleRelease() {
        Long l = (Long) u.lastOrNull(this.selectedGuildIds);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        r.removeAll(this.selectedGuildIds, new StoreGuildSelected$handleConnectionOpen$1(payload));
        markChanged();
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        if (this.selectedGuildIds.remove(Long.valueOf(guild.getId()))) {
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildSelected(long guildId) {
        this.selectedGuildIds.add(Long.valueOf(guildId));
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.selectedGuildIds.clear();
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.selectedGuildIds.clear();
        this.selectedGuildIds.addAll(this.selectedGuildIdsCache.get());
        markChanged();
    }

    public final Observable<List<Long>> observeRecentSelectedGuildIds() {
        Observable<List<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildSelected$observeRecentSelectedGuildIds$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.guild.Guild> observeSelectedGuild() {
        Observable<com.discord.models.guild.Guild> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this, this.guildStore}, false, null, null, new StoreGuildSelected$observeSelectedGuild$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeSelectedGuildId() {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildSelected$observeSelectedGuildId$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void set(long guildId) {
        this.dispatcher.schedule(new StoreGuildSelected$set$1(this, guildId));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        if (this.selectedGuildIds.isEmpty()) {
            this.selectedGuildIds.add(0L);
        }
        this.analyticsStore.trackGuildViewed(((Number) u.last(this.selectedGuildIds)).longValue());
        Set<Long> lurkingGuildIdsSync = this.stream.getLurking().getLurkingGuildIdsSync();
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(0, null, 3, null);
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet2 = this.selectedGuildIds;
        ArrayList arrayList = new ArrayList();
        for (Long l : leastRecentlyAddedSet2) {
            if (true ^ lurkingGuildIdsSync.contains(Long.valueOf(l.longValue()))) {
                arrayList.add(l);
            }
        }
        leastRecentlyAddedSet.addAll(arrayList);
        this.selectedGuildIdsCache.set(leastRecentlyAddedSet, true);
        this.selectedGuildIdsSnapshot = u.reversed(this.selectedGuildIds);
    }

    public StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(storeAnalytics, "analyticsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.analyticsStore = storeAnalytics;
        this.observationDeck = observationDeck;
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(5, null, 2, null);
        this.selectedGuildIds = leastRecentlyAddedSet;
        this.selectedGuildIdsSnapshot = new ArrayList();
        this.selectedGuildIdsCache = new Persister<>("STORE_GUILD_SELECTED_V5", leastRecentlyAddedSet);
    }
}
