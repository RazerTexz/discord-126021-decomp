package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.spotify.ModelSpotifyAlbum;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spotify.SpotifyApiClient;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Subscription expireStateSub;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private final SpotifyApiClient spotifyApiClient;
    private SpotifyState spotifyState;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreSpotify.kt */
    public static final /* data */ class SpotifyState {
        private final boolean playing;
        private final int position;
        private final long start;
        private final ModelSpotifyTrack track;

        public SpotifyState() {
            this(null, false, 0, 0L, 15, null);
        }

        public SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j) {
            this.track = modelSpotifyTrack;
            this.playing = z2;
            this.position = i;
            this.start = j;
        }

        public static /* synthetic */ SpotifyState copy$default(SpotifyState spotifyState, ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                modelSpotifyTrack = spotifyState.track;
            }
            if ((i2 & 2) != 0) {
                z2 = spotifyState.playing;
            }
            boolean z3 = z2;
            if ((i2 & 4) != 0) {
                i = spotifyState.position;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = spotifyState.start;
            }
            return spotifyState.copy(modelSpotifyTrack, z3, i3, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getPlaying() {
            return this.playing;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        public final SpotifyState copy(ModelSpotifyTrack track, boolean playing, int position, long start) {
            return new SpotifyState(track, playing, position, start);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpotifyState)) {
                return false;
            }
            SpotifyState spotifyState = (SpotifyState) other;
            return Intrinsics3.areEqual(this.track, spotifyState.track) && this.playing == spotifyState.playing && this.position == spotifyState.position && this.start == spotifyState.start;
        }

        public final boolean getPlaying() {
            return this.playing;
        }

        public final int getPosition() {
            return this.position;
        }

        public final long getStart() {
            return this.start;
        }

        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            ModelSpotifyTrack modelSpotifyTrack = this.track;
            int iHashCode = (modelSpotifyTrack != null ? modelSpotifyTrack.hashCode() : 0) * 31;
            boolean z2 = this.playing;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return b.a(this.start) + ((((iHashCode + r1) * 31) + this.position) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpotifyState(track=");
            sbU.append(this.track);
            sbU.append(", playing=");
            sbU.append(this.playing);
            sbU.append(", position=");
            sbU.append(this.position);
            sbU.append(", start=");
            return outline.C(sbU, this.start, ")");
        }

        public /* synthetic */ SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : modelSpotifyTrack, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? i : 0, (i2 & 8) != 0 ? 0L : j);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$init$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSpotify.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelSpotifyTrack, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$init$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSpotify.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelSpotifyTrack $track;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelSpotifyTrack modelSpotifyTrack) {
                super(0);
                this.$track = modelSpotifyTrack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SpotifyState spotifyState = StoreSpotify.this.spotifyState;
                if (spotifyState != null) {
                    StoreSpotify.this.spotifyState = SpotifyState.copy$default(spotifyState, this.$track, false, 0, 0L, 14, null);
                    Subscription subscription = StoreSpotify.this.expireStateSub;
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    if (this.$track != null) {
                        StoreSpotify.this.startStateExpiration((this.$track.getDurationMs() + spotifyState.getStart()) - StoreSpotify.this.clock.currentTimeMillis());
                    }
                }
                StoreSpotify.this.publishState();
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            StoreSpotify.this.dispatcher.schedule(new AnonymousClass1(modelSpotifyTrack));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$setPlayingStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSpotify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $playing;
        public final /* synthetic */ int $position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, int i) {
            super(0);
            this.$playing = z2;
            this.$position = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreSpotify.this.spotifyState == null) {
                StoreSpotify.this.spotifyState = new SpotifyState(null, false, 0, 0L, 15, null);
            }
            StoreSpotify storeSpotify = StoreSpotify.this;
            SpotifyState spotifyState = storeSpotify.spotifyState;
            storeSpotify.spotifyState = spotifyState != null ? SpotifyState.copy$default(spotifyState, null, this.$playing, this.$position, StoreSpotify.this.clock.currentTimeMillis() - ((long) this.$position), 1, null) : null;
            StoreSpotify.this.publishStateTrigger.onNext(Unit.a);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$startStateExpiration$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSpotify.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreSpotify.this.expireStateSub = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreSpotify.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSpotify.kt */
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
                StoreSpotify.this.spotifyState = null;
                StoreSpotify.this.publishState();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreSpotify.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    public StoreSpotify(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.publishStateTrigger = BehaviorSubject.k0();
        this.spotifyApiClient = new SpotifyApiClient(clock);
    }

    @Store3
    private final void publishState() {
        boolean z2;
        String str;
        List<ModelSpotifyAlbum.AlbumImage> images;
        List<ModelSpotifyAlbum.AlbumImage> images2;
        ModelSpotifyAlbum.AlbumImage albumImage;
        String url;
        List listSplit$default;
        if (this.spotifyState == null) {
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
            return;
        }
        StoreUserConnections.State stateSnapshot = this.stream.getUserConnections().getStateSnapshot();
        if (!(stateSnapshot instanceof Collection) || !stateSnapshot.isEmpty()) {
            Iterator<ConnectedAccount> it = stateSnapshot.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                ConnectedAccount next = it.next();
                if (Intrinsics3.areEqual(next.getType(), Platform.SPOTIFY.getPlatformId()) && next.getShowActivity()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (z2) {
            SpotifyState spotifyState = this.spotifyState;
            Intrinsics3.checkNotNull(spotifyState);
            ModelSpotifyTrack track = spotifyState.getTrack();
            boolean playing = spotifyState.getPlaying();
            long start = spotifyState.getStart();
            if (!playing || track == null) {
                this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
                return;
            }
            ModelSpotifyAlbum album = track.getAlbum();
            String str2 = (album == null || (images2 = album.getImages()) == null || (albumImage = (ModelSpotifyAlbum.AlbumImage) _Collections.firstOrNull((List) images2)) == null || (url = albumImage.getUrl()) == null || (listSplit$default = Strings4.split$default((CharSequence) url, new String[]{AutocompleteViewModel.COMMAND_DISCOVER_TOKEN}, false, 0, 6, (Object) null)) == null) ? null : (String) _Collections.last(listSplit$default);
            if (str2 != null) {
                str = Platform.SPOTIFY.getPlatformId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + str2;
            } else {
                str = null;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Platform platform = Platform.SPOTIFY;
            String properName = platform.getProperName();
            String name = track.getName();
            String id2 = track.getId();
            ModelSpotifyAlbum album2 = track.getAlbum();
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, ActivityUtils.createSpotifyListeningActivity(jCurrentTimeMillis, properName, name, id2, album2 != null ? album2.getName() : null, str, _Collections.joinToString$default(track.getArtists(), null, null, null, 0, null, StoreSpotify2.INSTANCE, 31, null), start, track.getDurationMs() + start, platform.getPlatformId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + this.stream.getUsers().getMe().getId()), true);
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String id3 = track.getId();
            ModelSpotifyAlbum album3 = track.getAlbum();
            analyticsTracker.activityUpdatedSpotify(id3, (album3 == null || (images = album3.getImages()) == null || images.isEmpty()) ? false : true);
        }
    }

    @Store3
    private final void startStateExpiration(long timeLeftMs) {
        Observable<Long> observableD0 = Observable.d0(timeLeftMs + 5000, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) StoreSpotify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        Intrinsics3.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
        this.publishStateTrigger.onNext(Unit.a);
    }

    @Store3
    public final void handleConnectionReady(boolean ready) {
        if (ready) {
            this.publishStateTrigger.onNext(Unit.a);
        }
    }

    @Store3
    public final void handlePreLogout() {
        this.spotifyState = null;
    }

    @Store3
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Object next;
        Intrinsics3.checkNotNullParameter(accounts, "accounts");
        Iterator<T> it = accounts.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsJVM.equals(Platform.SPOTIFY.name(), ((ConnectedAccount) next).getType(), true));
        ConnectedAccount connectedAccount = (ConnectedAccount) next;
        this.spotifyApiClient.setSpotifyAccountId(connectedAccount != null ? connectedAccount.getId() : null);
    }

    public final void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        SpotifyHelper.registerSpotifyBroadcastReceivers(context);
        Observable observableP = Observable.j(this.publishStateTrigger, this.spotifyApiClient.getSpotifyTrack().Y(new Func1<ModelSpotifyTrack, Observable<? extends ModelSpotifyTrack>>() { // from class: com.discord.stores.StoreSpotify.init.1
            @Override // j0.k.Func1
            public final Observable<? extends ModelSpotifyTrack> call(ModelSpotifyTrack modelSpotifyTrack) {
                return modelSpotifyTrack != null ? new ScalarSynchronousObservable(modelSpotifyTrack) : Observable.d0(1L, TimeUnit.SECONDS).G(new Func1() { // from class: com.discord.stores.StoreSpotify.init.1.1
                    @Override // j0.k.Func1
                    public final Void call(Long l) {
                        return null;
                    }
                });
            }
        }).r(), new Func2<Unit, ModelSpotifyTrack, ModelSpotifyTrack>() { // from class: com.discord.stores.StoreSpotify.init.2
            @Override // rx.functions.Func2
            public final ModelSpotifyTrack call(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
                return modelSpotifyTrack;
            }
        }).p(2L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "Observable.combineLatest…unce(2, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe(observableP, (Class<?>) StoreSpotify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    public final void setCurrentTrackId(String trackId) {
        Intrinsics3.checkNotNullParameter(trackId, "trackId");
        this.spotifyApiClient.fetchSpotifyTrack(trackId);
    }

    public final void setPlayingStatus(boolean playing, int position) {
        this.dispatcher.schedule(new AnonymousClass1(playing, position));
    }
}
