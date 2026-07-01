package com.discord.utilities.bugreports;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BugReportManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportManager$setupSubscriptions$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ BugReportManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportManager$setupSubscriptions$2(BugReportManager bugReportManager) {
        super(1);
        this.this$0 = bugReportManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        BugReportManager bugReportManager = this.this$0;
        m.checkNotNullExpressionValue(bool, "isStaff");
        bugReportManager.setUserIsStaff(bool.booleanValue());
    }
}
