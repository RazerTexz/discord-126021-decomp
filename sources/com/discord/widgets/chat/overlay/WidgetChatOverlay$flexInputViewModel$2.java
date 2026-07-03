package com.discord.widgets.chat.overlay;

import com.discord.widgets.chat.input.AppFlexInputViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$flexInputViewModel$2 extends AbstractC12240o implements Function0<AppFlexInputViewModel> {
    public final /* synthetic */ WidgetChatOverlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatOverlay$flexInputViewModel$2(WidgetChatOverlay widgetChatOverlay) {
        super(0);
        this.this$0 = widgetChatOverlay;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppFlexInputViewModel invoke() {
        return new AppFlexInputViewModel(this.this$0, null, null, null, null, null, 62, null);
    }
}
