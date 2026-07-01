package com.discord.stores;

import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$42 extends k implements Function1<ModelNotificationSettings, Unit> {
    public StoreStream$initGatewaySocketListeners$42(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildSettingUpdated", "handleGuildSettingUpdated(Lcom/discord/models/domain/ModelNotificationSettings;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelNotificationSettings modelNotificationSettings) {
        invoke2(modelNotificationSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelNotificationSettings modelNotificationSettings) {
        m.checkNotNullParameter(modelNotificationSettings, "p1");
        StoreStream.access$handleGuildSettingUpdated((StoreStream) this.receiver, modelNotificationSettings);
    }
}
