package com.discord.widgets.chat.input;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$flexInputViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput5 extends Lambda implements Function0<AppFlexInputViewModel> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput5(WidgetChatInput widgetChatInput) {
        super(0);
        this.this$0 = widgetChatInput;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppFlexInputViewModel invoke() {
        return new AppFlexInputViewModel(this.this$0, null, null, null, null, null, 62, null);
    }
}
