package com.discord.widgets.auth;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyPasswordLauncher$1 extends o implements Function1<WidgetAuthPhoneVerify$Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyPasswordLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        invoke2(widgetAuthPhoneVerify$Result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        m.checkNotNullParameter(widgetAuthPhoneVerify$Result, "result");
        if (widgetAuthPhoneVerify$Result instanceof WidgetAuthPhoneVerify$Result$Token) {
            WidgetAuthResetPassword.Companion.start(this.this$0.requireContext(), ((WidgetAuthPhoneVerify$Result$Token) widgetAuthPhoneVerify$Result).getToken());
        }
    }
}
