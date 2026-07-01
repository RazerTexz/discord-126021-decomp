package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentDto;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.ExperimentUtils;
import com.discord.utilities.experiments.RegisteredExperiment;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.gson.Gson;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments extends StoreV2 {
    private static final long DISCORD_TESTERS_GUILD_ID = 197038439483310086L;
    private static final String EXPERIMENT_OVERRIDES_CACHE_KEY = "EXPERIMENT_OVERRIDES_CACHE_KEY";
    private static final String EXPERIMENT_TRACKED_EXPOSURE_TIMESTAMPS_CACHE_KEY = "EXPERIMENT_TRIGGER_TIMESTAMPS_CACHE_KEY";
    private static final String GUILD_EXPERIMENTS_CACHE_KEY = "GUILD_EXPERIMENTS_CACHE_KEY";
    private static final String UNINITIALIZED = "UNINITIALIZED";
    private static final String USER_EXPERIMENTS_CACHE_KEY = "USER_EXPERIMENTS_CACHE_KEY";
    private String authToken;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final HashMap<String, Integer> experimentOverrides;
    private final Persister<Map<String, Integer>> experimentOverridesCache;
    private Map<String, Integer> experimentOverridesSnapshot;
    private final HashMap<String, Long> experimentTrackedExposureTimestamps;
    private String fingerprint;
    private final HashMap<Long, GuildExperimentDto> guildExperiments;
    private final Persister<List<GuildExperimentDto>> guildExperimentsCache;
    private Map<Long, GuildExperimentDto> guildExperimentsSnapshot;
    private boolean initialized;
    private final HashMap<String, Experiment> memoizedGuildExperiments;
    private final ObservationDeck observationDeck;
    private final StoreAuthentication storeAuthentication;
    private final StoreGuildMemberCounts storeGuildMemberCounts;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private final HashMap<Long, UserExperimentDto> userExperiments;
    private final Persister<Map<Long, UserExperimentDto>> userExperimentsCache;
    private Map<Long, UserExperimentDto> userExperimentsSnapshot;
    public static final StoreExperiments$Companion Companion = new StoreExperiments$Companion(null);
    private static final StoreExperiments$Companion$InitializedUpdateSource$1 InitializedUpdateSource = new StoreExperiments$Companion$InitializedUpdateSource$1();
    private static final StoreExperiments$Companion$ExperimentOverridesUpdateSource$1 ExperimentOverridesUpdateSource = new StoreExperiments$Companion$ExperimentOverridesUpdateSource$1();

    public /* synthetic */ StoreExperiments(Clock clock, Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StoreAuthentication storeAuthentication, StoreGuildMemberCounts storeGuildMemberCounts, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, dispatcher, storeUser, storeGuilds, storeAuthentication, storeGuildMemberCounts, (i & 64) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreExperiments storeExperiments) {
        return storeExperiments.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getExperimentOverrides$p(StoreExperiments storeExperiments) {
        return storeExperiments.experimentOverrides;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(StoreExperiments storeExperiments) {
        return storeExperiments.initialized;
    }

    public static final /* synthetic */ StoreAuthentication access$getStoreAuthentication$p(StoreExperiments storeExperiments) {
        return storeExperiments.storeAuthentication;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(StoreExperiments storeExperiments) {
        return storeExperiments.storeGuilds;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(StoreExperiments storeExperiments) {
        return storeExperiments.storeUser;
    }

    public static final /* synthetic */ void access$handleClearOverride(StoreExperiments storeExperiments, String str) {
        storeExperiments.handleClearOverride(str);
    }

    public static final /* synthetic */ void access$handleLoadedUserExperiments(StoreExperiments storeExperiments, Map map, boolean z2) {
        storeExperiments.handleLoadedUserExperiments(map, z2);
    }

    public static final /* synthetic */ void access$handleSetOverride(StoreExperiments storeExperiments, String str, int i) {
        storeExperiments.handleSetOverride(str, i);
    }

    public static final /* synthetic */ void access$setInitialized(StoreExperiments storeExperiments) {
        storeExperiments.setInitialized();
    }

    public static final /* synthetic */ void access$setInitialized$p(StoreExperiments storeExperiments, boolean z2) {
        storeExperiments.initialized = z2;
    }

    public static final /* synthetic */ void access$trackExposureToGuildExperiment(StoreExperiments storeExperiments, String str, long j, int i, int i2) {
        storeExperiments.trackExposureToGuildExperiment(str, j, i, i2);
    }

    public static final /* synthetic */ void access$trackExposureToUserExperiment(StoreExperiments storeExperiments, String str, int i, int i2, int i3) {
        storeExperiments.trackExposureToUserExperiment(str, i, i2, i3);
    }

    private final void cacheExperimentTrackedExposureTimestamps() {
        getPrefs().edit().putString(EXPERIMENT_TRACKED_EXPOSURE_TIMESTAMPS_CACHE_KEY, new Gson().m(this.experimentTrackedExposureTimestamps)).apply();
    }

    private final void cacheGuildExperiments() {
        Collection<GuildExperimentDto> collectionValues = this.guildExperiments.values();
        m.checkNotNullExpressionValue(collectionValues, "guildExperiments.values");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                this.guildExperimentsCache.set(arrayList, true);
                return;
            }
            Object next = it.next();
            GuildExperimentDto guildExperimentDto = (GuildExperimentDto) next;
            Collection<RegisteredExperiment> collectionValues2 = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            m.checkNotNullExpressionValue(collectionValues2, "ExperimentRegistry.registeredExperiments.values");
            if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                Iterator<T> it2 = collectionValues2.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!(ExperimentHash.INSTANCE.from(((RegisteredExperiment) it2.next()).getName()) == guildExperimentDto.getExperimentIdHash()));
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    private final void cacheUserExperiments() {
        HashMap<Long, UserExperimentDto> map = this.userExperiments;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map$Entry<Long, UserExperimentDto>> it = map.entrySet().iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                this.userExperimentsCache.set(linkedHashMap, true);
                return;
            }
            Map$Entry<Long, UserExperimentDto> next = it.next();
            Collection<RegisteredExperiment> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            m.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry.registeredExperiments.values");
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it2 = collectionValues.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!(ExperimentHash.INSTANCE.from(((RegisteredExperiment) it2.next()).getName()) == next.getValue().getNameHash()));
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
    }

    private final void didTrackExposureToExperiment(String exposureKey) {
        this.experimentTrackedExposureTimestamps.put(exposureKey, Long.valueOf(this.clock.currentTimeMillis()));
        cacheExperimentTrackedExposureTimestamps();
    }

    @StoreThread
    private final void handleClearOverride(String experimentName) {
        this.experimentOverrides.remove(experimentName);
        markChanged(ExperimentOverridesUpdateSource);
    }

    @StoreThread
    private final void handleLoadedGuildExperiments(Collection<GuildExperimentDto> experiments, boolean doCache) {
        this.guildExperiments.clear();
        this.memoizedGuildExperiments.clear();
        HashMap<Long, GuildExperimentDto> map = this.guildExperiments;
        for (Object obj : experiments) {
            map.put(Long.valueOf(((GuildExperimentDto) obj).getExperimentIdHash()), (GuildExperimentDto) obj);
        }
        if (doCache) {
            cacheGuildExperiments();
        }
        markChanged();
    }

    @StoreThread
    private final void handleLoadedUserExperiments(Map<Long, UserExperimentDto> experiments, boolean doCache) {
        this.userExperiments.clear();
        this.userExperiments.putAll(experiments);
        if (doCache) {
            cacheUserExperiments();
        }
        markChanged();
    }

    @StoreThread
    private final void handleSetOverride(String experimentName, int bucket) {
        this.experimentOverrides.put(experimentName, Integer.valueOf(bucket));
        markChanged(ExperimentOverridesUpdateSource);
    }

    private final Map<String, Long> loadCachedExperimentTrackedExposureTimestamps() {
        String string = getPrefs().getString(EXPERIMENT_TRACKED_EXPOSURE_TIMESTAMPS_CACHE_KEY, null);
        if (string == null) {
            return h0.emptyMap();
        }
        Object objG = new Gson().g(string, new StoreExperiments$loadCachedExperimentTrackedExposureTimestamps$typeToken$1().getType());
        m.checkNotNullExpressionValue(objG, "Gson().fromJson(json, typeToken)");
        return (Map) objG;
    }

    private final synchronized void memoizeGuildExperiment(String experimentName, long guildId, Experiment experiment) {
        this.memoizedGuildExperiments.put(experimentName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + guildId, experiment);
    }

    @StoreThread
    private final void reset() {
        if (this.authToken == null) {
            this.userExperiments.clear();
            this.guildExperiments.clear();
            this.userExperimentsCache.set(new HashMap(), true);
            this.guildExperimentsCache.set(new ArrayList(), true);
            this.initialized = false;
            markChanged();
        }
    }

    @StoreThread
    private final void setInitialized() {
        this.initialized = true;
        markChanged(InitializedUpdateSource);
    }

    private final synchronized void trackExposureToGuildExperiment(String name, long guildId, int bucket, int revision) {
        String str = name + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + guildId;
        if (wasExperimentExposureTrackedRecently(str, this.clock.currentTimeMillis())) {
            return;
        }
        AnalyticsTracker.guildExperimentTriggered(name, revision, bucket, guildId);
        didTrackExposureToExperiment(str);
    }

    private final synchronized void trackExposureToUserExperiment(String name, int bucket, int population, int revision) {
        if (wasExperimentExposureTrackedRecently(name, this.clock.currentTimeMillis())) {
            return;
        }
        AnalyticsTracker.userExperimentTriggered(name, revision, population, bucket);
        didTrackExposureToExperiment(name);
    }

    @StoreThread
    private final void tryInitializeExperiments() {
        if (this.initialized || m.areEqual(this.authToken, UNINITIALIZED) || m.areEqual(this.fingerprint, UNINITIALIZED)) {
            return;
        }
        this.initialized = true;
        if (this.authToken != null) {
            setInitialized();
            return;
        }
        Observable observableC0 = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getExperiments(), false, 1, null).c0(2000L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableC0, "RestAPI\n          .api\n …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableC0, StoreExperiments.class, (Context) null, (Function1) null, new StoreExperiments$tryInitializeExperiments$2(this), (Function0) null, (Function0) null, new StoreExperiments$tryInitializeExperiments$1(this), 54, (Object) null);
    }

    private final boolean wasExperimentExposureTrackedRecently(String exposureKey, long nowMs) {
        Long l = this.experimentTrackedExposureTimestamps.get(exposureKey);
        if (l == null) {
            l = Long.MIN_VALUE;
        }
        m.checkNotNullExpressionValue(l, "experimentTrackedExposur…y] ?: Timestamp.MIN_VALUE");
        return nowMs - 604800000 < l.longValue();
    }

    public final void clearOverride(String experimentName) {
        m.checkNotNullParameter(experimentName, "experimentName");
        this.dispatcher.schedule(new StoreExperiments$clearOverride$1(this, experimentName));
    }

    public final Observable<Boolean> getExperimentalAlpha() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeUser, this.storeGuilds}, false, null, null, new StoreExperiments$getExperimentalAlpha$1(this), 14, null);
    }

    public final Experiment getGuildExperiment(String experimentName, long guildId, boolean trackExposure) {
        m.checkNotNullParameter(experimentName, "experimentName");
        long jFrom = ExperimentHash.INSTANCE.from(experimentName);
        Integer num = this.experimentOverridesSnapshot.get(experimentName);
        GuildExperimentDto guildExperimentDto = this.guildExperimentsSnapshot.get(Long.valueOf(jFrom));
        if (num != null) {
            return new Experiment(guildExperimentDto != null ? guildExperimentDto.getRevision() : 0, num.intValue(), 0, true, StoreExperiments$getGuildExperiment$1.INSTANCE);
        }
        Experiment memoizedGuildExperiment$app_productionGoogleRelease = getMemoizedGuildExperiment$app_productionGoogleRelease(guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + experimentName, guildId);
        if (memoizedGuildExperiment$app_productionGoogleRelease != null) {
            return memoizedGuildExperiment$app_productionGoogleRelease;
        }
        if (guildExperimentDto == null) {
            return null;
        }
        int iComputeGuildExperimentBucket = ExperimentUtils.INSTANCE.computeGuildExperimentBucket(experimentName, guildId, this.storeGuildMemberCounts.getApproximateMemberCount(guildId), this.storeGuilds.getGuild(guildId), guildExperimentDto);
        int revision = guildExperimentDto.getRevision();
        Experiment experiment = new Experiment(revision, iComputeGuildExperimentBucket, 0, false, new StoreExperiments$getGuildExperiment$experiment$1(this, experimentName, guildId, iComputeGuildExperimentBucket, revision));
        if (trackExposure) {
            experiment.getTrackExposure().invoke();
        }
        memoizeGuildExperiment(experimentName, guildId, experiment);
        return experiment;
    }

    public final synchronized Experiment getMemoizedGuildExperiment$app_productionGoogleRelease(String experimentName, long guildId) {
        m.checkNotNullParameter(experimentName, "experimentName");
        return this.memoizedGuildExperiments.get(experimentName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + guildId);
    }

    public final Experiment getUserExperiment(String name, boolean trackExposure) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        long jFrom = ExperimentHash.INSTANCE.from(name);
        Integer num = this.experimentOverridesSnapshot.get(name);
        UserExperimentDto userExperimentDto = this.userExperimentsSnapshot.get(Long.valueOf(jFrom));
        if (num != null) {
            return new Experiment(userExperimentDto != null ? userExperimentDto.getRevision() : 0, num.intValue(), userExperimentDto != null ? userExperimentDto.getPopulation() : 0, true, StoreExperiments$getUserExperiment$1.INSTANCE);
        }
        if (userExperimentDto == null) {
            return null;
        }
        int bucket = userExperimentDto.getBucket();
        int population = userExperimentDto.getPopulation();
        int revision = userExperimentDto.getRevision();
        Experiment experiment = new Experiment(revision, bucket, population, false, new StoreExperiments$getUserExperiment$experiment$1(this, name, bucket, population, revision));
        if (trackExposure) {
            experiment.getTrackExposure().invoke();
        }
        return experiment;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        this.authToken = authToken;
        reset();
        tryInitializeExperiments();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        Map<Long, UserExperimentDto> experiments = payload.getExperiments();
        m.checkNotNullExpressionValue(experiments, "payload.experiments");
        handleLoadedUserExperiments(experiments, true);
        List<GuildExperimentDto> guildExperiments = payload.getGuildExperiments();
        if (guildExperiments != null) {
            m.checkNotNullExpressionValue(guildExperiments, "it");
            handleLoadedGuildExperiments(guildExperiments, true);
        }
    }

    @StoreThread
    public final void handleFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        tryInitializeExperiments();
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.experimentTrackedExposureTimestamps.putAll(loadCachedExperimentTrackedExposureTimestamps());
        this.experimentOverrides.putAll(this.experimentOverridesCache.get());
        handleLoadedUserExperiments(this.userExperimentsCache.get(), false);
        handleLoadedGuildExperiments(this.guildExperimentsCache.get(), false);
        markChanged(this, ExperimentOverridesUpdateSource);
    }

    public final Observable<Boolean> isInitialized() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{InitializedUpdateSource}, false, null, null, new StoreExperiments$isInitialized$1(this), 14, null);
    }

    public final Observable<Experiment> observeGuildExperiment(String experimentName, long guildId, boolean trackExposure) {
        m.checkNotNullParameter(experimentName, "experimentName");
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreExperiments$observeGuildExperiment$1(this, experimentName, guildId, trackExposure), 14, null);
    }

    public final Observable<Map<String, Integer>> observeOverrides() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{ExperimentOverridesUpdateSource}, false, null, null, new StoreExperiments$observeOverrides$1(this), 14, null);
    }

    public final Observable<Experiment> observeUserExperiment(String name, boolean trackExposure) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Observable<Experiment> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreExperiments$observeUserExperiment$1(this, name, trackExposure), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setOverride(String experimentName, int bucket) {
        m.checkNotNullParameter(experimentName, "experimentName");
        this.dispatcher.schedule(new StoreExperiments$setOverride$1(this, bucket, experimentName));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.userExperimentsSnapshot = new HashMap(this.userExperiments);
        this.guildExperimentsSnapshot = new HashMap(this.guildExperiments);
        if (getUpdateSources().contains(ExperimentOverridesUpdateSource)) {
            this.experimentOverridesSnapshot = new HashMap(this.experimentOverrides);
            this.experimentOverridesCache.set(this.experimentOverrides, true);
        }
    }

    public StoreExperiments(Clock clock, Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StoreAuthentication storeAuthentication, StoreGuildMemberCounts storeGuildMemberCounts, ObservationDeck observationDeck) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        m.checkNotNullParameter(storeGuildMemberCounts, "storeGuildMemberCounts");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.clock = clock;
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeAuthentication = storeAuthentication;
        this.storeGuildMemberCounts = storeGuildMemberCounts;
        this.observationDeck = observationDeck;
        this.authToken = UNINITIALIZED;
        this.fingerprint = UNINITIALIZED;
        this.userExperimentsSnapshot = h0.emptyMap();
        this.guildExperimentsSnapshot = h0.emptyMap();
        this.experimentOverridesSnapshot = h0.emptyMap();
        this.userExperiments = new HashMap<>();
        this.guildExperiments = new HashMap<>();
        this.experimentOverrides = new HashMap<>();
        this.memoizedGuildExperiments = new HashMap<>();
        this.experimentTrackedExposureTimestamps = new HashMap<>();
        this.userExperimentsCache = new Persister<>(USER_EXPERIMENTS_CACHE_KEY, new HashMap());
        this.guildExperimentsCache = new Persister<>(GUILD_EXPERIMENTS_CACHE_KEY, new ArrayList());
        this.experimentOverridesCache = new Persister<>(EXPERIMENT_OVERRIDES_CACHE_KEY, new HashMap());
    }
}
