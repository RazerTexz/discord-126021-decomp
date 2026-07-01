package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddName$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName4 extends Lambda implements Function0<WidgetHubAddNameViewModel> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName4(WidgetHubAddName widgetHubAddName) {
        super(0);
        this.this$0 = widgetHubAddName;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAddNameViewModel invoke() {
        return new WidgetHubAddNameViewModel(this.this$0.getArgs().getGuildId(), null, null, null, 14, null);
    }
}
