package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableGuildCommunication$onResume$1 extends k implements Function1<DisableGuildCommunicationViewModel$ViewState, Unit> {
    public WidgetDisableGuildCommunication$onResume$1(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(1, widgetDisableGuildCommunication, WidgetDisableGuildCommunication.class, "configureUI", "configureUI(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DisableGuildCommunicationViewModel$ViewState disableGuildCommunicationViewModel$ViewState) {
        invoke2(disableGuildCommunicationViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DisableGuildCommunicationViewModel$ViewState disableGuildCommunicationViewModel$ViewState) {
        m.checkNotNullParameter(disableGuildCommunicationViewModel$ViewState, "p1");
        WidgetDisableGuildCommunication.access$configureUI((WidgetDisableGuildCommunication) this.receiver, disableGuildCommunicationViewModel$ViewState);
    }
}
