package com.discord.utilities.spotify;

import com.discord.models.domain.ModelConnectionAccessToken;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SpotifyApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyApiClient$refreshSpotifyToken$1$1 extends o implements Function0<String> {
    public final /* synthetic */ ModelConnectionAccessToken $spotifyToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyApiClient$refreshSpotifyToken$1$1(ModelConnectionAccessToken modelConnectionAccessToken) {
        super(0);
        this.$spotifyToken = modelConnectionAccessToken;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.$spotifyToken.getAccessToken();
    }
}
