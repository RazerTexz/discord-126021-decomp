package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashSet<Long> guildWelcomeScreensSeen;
    private Set<Long> guildWelcomeScreensSeenSnapshot;
    private Map<Long, ? extends State> guildWelcomeScreensSnapshot;
    private final HashMap<Long, State> guildWelcomeScreensState;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static abstract class State {

        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final /* data */ class Loaded extends State {
            private final GuildWelcomeScreen data;

            public Loaded(GuildWelcomeScreen guildWelcomeScreen) {
                super(null);
                this.data = guildWelcomeScreen;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildWelcomeScreen guildWelcomeScreen, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildWelcomeScreen = loaded.data;
                }
                return loaded.copy(guildWelcomeScreen);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public final Loaded copy(GuildWelcomeScreen data) {
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public int hashCode() {
                GuildWelcomeScreen guildWelcomeScreen = this.data;
                if (guildWelcomeScreen != null) {
                    return guildWelcomeScreen.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(data=");
                sbU.append(this.data);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class C01371 extends Lambda implements Function1<GuildWelcomeScreen, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
            public static final class C01381 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01381(GuildWelcomeScreen guildWelcomeScreen) {
                    super(0);
                    this.$guildWelcomeScreen = guildWelcomeScreen;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildWelcomeScreens.this.handleGuildWelcomeScreen(anonymousClass1.$guildId, this.$guildWelcomeScreen);
                }
            }

            public C01371() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
                invoke2(guildWelcomeScreen);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
                Intrinsics3.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
                StoreGuildWelcomeScreens.this.dispatcher.schedule(new C01381(guildWelcomeScreen));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
            public static final class C01391 extends Lambda implements Function0<Unit> {
                public C01391() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildWelcomeScreens.this.handleGuildWelcomeScreenFetchFailed(anonymousClass1.$guildId);
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
                StoreGuildWelcomeScreens.this.dispatcher.schedule(new C01391());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = (State) StoreGuildWelcomeScreens.this.guildWelcomeScreensState.get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildWelcomeScreens.this.handleGuildWelcomeScreenFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildWelcomeScreen(this.$guildId), false), (Class<?>) StoreGuildWelcomeScreens.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01371());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$markWelcomeScreenShown$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGuildWelcomeScreens.this.guildWelcomeScreensSeen.contains(Long.valueOf(this.$guildId))) {
                return;
            }
            StoreGuildWelcomeScreens.this.guildWelcomeScreensSeen.add(Long.valueOf(this.$guildId));
            StoreGuildWelcomeScreens.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGuildWelcomeScreens.this.getGuildWelcomeScreen(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new State.Loaded(guildWelcomeScreen));
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final State getGuildWelcomeScreen(long guildId) {
        return this.guildWelcomeScreensSnapshot.get(Long.valueOf(guildId));
    }

    public final void handleGuildJoined(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        handleGuildWelcomeScreen(guildId, guildWelcomeScreen);
    }

    public final boolean hasWelcomeScreenBeenSeen(long guildId) {
        return this.guildWelcomeScreensSeenSnapshot.contains(Long.valueOf(guildId));
    }

    public final void markWelcomeScreenShown(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<State> observeGuildWelcomeScreen(long guildId) {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = Maps6.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = Sets5.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
