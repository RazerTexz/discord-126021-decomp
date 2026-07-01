package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserMutualGuilds$Model$Item $data;
    public final /* synthetic */ WidgetUserMutualGuilds$Adapter$ViewHolder this$0;

    public WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1(WidgetUserMutualGuilds$Adapter$ViewHolder widgetUserMutualGuilds$Adapter$ViewHolder, WidgetUserMutualGuilds$Model$Item widgetUserMutualGuilds$Model$Item) {
        this.this$0 = widgetUserMutualGuilds$Adapter$ViewHolder;
        this.$data = widgetUserMutualGuilds$Model$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreGuildSelected guildSelected = StoreStream.Companion.getGuildSelected();
        Guild guild = this.$data.getGuild();
        guildSelected.set(guild != null ? guild.getId() : 0L);
        WidgetUserMutualGuilds$Adapter.access$getGuildSelectedCallback$p(WidgetUserMutualGuilds$Adapter$ViewHolder.access$getAdapter$p(this.this$0)).call();
    }
}
