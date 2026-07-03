package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyArtist;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$publishState$activity$1 extends AbstractC12240o implements Function1<ModelSpotifyArtist, CharSequence> {
    public static final StoreSpotify$publishState$activity$1 INSTANCE = new StoreSpotify$publishState$activity$1();

    public StoreSpotify$publishState$activity$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ModelSpotifyArtist modelSpotifyArtist) {
        C12238m.checkNotNullParameter(modelSpotifyArtist, "it");
        return modelSpotifyArtist.getName();
    }
}
