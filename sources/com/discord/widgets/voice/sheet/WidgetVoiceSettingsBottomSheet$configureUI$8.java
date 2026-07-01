package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.mobile_reports.WidgetMobileReports$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$configureUI$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet$ViewState $viewState;
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet$configureUI$8(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet$ViewState widgetVoiceSettingsBottomSheet$ViewState) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
        this.$viewState = widgetVoiceSettingsBottomSheet$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetMobileReports$Companion widgetMobileReports$Companion = WidgetMobileReports.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetMobileReports$Companion.launchStageChannelReport(contextRequireContext, this.$viewState.getChannel().getId());
    }
}
