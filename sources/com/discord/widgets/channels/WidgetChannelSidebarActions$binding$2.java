package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSidebarActions$binding$2 extends k implements Function1<View, WidgetChannelSidebarActionsBinding> {
    public static final WidgetChannelSidebarActions$binding$2 INSTANCE = new WidgetChannelSidebarActions$binding$2();

    public WidgetChannelSidebarActions$binding$2() {
        super(1, WidgetChannelSidebarActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSidebarActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSidebarActionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.widget_channel_sidebar_actions_guild_view;
        GuildChannelSideBarActionsView guildChannelSideBarActionsView = (GuildChannelSideBarActionsView) view.findViewById(R$id.widget_channel_sidebar_actions_guild_view);
        if (guildChannelSideBarActionsView != null) {
            i = R$id.widget_channel_sidebar_actions_private_view;
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = (PrivateChannelSideBarActionsView) view.findViewById(R$id.widget_channel_sidebar_actions_private_view);
            if (privateChannelSideBarActionsView != null) {
                return new WidgetChannelSidebarActionsBinding((FrameLayout) view, guildChannelSideBarActionsView, privateChannelSideBarActionsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
