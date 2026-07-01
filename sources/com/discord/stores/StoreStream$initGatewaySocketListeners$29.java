package com.discord.stores;

import com.discord.models.domain.ModelUserNote$Update;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$29 extends k implements Function1<ModelUserNote$Update, Unit> {
    public StoreStream$initGatewaySocketListeners$29(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleUserNoteUpdated", "handleUserNoteUpdated(Lcom/discord/models/domain/ModelUserNote$Update;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote$Update modelUserNote$Update) {
        invoke2(modelUserNote$Update);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserNote$Update modelUserNote$Update) {
        m.checkNotNullParameter(modelUserNote$Update, "p1");
        StoreStream.access$handleUserNoteUpdated((StoreStream) this.receiver, modelUserNote$Update);
    }
}
