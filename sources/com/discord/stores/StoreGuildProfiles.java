package com.discord.stores;

import com.discord.api.guild.preview.GuildPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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
            C12238m.checkNotNullParameter(fetchStates, "fetchState");
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
            C12238m.checkNotNullParameter(fetchState, "fetchState");
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
            return C12238m.areEqual(this.fetchState, guildProfileData.fetchState) && C12238m.areEqual(this.data, guildProfileData.data);
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
            StringBuilder sbM833U = C1643a.m833U("GuildProfileData(fetchState=");
            sbM833U.append(this.fetchState);
            sbM833U.append(", data=");
            sbM833U.append(this.data);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1 */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final class C60371 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildProfiles.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<GuildPreview, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildProfiles.kt */
            public static final class C132561 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ GuildPreview $guildPreview;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132561(GuildPreview guildPreview) {
                    super(0);
                    this.$guildPreview = guildPreview;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildProfiles.this.handleGuildProfileFetchSuccess(this.$guildPreview);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildPreview guildPreview) {
                invoke2(guildPreview);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildPreview guildPreview) {
                C12238m.checkNotNullParameter(guildPreview, "guildPreview");
                StoreGuildProfiles.this.dispatcher.schedule(new C132561(guildPreview));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildProfiles.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreGuildProfiles.kt */
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
                    C60371 c60371 = C60371.this;
                    StoreGuildProfiles.this.handleGuildProfileFetchFailed(c60371.$guildId);
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
                StoreGuildProfiles.this.dispatcher.schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60371(long j) {
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
            GuildProfileData guildProfileData = (GuildProfileData) StoreGuildProfiles.this.guildProfilesState.get(Long.valueOf(this.$guildId));
            if ((guildProfileData != null ? guildProfileData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildProfiles.this.handleGuildProfileFetchStart(this.$guildId);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildPreview(this.$guildId), false, 1, null), (Class<?>) StoreGuildProfiles.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$1 */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final class C60381 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60381(long j) {
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
            StoreGuildProfiles.this.fetchIfNonexisting(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$2 */
    /* JADX INFO: compiled from: StoreGuildProfiles.kt */
    public static final class C60392 extends AbstractC12240o implements Function0<GuildProfileData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60392(long j) {
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
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildProfilesState = new HashMap();
        this.guildProfilesStateSnapshot = new HashMap();
    }

    @StoreThread
    private final void fetchGuildProfile(long guildId) {
        this.dispatcher.schedule(new C60371(guildId));
    }

    @StoreThread
    private final void fetchIfNonexisting(long guildId) {
        GuildProfileData guildProfileData = this.guildProfilesState.get(Long.valueOf(guildId));
        if (guildProfileData == null || guildProfileData.getFetchState() == FetchStates.FAILED) {
            fetchGuildProfile(guildId);
        }
    }

    @StoreThread
    private final void handleGuildProfileFetchFailed(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FAILED, null));
        markChanged();
    }

    @StoreThread
    private final void handleGuildProfileFetchStart(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FETCHING, null));
        markChanged();
    }

    @StoreThread
    private final void handleGuildProfileFetchSuccess(GuildPreview guildPreview) {
        this.guildProfilesState.put(Long.valueOf(guildPreview.getId()), new GuildProfileData(FetchStates.SUCCEEDED, guildPreview));
        markChanged();
    }

    public final Observable<GuildProfileData> observeGuildProfile(long guildId) {
        this.dispatcher.schedule(new C60381(guildId));
        Observable<GuildProfileData> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60392(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.guildProfilesStateSnapshot = new HashMap(this.guildProfilesState);
    }
}
