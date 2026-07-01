package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.a0;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureUI$2(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        this.this$0 = widgetServerSettingsOverview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview$AfkBottomSheet widgetServerSettingsOverview$AfkBottomSheet = new WidgetServerSettingsOverview$AfkBottomSheet();
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        widgetServerSettingsOverview$AfkBottomSheet.show(childFragmentManager, a0.getOrCreateKotlinClass(WidgetServerSettingsOverview$AfkBottomSheet.class).toString());
    }
}
