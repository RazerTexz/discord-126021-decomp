package com.discord.widgets.channels.permissions;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet$onViewCreated$1 implements Runnable {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetChannelSettingsAddMemberSheet this$0;

    public WidgetChannelSettingsAddMemberSheet$onViewCreated$1(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet, View view) {
        this.this$0 = widgetChannelSettingsAddMemberSheet;
        this.$view = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup$LayoutParams layoutParams = this.$view.getLayoutParams();
        if (layoutParams != null) {
            Resources resources = this.this$0.getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
        }
    }
}
