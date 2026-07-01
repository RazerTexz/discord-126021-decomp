package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$setPlayingStatus$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $playing;
    public final /* synthetic */ int $position;
    public final /* synthetic */ StoreSpotify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSpotify$setPlayingStatus$1(StoreSpotify storeSpotify, boolean z2, int i) {
        super(0);
        this.this$0 = storeSpotify;
        this.$playing = z2;
        this.$position = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreSpotify.access$getSpotifyState$p(this.this$0) == null) {
            StoreSpotify.access$setSpotifyState$p(this.this$0, new StoreSpotify$SpotifyState(null, false, 0, 0L, 15, null));
        }
        StoreSpotify storeSpotify = this.this$0;
        StoreSpotify$SpotifyState storeSpotify$SpotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(storeSpotify);
        StoreSpotify.access$setSpotifyState$p(storeSpotify, storeSpotify$SpotifyStateAccess$getSpotifyState$p != null ? StoreSpotify$SpotifyState.copy$default(storeSpotify$SpotifyStateAccess$getSpotifyState$p, null, this.$playing, this.$position, StoreSpotify.access$getClock$p(this.this$0).currentTimeMillis() - ((long) this.$position), 1, null) : null);
        StoreSpotify.access$getPublishStateTrigger$p(this.this$0).onNext(Unit.a);
    }
}
