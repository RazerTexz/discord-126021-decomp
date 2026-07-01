package com.discord.widgets.home;

import com.discord.panels.OverlappingPanelsLayout$PanelStateListener;
import com.discord.panels.PanelState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureOverlappingPanels$1 implements OverlappingPanelsLayout$PanelStateListener {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$configureOverlappingPanels$1(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // com.discord.panels.OverlappingPanelsLayout$PanelStateListener
    public void onPanelStateChange(PanelState panelState) {
        m.checkNotNullParameter(panelState, "panelState");
        WidgetHome.access$getViewModel$p(this.this$0).onStartPanelStateChange(panelState);
    }
}
