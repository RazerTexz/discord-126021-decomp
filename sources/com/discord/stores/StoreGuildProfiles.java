package com.discord.stores;

import com.discord.api.guild.preview.GuildPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, StoreGuildProfiles$GuildProfileData> guildProfilesState;
    private Map<Long, StoreGuildProfiles$GuildProfileData> guildProfilesStateSnapshot;
    private final ObservationDeck observationDeck;

    public StoreGuildProfiles(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildProfilesState = new HashMap();
        this.guildProfilesStateSnapshot = new HashMap();
    }

    public static final /* synthetic */ void access$fetchIfNonexisting(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.fetchIfNonexisting(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.dispatcher;
    }

    public static final /* synthetic */ Map access$getGuildProfilesState$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.guildProfilesState;
    }

    public static final /* synthetic */ Map access$getGuildProfilesStateSnapshot$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.guildProfilesStateSnapshot;
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchFailed(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.handleGuildProfileFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchStart(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.handleGuildProfileFetchStart(j);
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchSuccess(StoreGuildProfiles storeGuildProfiles, GuildPreview guildPreview) {
        storeGuildProfiles.handleGuildProfileFetchSuccess(guildPreview);
    }

    public static final /* synthetic */ void access$setGuildProfilesStateSnapshot$p(StoreGuildProfiles storeGuildProfiles, Map map) {
        storeGuildProfiles.guildProfilesStateSnapshot = map;
    }

    @StoreThread
    private final void fetchGuildProfile(long guildId) {
        this.dispatcher.schedule(new StoreGuildProfiles$fetchGuildProfile$1(this, guildId));
    }

    @StoreThread
    private final void fetchIfNonexisting(long guildId) {
        StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData = this.guildProfilesState.get(Long.valueOf(guildId));
        if (storeGuildProfiles$GuildProfileData == null || storeGuildProfiles$GuildProfileData.getFetchState() == StoreGuildProfiles$FetchStates.FAILED) {
            fetchGuildProfile(guildId);
        }
    }

    @StoreThread
    private final void handleGuildProfileFetchFailed(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new StoreGuildProfiles$GuildProfileData(StoreGuildProfiles$FetchStates.FAILED, null));
        markChanged();
    }

    @StoreThread
    private final void handleGuildProfileFetchStart(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new StoreGuildProfiles$GuildProfileData(StoreGuildProfiles$FetchStates.FETCHING, null));
        markChanged();
    }

    @StoreThread
    private final void handleGuildProfileFetchSuccess(GuildPreview guildPreview) {
        this.guildProfilesState.put(Long.valueOf(guildPreview.getId()), new StoreGuildProfiles$GuildProfileData(StoreGuildProfiles$FetchStates.SUCCEEDED, guildPreview));
        markChanged();
    }

    public final Observable<StoreGuildProfiles$GuildProfileData> observeGuildProfile(long guildId) {
        this.dispatcher.schedule(new StoreGuildProfiles$observeGuildProfile$1(this, guildId));
        Observable<StoreGuildProfiles$GuildProfileData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildProfiles$observeGuildProfile$2(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.guildProfilesStateSnapshot = new HashMap(this.guildProfilesState);
    }
}
