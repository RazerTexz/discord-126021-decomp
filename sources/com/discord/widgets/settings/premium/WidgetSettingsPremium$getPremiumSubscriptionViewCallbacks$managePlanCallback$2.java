package com.discord.widgets.settings.premium;

import b.a.d.m;
import com.discord.utilities.billing.GooglePlayBillingManager;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$2(WidgetSettingsPremium widgetSettingsPremium) {
        super(0);
        this.this$0 = widgetSettingsPremium;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        m.i(this.this$0, 2131887073, 0, 4);
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }
}
