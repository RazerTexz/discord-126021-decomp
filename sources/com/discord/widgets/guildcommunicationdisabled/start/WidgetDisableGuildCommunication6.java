package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication6 extends Lambda implements Function0<DisableGuildCommunicationViewModel> {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication6(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel invoke() {
        return new DisableGuildCommunicationViewModel(this.this$0.getUserId(), this.this$0.getGuildId(), null, null, null, null, 60, null);
    }
}
