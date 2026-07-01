package com.discord.widgets.servers.member_verification;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationSuccessDialog$onViewBoundOrOnResume$1 extends k implements Function1<MemberVerificationSuccessViewModel$ViewState, Unit> {
    public MemberVerificationSuccessDialog$onViewBoundOrOnResume$1(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        super(1, memberVerificationSuccessDialog, MemberVerificationSuccessDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationSuccessViewModel$ViewState memberVerificationSuccessViewModel$ViewState) {
        invoke2(memberVerificationSuccessViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MemberVerificationSuccessViewModel$ViewState memberVerificationSuccessViewModel$ViewState) {
        m.checkNotNullParameter(memberVerificationSuccessViewModel$ViewState, "p1");
        MemberVerificationSuccessDialog.access$configureUI((MemberVerificationSuccessDialog) this.receiver, memberVerificationSuccessViewModel$ViewState);
    }
}
