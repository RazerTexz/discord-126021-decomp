package com.discord.stores;

import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashSet<Long> guildWelcomeScreensSeen;
    private Set<Long> guildWelcomeScreensSeenSnapshot;
    private Map<Long, ? extends StoreGuildWelcomeScreens$State> guildWelcomeScreensSnapshot;
    private final HashMap<Long, StoreGuildWelcomeScreens$State> guildWelcomeScreensState;
    private final ObservationDeck observationDeck;

    public /* synthetic */ StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.dispatcher;
    }

    public static final /* synthetic */ HashSet access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensSeen;
    }

    public static final /* synthetic */ HashMap access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensState;
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j, GuildWelcomeScreen guildWelcomeScreen) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreen(j, guildWelcomeScreen);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchStart(j);
    }

    @StoreThread
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new StoreGuildWelcomeScreens$State$Loaded(guildWelcomeScreen));
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), StoreGuildWelcomeScreens$State$Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), StoreGuildWelcomeScreens$State$Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new StoreGuildWelcomeScreens$fetchIfNonexisting$1(this, guildId));
    }

    public final StoreGuildWelcomeScreens$State getGuildWelcomeScreen(long guildId) {
        return this.guildWelcomeScreensSnapshot.get(Long.valueOf(guildId));
    }

    public final void handleGuildJoined(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        handleGuildWelcomeScreen(guildId, guildWelcomeScreen);
    }

    public final boolean hasWelcomeScreenBeenSeen(long guildId) {
        return this.guildWelcomeScreensSeenSnapshot.contains(Long.valueOf(guildId));
    }

    public final void markWelcomeScreenShown(long guildId) {
        this.dispatcher.schedule(new StoreGuildWelcomeScreens$markWelcomeScreenShown$1(this, guildId));
    }

    public final Observable<StoreGuildWelcomeScreens$State> observeGuildWelcomeScreen(long guildId) {
        Observable<StoreGuildWelcomeScreens$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = h0.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = n0.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
