package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.premium.PremiumUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configurePaymentInfo$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $isAppleSubscription;

    public WidgetSettingsPremium$configurePaymentInfo$1(boolean z2) {
        this.$isAppleSubscription = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isAppleSubscription) {
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            premiumUtils.openAppleBilling(context);
        }
    }
}
