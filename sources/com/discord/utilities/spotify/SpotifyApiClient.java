package com.discord.utilities.spotify;

import android.annotation.SuppressLint;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: SpotifyApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyApiClient {
    private final Clock clock;
    private String spotifyAccountId;
    private final BehaviorSubject<ModelSpotifyTrack> spotifyTrackSubject;
    private final HashMap<String, ModelSpotifyTrack> spotifyTracks;
    private long tokenExpiresAt;
    private Subscription tokenSubscription;
    private String trackIdToFetch;

    /* JADX INFO: renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$1 */
    /* JADX INFO: compiled from: SpotifyApiClient.kt */
    public static final class C69131 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69131(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() == 401) {
                SpotifyApiClient.this.setTrackIdToFetch(this.$trackId);
                SpotifyApiClient.this.refreshSpotifyToken();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$2 */
    /* JADX INFO: compiled from: SpotifyApiClient.kt */
    public static final class C69142 extends AbstractC12240o implements Function1<ModelSpotifyTrack, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69142(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            C12238m.checkNotNullParameter(modelSpotifyTrack, "track");
            SpotifyApiClient.this.setCachedTrack(modelSpotifyTrack);
            SpotifyApiClient.this.spotifyTrackSubject.onNext(SpotifyApiClient.this.getCachedTrack(this.$trackId));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1 */
    /* JADX INFO: compiled from: SpotifyApiClient.kt */
    public static final class C69151 extends AbstractC12240o implements Function1<ModelConnectionAccessToken, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SpotifyApiClient.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<String> {
            public final /* synthetic */ ModelConnectionAccessToken $spotifyToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelConnectionAccessToken modelConnectionAccessToken) {
                super(0);
                this.$spotifyToken = modelConnectionAccessToken;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.$spotifyToken.getAccessToken();
            }
        }

        public C69151() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelConnectionAccessToken modelConnectionAccessToken) {
            invoke2(modelConnectionAccessToken);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelConnectionAccessToken modelConnectionAccessToken) {
            C12238m.checkNotNullParameter(modelConnectionAccessToken, "spotifyToken");
            RestAPI.AppHeadersProvider.spotifyTokenProvider = new AnonymousClass1(modelConnectionAccessToken);
            SpotifyApiClient spotifyApiClient = SpotifyApiClient.this;
            spotifyApiClient.setTokenExpiresAt(spotifyApiClient.clock.currentTimeMillis() + 3600000);
            String trackIdToFetch = SpotifyApiClient.this.getTrackIdToFetch();
            if (trackIdToFetch != null) {
                SpotifyApiClient.this.fetchSpotifyTrack(trackIdToFetch);
                SpotifyApiClient.this.setTrackIdToFetch(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$2 */
    /* JADX INFO: compiled from: SpotifyApiClient.kt */
    public static final class C69162 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C69162() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            SpotifyApiClient.this.tokenSubscription = subscription;
        }
    }

    public SpotifyApiClient(Clock clock) {
        C12238m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.spotifyTracks = new HashMap<>();
        this.spotifyTrackSubject = BehaviorSubject.m11129k0();
    }

    private final synchronized ModelSpotifyTrack getCachedTrack(String trackId) {
        return this.spotifyTracks.get(trackId);
    }

    private final synchronized long getTokenExpiresAt() {
        return this.tokenExpiresAt;
    }

    private final synchronized String getTrackIdToFetch() {
        return this.trackIdToFetch;
    }

    private final boolean isTokenExpiring() {
        return this.clock.currentTimeMillis() >= getTokenExpiresAt() - 10000;
    }

    @SuppressLint({"DefaultLocale"})
    private final void refreshSpotifyToken() {
        String str;
        Subscription subscription = this.tokenSubscription;
        if ((subscription == null || (subscription != null && subscription.isUnsubscribed())) && (str = this.spotifyAccountId) != null) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            String strName = Platform.SPOTIFY.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(api.getConnectionAccessToken(lowerCase, str), false, 1, null), (Class<?>) SpotifyApiClient.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C69162()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C69151());
        }
    }

    private final synchronized void setCachedTrack(ModelSpotifyTrack track) {
        this.spotifyTracks.put(track.getId(), track);
    }

    private final synchronized void setTokenExpiresAt(long expiresAt) {
        this.tokenExpiresAt = expiresAt;
    }

    private final synchronized void setTrackIdToFetch(String trackId) {
        this.trackIdToFetch = trackId;
    }

    public final void fetchSpotifyTrack(String trackId) {
        C12238m.checkNotNullParameter(trackId, "trackId");
        if (getCachedTrack(trackId) != null) {
            this.spotifyTrackSubject.onNext(getCachedTrack(trackId));
            return;
        }
        this.spotifyTrackSubject.onNext(null);
        if (isTokenExpiring()) {
            setTrackIdToFetch(trackId);
            refreshSpotifyToken();
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSpotify().getSpotifyTrack(trackId), false, 1, null), (Class<?>) SpotifyApiClient.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C69131(trackId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C69142(trackId));
        }
    }

    public final Observable<ModelSpotifyTrack> getSpotifyTrack() {
        BehaviorSubject<ModelSpotifyTrack> behaviorSubject = this.spotifyTrackSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "spotifyTrackSubject");
        return behaviorSubject;
    }

    public final void setSpotifyAccountId(String id2) {
        this.spotifyAccountId = id2;
    }
}
