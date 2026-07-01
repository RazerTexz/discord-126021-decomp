package com.discord.widgets.bugreports;

import com.discord.api.bugreport.BugReportConfig;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$loadFeatures$1 extends o implements Function1<RestCallState<? extends BugReportConfig>, Unit> {
    public final /* synthetic */ BugReportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$loadFeatures$1(BugReportViewModel bugReportViewModel) {
        super(1);
        this.this$0 = bugReportViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends BugReportConfig> restCallState) {
        invoke2((RestCallState<BugReportConfig>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<BugReportConfig> restCallState) {
        m.checkNotNullParameter(restCallState, "it");
        BugReportViewModel.access$setBugReportConfig$p(this.this$0, restCallState);
    }
}
