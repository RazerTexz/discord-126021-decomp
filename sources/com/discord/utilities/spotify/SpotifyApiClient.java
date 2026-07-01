package com.discord.utilities.spotify;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

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

    public SpotifyApiClient(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.spotifyTracks = new HashMap<>();
        this.spotifyTrackSubject = BehaviorSubject.k0();
    }

    public static final /* synthetic */ ModelSpotifyTrack access$getCachedTrack(SpotifyApiClient spotifyApiClient, String str) {
        return spotifyApiClient.getCachedTrack(str);
    }

    public static final /* synthetic */ Clock access$getClock$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getSpotifyTrackSubject$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.spotifyTrackSubject;
    }

    public static final /* synthetic */ Subscription access$getTokenSubscription$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.tokenSubscription;
    }

    public static final /* synthetic */ String access$getTrackIdToFetch(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.getTrackIdToFetch();
    }

    public static final /* synthetic */ void access$refreshSpotifyToken(SpotifyApiClient spotifyApiClient) {
        spotifyApiClient.refreshSpotifyToken();
    }

    public static final /* synthetic */ void access$setCachedTrack(SpotifyApiClient spotifyApiClient, ModelSpotifyTrack modelSpotifyTrack) {
        spotifyApiClient.setCachedTrack(modelSpotifyTrack);
    }

    public static final /* synthetic */ void access$setTokenExpiresAt(SpotifyApiClient spotifyApiClient, long j) {
        spotifyApiClient.setTokenExpiresAt(j);
    }

    public static final /* synthetic */ void access$setTokenSubscription$p(SpotifyApiClient spotifyApiClient, Subscription subscription) {
        spotifyApiClient.tokenSubscription = subscription;
    }

    public static final /* synthetic */ void access$setTrackIdToFetch(SpotifyApiClient spotifyApiClient, String str) {
        spotifyApiClient.setTrackIdToFetch(str);
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
            RestAPI api = RestAPI.Companion.getApi();
            String strName = Platform.SPOTIFY.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(api.getConnectionAccessToken(lowerCase, str), false, 1, null), SpotifyApiClient.class, (Context) null, new SpotifyApiClient$refreshSpotifyToken$2(this), (Function1) null, (Function0) null, (Function0) null, new SpotifyApiClient$refreshSpotifyToken$1(this), 58, (Object) null);
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
        m.checkNotNullParameter(trackId, "trackId");
        if (getCachedTrack(trackId) != null) {
            this.spotifyTrackSubject.onNext(getCachedTrack(trackId));
            return;
        }
        this.spotifyTrackSubject.onNext(null);
        if (!isTokenExpiring()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSpotify().getSpotifyTrack(trackId), false, 1, null), SpotifyApiClient.class, (Context) null, (Function1) null, new SpotifyApiClient$fetchSpotifyTrack$1(this, trackId), (Function0) null, (Function0) null, new SpotifyApiClient$fetchSpotifyTrack$2(this, trackId), 54, (Object) null);
        } else {
            setTrackIdToFetch(trackId);
            refreshSpotifyToken();
        }
    }

    public final Observable<ModelSpotifyTrack> getSpotifyTrack() {
        BehaviorSubject<ModelSpotifyTrack> behaviorSubject = this.spotifyTrackSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "spotifyTrackSubject");
        return behaviorSubject;
    }

    public final void setSpotifyAccountId(String id2) {
        this.spotifyAccountId = id2;
    }
}
