package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.premium.PremiumUtils;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configureStatusNotice$1 implements View$OnClickListener {
    public final /* synthetic */ ModelSubscription $subscription;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium$configureStatusNotice$1(WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        this.this$0 = widgetSettingsPremium;
        this.$subscription = modelSubscription;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PremiumUtils.INSTANCE.openGooglePlayBilling(this.this$0.requireContext(), this.$subscription.getPaymentGatewayPlanId());
    }
}
