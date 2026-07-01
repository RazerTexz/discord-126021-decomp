package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$onViewBoundOrOnResume$1 extends o implements Function1<GuildInviteViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$onViewBoundOrOnResume$1(WidgetGuildInvite widgetGuildInvite) {
        super(1);
        this.this$0 = widgetGuildInvite;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteViewModel$ViewState guildInviteViewModel$ViewState) {
        invoke2(guildInviteViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteViewModel$ViewState guildInviteViewModel$ViewState) {
        m.checkNotNullParameter(guildInviteViewModel$ViewState, "viewState");
        this.this$0.configureUI(guildInviteViewModel$ViewState);
    }
}
