package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.domain.ModelGuildTemplate;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1 implements View$OnClickListener {
    public final /* synthetic */ ModelGuildTemplate $guildTemplate;
    public final /* synthetic */ WidgetChatListAdapterItemGuildTemplate this$0;

    public WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, ModelGuildTemplate modelGuildTemplate) {
        this.this$0 = widgetChatListAdapterItemGuildTemplate;
        this.$guildTemplate = modelGuildTemplate;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemGuildTemplate.access$openGuildTemplate(this.this$0, a.x(view, "it", "it.context"), this.$guildTemplate);
    }
}
