package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import com.discord.utilities.analytics.Traits$Location$Page;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$3 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelSubscription $premiumSubscription;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$3(WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
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
        WidgetChoosePlan$Companion.launch$default(WidgetChoosePlan.Companion, this.this$0.requireContext(), null, WidgetChoosePlan$ViewType.SWITCH_PLANS, this.$premiumSubscription.getPaymentGatewayPlanId(), new Traits$Location(Traits$Location$Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(this.this$0), Traits$Location$Obj.BUTTON_CTA, Traits$Location$ObjType.BUY, null, 16, null), null, 34, null);
    }
}
