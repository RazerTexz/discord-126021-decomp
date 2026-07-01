package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyTrack;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify$init$3 extends o implements Function1<ModelSpotifyTrack, Unit> {
    public final /* synthetic */ StoreSpotify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSpotify$init$3(StoreSpotify storeSpotify) {
        super(1);
        this.this$0 = storeSpotify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
        invoke2(modelSpotifyTrack);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
        StoreSpotify.access$getDispatcher$p(this.this$0).schedule(new StoreSpotify$init$3$1(this, modelSpotifyTrack));
    }
}
