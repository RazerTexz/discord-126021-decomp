package com.discord.widgets.guilds.contextmenu;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu4 extends Lambda implements Function0<GuildContextMenuViewModel> {
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildContextMenu4(WidgetGuildContextMenu widgetGuildContextMenu) {
        super(0);
        this.this$0 = widgetGuildContextMenu;
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
