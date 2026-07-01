package com.discord.utilities.spotify;

import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.utilities.rest.RestAPI$AppHeadersProvider;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpotifyApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyApiClient$refreshSpotifyToken$1 extends o implements Function1<ModelConnectionAccessToken, Unit> {
    public final /* synthetic */ SpotifyApiClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyApiClient$refreshSpotifyToken$1(SpotifyApiClient spotifyApiClient) {
        super(1);
        this.this$0 = spotifyApiClient;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelConnectionAccessToken modelConnectionAccessToken) {
        invoke2(modelConnectionAccessToken);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelConnectionAccessToken modelConnectionAccessToken) {
        m.checkNotNullParameter(modelConnectionAccessToken, "spotifyToken");
        RestAPI$AppHeadersProvider.spotifyTokenProvider = new SpotifyApiClient$refreshSpotifyToken$1$1(modelConnectionAccessToken);
        SpotifyApiClient spotifyApiClient = this.this$0;
        SpotifyApiClient.access$setTokenExpiresAt(spotifyApiClient, SpotifyApiClient.access$getClock$p(spotifyApiClient).currentTimeMillis() + 3600000);
        String strAccess$getTrackIdToFetch = SpotifyApiClient.access$getTrackIdToFetch(this.this$0);
        if (strAccess$getTrackIdToFetch != null) {
            this.this$0.fetchSpotifyTrack(strAccess$getTrackIdToFetch);
            SpotifyApiClient.access$setTrackIdToFetch(this.this$0, null);
        }
    }
}
