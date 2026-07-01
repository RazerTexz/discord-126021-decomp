package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2 extends Lambda implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(WidgetChatInputAttachments.AnonymousClass1 anonymousClass1) {
        super(1);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        invoke2(inputContentInfoCompat);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputContentInfoCompat inputContentInfoCompat) {
        Intrinsics3.checkNotNullParameter(inputContentInfoCompat, "it");
        WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
        Context context = widgetChatInputAttachments.flexInputFragment.l().getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "flexInputFragment.getTextInput().context");
        widgetChatInputAttachments.setAttachmentFromPicker(context, inputContentInfoCompat);
    }
}
