package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Subscription;
import com.discord.utilities.billing.GooglePlaySku;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ MaterialButton $button;
    public final /* synthetic */ ModelSubscription $premiumSubscription$inlined;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2(MaterialButton materialButton, WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        this.$button = materialButton;
        this.this$0 = widgetSettingsPremium;
        this.$premiumSubscription$inlined = modelSubscription;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlan$Companion widgetChoosePlan$Companion = WidgetChoosePlan.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        WidgetChoosePlan$ViewType widgetChoosePlan$ViewType = m.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).t.f76b) ? WidgetChoosePlan$ViewType.BUY_PREMIUM_TIER_1 : WidgetChoosePlan$ViewType.BUY_PREMIUM_TIER_2;
        ModelSubscription modelSubscription = this.$premiumSubscription$inlined;
        WidgetChoosePlan$Companion.launch$default(widgetChoosePlan$Companion, contextRequireContext, null, widgetChoosePlan$ViewType, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null, new Traits$Location(Traits$Location$Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(this.this$0), Traits$Location$Obj.BUTTON_CTA, Traits$Location$ObjType.BUY, null, 16, null), Traits$Subscription.Companion.withGatewayPlanId(m.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).t.f76b) ? GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName() : GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()), 2, null);
    }
}
