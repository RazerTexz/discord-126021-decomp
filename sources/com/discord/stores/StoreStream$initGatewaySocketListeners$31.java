package com.discord.stores;

import com.discord.models.domain.ModelUserRelationship;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$31 extends k implements Function1<ModelUserRelationship, Unit> {
    public StoreStream$initGatewaySocketListeners$31(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleRelationshipRemove", "handleRelationshipRemove(Lcom/discord/models/domain/ModelUserRelationship;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserRelationship modelUserRelationship) {
        invoke2(modelUserRelationship);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserRelationship modelUserRelationship) {
        m.checkNotNullParameter(modelUserRelationship, "p1");
        StoreStream.access$handleRelationshipRemove((StoreStream) this.receiver, modelUserRelationship);
    }
}
