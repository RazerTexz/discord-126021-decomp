package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$onViewBoundOrOnResume$1 extends o implements Function1<GuildInviteSettingsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings$onViewBoundOrOnResume$1(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(1);
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel$ViewState guildInviteSettingsViewModel$ViewState) {
        invoke2(guildInviteSettingsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteSettingsViewModel$ViewState guildInviteSettingsViewModel$ViewState) {
        WidgetGuildInviteSettings widgetGuildInviteSettings = this.this$0;
        m.checkNotNullExpressionValue(guildInviteSettingsViewModel$ViewState, "viewState");
        widgetGuildInviteSettings.configureUi(guildInviteSettingsViewModel$ViewState);
    }
}
