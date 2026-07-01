package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureChatGuard$1 implements View$OnClickListener {
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureChatGuard$1(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded) {
        this.this$0 = widgetChatInput;
        this.$viewState = chatInputViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatInput.access$showFollowSheet(this.this$0, this.$viewState.getChannel().getId(), this.$viewState.getChannel().getGuildId());
    }
}
