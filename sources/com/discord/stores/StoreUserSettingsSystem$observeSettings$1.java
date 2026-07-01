package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettingsSystem$observeSettings$1 extends o implements Function0<StoreUserSettingsSystem$Settings> {
    public final /* synthetic */ StoreUserSettingsSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSettingsSystem$observeSettings$1(StoreUserSettingsSystem storeUserSettingsSystem) {
        super(0);
        this.this$0 = storeUserSettingsSystem;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreUserSettingsSystem$Settings invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreUserSettingsSystem$Settings invoke() {
        return StoreUserSettingsSystem.access$getSettings$p(this.this$0);
    }
}
