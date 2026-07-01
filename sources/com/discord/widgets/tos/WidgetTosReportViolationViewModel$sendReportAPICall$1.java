package com.discord.widgets.tos;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel$sendReportAPICall$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetTosReportViolationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolationViewModel$sendReportAPICall$1(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel) {
        super(1);
        this.this$0 = widgetTosReportViolationViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetTosReportViolationViewModel.access$updateViewState(this.this$0, WidgetTosReportViolationViewModel$ViewState$SubmissionError.INSTANCE);
    }
}
