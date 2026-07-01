package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetChannelsList this$0;

    public WidgetChannelsList$configureUI$3(WidgetChannelsList widgetChannelsList, Guild guild) {
        this.this$0 = widgetChannelsList;
        this.$guild = guild;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsList.access$ackPremiumGuildHint(this.this$0);
        WidgetGuildProfileSheet$Companion widgetGuildProfileSheet$Companion = WidgetGuildProfileSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Guild guild = this.$guild;
        WidgetGuildProfileSheet$Companion.show$default(widgetGuildProfileSheet$Companion, parentFragmentManager, true, guild != null ? guild.getId() : 0L, 0L, false, 24, null);
    }
}
