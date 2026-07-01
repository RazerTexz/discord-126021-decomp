package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.servers.WidgetServerNotifications;
import com.discord.widgets.servers.WidgetServerNotifications$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$configureValidUI$2 implements View$OnClickListener {
    public final /* synthetic */ GuildContextMenuViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    public WidgetGuildContextMenu$configureValidUI$2(WidgetGuildContextMenu widgetGuildContextMenu, GuildContextMenuViewModel$ViewState$Valid guildContextMenuViewModel$ViewState$Valid) {
        this.this$0 = widgetGuildContextMenu;
        this.$viewState = guildContextMenuViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildContextMenu.access$doCircularRemove(this.this$0);
        WidgetServerNotifications$Companion widgetServerNotifications$Companion = WidgetServerNotifications.Companion;
        long id2 = this.$viewState.getGuild().getId();
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        widgetServerNotifications$Companion.launch(id2, fragmentActivityRequireActivity);
    }
}
