package com.discord.utilities.spotify;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpotifyApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyApiClient$fetchSpotifyTrack$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ String $trackId;
    public final /* synthetic */ SpotifyApiClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyApiClient$fetchSpotifyTrack$1(SpotifyApiClient spotifyApiClient, String str) {
        super(1);
        this.this$0 = spotifyApiClient;
        this.$trackId = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        if (response.getCode() == 401) {
            SpotifyApiClient.access$setTrackIdToFetch(this.this$0, this.$trackId);
            SpotifyApiClient.access$refreshSpotifyToken(this.this$0);
        }
    }
}
