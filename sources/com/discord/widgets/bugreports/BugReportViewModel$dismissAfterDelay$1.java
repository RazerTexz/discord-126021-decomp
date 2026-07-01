package com.discord.widgets.bugreports;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$dismissAfterDelay$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ BugReportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$dismissAfterDelay$1(BugReportViewModel bugReportViewModel) {
        super(1);
        this.this$0 = bugReportViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        BugReportViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) BugReportViewModel$Event$CloseReport.INSTANCE);
    }
}
