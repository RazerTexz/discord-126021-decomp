package com.discord.stores;

import android.content.Context;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryType;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories extends StoreV2 {
    public static final StoreDirectories$Companion Companion = new StoreDirectories$Companion(null);
    private static final String DISCORD_HUB_VERIFICATION_CLICKED_KEY = "hub_verification_clicked_key";
    private static final String GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED = "guild_scheduled_events_header_dismissed";
    private static final String HUB_NAME_PROMPT = "hub_name_prompt";
    private Map<Long, RestCallState<List<DirectoryEntryGuild>>> directoriesMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directoriesMapSnapshot;
    private Map<Long, RestCallState<List<DirectoryEntryEvent>>> directoryGuildScheduledEventsMap;
    private Map<Long, ? extends RestCallState<? extends List<DirectoryEntryEvent>>> directoryGuildScheduledEventsMapSnapshot;
    private final Persister<Boolean> discordHubClickedPersister;
    private final Dispatcher dispatcher;
    private Map<Long, RestCallState<Map<Integer, Integer>>> entryCountMap;
    private Map<Long, ? extends RestCallState<? extends Map<Integer, Integer>>> entryCountMapSnapshot;
    private final Persister<Boolean> guildScheduledEventsHeaderDismissed;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildStore;
    private final Persister<Set<Long>> hubNamePromptPersister;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    public /* synthetic */ StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, storeGuilds, storeGuildScheduledEvents, (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Map access$getDirectoriesMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoriesMap;
    }

    public static final /* synthetic */ Map access$getDirectoriesMapSnapshot$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoriesMapSnapshot;
    }

    public static final /* synthetic */ Map access$getDirectoryGuildScheduledEventsMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoryGuildScheduledEventsMap;
    }

    public static final /* synthetic */ Map access$getDirectoryGuildScheduledEventsMapSnapshot$p(StoreDirectories storeDirectories) {
        return storeDirectories.directoryGuildScheduledEventsMapSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreDirectories storeDirectories) {
        return storeDirectories.dispatcher;
    }

    public static final /* synthetic */ Map access$getEntryCountMap$p(StoreDirectories storeDirectories) {
        return storeDirectories.entryCountMap;
    }

    public static final /* synthetic */ StoreGuildScheduledEvents access$getGuildScheduledEventsStore$p(StoreDirectories storeDirectories) {
        return storeDirectories.guildScheduledEventsStore;
    }

    public static final /* synthetic */ Persister access$getHubNamePromptPersister$p(StoreDirectories storeDirectories) {
        return storeDirectories.hubNamePromptPersister;
    }

    public static final /* synthetic */ void access$setDirectoriesMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoriesMap = map;
    }

    public static final /* synthetic */ void access$setDirectoriesMapSnapshot$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoriesMapSnapshot = map;
    }

    public static final /* synthetic */ void access$setDirectoryGuildScheduledEventsMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoryGuildScheduledEventsMap = map;
    }

    public static final /* synthetic */ void access$setDirectoryGuildScheduledEventsMapSnapshot$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.directoryGuildScheduledEventsMapSnapshot = map;
    }

    public static final /* synthetic */ void access$setEntryCountMap$p(StoreDirectories storeDirectories, Map map) {
        storeDirectories.entryCountMap = map;
    }

    public final void addServerToDirectory(long channelId, DirectoryEntryGuild directoryEntry) {
        m.checkNotNullParameter(directoryEntry, "directoryEntry");
        this.dispatcher.schedule(new StoreDirectories$addServerToDirectory$1(this, channelId, directoryEntry));
    }

    public final void fetchDirectoriesForChannel(long channelId) {
        Observable<R> observableG = this.restApi.getDirectoryEntries(channelId).G(StoreDirectories$fetchDirectoriesForChannel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "restApi\n        .getDire…imateMemberCount ?: 0 } }");
        RestCallStateKt.executeRequest(observableG, new StoreDirectories$fetchDirectoriesForChannel$2(this, channelId));
    }

    public final void fetchEntryCountsForChannel(long channelId) {
        RestCallStateKt.executeRequest(this.restApi.getEntryCounts(channelId), new StoreDirectories$fetchEntryCountsForChannel$1(this, channelId));
    }

    public final void fetchGuildScheduledEventsForChannel(long guildId, long channelId) {
        if (GrowthTeamFeatures.INSTANCE.hubEventsEnabled(guildId, false)) {
            RestCallStateKt.executeRequest(this.restApi.getDirectoryGuildScheduledEvents(channelId, DirectoryEntryType.GuildScheduledEvent.getKey()), new StoreDirectories$fetchGuildScheduledEventsForChannel$1(this, channelId));
        }
    }

    public final boolean getAndSetSeenNamePrompt(long guildId) {
        boolean zContains = this.hubNamePromptPersister.get().contains(Long.valueOf(guildId));
        Persister<Set<Long>> persister = this.hubNamePromptPersister;
        persister.set(o0.plus(persister.get(), Long.valueOf(guildId)), true);
        return zContains;
    }

    public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesForChannel(long channelId) {
        return (RestCallState) this.directoriesMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<Map<Integer, Integer>> getEntryCountsForChannel(long channelId) {
        return (RestCallState) this.entryCountMapSnapshot.get(Long.valueOf(channelId));
    }

    public final RestCallState<List<DirectoryEntryEvent>> getGuildScheduledEventsForChannel(long channelId) {
        return (RestCallState) this.directoryGuildScheduledEventsMapSnapshot.get(Long.valueOf(channelId));
    }

    public final boolean getGuildScheduledEventsHeaderDismissed() {
        return this.guildScheduledEventsHeaderDismissed.get().booleanValue();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Observable observableR = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.guildStore.observeGuilds(), 1L, TimeUnit.SECONDS)).G(StoreDirectories$init$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "guildStore\n        .obse…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreDirectories.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreDirectories$init$2(this), 62, (Object) null);
    }

    public final void markDiscordHubClicked() {
        this.discordHubClickedPersister.set(Boolean.TRUE, true);
    }

    public final void markGuildScheduledEventsHeaderDismissed() {
        this.guildScheduledEventsHeaderDismissed.set(Boolean.TRUE, true);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observeDirectories() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreDirectories$observeDirectories$1(this), 14, null);
    }

    public final Observable<RestCallState<List<DirectoryEntryGuild>>> observeDirectoriesForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreDirectories$observeDirectoriesForChannel$1(this, channelId), 14, null);
    }

    public final Observable<Map<Long, RestCallState<List<DirectoryEntryEvent>>>> observeDirectoryGuildScheduledEvents() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreDirectories$observeDirectoryGuildScheduledEvents$1(this), 14, null);
    }

    public final Observable<Boolean> observeDiscordHubClicked() {
        Observable<Boolean> observableR = this.discordHubClickedPersister.getObservable().r();
        m.checkNotNullExpressionValue(observableR, "discordHubClickedPersist…  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeServerFromDirectory(long channelId, long guildId) {
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restApi.removeServerFromHub(channelId, guildId), new StoreDirectories$removeServerFromDirectory$1(channelId, guildId)), new StoreDirectories$removeServerFromDirectory$2(this, channelId, guildId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.directoriesMapSnapshot = new HashMap(this.directoriesMap);
        this.entryCountMapSnapshot = new HashMap(this.entryCountMap);
        this.directoryGuildScheduledEventsMapSnapshot = new HashMap(this.directoryGuildScheduledEventsMap);
    }

    public StoreDirectories(Dispatcher dispatcher, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildScheduledEvents storeGuildScheduledEvents, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildStore = storeGuilds;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.restApi = restAPI;
        this.directoriesMapSnapshot = h0.emptyMap();
        this.directoriesMap = new LinkedHashMap();
        this.entryCountMapSnapshot = h0.emptyMap();
        this.entryCountMap = new LinkedHashMap();
        this.directoryGuildScheduledEventsMapSnapshot = h0.emptyMap();
        this.directoryGuildScheduledEventsMap = new LinkedHashMap();
        Boolean bool = Boolean.FALSE;
        this.discordHubClickedPersister = new Persister<>(DISCORD_HUB_VERIFICATION_CLICKED_KEY, bool);
        this.guildScheduledEventsHeaderDismissed = new Persister<>(GUILD_SCHEDULED_EVENTS_HEADER_DISMISSED, bool);
        this.hubNamePromptPersister = new Persister<>(HUB_NAME_PROMPT, n0.emptySet());
    }
}
