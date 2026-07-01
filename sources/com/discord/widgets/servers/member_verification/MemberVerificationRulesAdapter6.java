package com.discord.widgets.servers.member_verification;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$onUserInputDataEntered$1, reason: use source file name */
/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter6 extends Lambda implements Function2<Integer, Object, Unit> {
    public static final MemberVerificationRulesAdapter6 INSTANCE = new MemberVerificationRulesAdapter6();

    public MemberVerificationRulesAdapter6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
        invoke(num.intValue(), obj);
        return Unit.a;
    }

    public final void invoke(int i, Object obj) {
        Intrinsics3.checkNotNullParameter(obj, "<anonymous parameter 1>");
    }
}
