package com.discord.widgets.stage.sheet;

import android.text.Editable;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$onViewCreated$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet$onViewCreated$1(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(1);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        TextInputLayout textInputLayout = WidgetStageStartEventBottomSheet.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
        textInputLayout.setError(null);
        WidgetStageStartEventBottomSheet.access$getViewModel$p(this.this$0).setTopic(editable.toString());
    }
}
