package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.widget.SwitchCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$onViewBoundOrOnResume$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetCreateChannel this$0;

    public WidgetCreateChannel$onViewBoundOrOnResume$7(WidgetCreateChannel widgetCreateChannel) {
        this.this$0 = widgetCreateChannel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SwitchCompat switchCompat = WidgetCreateChannel.access$getBinding$p(this.this$0).i;
        m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        SwitchCompat switchCompat2 = WidgetCreateChannel.access$getBinding$p(this.this$0).i;
        m.checkNotNullExpressionValue(switchCompat2, "binding.createChannelPrivateSwitch");
        switchCompat.setChecked(!switchCompat2.isChecked());
        WidgetCreateChannel.access$configurePrivateRoles(this.this$0);
    }
}
