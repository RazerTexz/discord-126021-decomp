package com.discord.stores;

import com.discord.api.interaction.InteractionStateUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$62 extends k implements Function1<InteractionStateUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$62(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleInteractionCreate", "handleInteractionCreate(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
        invoke2(interactionStateUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
        m.checkNotNullParameter(interactionStateUpdate, "p1");
        StoreStream.access$handleInteractionCreate((StoreStream) this.receiver, interactionStateUpdate);
    }
}
