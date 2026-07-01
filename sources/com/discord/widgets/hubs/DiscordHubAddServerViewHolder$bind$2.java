package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.guild.Guild;

/* JADX INFO: compiled from: DiscordHubAddServerViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordHubAddServerViewHolder$bind$2 implements View$OnClickListener {
    public final /* synthetic */ Guild $data;
    public final /* synthetic */ DiscordHubAddServerViewHolder this$0;

    public DiscordHubAddServerViewHolder$bind$2(DiscordHubAddServerViewHolder discordHubAddServerViewHolder, Guild guild) {
        this.this$0 = discordHubAddServerViewHolder;
        this.$data = guild;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnClickListener().invoke(Long.valueOf(this.$data.getId()));
    }
}
