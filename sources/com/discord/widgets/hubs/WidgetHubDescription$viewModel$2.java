package com.discord.widgets.hubs;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$viewModel$2 extends o implements Function0<WidgetHubDescriptionViewModel> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$viewModel$2(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel invoke() {
        return new WidgetHubDescriptionViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().isEditing(), this.this$0.getArgs().getPrimaryCategoryId(), null, null, 48, null);
    }
}
