package com.discord.widgets.guild_automod;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ReportIssueWithAutoModViewModel$1 extends k implements Function1<ReportIssueWithAutoModViewModel$StoreState, Unit> {
    public ReportIssueWithAutoModViewModel$1(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel) {
        super(1, reportIssueWithAutoModViewModel, ReportIssueWithAutoModViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel$StoreState reportIssueWithAutoModViewModel$StoreState) {
        invoke2(reportIssueWithAutoModViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ReportIssueWithAutoModViewModel$StoreState reportIssueWithAutoModViewModel$StoreState) {
        m.checkNotNullParameter(reportIssueWithAutoModViewModel$StoreState, "p1");
        ReportIssueWithAutoModViewModel.access$handleStoreState((ReportIssueWithAutoModViewModel) this.receiver, reportIssueWithAutoModViewModel$StoreState);
    }
}
