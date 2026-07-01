package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1(Guild guild, WidgetDirectoryChannel widgetDirectoryChannel) {
        this.$guild = guild;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
        Context contextX = a.x(view, "it", "it.context");
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, contextX, childFragmentManager, this.$guild.getId(), null, false, null, null, "Guild Header", 120, null);
    }
}
