package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$10(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventSettingsViewModel guildScheduledEventSettingsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0);
        MaterialCheckBox materialCheckBox = WidgetGuildScheduledEventSettings.access$getBinding$p(this.this$0).p;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        guildScheduledEventSettingsViewModelAccess$getViewModel$p.toggleBroadcastToDirectoryChannel(!materialCheckBox.isChecked());
    }
}
