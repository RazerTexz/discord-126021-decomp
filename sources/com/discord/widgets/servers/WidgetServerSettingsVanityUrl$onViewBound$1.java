package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$onViewBound$1 implements View$OnFocusChangeListener {
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    public WidgetServerSettingsVanityUrl$onViewBound$1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        this.this$0 = widgetServerSettingsVanityUrl;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (!z2) {
            WidgetServerSettingsVanityUrl$Companion widgetServerSettingsVanityUrl$Companion = WidgetServerSettingsVanityUrl.Companion;
            TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).h;
            m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlPrefix");
            WidgetServerSettingsVanityUrl$Companion.access$translateToOriginX(widgetServerSettingsVanityUrl$Companion, textView);
            TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).f2588b;
            m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
            WidgetServerSettingsVanityUrl$Companion.access$translateToOriginX(widgetServerSettingsVanityUrl$Companion, textInputLayout);
            return;
        }
        TextView textView2 = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlPrefix");
        int width = textView2.getWidth();
        WidgetServerSettingsVanityUrl$Companion widgetServerSettingsVanityUrl$Companion2 = WidgetServerSettingsVanityUrl.Companion;
        TextView textView3 = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlPrefix");
        WidgetServerSettingsVanityUrl$Companion.access$translateLeft(widgetServerSettingsVanityUrl$Companion2, textView3, width);
        TextInputLayout textInputLayout2 = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).f2588b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        WidgetServerSettingsVanityUrl$Companion.access$translateLeft(widgetServerSettingsVanityUrl$Companion2, textInputLayout2, width);
    }
}
