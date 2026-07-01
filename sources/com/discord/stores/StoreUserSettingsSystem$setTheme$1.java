package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettingsSystem$setTheme$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $apiSync;
    public final /* synthetic */ Function0 $onRequestApiSync;
    public final /* synthetic */ String $theme;
    public final /* synthetic */ StoreUserSettingsSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSettingsSystem$setTheme$1(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0) {
        super(0);
        this.this$0 = storeUserSettingsSystem;
        this.$theme = str;
        this.$apiSync = z2;
        this.$onRequestApiSync = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserSettingsSystem.access$setThemeInternal(this.this$0, this.$theme, this.$apiSync, this.$onRequestApiSync);
    }
}
