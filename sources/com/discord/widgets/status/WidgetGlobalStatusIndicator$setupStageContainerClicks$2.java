package com.discord.widgets.status;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator$setupStageContainerClicks$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator$setupStageContainerClicks$2(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        this.this$0 = widgetGlobalStatusIndicator;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requestMicrophone(new WidgetGlobalStatusIndicator$setupStageContainerClicks$2$1(this), new WidgetGlobalStatusIndicator$setupStageContainerClicks$2$2(this));
    }
}
