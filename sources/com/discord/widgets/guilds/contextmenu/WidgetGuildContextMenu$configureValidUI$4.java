package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$configureValidUI$4 implements View$OnClickListener {
    public final /* synthetic */ GuildContextMenuViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    public WidgetGuildContextMenu$configureValidUI$4(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel$ViewState$Valid guildContextMenuViewModel$ViewState$Valid) {
        this.this$0 = widgetGuildContextMenu;
        this.$viewState = guildContextMenuViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildContextMenu.access$doCircularRemove(this.this$0);
        WidgetGuildProfileSheet$Companion widgetGuildProfileSheet$Companion = WidgetGuildProfileSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetGuildProfileSheet$Companion.show$default(widgetGuildProfileSheet$Companion, parentFragmentManager, this.$viewState.isGuildSelected(), this.$viewState.getGuild().getId(), 0L, false, 24, null);
    }
}
