package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription8 extends Lambda implements Function0<WidgetHubDescriptionViewModel> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription8(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel invoke() {
        return new WidgetHubDescriptionViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().isEditing(), this.this$0.getArgs().getPrimaryCategoryId(), null, null, 48, null);
    }
}
