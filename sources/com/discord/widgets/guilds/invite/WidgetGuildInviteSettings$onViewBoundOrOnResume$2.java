package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$onViewBoundOrOnResume$2 extends o implements Function1<GuildInviteSettingsViewModel$Event, Unit> {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings$onViewBoundOrOnResume$2(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(1);
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel$Event guildInviteSettingsViewModel$Event) {
        invoke2(guildInviteSettingsViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteSettingsViewModel$Event guildInviteSettingsViewModel$Event) {
        m.checkNotNullParameter(guildInviteSettingsViewModel$Event, "event");
        this.this$0.handleEvent(guildInviteSettingsViewModel$Event);
    }
}
