package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel$1 extends o implements Function1<MemberVerificationPendingViewModel$StoreState, Unit> {
    public final /* synthetic */ MemberVerificationPendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel$1(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        super(1);
        this.this$0 = memberVerificationPendingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel$StoreState memberVerificationPendingViewModel$StoreState) {
        invoke2(memberVerificationPendingViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MemberVerificationPendingViewModel$StoreState memberVerificationPendingViewModel$StoreState) {
        m.checkNotNullParameter(memberVerificationPendingViewModel$StoreState, "storeState");
        MemberVerificationPendingViewModel.access$handleStoreState(this.this$0, memberVerificationPendingViewModel$StoreState);
    }
}
