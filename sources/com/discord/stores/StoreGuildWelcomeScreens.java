package com.discord.stores;

import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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
                    return (other instanceof Loaded) && C12238m.areEqual(this.data, ((Loaded) other).data);
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
                StringBuilder sbM833U = C1643a.m833U("Loaded(data=");
                sbM833U.append(this.data);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1 */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class C60911 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<GuildWelcomeScreen, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
            public static final class C132591 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132591(GuildWelcomeScreen guildWelcomeScreen) {
                    super(0);
                    this.$guildWelcomeScreen = guildWelcomeScreen;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60911 c60911 = C60911.this;
                    StoreGuildWelcomeScreens.this.handleGuildWelcomeScreen(c60911.$guildId, this.$guildWelcomeScreen);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
                invoke2(guildWelcomeScreen);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
                C12238m.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
                StoreGuildWelcomeScreens.this.dispatcher.schedule(new C132591(guildWelcomeScreen));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60911 c60911 = C60911.this;
                    StoreGuildWelcomeScreens.this.handleGuildWelcomeScreenFetchFailed(c60911.$guildId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                StoreGuildWelcomeScreens.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60911(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = (State) StoreGuildWelcomeScreens.this.guildWelcomeScreensState.get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildWelcomeScreens.this.handleGuildWelcomeScreenFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildWelcomeScreen(this.$guildId), false), (Class<?>) StoreGuildWelcomeScreens.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$markWelcomeScreenShown$1 */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class C60921 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60921(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1 */
    /* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
    public static final class C60931 extends AbstractC12240o implements Function0<State> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60931(long j) {
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
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new State.Loaded(guildWelcomeScreen));
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new C60911(guildId));
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
        this.dispatcher.schedule(new C60921(guildId));
    }

    public final Observable<State> observeGuildWelcomeScreen(long guildId) {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60931(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = C12136h0.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = C12148n0.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
