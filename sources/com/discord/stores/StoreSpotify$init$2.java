package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import kotlin.Unit;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$init$2<T1, T2, R> implements Func2<Unit, ModelSpotifyTrack, ModelSpotifyTrack> {
    public static final StoreSpotify$init$2 INSTANCE = new StoreSpotify$init$2();

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelSpotifyTrack call2(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
        return modelSpotifyTrack;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ModelSpotifyTrack call(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
        return call2(unit, modelSpotifyTrack);
    }
}
