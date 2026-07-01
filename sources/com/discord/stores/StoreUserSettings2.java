package com.discord.stores;

import b.a.d.AppToast;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelUserSettings;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$Companion$updateUserSettings$1, reason: use source file name */
/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings2 extends Lambda implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ Integer $successStringResId;
    public final /* synthetic */ AppActivity $this_updateUserSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSettings2(AppActivity appActivity, Integer num) {
        super(1);
        this.$this_updateUserSettings = appActivity;
        this.$successStringResId = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        Integer num = this.$successStringResId;
        if (num != null) {
            AppToast.g(this.$this_updateUserSettings, num.intValue(), 0, null, 12);
        }
    }
}
