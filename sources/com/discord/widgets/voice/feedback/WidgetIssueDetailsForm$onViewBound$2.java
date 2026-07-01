package com.discord.widgets.voice.feedback;

import android.text.Editable;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$onViewBound$2 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIssueDetailsForm$onViewBound$2(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        super(1);
        this.this$0 = widgetIssueDetailsForm;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        MaterialButton materialButton = WidgetIssueDetailsForm.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(editable.length() > 0);
    }
}
