package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.premium.PremiumUtils;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configurePaymentInfo$2 implements View$OnClickListener {
    public final /* synthetic */ boolean $isGoogleSubscription;
    public final /* synthetic */ ModelSubscription $subscription;

    public WidgetSettingsPremium$configurePaymentInfo$2(boolean z2, ModelSubscription modelSubscription) {
        this.$isGoogleSubscription = z2;
        this.$subscription = modelSubscription;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isGoogleSubscription) {
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            Context contextX = a.x(view, "it", "it.context");
            ModelSubscription modelSubscription = this.$subscription;
            premiumUtils.openGooglePlayBilling(contextX, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null);
        }
    }
}
