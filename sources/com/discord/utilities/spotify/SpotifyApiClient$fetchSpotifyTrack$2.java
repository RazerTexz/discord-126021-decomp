package com.discord.utilities.spotify;

import com.discord.models.domain.spotify.ModelSpotifyTrack;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpotifyApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyApiClient$fetchSpotifyTrack$2 extends o implements Function1<ModelSpotifyTrack, Unit> {
    public final /* synthetic */ String $trackId;
    public final /* synthetic */ SpotifyApiClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyApiClient$fetchSpotifyTrack$2(SpotifyApiClient spotifyApiClient, String str) {
        super(1);
        this.this$0 = spotifyApiClient;
        this.$trackId = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
        invoke2(modelSpotifyTrack);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
        m.checkNotNullParameter(modelSpotifyTrack, "track");
        SpotifyApiClient.access$setCachedTrack(this.this$0, modelSpotifyTrack);
        SpotifyApiClient.access$getSpotifyTrackSubject$p(this.this$0).onNext(SpotifyApiClient.access$getCachedTrack(this.this$0, this.$trackId));
    }
}
