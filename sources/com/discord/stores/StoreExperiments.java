package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentDto;
import com.discord.models.experiments.dto.UnauthenticatedUserExperimentsDto;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.utilities.experiments.ExperimentUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StoreExperiments3 InitializedUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreExperiments$Companion$InitializedUpdateSource$1
    };
    private static final StoreExperiments2 ExperimentOverridesUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreExperiments$Companion$ExperimentOverridesUpdateSource$1
    };

    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isExperimentalAlpha(StoreGuilds storeGuilds, StoreUser storeUser) {
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) || storeGuilds.getGuilds().get(Long.valueOf(StoreExperiments.DISCORD_TESTERS_GUILD_ID)) != null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$clearOverride$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $experimentName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$experimentName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExperiments.this.handleClearOverride(this.$experimentName);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$getExperimentalAlpha$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreExperiments.INSTANCE.isExperimentalAlpha(StoreExperiments.this.storeGuilds, StoreExperiments.this.storeUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$getGuildExperiment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$getUserExperiment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$isInitialized$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreExperiments.this.initialized;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$observeGuildExperiment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Experiment> {
        public final /* synthetic */ String $experimentName;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $trackExposure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, boolean z2) {
            super(0);
            this.$experimentName = str;
            this.$guildId = j;
            this.$trackExposure = z2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Experiment invoke() {
            return StoreExperiments.this.getGuildExperiment(this.$experimentName, this.$guildId, this.$trackExposure);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$observeOverrides$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Integer> invoke() {
            return StoreExperiments.this.experimentOverrides;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$observeUserExperiment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Experiment> {
        public final /* synthetic */ String $name;
        public final /* synthetic */ boolean $trackExposure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2) {
            super(0);
            this.$name = str;
            this.$trackExposure = z2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Experiment invoke() {
            return StoreExperiments.this.getUserExperiment(this.$name, this.$trackExposure);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$setOverride$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $bucket;
        public final /* synthetic */ String $experimentName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, String str) {
            super(0);
            this.$bucket = i;
            this.$experimentName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Integer num = (Integer) StoreExperiments.this.experimentOverrides.get(this.$experimentName);
            if (num != null && num.intValue() == this.$bucket) {
                return;
            }
            StoreExperiments.this.handleSetOverride(this.$experimentName, this.$bucket);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$tryInitializeExperiments$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<UnauthenticatedUserExperimentsDto, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$tryInitializeExperiments$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreExperiments.kt */
        public static final class C01091 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ UnauthenticatedUserExperimentsDto $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01091(UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto) {
                super(0);
                this.$it = unauthenticatedUserExperimentsDto;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreExperiments.this.storeAuthentication.setFingerprint(this.$it.getFingerprint(), false);
                StoreExperiments storeExperiments = StoreExperiments.this;
                List<UserExperimentDto> assignments = this.$it.getAssignments();
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(assignments, 10)), 16));
                for (Object obj : assignments) {
                    linkedHashMap.put(Long.valueOf(((UserExperimentDto) obj).getNameHash()), obj);
                }
                storeExperiments.handleLoadedUserExperiments(linkedHashMap, true);
                StoreExperiments.this.setInitialized();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto) {
            invoke2(unauthenticatedUserExperimentsDto);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto) {
            StoreExperiments.this.dispatcher.schedule(new C01091(unauthenticatedUserExperimentsDto));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$tryInitializeExperiments$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExperiments.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreExperiments$tryInitializeExperiments$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreExperiments.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreExperiments.this.setInitialized();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreExperiments.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreExperiments(Clock clock, Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StoreAuthentication storeAuthentication, StoreGuildMemberCounts storeGuildMemberCounts, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, dispatcher, storeUser, storeGuilds, storeAuthentication, storeGuildMemberCounts, (i & 64) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void cacheExperimentTrackedExposureTimestamps() {
        getPrefs().edit().putString(EXPERIMENT_TRACKED_EXPOSURE_TIMESTAMPS_CACHE_KEY, new Gson().m(this.experimentTrackedExposureTimestamps)).apply();
    }

    private final void cacheGuildExperiments() {
        Collection<GuildExperimentDto> collectionValues = this.guildExperiments.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "guildExperiments.values");
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
            Collection<ExperimentRegistry2> collectionValues2 = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues2, "ExperimentRegistry.registeredExperiments.values");
            if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                Iterator<T> it2 = collectionValues2.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!(ExperimentHash.INSTANCE.from(((ExperimentRegistry2) it2.next()).getName()) == guildExperimentDto.getExperimentIdHash()));
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
        Iterator<Map.Entry<Long, UserExperimentDto>> it = map.entrySet().iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                this.userExperimentsCache.set(linkedHashMap, true);
                return;
            }
            Map.Entry<Long, UserExperimentDto> next = it.next();
            Collection<ExperimentRegistry2> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry.registeredExperiments.values");
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it2 = collectionValues.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!(ExperimentHash.INSTANCE.from(((ExperimentRegistry2) it2.next()).getName()) == next.getValue().getNameHash()));
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

    @Store3
    private final void handleClearOverride(String experimentName) {
        this.experimentOverrides.remove(experimentName);
        markChanged(ExperimentOverridesUpdateSource);
    }

    @Store3
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

    @Store3
    private final void handleLoadedUserExperiments(Map<Long, UserExperimentDto> experiments, boolean doCache) {
        this.userExperiments.clear();
        this.userExperiments.putAll(experiments);
        if (doCache) {
            cacheUserExperiments();
        }
        markChanged();
    }

    @Store3
    private final void handleSetOverride(String experimentName, int bucket) {
        this.experimentOverrides.put(experimentName, Integer.valueOf(bucket));
        markChanged(ExperimentOverridesUpdateSource);
    }

    private final Map<String, Long> loadCachedExperimentTrackedExposureTimestamps() {
        String string = getPrefs().getString(EXPERIMENT_TRACKED_EXPOSURE_TIMESTAMPS_CACHE_KEY, null);
        if (string == null) {
            return Maps6.emptyMap();
        }
        Object objG = new Gson().g(string, new TypeToken<Map<String, ? extends Long>>() { // from class: com.discord.stores.StoreExperiments$loadCachedExperimentTrackedExposureTimestamps$typeToken$1
        }.getType());
        Intrinsics3.checkNotNullExpressionValue(objG, "Gson().fromJson(json, typeToken)");
        return (Map) objG;
    }

    private final synchronized void memoizeGuildExperiment(String experimentName, long guildId, Experiment experiment) {
        this.memoizedGuildExperiments.put(experimentName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + guildId, experiment);
    }

    @Store3
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

    @Store3
    private final void setInitialized() {
        this.initialized = true;
        markChanged(InitializedUpdateSource);
    }

    private final synchronized void trackExposureToGuildExperiment(String name, long guildId, int bucket, int revision) {
        String str = name + MentionUtils.EMOJIS_AND_STICKERS_CHAR + guildId;
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

    @Store3
    private final void tryInitializeExperiments() {
        if (this.initialized || Intrinsics3.areEqual(this.authToken, UNINITIALIZED) || Intrinsics3.areEqual(this.fingerprint, UNINITIALIZED)) {
            return;
        }
        this.initialized = true;
        if (this.authToken != null) {
            setInitialized();
            return;
        }
        Observable observableC0 = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getExperiments(), false, 1, null).c0(2000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableC0, "RestAPI\n          .api\n …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableC0, (Class<?>) StoreExperiments.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final boolean wasExperimentExposureTrackedRecently(String exposureKey, long nowMs) {
        Long l = this.experimentTrackedExposureTimestamps.get(exposureKey);
        if (l == null) {
            l = Long.MIN_VALUE;
        }
        Intrinsics3.checkNotNullExpressionValue(l, "experimentTrackedExposur…y] ?: Timestamp.MIN_VALUE");
        return nowMs - 604800000 < l.longValue();
    }

    public final void clearOverride(String experimentName) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        this.dispatcher.schedule(new AnonymousClass1(experimentName));
    }

    public final Observable<Boolean> getExperimentalAlpha() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeUser, this.storeGuilds}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Experiment getGuildExperiment(String experimentName, long guildId, boolean trackExposure) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        long jFrom = ExperimentHash.INSTANCE.from(experimentName);
        Integer num = this.experimentOverridesSnapshot.get(experimentName);
        GuildExperimentDto guildExperimentDto = this.guildExperimentsSnapshot.get(Long.valueOf(jFrom));
        if (num != null) {
            return new Experiment(guildExperimentDto != null ? guildExperimentDto.getRevision() : 0, num.intValue(), 0, true, AnonymousClass1.INSTANCE);
        }
        Experiment memoizedGuildExperiment$app_productionGoogleRelease = getMemoizedGuildExperiment$app_productionGoogleRelease(guildId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + experimentName, guildId);
        if (memoizedGuildExperiment$app_productionGoogleRelease != null) {
            return memoizedGuildExperiment$app_productionGoogleRelease;
        }
        if (guildExperimentDto == null) {
            return null;
        }
        int iComputeGuildExperimentBucket = ExperimentUtils.INSTANCE.computeGuildExperimentBucket(experimentName, guildId, this.storeGuildMemberCounts.getApproximateMemberCount(guildId), this.storeGuilds.getGuild(guildId), guildExperimentDto);
        int revision = guildExperimentDto.getRevision();
        Experiment experiment = new Experiment(revision, iComputeGuildExperimentBucket, 0, false, new StoreExperiments4(this, experimentName, guildId, iComputeGuildExperimentBucket, revision));
        if (trackExposure) {
            experiment.getTrackExposure().invoke();
        }
        memoizeGuildExperiment(experimentName, guildId, experiment);
        return experiment;
    }

    public final synchronized Experiment getMemoizedGuildExperiment$app_productionGoogleRelease(String experimentName, long guildId) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        return this.memoizedGuildExperiments.get(experimentName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + guildId);
    }

    public final Experiment getUserExperiment(String name, boolean trackExposure) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        long jFrom = ExperimentHash.INSTANCE.from(name);
        Integer num = this.experimentOverridesSnapshot.get(name);
        UserExperimentDto userExperimentDto = this.userExperimentsSnapshot.get(Long.valueOf(jFrom));
        if (num != null) {
            return new Experiment(userExperimentDto != null ? userExperimentDto.getRevision() : 0, num.intValue(), userExperimentDto != null ? userExperimentDto.getPopulation() : 0, true, AnonymousClass1.INSTANCE);
        }
        if (userExperimentDto == null) {
            return null;
        }
        int bucket = userExperimentDto.getBucket();
        int population = userExperimentDto.getPopulation();
        int revision = userExperimentDto.getRevision();
        Experiment experiment = new Experiment(revision, bucket, population, false, new StoreExperiments5(this, name, bucket, population, revision));
        if (trackExposure) {
            experiment.getTrackExposure().invoke();
        }
        return experiment;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        this.authToken = authToken;
        reset();
        tryInitializeExperiments();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        Map<Long, UserExperimentDto> experiments = payload.getExperiments();
        Intrinsics3.checkNotNullExpressionValue(experiments, "payload.experiments");
        handleLoadedUserExperiments(experiments, true);
        List<GuildExperimentDto> guildExperiments = payload.getGuildExperiments();
        if (guildExperiments != null) {
            Intrinsics3.checkNotNullExpressionValue(guildExperiments, "it");
            handleLoadedGuildExperiments(guildExperiments, true);
        }
    }

    @Store3
    public final void handleFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        tryInitializeExperiments();
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.experimentTrackedExposureTimestamps.putAll(loadCachedExperimentTrackedExposureTimestamps());
        this.experimentOverrides.putAll(this.experimentOverridesCache.get());
        handleLoadedUserExperiments(this.userExperimentsCache.get(), false);
        handleLoadedGuildExperiments(this.guildExperimentsCache.get(), false);
        markChanged(this, ExperimentOverridesUpdateSource);
    }

    public final Observable<Boolean> isInitialized() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{InitializedUpdateSource}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Experiment> observeGuildExperiment(String experimentName, long guildId, boolean trackExposure) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(experimentName, guildId, trackExposure), 14, null);
    }

    public final Observable<Map<String, Integer>> observeOverrides() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ExperimentOverridesUpdateSource}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Experiment> observeUserExperiment(String name, boolean trackExposure) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Observable<Experiment> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(name, trackExposure), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setOverride(String experimentName, int bucket) {
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        this.dispatcher.schedule(new AnonymousClass1(bucket, experimentName));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
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
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        Intrinsics3.checkNotNullParameter(storeGuildMemberCounts, "storeGuildMemberCounts");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.clock = clock;
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeAuthentication = storeAuthentication;
        this.storeGuildMemberCounts = storeGuildMemberCounts;
        this.observationDeck = observationDeck;
        this.authToken = UNINITIALIZED;
        this.fingerprint = UNINITIALIZED;
        this.userExperimentsSnapshot = Maps6.emptyMap();
        this.guildExperimentsSnapshot = Maps6.emptyMap();
        this.experimentOverridesSnapshot = Maps6.emptyMap();
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
