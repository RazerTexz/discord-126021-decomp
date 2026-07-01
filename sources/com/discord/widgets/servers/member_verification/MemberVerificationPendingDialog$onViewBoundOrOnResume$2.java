package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$onViewBoundOrOnResume$2 extends o implements Function1<MemberVerificationPendingViewModel$Event, Unit> {
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingDialog$onViewBoundOrOnResume$2(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        super(1);
        this.this$0 = memberVerificationPendingDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel$Event memberVerificationPendingViewModel$Event) {
        invoke2(memberVerificationPendingViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MemberVerificationPendingViewModel$Event memberVerificationPendingViewModel$Event) {
        m.checkNotNullParameter(memberVerificationPendingViewModel$Event, "event");
        if (!(memberVerificationPendingViewModel$Event instanceof MemberVerificationPendingViewModel$Event$Success) && (memberVerificationPendingViewModel$Event instanceof MemberVerificationPendingViewModel$Event$Error)) {
            b.a.d.m.i(this.this$0, 2131891378, 0, 4);
        }
    }
}
