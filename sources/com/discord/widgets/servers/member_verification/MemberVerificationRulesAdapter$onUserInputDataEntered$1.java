package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$onUserInputDataEntered$1 extends o implements Function2<Integer, Object, Unit> {
    public static final MemberVerificationRulesAdapter$onUserInputDataEntered$1 INSTANCE = new MemberVerificationRulesAdapter$onUserInputDataEntered$1();

    public MemberVerificationRulesAdapter$onUserInputDataEntered$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
        invoke(num.intValue(), obj);
        return Unit.a;
    }

    public final void invoke(int i, Object obj) {
        m.checkNotNullParameter(obj, "<anonymous parameter 1>");
    }
}
