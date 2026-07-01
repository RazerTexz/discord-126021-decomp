package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildContextMenu$onResume$1 extends k implements Function1<GuildContextMenuViewModel$ViewState, Unit> {
    public WidgetGuildContextMenu$onResume$1(WidgetGuildContextMenu widgetGuildContextMenu) {
        super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel$ViewState guildContextMenuViewModel$ViewState) {
        invoke2(guildContextMenuViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildContextMenuViewModel$ViewState guildContextMenuViewModel$ViewState) {
        m.checkNotNullParameter(guildContextMenuViewModel$ViewState, "p1");
        WidgetGuildContextMenu.access$configureUI((WidgetGuildContextMenu) this.receiver, guildContextMenuViewModel$ViewState);
    }
}
