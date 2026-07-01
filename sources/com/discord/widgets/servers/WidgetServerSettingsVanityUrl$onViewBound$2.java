package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    public WidgetServerSettingsVanityUrl$onViewBound$2(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        this.this$0 = widgetServerSettingsVanityUrl;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = this.this$0;
        TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(widgetServerSettingsVanityUrl).f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        widgetServerSettingsVanityUrl.showKeyboard(textInputLayout);
    }
}
