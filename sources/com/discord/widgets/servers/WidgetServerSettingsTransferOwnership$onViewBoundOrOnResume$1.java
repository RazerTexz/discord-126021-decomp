package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsTransferOwnership$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsTransferOwnership$Model, Unit> {
    public WidgetServerSettingsTransferOwnership$onViewBoundOrOnResume$1(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        super(1, widgetServerSettingsTransferOwnership, WidgetServerSettingsTransferOwnership.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsTransferOwnership$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model) {
        invoke2(widgetServerSettingsTransferOwnership$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model) {
        WidgetServerSettingsTransferOwnership.access$configureUI((WidgetServerSettingsTransferOwnership) this.receiver, widgetServerSettingsTransferOwnership$Model);
    }
}
