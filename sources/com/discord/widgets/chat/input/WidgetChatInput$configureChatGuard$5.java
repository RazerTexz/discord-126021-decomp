package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureChatGuard$5 implements View$OnClickListener {
    public final /* synthetic */ String $guideUrl;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureChatGuard$5(WidgetChatInput widgetChatInput, String str) {
        this.this$0 = widgetChatInput;
        this.$guideUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.I(WidgetChatInput.access$getBinding$p(this.this$0).f2304s.f205b, "binding.guardCommunicati…nicationDisabledGuardText", "binding.guardCommunicati…DisabledGuardText.context"), this.$guideUrl, false, false, null, 28, null);
    }
}
