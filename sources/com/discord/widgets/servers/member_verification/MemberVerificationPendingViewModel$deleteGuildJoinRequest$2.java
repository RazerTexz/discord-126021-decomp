package com.discord.widgets.servers.member_verification;

import com.discord.models.domain.ModelMemberVerificationFormResponse;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel$deleteGuildJoinRequest$2 extends o implements Function1<ModelMemberVerificationFormResponse, Unit> {
    public final /* synthetic */ MemberVerificationPendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel$deleteGuildJoinRequest$2(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        super(1);
        this.this$0 = memberVerificationPendingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
        invoke2(modelMemberVerificationFormResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
        MemberVerificationPendingViewModel.access$onResetSuccess(this.this$0);
    }
}
