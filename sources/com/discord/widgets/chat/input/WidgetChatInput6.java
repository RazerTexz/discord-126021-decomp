package com.discord.widgets.chat.input;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput6 extends Lambda implements Function0<ChatInputViewModel> {
    public static final WidgetChatInput6 INSTANCE = new WidgetChatInput6();

    public WidgetChatInput6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChatInputViewModel invoke() {
        return new ChatInputViewModel(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }
}
