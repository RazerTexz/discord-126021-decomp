package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsCommunitySecondStep this$0;

    public WidgetServerSettingsCommunitySecondStep$configureUI$1(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        this.this$0 = widgetServerSettingsCommunitySecondStep;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector$Companion widgetChannelSelector$Companion = WidgetChannelSelector.Companion;
        WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = this.this$0;
        WidgetChannelSelector$Companion.launchForText$default(widgetChannelSelector$Companion, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(widgetServerSettingsCommunitySecondStep).getGuildId(), "REQUEST_KEY_RULES_CHANNEL", false, 0, 24, null);
    }
}
