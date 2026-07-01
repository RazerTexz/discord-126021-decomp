package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyArtist;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$publishState$activity$1 extends o implements Function1<ModelSpotifyArtist, CharSequence> {
    public static final StoreSpotify$publishState$activity$1 INSTANCE = new StoreSpotify$publishState$activity$1();

    public StoreSpotify$publishState$activity$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ModelSpotifyArtist modelSpotifyArtist) {
        return invoke2(modelSpotifyArtist);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ModelSpotifyArtist modelSpotifyArtist) {
        m.checkNotNullParameter(modelSpotifyArtist, "it");
        return modelSpotifyArtist.getName();
    }
}
