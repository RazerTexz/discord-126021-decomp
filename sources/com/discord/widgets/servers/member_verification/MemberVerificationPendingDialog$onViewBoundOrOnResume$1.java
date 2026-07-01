package com.discord.widgets.servers.member_verification;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationPendingDialog$onViewBoundOrOnResume$1 extends k implements Function1<MemberVerificationPendingViewModel$ViewState, Unit> {
    public MemberVerificationPendingDialog$onViewBoundOrOnResume$1(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        super(1, memberVerificationPendingDialog, MemberVerificationPendingDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel$ViewState memberVerificationPendingViewModel$ViewState) {
        invoke2(memberVerificationPendingViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MemberVerificationPendingViewModel$ViewState memberVerificationPendingViewModel$ViewState) {
        m.checkNotNullParameter(memberVerificationPendingViewModel$ViewState, "p1");
        MemberVerificationPendingDialog.access$configureUI((MemberVerificationPendingDialog) this.receiver, memberVerificationPendingViewModel$ViewState);
    }
}
