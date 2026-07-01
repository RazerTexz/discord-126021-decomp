package com.discord.widgets.guilds.contextmenu;

import android.os.Bundle;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$viewModel$2 extends o implements Function0<GuildContextMenuViewModel> {
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildContextMenu$viewModel$2(WidgetGuildContextMenu widgetGuildContextMenu) {
        super(0);
        this.this$0 = widgetGuildContextMenu;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildContextMenuViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildContextMenuViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return new GuildContextMenuViewModel(arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, null, 6, null);
        }
        throw new IllegalStateException("missing guild id");
    }
}
