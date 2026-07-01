package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$init$1<T, R> implements b<ModelSpotifyTrack, Observable<? extends ModelSpotifyTrack>> {
    public static final StoreSpotify$init$1 INSTANCE = new StoreSpotify$init$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModelSpotifyTrack> call(ModelSpotifyTrack modelSpotifyTrack) {
        return call2(modelSpotifyTrack);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelSpotifyTrack> call2(ModelSpotifyTrack modelSpotifyTrack) {
        return modelSpotifyTrack != null ? new k(modelSpotifyTrack) : Observable.d0(1L, TimeUnit.SECONDS).G(StoreSpotify$init$1$1.INSTANCE);
    }
}
