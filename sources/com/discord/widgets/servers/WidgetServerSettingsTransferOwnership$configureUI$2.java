package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsTransferOwnership this$0;

    public WidgetServerSettingsTransferOwnership$configureUI$2(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        this.this$0 = widgetServerSettingsTransferOwnership;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsTransferOwnership.access$getBinding$p(this.this$0).f2455b.toggle();
        MaterialButton materialButton = WidgetServerSettingsTransferOwnership.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(materialButton, "binding.guildTransferOwnershipConfirm");
        CheckedSetting checkedSetting = WidgetServerSettingsTransferOwnership.access$getBinding$p(this.this$0).f2455b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildTransferOwnershipAcknowledgeCheck");
        materialButton.setEnabled(checkedSetting.isChecked());
    }
}
