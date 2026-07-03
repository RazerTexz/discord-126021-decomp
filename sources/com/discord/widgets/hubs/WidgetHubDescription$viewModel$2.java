package com.discord.widgets.hubs;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$viewModel$2 extends AbstractC12240o implements Function0<WidgetHubDescriptionViewModel> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$viewModel$2(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel invoke() {
        return new WidgetHubDescriptionViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().isEditing(), this.this$0.getArgs().getPrimaryCategoryId(), null, null, 48, null);
    }
}
