package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaSettings$init$2 extends k implements Function1<Boolean, Unit> {
    public StoreMediaSettings$init$2(StoreMediaSettings storeMediaSettings) {
        super(1, storeMediaSettings, StoreMediaSettings.class, "handleCanUseVad", "handleCanUseVad(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        StoreMediaSettings.access$handleCanUseVad((StoreMediaSettings) this.receiver, z2);
    }
}
