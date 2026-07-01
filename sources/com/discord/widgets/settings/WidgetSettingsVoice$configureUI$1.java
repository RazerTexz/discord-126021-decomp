package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.a0;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsVoice this$0;

    public WidgetSettingsVoice$configureUI$1(WidgetSettingsVoice widgetSettingsVoice) {
        this.this$0 = widgetSettingsVoice;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsVoice$InputModeSelector widgetSettingsVoice$InputModeSelector = new WidgetSettingsVoice$InputModeSelector();
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        widgetSettingsVoice$InputModeSelector.show(childFragmentManager, String.valueOf(a0.getOrCreateKotlinClass(WidgetSettingsVoice$InputModeSelector.class)));
    }
}
