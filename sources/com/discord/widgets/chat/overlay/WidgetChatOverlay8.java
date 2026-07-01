package com.discord.widgets.chat.overlay;

import com.discord.widgets.chat.input.AppFlexInputViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$flexInputViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay8 extends Lambda implements Function0<AppFlexInputViewModel> {
    public final /* synthetic */ WidgetChatOverlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatOverlay8(WidgetChatOverlay widgetChatOverlay) {
        super(0);
        this.this$0 = widgetChatOverlay;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppFlexInputViewModel invoke() {
        return new AppFlexInputViewModel(this.this$0, null, null, null, null, null, 62, null);
    }
}
