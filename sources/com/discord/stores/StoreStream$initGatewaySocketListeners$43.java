package com.discord.stores;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$43 extends k implements Function1<ModelUserSettings, Unit> {
    public StoreStream$initGatewaySocketListeners$43(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleUserSettingsUpdate", "handleUserSettingsUpdate(Lcom/discord/models/domain/ModelUserSettings;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "p1");
        StoreStream.access$handleUserSettingsUpdate((StoreStream) this.receiver, modelUserSettings);
    }
}
