package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2 */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7743xe5e506b3 extends AbstractC12240o implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments.C77411 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7743xe5e506b3(WidgetChatInputAttachments.C77411 c77411) {
        super(1);
        this.this$0 = c77411;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        invoke2(inputContentInfoCompat);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputContentInfoCompat inputContentInfoCompat) {
        C12238m.checkNotNullParameter(inputContentInfoCompat, "it");
        WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
        Context context = widgetChatInputAttachments.flexInputFragment.m9293l().getContext();
        C12238m.checkNotNullExpressionValue(context, "flexInputFragment.getTextInput().context");
        widgetChatInputAttachments.setAttachmentFromPicker(context, inputContentInfoCompat);
    }
}
