package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel$1 extends o implements Function1<MemberVerificationSuccessViewModel$StoreState, Unit> {
    public final /* synthetic */ MemberVerificationSuccessViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessViewModel$1(MemberVerificationSuccessViewModel memberVerificationSuccessViewModel) {
        super(1);
        this.this$0 = memberVerificationSuccessViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationSuccessViewModel$StoreState memberVerificationSuccessViewModel$StoreState) {
        invoke2(memberVerificationSuccessViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MemberVerificationSuccessViewModel$StoreState memberVerificationSuccessViewModel$StoreState) {
        m.checkNotNullParameter(memberVerificationSuccessViewModel$StoreState, "storeState");
        MemberVerificationSuccessViewModel.access$handleStoreState(this.this$0, memberVerificationSuccessViewModel$StoreState);
    }
}
