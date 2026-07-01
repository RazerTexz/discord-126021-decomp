package com.discord.widgets.nux;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateCardViewHolder$bind$2 implements View$OnClickListener {
    public final /* synthetic */ GuildTemplate $guildTemplate;
    public final /* synthetic */ GuildTemplateCardViewHolder this$0;

    public GuildTemplateCardViewHolder$bind$2(GuildTemplateCardViewHolder guildTemplateCardViewHolder, GuildTemplate guildTemplate) {
        this.this$0 = guildTemplateCardViewHolder;
        this.$guildTemplate = guildTemplate;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getCallbacks().onTemplateClick(this.$guildTemplate);
    }
}
