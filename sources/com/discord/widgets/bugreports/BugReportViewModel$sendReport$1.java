package com.discord.widgets.bugreports;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$sendReport$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ BugReportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$sendReport$1(BugReportViewModel bugReportViewModel) {
        super(1);
        this.this$0 = bugReportViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        BugReportViewModel bugReportViewModel = this.this$0;
        BugReportViewModel.access$updateViewState(bugReportViewModel, new BugReportViewModel$ViewState$Success(bugReportViewModel.getSuccessSticker()));
        BugReportViewModel.access$dismissAfterDelay(this.this$0);
    }
}
