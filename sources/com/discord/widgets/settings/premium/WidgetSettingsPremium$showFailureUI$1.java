package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$showFailureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium$showFailureUI$1(WidgetSettingsPremium widgetSettingsPremium) {
        this.this$0 = widgetSettingsPremium;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPremium.access$getViewModel$p(this.this$0).onRetryClicked();
    }
}
