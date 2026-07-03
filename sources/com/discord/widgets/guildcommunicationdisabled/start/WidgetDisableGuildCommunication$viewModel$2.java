package com.discord.widgets.guildcommunicationdisabled.start;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$viewModel$2 extends AbstractC12240o implements Function0<DisableGuildCommunicationViewModel> {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication$viewModel$2(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel invoke() {
        return new DisableGuildCommunicationViewModel(this.this$0.getUserId(), this.this$0.getGuildId(), null, null, null, null, 60, null);
    }
}
