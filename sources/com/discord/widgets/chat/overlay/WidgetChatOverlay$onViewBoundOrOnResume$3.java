package com.discord.widgets.chat.overlay;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$onViewBoundOrOnResume$3 extends o implements Function1<WidgetChatOverlay$OldMessageModel, Unit> {
    public final /* synthetic */ WidgetChatOverlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatOverlay$onViewBoundOrOnResume$3(WidgetChatOverlay widgetChatOverlay) {
        super(1);
        this.this$0 = widgetChatOverlay;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatOverlay$OldMessageModel widgetChatOverlay$OldMessageModel) {
        invoke2(widgetChatOverlay$OldMessageModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatOverlay$OldMessageModel widgetChatOverlay$OldMessageModel) {
        if (widgetChatOverlay$OldMessageModel.isViewingOldMessages()) {
            WidgetChatOverlay.access$getBinding$p(this.this$0).f2345b.show();
        } else {
            WidgetChatOverlay.access$getBinding$p(this.this$0).f2345b.hide();
        }
    }
}
