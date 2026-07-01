package com.discord.widgets.chat.input;

import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        super(0);
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.hideExpressionTray();
        }
    }
}
