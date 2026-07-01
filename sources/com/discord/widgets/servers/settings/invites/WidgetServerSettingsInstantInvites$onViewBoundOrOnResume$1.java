package com.discord.widgets.servers.settings.invites;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsInstantInvites$Model, Unit> {
    public WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
        super(1, widgetServerSettingsInstantInvites, WidgetServerSettingsInstantInvites.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsInstantInvites$Model widgetServerSettingsInstantInvites$Model) {
        invoke2(widgetServerSettingsInstantInvites$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsInstantInvites$Model widgetServerSettingsInstantInvites$Model) {
        WidgetServerSettingsInstantInvites.access$configureUI((WidgetServerSettingsInstantInvites) this.receiver, widgetServerSettingsInstantInvites$Model);
    }
}
