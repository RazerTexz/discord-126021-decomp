package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2 extends o implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments$configureFlexInputFragment$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(WidgetChatInputAttachments$configureFlexInputFragment$1 widgetChatInputAttachments$configureFlexInputFragment$1) {
        super(1);
        this.this$0 = widgetChatInputAttachments$configureFlexInputFragment$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        invoke2(inputContentInfoCompat);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputContentInfoCompat inputContentInfoCompat) {
        m.checkNotNullParameter(inputContentInfoCompat, "it");
        WidgetChatInputAttachments widgetChatInputAttachments = this.this$0.this$0;
        Context context = WidgetChatInputAttachments.access$getFlexInputFragment$p(widgetChatInputAttachments).l().getContext();
        m.checkNotNullExpressionValue(context, "flexInputFragment.getTextInput().context");
        WidgetChatInputAttachments.access$setAttachmentFromPicker(widgetChatInputAttachments, context, inputContentInfoCompat);
    }
}
