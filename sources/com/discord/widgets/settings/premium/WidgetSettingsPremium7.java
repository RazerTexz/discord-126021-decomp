package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium7 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ModelSubscription $premiumSubscription;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium7(WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        super(0);
        this.this$0 = widgetSettingsPremium;
        this.$premiumSubscription = modelSubscription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChoosePlan.INSTANCE.launch(this.this$0.requireContext(), (34 & 2) != 0 ? null : null, WidgetChoosePlan.ViewType.SWITCH_PLANS, (34 & 8) != 0 ? null : this.$premiumSubscription.getPaymentGatewayPlanId(), new Traits.Location(Traits.Location.Page.USER_SETTINGS, this.this$0.getAnalyticsLocationSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : null);
    }
}
