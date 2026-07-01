package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsCommunityThirdStep this$0;

    public WidgetServerSettingsCommunityThirdStep$configureUI$3(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        this.this$0 = widgetServerSettingsCommunityThirdStep;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(this.this$0).modifyGuildConfig(new WidgetServerSettingsCommunityThirdStep$configureUI$3$1(this));
    }
}
