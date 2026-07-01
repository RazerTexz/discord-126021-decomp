package com.discord.widgets.chat.list.actions;

import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$10(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model, long j) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requireContext().startActivity(Intent.createChooser(IntentUtils.INSTANCE.toExternalizedSend(IntentUtils$RouteBuilders.selectChannel(this.$data.getMessage().getChannelId(), this.$guildId, Long.valueOf(this.$data.getMessage().getId()))), this.this$0.getString(2131895647)));
        this.this$0.dismiss();
    }
}
