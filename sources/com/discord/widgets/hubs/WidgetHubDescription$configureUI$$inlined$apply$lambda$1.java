package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$configureUI$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ HubDescriptionState $state$inlined;
    public final /* synthetic */ WidgetHubDescription this$0;

    public WidgetHubDescription$configureUI$$inlined$apply$lambda$1(WidgetHubDescription widgetHubDescription, HubDescriptionState hubDescriptionState) {
        this.this$0 = widgetHubDescription;
        this.$state$inlined = hubDescriptionState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHubDescription.access$maybeAddServer(this.this$0);
    }
}
