package com.discord.widgets.settings.premium;

import com.discord.utilities.premium.PremiumUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$getGuildBoostViewCallbacks$5 extends o implements Function0<Unit> {
    public final /* synthetic */ String $skuName;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$getGuildBoostViewCallbacks$5(WidgetSettingsPremium widgetSettingsPremium, String str) {
        super(0);
        this.this$0 = widgetSettingsPremium;
        this.$skuName = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PremiumUtils.INSTANCE.openGooglePlayBilling(this.this$0.requireContext(), this.$skuName);
    }
}
