package com.discord.widgets.user;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMutualFriends$onViewBoundOrOnResume$1 extends k implements Function1<WidgetUserMutualFriends$Model, Unit> {
    public WidgetUserMutualFriends$onViewBoundOrOnResume$1(WidgetUserMutualFriends widgetUserMutualFriends) {
        super(1, widgetUserMutualFriends, WidgetUserMutualFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserMutualFriends$Model widgetUserMutualFriends$Model) {
        invoke2(widgetUserMutualFriends$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserMutualFriends$Model widgetUserMutualFriends$Model) {
        m.checkNotNullParameter(widgetUserMutualFriends$Model, "p1");
        WidgetUserMutualFriends.access$configureUI((WidgetUserMutualFriends) this.receiver, widgetUserMutualFriends$Model);
    }
}
