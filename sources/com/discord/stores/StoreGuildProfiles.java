package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, GuildProfileData> guildProfilesState;
    private Map<Long, GuildProfileData> guildProfilesStateSnapshot;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public enum FetchStates {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final /* data */ class GuildProfileData {
        private final GuildPreview data;
        private final FetchStates fetchState;

        public GuildProfileData(FetchStates fetchStates, GuildPreview guildPreview) {
            Intrinsics3.checkNotNullParameter(fetchStates, "fetchState");
            this.fetchState = fetchStates;
            this.data = guildPreview;
        }

        public static /* synthetic */ GuildProfileData copy$default(GuildProfileData guildProfileData, FetchStates fetchStates, GuildPreview guildPreview, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchStates = guildProfileData.fetchState;
            }
            if ((i & 2) != 0) {
                guildPreview = guildProfileData.data;
            }
            return guildProfileData.copy(fetchStates, guildPreview);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GuildPreview getData() {
            return this.data;
        }

        public final GuildProfileData copy(FetchStates fetchState, GuildPreview data) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            return new GuildProfileData(fetchState, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildProfileData)) {
                return false;
            }
            GuildProfileData guildProfileData = (GuildProfileData) other;
            return Intrinsics3.areEqual(this.fetchState, guildProfileData.fetchState) && Intrinsics3.areEqual(this.data, guildProfileData.data);
        }

        public final GuildPreview getData() {
            return this.data;
        }

        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        public int hashCode() {
            FetchStates fetchStates = this.fetchState;
            int iHashCode = (fetchStates != null ? fetchStates.hashCode() : 0) * 31;
            GuildPreview guildPreview = this.data;
            return iHashCode + (guildPreview != null ? guildPreview.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildProfileData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildProfiles.kt */
        public static final class C01241 extends Lambda implements Function1<GuildPreview, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildProfiles.kt */
            public static final class C01251 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ GuildPreview $guildPreview;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01251(GuildPreview guildPreview) {
                    super(0);
                    this.$guildPreview = guildPreview;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildProfiles.this.handleGuildProfileFetchSuccess(this.$guildPreview);
                }
            }

            public C01241() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildPreview guildPreview) {
                invoke2(guildPreview);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildPreview guildPreview) {
                Intrinsics3.checkNotNullParameter(guildPreview, "guildPreview");
                StoreGuildProfiles.this.dispatcher.schedule(new C01251(guildPreview));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildProfiles.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildProfiles.kt */
            public static final class C01261 extends Lambda implements Function0<Unit> {
                public C01261() {
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
                    StoreGuildProfiles.this.handleGuildProfileFetchFailed(anonymousClass1.$guildId);
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
                StoreGuildProfiles.this.dispatcher.schedule(new C01261());
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
            GuildProfileData guildProfileData = (GuildProfileData) StoreGuildProfiles.this.guildProfilesState.get(Long.valueOf(this.$guildId));
            if ((guildProfileData != null ? guildProfileData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildProfiles.this.handleGuildProfileFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildPreview(this.$guildId), false, 1, null), (Class<?>) StoreGuildProfiles.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01241());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
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
            StoreGuildProfiles.this.fetchIfNonexisting(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<GuildProfileData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildProfileData invoke() {
            return (GuildProfileData) StoreGuildProfiles.this.guildProfilesStateSnapshot.get(Long.valueOf(this.$guildId));
        }
    }

    public StoreGuildProfiles(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildProfilesState = new HashMap();
        this.guildProfilesStateSnapshot = new HashMap();
    }

    @Store3
    private final void fetchGuildProfile(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    @Store3
    private final void fetchIfNonexisting(long guildId) {
        GuildProfileData guildProfileData = this.guildProfilesState.get(Long.valueOf(guildId));
        if (guildProfileData == null || guildProfileData.getFetchState() == FetchStates.FAILED) {
            fetchGuildProfile(guildId);
        }
    }

    @Store3
    private final void handleGuildProfileFetchFailed(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FAILED, null));
        markChanged();
    }

    @Store3
    private final void handleGuildProfileFetchStart(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FETCHING, null));
        markChanged();
    }

    @Store3
    private final void handleGuildProfileFetchSuccess(GuildPreview guildPreview) {
        this.guildProfilesState.put(Long.valueOf(guildPreview.getId()), new GuildProfileData(FetchStates.SUCCEEDED, guildPreview));
        markChanged();
    }

    public final Observable<GuildProfileData> observeGuildProfile(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable<GuildProfileData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.guildProfilesStateSnapshot = new HashMap(this.guildProfilesState);
    }
}
