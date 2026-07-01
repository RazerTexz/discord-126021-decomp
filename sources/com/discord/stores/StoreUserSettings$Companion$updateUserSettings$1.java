package com.discord.stores;

import com.discord.app.AppActivity;
import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings$Companion$updateUserSettings$1 extends o implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ Integer $successStringResId;
    public final /* synthetic */ AppActivity $this_updateUserSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSettings$Companion$updateUserSettings$1(AppActivity appActivity, Integer num) {
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
        m.checkNotNullParameter(modelUserSettings, "it");
        Integer num = this.$successStringResId;
        if (num != null) {
            b.a.d.m.g(this.$this_updateUserSettings, num.intValue(), 0, null, 12);
        }
    }
}
