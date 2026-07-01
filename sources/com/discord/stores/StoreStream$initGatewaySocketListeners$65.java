package com.discord.stores;

import com.discord.api.interaction.InteractionModalCreate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$65 extends k implements Function1<InteractionModalCreate, Unit> {
    public StoreStream$initGatewaySocketListeners$65(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleInteractionModalCreate", "handleInteractionModalCreate(Lcom/discord/api/interaction/InteractionModalCreate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
        invoke2(interactionModalCreate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "p1");
        ((StoreStream) this.receiver).handleInteractionModalCreate(interactionModalCreate);
    }
}
