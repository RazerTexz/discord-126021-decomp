package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyTrack;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Subscription;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$init$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelSpotifyTrack $track;
    public final /* synthetic */ StoreSpotify$init$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSpotify$init$3$1(StoreSpotify$init$3 storeSpotify$init$3, ModelSpotifyTrack modelSpotifyTrack) {
        super(0);
        this.this$0 = storeSpotify$init$3;
        this.$track = modelSpotifyTrack;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreSpotify$SpotifyState storeSpotify$SpotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(this.this$0.this$0);
        if (storeSpotify$SpotifyStateAccess$getSpotifyState$p != null) {
            StoreSpotify.access$setSpotifyState$p(this.this$0.this$0, StoreSpotify$SpotifyState.copy$default(storeSpotify$SpotifyStateAccess$getSpotifyState$p, this.$track, false, 0, 0L, 14, null));
            Subscription subscriptionAccess$getExpireStateSub$p = StoreSpotify.access$getExpireStateSub$p(this.this$0.this$0);
            if (subscriptionAccess$getExpireStateSub$p != null) {
                subscriptionAccess$getExpireStateSub$p.unsubscribe();
            }
            if (this.$track != null) {
                StoreSpotify.access$startStateExpiration(this.this$0.this$0, (this.$track.getDurationMs() + storeSpotify$SpotifyStateAccess$getSpotifyState$p.getStart()) - StoreSpotify.access$getClock$p(this.this$0.this$0).currentTimeMillis());
            }
        }
        StoreSpotify.access$publishState(this.this$0.this$0);
    }
}
