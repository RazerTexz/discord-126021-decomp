package com.discord.widgets.settings.account;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1 extends k implements Function1<WidgetSettingsBlockedUsersViewModel$ViewState, Unit> {
    public WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
        super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel$ViewState widgetSettingsBlockedUsersViewModel$ViewState) {
        invoke2(widgetSettingsBlockedUsersViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsBlockedUsersViewModel$ViewState widgetSettingsBlockedUsersViewModel$ViewState) {
        m.checkNotNullParameter(widgetSettingsBlockedUsersViewModel$ViewState, "p1");
        WidgetSettingsBlockedUsers.access$configureUI((WidgetSettingsBlockedUsers) this.receiver, widgetSettingsBlockedUsersViewModel$ViewState);
    }
}
