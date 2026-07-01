package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildContextMenu$onResume$2 extends k implements Function1<GuildContextMenuViewModel$Event, Unit> {
    public WidgetGuildContextMenu$onResume$2(WidgetGuildContextMenu widgetGuildContextMenu) {
        super(1, widgetGuildContextMenu, WidgetGuildContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel$Event guildContextMenuViewModel$Event) {
        invoke2(guildContextMenuViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildContextMenuViewModel$Event guildContextMenuViewModel$Event) {
        m.checkNotNullParameter(guildContextMenuViewModel$Event, "p1");
        WidgetGuildContextMenu.access$handleEvent((WidgetGuildContextMenu) this.receiver, guildContextMenuViewModel$Event);
    }
}
