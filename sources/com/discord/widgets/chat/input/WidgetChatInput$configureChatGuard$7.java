package com.discord.widgets.chat.input;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.guilds.MemberVerificationUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureChatGuard$7 implements View$OnClickListener {
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureChatGuard$7(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded) {
        this.this$0 = widgetChatInput;
        this.$viewState = chatInputViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, contextRequireContext, parentFragmentManager, this.$viewState.getChannel().getGuildId(), Traits$Location$Page.GUILD_CHANNEL, null, null, WidgetChatInput$configureChatGuard$7$1.INSTANCE, 48, null);
    }
}
