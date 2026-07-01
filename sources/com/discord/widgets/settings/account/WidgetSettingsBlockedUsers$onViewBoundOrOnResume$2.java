package com.discord.widgets.settings.account;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2 extends k implements Function1<WidgetSettingsBlockedUsersViewModel$Event, Unit> {
    public WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
        super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel$Event widgetSettingsBlockedUsersViewModel$Event) {
        invoke2(widgetSettingsBlockedUsersViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsBlockedUsersViewModel$Event widgetSettingsBlockedUsersViewModel$Event) {
        m.checkNotNullParameter(widgetSettingsBlockedUsersViewModel$Event, "p1");
        WidgetSettingsBlockedUsers.access$handleEvent((WidgetSettingsBlockedUsers) this.receiver, widgetSettingsBlockedUsersViewModel$Event);
    }
}
