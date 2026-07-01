package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubDescription this$0;

    public WidgetHubDescription$onViewBound$1(WidgetHubDescription widgetHubDescription) {
        this.this$0 = widgetHubDescription;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetRadioSelectorBottomSheet$Companion widgetRadioSelectorBottomSheet$Companion = WidgetRadioSelectorBottomSheet.Companion;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        widgetRadioSelectorBottomSheet$Companion.show(childFragmentManager, WidgetHubDescription.access$getSelectorArgs$p(this.this$0), new WidgetHubDescription$onViewBound$1$1(this));
    }
}
