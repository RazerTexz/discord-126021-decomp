package com.discord.widgets.channels;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$onViewBoundOrOnResume$4 extends k implements Function1<WidgetGroupInviteFriends$Model, Unit> {
    public WidgetGroupInviteFriends$onViewBoundOrOnResume$4(WidgetGroupInviteFriends widgetGroupInviteFriends) {
        super(1, widgetGroupInviteFriends, WidgetGroupInviteFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model) {
        invoke2(widgetGroupInviteFriends$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model) {
        WidgetGroupInviteFriends.access$configureUI((WidgetGroupInviteFriends) this.receiver, widgetGroupInviteFriends$Model);
    }
}
