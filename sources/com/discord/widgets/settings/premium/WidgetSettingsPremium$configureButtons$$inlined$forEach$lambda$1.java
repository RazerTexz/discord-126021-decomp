package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.premium.PremiumUtils;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$1(WidgetSettingsPremium widgetSettingsPremium) {
        this.this$0 = widgetSettingsPremium;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PremiumUtils.INSTANCE.openAppleBilling(this.this$0.requireContext());
    }
}
