package com.discord.widgets.chat.overlay;

import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$chatInputViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay6 extends Lambda implements Function0<ChatInputViewModel> {
    public static final WidgetChatOverlay6 INSTANCE = new WidgetChatOverlay6();

    public WidgetChatOverlay6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChatInputViewModel invoke() {
        return new ChatInputViewModel(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }
}
